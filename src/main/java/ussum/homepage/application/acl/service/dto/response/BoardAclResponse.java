package ussum.homepage.application.acl.service.dto.response;

import ussum.homepage.domain.acl.BoardAcl;

public record BoardAclResponse (Long id,
                                   String target,
                                   String type,
                                   String action,
                                   String order){
    public static BoardAclResponse of(BoardAcl boardAcl){
        return new BoardAclResponse(
                boardAcl.getId(),
                boardAcl.getTarget(),
                boardAcl.getType(),
                boardAcl.getAction(),
                boardAcl.getOrder()
        );
    }
}
