package ussum.homepage.application.acl.service.dto.request;

import ussum.homepage.domain.acl.BoardAcl;
import ussum.homepage.infra.jpa.acl.entity.Action;
import ussum.homepage.infra.jpa.acl.entity.Target;
import ussum.homepage.infra.jpa.acl.entity.Type;

public record BoardAclCreateRequest(
        String target,
        String type,
        String action
) {
    public BoardAcl toDomain(Long boardId){
        return BoardAcl.of(
                null,
                target,
                type,
                action,
                "NONE",
                boardId
        );
    }
}
