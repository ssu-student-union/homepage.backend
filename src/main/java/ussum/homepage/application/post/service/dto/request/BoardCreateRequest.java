package ussum.homepage.application.post.service.dto.request;

import ussum.homepage.application.acl.service.dto.request.BoardAclCreateRequest;
import ussum.homepage.domain.acl.BoardAcl;
import ussum.homepage.domain.post.Board;
import ussum.homepage.infra.jpa.post.entity.BoardCode;

import java.util.List;

public record BoardCreateRequest(
        String name,
        String boardCode,
        List<BoardAclCreateRequest> boardAclCreateRequest
) {
    public Board toDomain(){
        return Board.of(
                null,
                boardCode,
                name,
                null,
                null
        );
    }
    public List<BoardAcl> toList(){
        return boardAclCreateRequest.stream().map(boardAclCreateRequest1 -> boardAclCreateRequest1.toDomain(null)).toList();
    }
}
