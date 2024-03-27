package ussum.homepage.domain.acl.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ussum.homepage.domain.acl.BoardAcl;
import ussum.homepage.domain.acl.BoardAclRepository;
import ussum.homepage.global.error.exception.GeneralException;

import static ussum.homepage.global.error.status.ErrorStatus.BOARD_ACL_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class AclModifier {
    private final BoardAclRepository boardAclRepository;
    public BoardAcl updateBoardAcl(BoardAcl boardAcl){
        return boardAclRepository.update(boardAcl);
    }
    public void deleteBoardAcl(String boardCode, Long boardAclId){
        BoardAcl boardAcl = boardAclRepository.findById(boardAclId).orElseThrow(()->new GeneralException(BOARD_ACL_NOT_FOUND));
        boardAclRepository.delete(boardAcl);
    }
}
