package ussum.homepage.domain.post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    Optional<Post> findById(Long postId);
    Optional<List<Post>> findByBoard(Long boardId);
}
