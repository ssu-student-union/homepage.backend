package ussum.homepage.application.post.service.dto;

import ussum.homepage.domain.post.Board;

import java.util.List;
import java.util.function.Function;

public record BoardListResponse(
        List<BoardResponse> boards,
        Integer total
) {
    public static BoardListResponse of(List<Board> boards, Integer total, Function<Long, BoardResponse> formatter){
        return new BoardListResponse(
                boards.stream()
                        .map(board -> formatter.apply(board.getId()))
                        .toList(),
                total
        );
    }
}
