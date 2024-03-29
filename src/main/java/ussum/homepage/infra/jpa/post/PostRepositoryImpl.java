package ussum.homepage.infra.jpa.post;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import ussum.homepage.domain.post.Post;
import ussum.homepage.domain.post.PostRepository;
import ussum.homepage.global.error.exception.GeneralException;
import ussum.homepage.infra.jpa.post.entity.BoardCode;
import ussum.homepage.infra.jpa.post.entity.BoardEntity;
import ussum.homepage.infra.jpa.post.entity.PostEntity;
import ussum.homepage.infra.jpa.post.repository.BoardJpaRepository;
import ussum.homepage.infra.jpa.post.repository.PostJpaRepository;

import java.util.List;
import java.util.Optional;

import static ussum.homepage.global.error.status.ErrorStatus.BOARD_NOT_FOUND;

@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {
    private final PostJpaRepository postJpaRepository;
    private final BoardJpaRepository boardJpaRepository;
    private final PostMapper postMapper;

    @Override
    public Optional<Post> findById(Long postId) {
        return postJpaRepository.findById(postId).map(postMapper::toDomain);
    }

    @Override
    public Page<Post> findAllWithBoard(Pageable pageable, String boardCode) {
        BoardEntity boardEntity = boardJpaRepository.findByBoardCode(BoardCode.getEnumBoardCodeFromStringBoardCode(boardCode))
                .orElseThrow(() -> new GeneralException(BOARD_NOT_FOUND));

        return postJpaRepository.findAllByBoard(pageable,boardEntity).map(postMapper::toDomain);
    }

    @Override
    public Optional<Post> findByBoardIdAndId(Long boardId, Long postId) {
        BoardEntity boardEntity = boardJpaRepository.findById(boardId).orElseThrow(() -> new GeneralException(BOARD_NOT_FOUND));
        return postJpaRepository.findByBoardEntityAndId(boardEntity, postId)
                .map(postMapper::toDomain);
    }
}
