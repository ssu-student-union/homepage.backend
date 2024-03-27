package ussum.homepage.application.post.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ussum.homepage.application.acl.service.dto.response.BoardAclResponse;
import ussum.homepage.global.ApiResponse;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping
@RestController
public class BoardController {
    @GetMapping("/boards")
    public ApiResponse<List<BoardResponse>> getBoardList(@PathVariable(name = ":boardCode") String boardCode) {
        List<BoardResponse> boards = aclService.getBoardAclList(boardCode);
        return ApiResponse.onSuccess(acls);
    }
}
