package ussum.homepage.domain.comment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostCommentRepository {
    Page<PostComment> findAllByPostId(Pageable pageable, Long postId);
}
