package ussum.homepage.application.comment.service.dto;

import ussum.homepage.application.post.service.dto.response.PostResponse;
import ussum.homepage.application.user.service.dto.response.UserResponse;
import ussum.homepage.domain.comment.PostComment;

public record PostCommentResponse(
        Long id,
        PostResponse post,
        UserResponse author,
        String content,
        String type,
        String lastEditedAt

) {
    public static PostCommentResponse of(PostComment postComment, PostResponse postResponse, UserResponse userResponse,String type){
        return new PostCommentResponse(
                postComment.getId(),
                postResponse,
                userResponse,
                postComment.getContent(),
                type,
                postComment.getLastEditedAt());
    }
}
