package ussum.homepage.infra.jpa.user.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "group")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GroupEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private MajorCode majorCode;
    private String name;

}
