package ussum.homepage.application.user.service.dto.response;

import ussum.homepage.domain.user.User;

public record UserResponse(
        Long id,
        String name,
        String profileImage,
        String createdAt
) {
    public static UserResponse of(User user) {
        return new UserResponse(user.getId(), user.getName(), user.getProfileImage(), user.getCreatedAt());
    }
}
