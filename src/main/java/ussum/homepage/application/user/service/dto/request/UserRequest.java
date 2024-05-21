package ussum.homepage.application.user.service.dto.request;

import ussum.homepage.domain.user.User;

public record UserRequest(
        Long id,
        String profileImage,
        String name,
        Long studentId
) {
    public User toDomain(){
        return User.of(
                null, // id값은 뭘 의미?
                name,
                studentId,
                profileImage,
                null,
                null
        );
    }

}


