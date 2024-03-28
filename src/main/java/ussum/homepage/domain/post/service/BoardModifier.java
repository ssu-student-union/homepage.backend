package ussum.homepage.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ussum.homepage.application.post.service.dto.request.BoardUpdateRequest;
import ussum.homepage.domain.post.Board;
import ussum.homepage.domain.post.BoardRepository;

@Service
@RequiredArgsConstructor
public class BoardModifier {
    private final BoardRepository boardRepository;
    private final BoardReader boardReader;
    public Board updateBoard(String boardCode, BoardUpdateRequest boardUpdateRequest){
        return boardRepository.save(boardUpdateRequest.toDomain(
                boardReader.getBoardWithBoardCode(boardCode).getId()
        ));
    }
}
