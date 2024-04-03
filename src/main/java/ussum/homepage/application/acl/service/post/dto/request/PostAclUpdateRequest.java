package ussum.homepage.application.acl.service.post.dto.request;

import ussum.homepage.domain.acl.BoardAcl;
import ussum.homepage.domain.acl.PostAcl;
import ussum.homepage.infra.jpa.acl.entity.Action;
import ussum.homepage.infra.jpa.acl.entity.Target;
import ussum.homepage.infra.jpa.acl.entity.Type;

public record PostAclUpdateRequest(
        String target,
        String type,
        String action
) {
    public PostAcl toDomain(Long postAclId, Long postId) {
        return PostAcl.of(
                postAclId,
                target,
                type,
                action,
                null,
                postId
        );
    }
}

