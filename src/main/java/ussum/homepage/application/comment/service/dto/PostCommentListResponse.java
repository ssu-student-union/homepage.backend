package ussum.homepage.application.comment.service.dto;

import org.springframework.data.domain.Page;
import ussum.homepage.domain.comment.PostComment;

import java.util.List;
import java.util.function.Function;

public record PostCommentListResponse(
        List<PostCommentResponse> postComments,
        Integer total
) {
    public static PostCommentListResponse of(Page<PostComment> postComments, Long total, Function<Long, PostCommentResponse> formatter, String type){
        return new PostCommentListResponse(
                postComments.map(postComment -> formatter.apply(postComment.getId(), type)).toList(),
                Math.toIntExact(total)
        );
    }
}
