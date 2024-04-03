package ussum.homepage.infra.jpa.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import ussum.homepage.domain.comment.PostComment;
import ussum.homepage.domain.comment.PostCommentRepository;
import ussum.homepage.infra.jpa.comment.repository.PostCommentJpaRepository;

@Repository
@RequiredArgsConstructor
public class PostCommentRepositoryImpl implements PostCommentRepository {
    private final PostCommentJpaRepository postCommentJpaRepository;
    private final PostCommentMapper postCommentMapper;
    @Override
    public Page<PostComment> findAllByPostId(Pageable pageable, Long postId){
        return postCommentJpaRepository.findAllByPostId(pageable, postId).map(postCommentMapper::toDomain);
    }
    @Override
    public PostComment findByPostIdAndUserId(Long postId, Long userId){
        return postCommentMapper.toDomain(postCommentJpaRepository.findByPostIdAndUserId(postId, userId));
    }
}
