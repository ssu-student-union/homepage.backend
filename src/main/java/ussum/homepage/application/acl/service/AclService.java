package ussum.homepage.application.acl.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ussum.homepage.application.acl.service.dto.request.BoardAclCreateRequest;
import ussum.homepage.application.acl.service.dto.response.BoardAclResponse;
import ussum.homepage.domain.acl.BoardAcl;
import ussum.homepage.domain.acl.service.AclAppender;
import ussum.homepage.domain.acl.service.AclReader;
import ussum.homepage.domain.post.Board;
import ussum.homepage.domain.post.service.BoardReader;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AclService {
    private final BoardReader boardReader;
    private final AclAppender aclAppender;
    private final AclReader aclReader;
    public List<BoardAclResponse> getBoardAclList(String boardCode){
        Board board = boardReader.getBoardWithBoardCode(boardCode);
        List<BoardAcl> boardAclList = aclReader.getBoardAclList(board.getId());
        return boardAclList.stream().map( boardAcl -> BoardAclResponse.of(boardAcl))
                .collect(Collectors.toList());
    }
    public BoardAclResponse createBoardAcl(String boardCode, BoardAclCreateRequest boardAclCreateRequest){
        Board board = boardReader.getBoardWithBoardCode(boardCode);
        BoardAcl boardAcl = aclAppender.appendBoardAcl(boardAclCreateRequest.toDomain(board.getId()));
        return BoardAclResponse.of(boardAcl);
    }
}
