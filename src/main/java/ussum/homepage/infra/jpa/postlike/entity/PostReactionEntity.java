package ussum.homepage.infra.jpa.postlike.entity;
import jakarta.persistence.*;
import lombok.*;
import ussum.homepage.infra.jpa.post.entity.PostEntity;
import ussum.homepage.infra.jpa.user.entity.GroupEntity;
import ussum.homepage.infra.jpa.user.entity.UserEntity;

@Entity
@Table(name = "post_reaction")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostReactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Reaction reaction;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private PostEntity postEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

}
