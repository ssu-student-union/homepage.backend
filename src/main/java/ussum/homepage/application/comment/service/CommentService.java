package ussum.homepage.application.comment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ussum.homepage.application.comment.service.dto.PostCommentListResponse;
import ussum.homepage.application.comment.service.dto.PostCommentResponse;
import ussum.homepage.domain.comment.PostComment;
import ussum.homepage.domain.comment.service.PostCommentFormatter;
import ussum.homepage.domain.comment.service.PostCommentReader;
import ussum.homepage.domain.post.service.formatter.PostFormatter;
import ussum.homepage.domain.user.service.formatter.UserFormatter;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {
    private final PostFormatter postFormatter;
    private final UserFormatter userFormatter;
    private final PostCommentReader postCommentReader;
    private final PostCommentFormatter postCommentFormatter;
    public PostCommentListResponse getCommentList(String boardCode, Long postId, int page, int take, String type){
        Page<PostComment> commentList = postCommentReader.getPostCommentList(setPageable(page,take),postId);
        return PostCommentListResponse.of(commentList, commentList.getTotalElements(), postCommentFormatter::format, type);
    }
    private Pageable setPageable(int page, int take){
        return PageRequest.of(page, take);
    }
}
