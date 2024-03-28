package ussum.homepage.domain.post;

import java.util.List;
import java.util.Optional;

public interface BoardRepository {
    Optional<Board> findById(Long id);
    Optional<Board> findByBoardCode(String boardCode);
    List<Board> findAll();
}
