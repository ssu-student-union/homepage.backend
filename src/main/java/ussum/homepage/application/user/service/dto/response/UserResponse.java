package ussum.homepage.application.user.service.dto.response;

import ussum.homepage.domain.user.User;

public record UserResponse(
        Long id,
        String name,
        Long studentId,
        String profileImage,
        String createdAt
) {
    public static UserResponse of(User user) {
        return new UserResponse(user.getId(), user.getName(), user.getStudentId(), user.getProfileImage(), user.getCreatedAt());
    }
}
