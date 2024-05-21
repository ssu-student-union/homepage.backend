package ussum.homepage.application.oauth.service;

import io.netty.handler.codec.http.HttpHeaderValues;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;
import ussum.homepage.application.oauth.service.dto.KakaoTokenResponseDto;
import ussum.homepage.application.oauth.service.dto.KakaoUserInfoResponseDto;

import java.nio.charset.Charset;

import static org.springframework.security.oauth2.core.endpoint.OAuth2ParameterNames.GRANT_TYPE;

@Service
@Slf4j
@RequiredArgsConstructor
public class OAuthService {

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

    public void getUserInfo(String accessToken) {

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

        Long id = userInfo.getId();

        return ;
    }

}
