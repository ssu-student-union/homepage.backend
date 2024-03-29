package ussum.homepage.application.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ussum.homepage.application.post.service.dto.request.PostCreateRequest;
import ussum.homepage.application.post.service.dto.response.PostListResponse;
import ussum.homepage.application.post.service.dto.response.PostResponse;
import ussum.homepage.domain.post.Board;
import ussum.homepage.domain.post.Category;
import ussum.homepage.domain.post.Post;
import ussum.homepage.domain.post.service.*;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final BoardReader boardReader;
    private final CategoryReader categoryReader;

    private final PostReader postReader;
    private final PostFormatter postFormatter;
    private final PostAppender postAppender;


    public PostListResponse getPostList(Pageable pageable, String boardCode) {
//        Board board = boardReader.getBoardWithBoardCode(boardCode);
        Page<Post> postList = postReader.getPostList(pageable, boardCode);
        return PostListResponse.of(postList.getContent(),
                (int) postList.getTotalElements(), postFormatter::format);
    }

    public PostResponse getPost(String boardCode, Long postId) {
        return postFormatter.format(
                postReader.getPostWithBoardCode(boardCode, postId).getId()
        );
    }

    public void createPost(String boardCode,PostCreateRequest postCreateRequest) {
        Board board = boardReader.getBoardWithBoardCode(boardCode);
        Category category = categoryReader.getCategoryWithCode(postCreateRequest.categoryCode());

        postAppender.createPost(postCreateRequest.toDomain(board,category));
    }

}
