package ussum.homepage.domain.user;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import ussum.homepage.infra.jpa.user.entity.MajorCode;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Group {
    private Long id;
    private String majorCode;
    private String name;

}
