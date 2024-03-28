package ussum.homepage.application.acl.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ussum.homepage.application.acl.service.post.dto.request.PostAclCreateRequest;
import ussum.homepage.application.acl.service.post.dto.request.PostAclUpdateRequest;
import ussum.homepage.application.acl.service.post.dto.response.PostAclResponse;
import ussum.homepage.domain.acl.PostAcl;
import ussum.homepage.domain.acl.service.AclAppender;
import ussum.homepage.domain.acl.service.AclModifier;
import ussum.homepage.domain.acl.service.AclReader;
import ussum.homepage.domain.acl.service.post.PostAclAppender;
import ussum.homepage.domain.acl.service.post.PostAclModifier;
import ussum.homepage.domain.acl.service.post.PostAclReader;
import ussum.homepage.domain.post.service.BoardReader;
import ussum.homepage.domain.post.service.PostReader;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostAclService {
    private final PostAclAppender postAclAppender;
    private final PostAclReader postAclReader;
    private final PostAclModifier postAclModifier;

    public List<PostAclResponse> getPostAclList(Long postId) {
        List<PostAcl> postAclList = postAclReader.getPostAclList(postId);
        return postAclList.stream().map(postAcl -> PostAclResponse.of(postAcl))
                .collect(Collectors.toList());
    }

    public PostAclResponse createPostAcl(Long postId,PostAclCreateRequest postAclCreateRequest) {
        PostAcl postAcl = postAclAppender.appendPostAcl(postAclCreateRequest.toDomain(postId));
        return PostAclResponse.of(postAcl);
    }

    public PostAclResponse editPostAcl(Long postId, Long postAclId, PostAclUpdateRequest postAclUpdateRequest) {
        PostAcl postAcl = postAclReader.getPostAcl(postAclId);
        return PostAclResponse.of(postAclModifier.updatePostAcl(postAclId, postAcl, postAclUpdateRequest));
    }

    public void deletePostAcl(Long postId, Long postAclId) {
        postAclModifier.deletePostAcl(postAclId);
    }
}
