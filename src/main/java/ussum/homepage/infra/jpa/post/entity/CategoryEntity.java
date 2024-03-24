package ussum.homepage.infra.jpa.post.entity;
import jakarta.persistence.*;
import lombok.*;
import ussum.homepage.infra.jpa.user.entity.MajorCode;

@Entity
@Table(name = "category")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private MajorCode majorCode;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private BoardEntity boardEntity;
}
