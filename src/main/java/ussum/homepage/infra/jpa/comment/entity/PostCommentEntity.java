package ussum.homepage.infra.jpa.comment.entity;
import jakarta.persistence.*;
import lombok.*;
import ussum.homepage.infra.jpa.post.entity.PostEntity;
import ussum.homepage.infra.jpa.user.entity.UserEntity;

import java.time.LocalDateTime;

@Entity
@Table(name = "post_comment")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostCommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private PostEntity postEntity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
    private LocalDateTime lastEditedAt;
}
