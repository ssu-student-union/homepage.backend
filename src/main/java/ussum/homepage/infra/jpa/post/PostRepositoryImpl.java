package ussum.homepage.infra.jpa.post;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import ussum.homepage.domain.post.Board;
import ussum.homepage.domain.post.Post;
import ussum.homepage.domain.post.PostRepository;
import ussum.homepage.global.error.exception.GeneralException;
import ussum.homepage.infra.jpa.post.entity.BoardCode;
import ussum.homepage.infra.jpa.post.entity.BoardEntity;
import ussum.homepage.infra.jpa.post.entity.CategoryEntity;
import ussum.homepage.infra.jpa.post.entity.PostEntity;
import ussum.homepage.infra.jpa.post.repository.BoardJpaRepository;
import ussum.homepage.infra.jpa.post.repository.CategoryJpaRepository;
import ussum.homepage.infra.jpa.post.repository.PostJpaRepository;
import ussum.homepage.infra.jpa.user.entity.UserEntity;
import ussum.homepage.infra.jpa.user.repository.UserJpaRepository;

import java.util.List;
import java.util.Optional;

import static ussum.homepage.global.error.status.ErrorStatus.*;

@Repository
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {
    private final PostJpaRepository postJpaRepository;
    private final BoardJpaRepository boardJpaRepository;
    private final CategoryJpaRepository categoryJpaRepository;
    private final UserJpaRepository userJpaRepository;
    private final PostMapper postMapper;

    @Override
    public Optional<Post> findById(Long postId) {
        return postJpaRepository.findById(postId).map(postMapper::toDomain);
    }

    @Override
    public Optional<Post> findByBoardIdAndId(Long boardId, Long postId) {
        BoardEntity boardEntity = boardJpaRepository.findById(boardId).orElseThrow(() -> new GeneralException(BOARD_NOT_FOUND));
        return postJpaRepository.findByBoardEntityAndId(boardEntity, postId)
                .map(postMapper::toDomain);
    }

    @Override
    public Page<Post> findAllWithBoard(Pageable pageable, String boardCode) {
        BoardEntity boardEntity = boardJpaRepository.findByBoardCode(BoardCode.getEnumBoardCodeFromStringBoardCode(boardCode))
                .orElseThrow(() -> new GeneralException(BOARD_NOT_FOUND));

        return postJpaRepository.findAllByBoard(pageable,boardEntity).map(postMapper::toDomain);
    }

    @Override
    public List<Post> findByBoard(Long boardId) {
        return postJpaRepository.findAllByBoardId(boardId).stream()
                .map(postMapper::toDomain).toList();
    }

    @Override
    public Post save(Post post){
        //아직 User쪽 구현이 안되서 임시로 추가
        UserEntity userEntity = userJpaRepository.findById(post.getUserId())
                .orElseThrow(() -> new GeneralException(USER_NOT_FOUND));

        BoardEntity boardEntity = boardJpaRepository.findById(post.getBoardId())
                .orElseThrow(() -> new GeneralException(BOARD_NOT_FOUND));

        CategoryEntity categoryEntity = categoryJpaRepository.findById(post.getCategoryId())
                .orElseThrow(() -> new GeneralException(CATEGORY_NOT_FOUND));

        return postMapper.toDomain(
                postJpaRepository.save(postMapper.toEntity(post, userEntity, boardEntity, categoryEntity))
        );
    }

    @Override
    public void delete(Post post) {
        UserEntity userEntity = userJpaRepository.findById(post.getUserId())
                .orElseThrow(() -> new GeneralException(USER_NOT_FOUND));

        BoardEntity boardEntity = boardJpaRepository.findById(post.getBoardId())
                .orElseThrow(() -> new GeneralException(BOARD_NOT_FOUND));

        CategoryEntity categoryEntity = categoryJpaRepository.findById(post.getCategoryId())
                .orElseThrow(() -> new GeneralException(CATEGORY_NOT_FOUND));

        postJpaRepository.delete(postMapper.toEntity(post, userEntity, boardEntity, categoryEntity));
    }

    @Override
    public Page<Post> findBySearchCriteria(Pageable pageable, String q, String categoryCode) {
//        return postJpaRepository.findBySearchCriteria(pageable, q, categoryCode)
//                .map(postMapper::toDomain);
        return postJpaRepository.findBySearchCriteria(
                pageable,
                q.isEmpty() ? null : q,
                categoryCode.isEmpty() ? null : categoryCode).map(postMapper::toDomain);
    }
}
