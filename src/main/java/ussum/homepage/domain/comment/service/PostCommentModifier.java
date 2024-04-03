package ussum.homepage.domain.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ussum.homepage.application.comment.service.dto.request.PostCommentUpdateRequest;
import ussum.homepage.domain.comment.PostComment;
import ussum.homepage.domain.comment.PostCommentRepository;

@Service
@RequiredArgsConstructor
public class PostCommentModifier {
    private final PostCommentRepository postCommentRepository;
    public PostComment updateComment(Long userId, Long postId, Long commentId, PostCommentUpdateRequest postCommentUpdateRequest){
        return postCommentRepository.update(postCommentUpdateRequest.toDomain(commentId,postId,userId));
    }
}
