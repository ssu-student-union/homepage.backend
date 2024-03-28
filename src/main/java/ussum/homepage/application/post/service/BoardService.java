package ussum.homepage.application.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ussum.homepage.application.post.service.dto.BoardListResponse;
import ussum.homepage.application.post.service.dto.BoardResponse;
import ussum.homepage.domain.post.Board;
import ussum.homepage.domain.post.service.BoardReader;
import ussum.homepage.domain.post.service.formatter.BoardFormatter;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {
    private final BoardReader boardReader;
    private final BoardFormatter boardFormatter;
    public BoardListResponse getBoardList(){
        List<Board> boardList = boardReader.getBoardList();
        return BoardListResponse.of(boardList, boardList.size()+1,boardFormatter::format);
    }
}
