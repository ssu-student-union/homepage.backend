package ussum.homepage.application.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ussum.homepage.application.post.service.dto.response.PostListResponse;
import ussum.homepage.domain.post.Board;
import ussum.homepage.domain.post.Post;
import ussum.homepage.domain.post.service.*;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final BoardReader boardReader;
    private final PostReader postReader;
    private final PostFormatter postFormatter;

    public PostListResponse getPostList(Pageable pageable, String boardCode) {
//        Board board = boardReader.getBoardWithBoardCode(boardCode);
        Page<Post> postList = postReader.getPostList(pageable, boardCode);
        return PostListResponse.of(postList.getContent(),
                (int) postList.getTotalElements(), postFormatter::format);
    }

}
