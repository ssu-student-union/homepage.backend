package ussum.homepage.application.post.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ussum.homepage.application.post.service.dto.BoardListResponse;
import ussum.homepage.domain.post.service.BoardReader;
import ussum.homepage.global.ApiResponse;

@RequiredArgsConstructor
@RequestMapping
@RestController
public class BoardController {
    private final BoardReader boardReader;
    @GetMapping("/boards")
    public ApiResponse<BoardListResponse> getBoardList() {
        BoardListResponse board = boardReader.getBoardList();
        return ApiResponse.onSuccess(board);
    }
}
