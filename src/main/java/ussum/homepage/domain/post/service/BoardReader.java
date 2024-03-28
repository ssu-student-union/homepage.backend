package ussum.homepage.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ussum.homepage.application.post.service.dto.BoardListResponse;
import ussum.homepage.domain.post.Board;
import ussum.homepage.domain.post.BoardRepository;
import ussum.homepage.domain.post.service.formatter.BoardFormatter;
import ussum.homepage.global.error.exception.GeneralException;

import java.util.List;

import static ussum.homepage.global.error.status.ErrorStatus.BOARD_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class BoardReader {
    private final BoardRepository boardRepository;
    private final BoardFormatter boardFormatter;
    public Board getBoardWithBoardCode(String boardCode){
        return boardRepository.findByBoardCode(boardCode).orElseThrow(()-> new GeneralException(BOARD_NOT_FOUND));
    }
    public BoardListResponse getBoardList(){
        List<Board> boardList =  boardRepository.findAll();
        return BoardListResponse.of(boardList, boardList.size()+1,boardFormatter::format);
    }
    public Board getBoardWithId(Long boardId){
        return boardRepository.findById(boardId).orElseThrow(()-> new GeneralException(BOARD_NOT_FOUND));
    }
}
