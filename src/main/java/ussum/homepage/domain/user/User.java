package ussum.homepage.domain.user;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {
    private Long id;
    private String name;
    private Long studentId;
    private String profileImage;
    private String createdAt;
    private String updatedAt;

    public static User of(Long id, String name, Long studentId, String profileImage,
                          LocalDateTime createdAt, LocalDateTime updatedAt) {
        return new User(id, name, studentId, profileImage, String.valueOf(createdAt), String.valueOf(updatedAt));
    }
}
