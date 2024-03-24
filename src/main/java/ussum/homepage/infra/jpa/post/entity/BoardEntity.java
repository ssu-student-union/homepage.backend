package ussum.homepage.infra.jpa.post.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "board")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private BoardCode boardCode;
    private String name;
}
