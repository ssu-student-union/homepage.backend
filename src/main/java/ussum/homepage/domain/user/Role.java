package ussum.homepage.domain.user;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import ussum.homepage.infra.jpa.user.entity.UserEntity;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Role {
    private Long id;
    private String role;
    private Long userId;
}
