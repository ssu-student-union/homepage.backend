package ussum.homepage.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ussum.homepage.domain.acl.BoardAcl;
import ussum.homepage.domain.acl.BoardAclRepository;
import ussum.homepage.domain.post.Board;
import ussum.homepage.domain.post.BoardRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardAppender {
    private final BoardRepository boardRepository;
    private final BoardAclRepository boardAclRepository;
    @Transactional
    public void createBoard(Board board, List<BoardAcl> boardAclList){
        Board saveBoard = boardRepository.save(board);
        boardAclList.stream().map(boardAcl ->
                boardAclRepository.save(
                    BoardAcl.of(
                            null,
                            boardAcl.getTarget(),
                            boardAcl.getType(),
                            boardAcl.getAction(),
                            null,
                            saveBoard.getId()
                        )
                )
        );
    }
}
