package ussum.homepage.domain.comment;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PostComment {
    private Long id;
    private String content;
    private Long postId;
    private Long userId;
}
