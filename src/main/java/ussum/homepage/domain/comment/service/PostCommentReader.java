package ussum.homepage.domain.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ussum.homepage.domain.comment.PostComment;
import ussum.homepage.domain.comment.PostCommentRepository;

@Service
@RequiredArgsConstructor
public class PostCommentReader {
    private final PostCommentRepository postCommentRepository;
    public Page<PostComment> getPostCommentList(Pageable pageable, Long postId){
        return postCommentRepository.findAllByPostId(pageable, postId);
    }
    public PostComment getPostCommentWithPostIdAndUserId(Long postId, Long userId){
        return postCommentRepository.findByPostIdAndUserId(postId, userId);
    }
    public PostComment getPostComment(Long commentId){
        return postCommentRepository.findById(commentId);
    }
}
