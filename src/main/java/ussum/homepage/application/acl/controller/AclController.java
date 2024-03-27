package ussum.homepage.application.acl.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ussum.homepage.application.acl.service.AclService;
import ussum.homepage.application.acl.service.dto.request.BoardAclCreateRequest;
import ussum.homepage.application.acl.service.dto.request.BoardAclUpdateRequest;
import ussum.homepage.application.acl.service.dto.response.BoardAclResponse;
import ussum.homepage.application.acl.service.post.dto.response.PostAclResponse;
import ussum.homepage.global.ApiResponse;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping
@RestController
public class AclController {
    private final AclService aclService;

    @GetMapping("/boards/:boardCode/acls")
    public ApiResponse<List<BoardAclResponse>> getBoardAcls(@PathVariable(name = ":boardCode") String boardCode) {
        List<BoardAclResponse> acls = aclService.getBoardAclList(boardCode);
        return ApiResponse.onSuccess(acls);
    }

//    @GetMapping("/boards/:boardCode/posts/:postId/acls")
//    public ApiResponse<List<PostAclResponse>> getPostAcls(@PathVariable(name = ":boardCode") String boardCode,
//                                                          @PathVariable(name = ":postId") Long postId) {
//        List<PostAclResponse> acls = aclService.getPostAclList(postId);
//        return ApiResponse.onSuccess(acls);
//    }
    @PostMapping("/boards/:boardCode/acls")
    public ApiResponse<BoardAclResponse> createBoardAcl(@PathVariable(name = ":boardCode") String boardCode,@RequestBody BoardAclCreateRequest boardAclCreateRequest) {
        BoardAclResponse acl = aclService.createBoardAcl(boardCode, boardAclCreateRequest);
        return ApiResponse.onSuccess(acl);
    }
    @PatchMapping("/boards/:boardCode/acls/:boardAclId")
    public ApiResponse<BoardAclResponse> editBoardAcl(@PathVariable(name = ":boardAclId") Long boardAclId,@RequestBody BoardAclUpdateRequest boardAclUpdateRequest) {
        BoardAclResponse acl = aclService.editBoardAcl(boardAclId, boardAclUpdateRequest);
        return ApiResponse.onSuccess(acl);
    }
    @DeleteMapping("/boards/:boardCode/acls/:boardAclId")
    public ApiResponse<?> deleteBoardAcl(@PathVariable(name = ":boardCode") String boarderCode, @PathVariable(name = ":boardAclId") Long boardAclId) {
        aclService.deleteBoardAcl(boarderCode, boardAclId);
        return ApiResponse.onSuccess(null);
    }
}
