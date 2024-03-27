package ussum.homepage.domain.post;

import java.util.Optional;

public interface BoardRepository {
    Optional<Board> findById(Long id);
    Optional<Board> findByBoardCode(String boardCode);
}
