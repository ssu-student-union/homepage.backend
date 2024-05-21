package ussum.homepage.application.user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ussum.homepage.application.user.service.OnBoardingService;
import ussum.homepage.application.user.service.dto.request.UserRequest;
import ussum.homepage.application.user.service.dto.response.UserResponse;
import ussum.homepage.global.ApiResponse;

@RequiredArgsConstructor
@RequestMapping("/api/onboarding")
@RestController
public class OnBoardingController {
    private final OnBoardingService onBoardingService;

    @PostMapping("/academyinformation")
    public ApiResponse<UserResponse> createUserOnBoarding(@RequestBody UserRequest request){
        UserResponse response = onBoardingService.getUserOnBoarding(request);
        return ApiResponse.onSuccess(response);
    }
}
