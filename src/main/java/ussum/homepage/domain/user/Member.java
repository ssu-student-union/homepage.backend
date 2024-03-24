package ussum.homepage.domain.user;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import ussum.homepage.infra.jpa.user.entity.GroupEntity;
import ussum.homepage.infra.jpa.user.entity.UserEntity;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Member {
    private Long id;
    private boolean isAdmin;
    private Long userId;

    private Long groupId;
}
