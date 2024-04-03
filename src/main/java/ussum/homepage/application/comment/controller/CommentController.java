package ussum.homepage.application.comment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ussum.homepage.application.comment.service.CommentService;
import ussum.homepage.application.comment.service.dto.PostCommentListResponse;
import ussum.homepage.application.comment.service.dto.PostCommentResponse;
import ussum.homepage.application.post.service.dto.BoardListResponse;
import ussum.homepage.global.ApiResponse;

@RequiredArgsConstructor
@RequestMapping
@RestController
public class CommentController {
    private CommentService commentService;
    @GetMapping("/board/{boardCode}/posts/{postId}/comments")
    public ApiResponse<PostCommentListResponse> getPostCommentList(@PathVariable(name = "boardCode") String boardCode,
                                                             @PathVariable(name = "postId") Long postId,
                                                             @RequestParam(name = "page") int page,
                                                             @RequestParam(name = "take") int take,
                                                             @RequestParam(name = "type") String type) {
        PostCommentListResponse comments = commentService.getCommentList(boardCode, postId, page, take, type);
        return ApiResponse.onSuccess(comments);
    }
    @PostMapping("/boards/:boardCode/posts/:postId/comments")
    public ApiResponse<PostCommentResponse> createPostComment(@PathVariable(name = "boardCode") String boardCode,
                                                              @PathVariable(name = "postId") Long postId,
                                                              @RequestBody String content) {
        PostCommentResponse comment = commentService.createComment(null, boardCode, postId, content);
        return ApiResponse.onSuccess(comment);
    }
}
