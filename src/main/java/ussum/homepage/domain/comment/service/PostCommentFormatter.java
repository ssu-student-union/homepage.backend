package ussum.homepage.domain.comment.service;

import ussum.homepage.application.comment.service.dto.PostCommentResponse;

public interface PostCommentFormatter {
    PostCommentResponse format(Long postId, Long userId, String type);
}
