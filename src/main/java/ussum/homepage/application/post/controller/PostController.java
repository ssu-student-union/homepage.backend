package ussum.homepage.application.post.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import ussum.homepage.application.post.service.PostService;
import ussum.homepage.application.post.service.dto.request.PostCreateRequest;
import ussum.homepage.application.post.service.dto.request.PostSearchRequest;
import ussum.homepage.application.post.service.dto.request.PostUpdateRequest;
import ussum.homepage.application.post.service.dto.response.PostListResponse;
import ussum.homepage.application.post.service.dto.response.PostResponse;
import ussum.homepage.global.ApiResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boards")
public class PostController {
    private final PostService postService;

    @GetMapping("/{boardCode}/posts/")
    public ApiResponse<PostListResponse> getBoardPostsList(Pageable pageable,
                                                           @PathVariable(name = "boardCode") String boardCode) {

//        PostListResponse postList = postService.getPostList(PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("id").descending()), boardCode);
        PostListResponse postList = postService.getPostList(pageable, boardCode);
        return ApiResponse.onSuccess(postList);
    }

    @GetMapping("/{boardCode}/posts/{postId}")
    public ApiResponse<PostResponse> getBoardPost(@PathVariable(name = "boardCode") String boardCode,
                                                  @PathVariable(name = "postId") Long postId) {

        return ApiResponse.onSuccess(postService.getPost(boardCode, postId));
    }

    @PostMapping("/{boardCode}/posts")
    public ApiResponse<?> createBoardPost(@PathVariable(name = "boardCode") String boardCode,
                                          @RequestBody PostCreateRequest postCreateRequest) {
        postService.createPost(boardCode,postCreateRequest);
        return ApiResponse.onSuccess(null);
    }

    @PatchMapping("/{boardCode}/posts/{postId}")
    public ApiResponse<PostResponse> editBoardPost(@PathVariable(name = "boardCode") String boardCode,
                                                   @PathVariable(name = "postId") Long postId,
                                                   @RequestBody PostUpdateRequest postUpdateRequest) {
        PostResponse post = postService.editPost(boardCode,postId, postUpdateRequest);
        return ApiResponse.onSuccess(post);
    }

    @DeleteMapping("/{boardCode}/posts/{postId}")
    public ApiResponse<?> deleteBoardPost(@PathVariable(name = "boardCode") String boardCode,
                                          @PathVariable(name = "postId") Long postId) {
        postService.deletePost(boardCode, postId);
        return ApiResponse.onSuccess(null);
    }

    @GetMapping("/{boardCode}/posts/search")
    public ApiResponse<?> searchPost(Pageable pageable, @RequestBody PostSearchRequest postSearchRequest) {
        PostListResponse postSearchListResponse = postService.searchPost(pageable, postSearchRequest);
        return ApiResponse.onSuccess(postSearchListResponse);
    }


}
