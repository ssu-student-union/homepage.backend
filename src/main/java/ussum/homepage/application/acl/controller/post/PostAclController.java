package ussum.homepage.application.acl.controller.post;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ussum.homepage.application.acl.service.AclService;
import ussum.homepage.application.acl.service.PostAclService;
import ussum.homepage.application.acl.service.post.dto.request.PostAclCreateRequest;
import ussum.homepage.application.acl.service.post.dto.response.PostAclResponse;
import ussum.homepage.global.ApiResponse;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping
@RestController
public class PostAclController {
    private final PostAclService postAclService;

    @GetMapping("/boards/posts/:postId/acls")
    public ApiResponse<List<PostAclResponse>> getPostAcls(/**@PathVariable(name = ":boardCode") String boardCode,**/
                                                          @PathVariable(name = ":postId") Long postId) {

        return ApiResponse.onSuccess(postAclService.getPostAclList(postId));
    }

    @PostMapping("/boards/posts/:postId/acls")
    public ApiResponse<PostAclResponse> createPostAcl(@PathVariable(name = ":postId") Long postId,
                                                       PostAclCreateRequest postAclCreateRequest) {

        return ApiResponse.onSuccess(postAclService.createPostAcl(postId, postAclCreateRequest));
    }




}
