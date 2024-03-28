package ussum.homepage.application.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ussum.homepage.application.post.service.dto.BoardListResponse;
import ussum.homepage.application.post.service.dto.BoardResponse;
import ussum.homepage.application.post.service.dto.request.BoardCreateRequest;
import ussum.homepage.application.post.service.dto.request.BoardUpdateRequest;
import ussum.homepage.domain.post.service.BoardAppender;
import ussum.homepage.domain.post.service.BoardModifier;
import ussum.homepage.domain.post.service.BoardReader;
import ussum.homepage.domain.post.service.formatter.BoardFormatter;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {
    private final BoardReader boardReader;
    private final BoardAppender boardAppender;
    private final BoardFormatter boardFormatter;
    private final BoardModifier boardModifier;
    public BoardListResponse getBoardList(){
        return BoardListResponse.of(
                boardReader.getBoardList(),
                boardReader.getBoardList().size()+1,
                boardFormatter::format);
    }
    public void createBoard(BoardCreateRequest boardCreateRequest){
        boardAppender.createBoard(boardCreateRequest.toDomain(), boardCreateRequest.toList());
    }
    public BoardResponse getBoard(String boardCode){
        return boardFormatter.format(
                boardReader.getBoardWithBoardCode(boardCode).getId()
        );
    }
    public BoardResponse editBoard(String boardCode, BoardUpdateRequest boardUpdateRequest){
        return boardFormatter.format(
                boardModifier.updateBoard(boardCode, boardUpdateRequest).getId()
        );
    }
    public void deleteBoard(String boardCode){
        boardModifier.deleteBoard(boardCode);
    }
}
