package ussum.homepage.infra.jpa.post;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ussum.homepage.domain.post.Board;
import ussum.homepage.domain.post.BoardRepository;
import ussum.homepage.global.error.exception.GeneralException;
import ussum.homepage.infra.jpa.post.entity.BoardCode;
import ussum.homepage.infra.jpa.post.repository.BoardJpaRepository;

import java.util.Optional;

import static ussum.homepage.global.error.status.ErrorStatus.BOARD_NOT_FOUND;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryImpl implements BoardRepository {
    private final BoardJpaRepository boardJpaRepository;
    private final BoardMapper boardMapper;
    @Override
    public Optional<Board> findById(Long id){
        return boardJpaRepository.findById(id).map(boardMapper::toDomain);
    }
    @Override
    public Optional<Board> findByBoardCode(String boardCode){
        return boardJpaRepository.findByBoardCode(BoardCode.getEnumBoardCodeFromStringBoardCode(boardCode)).map(boardMapper::toDomain);
    }
}
