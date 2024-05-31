package ussum.homepage.application.user.service;

import io.netty.handler.codec.http.HttpHeaderValues;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;
import ussum.homepage.application.user.service.dto.response.KakaoTokenResponseDto;
import ussum.homepage.application.user.service.dto.response.KakaoUserInfoResponseDto;
import ussum.homepage.application.user.service.dto.response.UserOAuthResponse;
import ussum.homepage.domain.user.User;
import ussum.homepage.domain.user.auth.KakaoUserInfo;
import ussum.homepage.domain.user.service.UserAppender;
import ussum.homepage.domain.user.service.UserFormatter;
import ussum.homepage.domain.user.service.UserModifier;
import ussum.homepage.domain.user.service.UserReader;
import ussum.homepage.global.jwt.JwtTokenInfo;
import ussum.homepage.global.jwt.JwtTokenProvider;

import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class OAuthService {
    private final UserFormatter userFormatter;
    private final UserReader userReader;
    private final UserModifier userModifier;
    private final UserAppender userAppender;
    private final JwtTokenProvider provider;

    @Value("${oauth2.kakao.client_id}")
    private String clientId;

    @Value("${oauth2.kakao.redirect_uri}")
    private String redirectUri;

    @Value("${oauth2.kakao.token_uri}")
    private String tokenUri;

    @Value("${oauth2.kakao.resource_uri}")
    private String resource_uri;

    @Value("${oauth2.kakao.authorize_uri}")
    private String authorize_uri;

    @Transactional
    public String getKakaoLogin(){
        String authUrl = authorize_uri +
                "?client_id=" + clientId +
                "&redirect_uri=" + redirectUri +
                "&response_type=code";
        return authUrl;
    }

    @Transactional
    public String getAccessToken(String code) {
        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(tokenUri)
                .queryParam("grant_type", "authorization_code")
                .queryParam("client_id", clientId)
                .queryParam("redirect_uri", redirectUri)
                .queryParam("code", code)
                .build();

        KakaoTokenResponseDto responseDto = WebClient.create().post()
                .uri(uriComponents.toString())
                .retrieve()
                //TODO : Custom Exception
                .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> Mono.error(new RuntimeException("파라미터가 옳지 않음")))
                .onStatus(HttpStatusCode::is5xxServerError, clientResponse -> Mono.error(new RuntimeException("서버 에러")))
                .bodyToMono(KakaoTokenResponseDto.class)
                .doOnError(error -> {
                    log.info("error content : {}", error.getMessage());
                })
                .block();

        log.info(" [Kakao Service] Access Token ------> {}", responseDto.getAccessToken());
        log.info(" [Kakao Service] Refresh Token ------> {}", responseDto.getRefreshToken());

        return responseDto.getAccessToken().toString();
    }

    @Transactional
    public UserOAuthResponse getUserInfo(String accessToken) {

        String urlString = resource_uri;

        KakaoUserInfoResponseDto userInfo = WebClient.create().get()
                .uri(urlString)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken) // access token 인가
                .header(HttpHeaders.CONTENT_TYPE, HttpHeaderValues.APPLICATION_X_WWW_FORM_URLENCODED.toString())
                .retrieve()
                //TODO : Custom Exception
                .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> Mono.error(new RuntimeException("파라미터가 옳지 않음")))
                .onStatus(HttpStatusCode::is5xxServerError, clientResponse -> Mono.error(new RuntimeException("서버 오류")))
                .bodyToMono(KakaoUserInfoResponseDto.class)
                .doOnError(error -> {
                    log.info("error content : {}", error.getMessage());
                })
                .block();
        return signIn(userInfo);
    }

    @Transactional
    public UserOAuthResponse signIn(KakaoUserInfoResponseDto userInfo) {
        Optional<User> optionalUser = userReader.findBykakaoId(userInfo.getId());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            return UserOAuthResponse.of(user, issueAccessTokenAndRefreshToken(user), Objects.isNull(user.getStudentId()));
        }else {
            // 사용자가 존재하지 않거나 예외가 발생한 경우에는 새로운 사용자로 처리
            User savedUser = saveUser(userInfo);
            JwtTokenInfo tokenInfo = issueAccessTokenAndRefreshToken(savedUser);
            Boolean isFirstLogin = Objects.isNull(savedUser.getStudentId());
            return UserOAuthResponse.of(savedUser, tokenInfo, isFirstLogin);
        }
    }

    private User saveUser(KakaoUserInfoResponseDto userInfo) {
        User createdUser = getUserByKakaoUserInfo(userInfo);
        log.info("카카오 id, 프로필 url 저장 완료");
        return userModifier.save(createdUser);

    }

    private User getUserByKakaoUserInfo(KakaoUserInfoResponseDto userInfo) {
        Optional<User> optionalUser = userReader.findBykakaoId(userInfo.getId());
        return optionalUser.orElseGet(() -> User.createUser(userInfo));
    }

    private JwtTokenInfo issueAccessTokenAndRefreshToken(User user) {
        return provider.issueToken(user);
    }

}
