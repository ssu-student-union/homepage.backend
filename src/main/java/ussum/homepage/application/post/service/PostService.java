package ussum.homepage.application.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ussum.homepage.application.post.service.dto.BoardResponse;
import ussum.homepage.application.post.service.dto.request.BoardUpdateRequest;
import ussum.homepage.application.post.service.dto.request.PostCreateRequest;
import ussum.homepage.application.post.service.dto.request.PostSearchRequest;
import ussum.homepage.application.post.service.dto.request.PostUpdateRequest;
import ussum.homepage.application.post.service.dto.response.PostListResponse;
import ussum.homepage.application.post.service.dto.response.PostResponse;
import ussum.homepage.domain.post.Board;
import ussum.homepage.domain.post.Category;
import ussum.homepage.domain.post.Post;
import ussum.homepage.domain.post.service.*;
import ussum.homepage.domain.user.User;
import ussum.homepage.domain.user.service.UserReader;

import java.util.List;

@Service
@RequiredArgsConstructor
//@Transactional(readOnly = true)
@   Transactional
public class PostService {
    private final BoardReader boardReader;
    private final CategoryReader categoryReader;
    private final UserReader userReader;

    private final PostReader postReader;
    private final PostFormatter postFormatter;
    private final PostAppender postAppender;
    private final PostModifier postModifier;


    public PostListResponse getPostList(Pageable pageable, String boardCode) {
//        Board board = boardReader.getBoardWithBoardCode(boardCode);
        Page<Post> postList = postReader.getPostList(pageable, boardCode);
        return PostListResponse.of(postList.getContent(), postList.getNumberOfElements(), postFormatter::format);
    }

    public PostResponse getPost(String boardCode, Long postId) {
        return postFormatter.format(
                postReader.getPostWithBoardCode(boardCode, postId).getId()
        );
    }

    public void createPost(String boardCode,PostCreateRequest postCreateRequest) {
        Board board = boardReader.getBoardWithBoardCode(boardCode);
        Category category = categoryReader.getCategoryWithCode(postCreateRequest.categoryCode());
        //user도 찾아 와야 하지 않을까
        User user = userReader.getUserWithId(1L);

        postAppender.createPost(postCreateRequest.toDomain(board, user, category));
    }

    @Transactional
    public PostResponse editPost(String boardCode,Long postId, PostUpdateRequest postUpdateRequest) {
        return postFormatter.format(
                postModifier.updatePost(boardCode, postId, postUpdateRequest).getId()
        );
    }

    @Transactional
    public void deletePost(String boardCode,Long postId){
        postModifier.deletePost(boardCode, postId);
    }

    public PostListResponse searchPost(Pageable pageable, PostSearchRequest postSearchRequest) {
        Page<Post> searchPost = postReader.getPostListBySearch(pageable, postSearchRequest);
        return PostListResponse.of(searchPost.getContent(), (int) searchPost.getTotalElements(),
                postFormatter::format);
    }

}
