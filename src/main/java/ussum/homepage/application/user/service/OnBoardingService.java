package ussum.homepage.application.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ussum.homepage.application.user.service.dto.request.UserRequest;
import ussum.homepage.application.user.service.dto.response.UserResponse;
import ussum.homepage.domain.user.User;
import ussum.homepage.domain.user.service.UserFormatter;
import ussum.homepage.domain.user.service.formatter.UserAppender;

@Service
@RequiredArgsConstructor
@Transactional
public class OnBoardingService {
    private final UserAppender userAppender;
    private final UserFormatter userFormatter;

    @Transactional
    public UserResponse getUserOnBoarding(UserRequest request){
        User user = userAppender.createUser(request.toDomain());
        return userFormatter.format(user.getId());
    }
}
