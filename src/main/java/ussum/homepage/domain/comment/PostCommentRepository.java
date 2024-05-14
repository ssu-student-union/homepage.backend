package ussum.homepage.domain.comment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostCommentRepository {
    Page<PostComment> findAllByPostId(Pageable pageable, Long postId);
    PostComment findByPostIdAndUserId(Long postId, Long userId);
    PostComment save(PostComment postComment);
    PostComment update(PostComment postComment);
    PostComment findById(Long id);
    void delete(PostComment postComment);
}
