package ussum.homepage.domain.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    Optional<Post> findById(Long postId);
    Page<Post> findAllWithBoard(Pageable pageable, String boardCode);
    Optional<Post> findByBoardIdAndId(Long boardId,Long postId);
    List<Post> findByBoard(Long postId);
    Post save(Post post);
}
