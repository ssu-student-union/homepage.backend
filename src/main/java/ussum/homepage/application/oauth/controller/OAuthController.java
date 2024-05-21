package ussum.homepage.application.oauth.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriBuilder;
import ussum.homepage.application.oauth.service.OAuthService;
import ussum.homepage.domain.user.KakaoInfo;
import ussum.homepage.global.ApiResponse;

@RestController
@RequiredArgsConstructor
public class OAuthController {
    private final OAuthService oAuthService;

    @GetMapping("/page")
    public void LoginPage(HttpServletResponse response) throws Exception{
        String redirectUri= oAuthService.getKakaoLogin();
        response.sendRedirect(redirectUri);
    }

    @GetMapping("/callback")
    public ApiResponse<String> callback(@RequestParam("code") String code){
        String accessToken = oAuthService.getAccessToken(code);
        System.out.println(accessToken);
        oAuthService.getUserInfo(accessToken);
        return ApiResponse.onSuccess(null);
    }

}
