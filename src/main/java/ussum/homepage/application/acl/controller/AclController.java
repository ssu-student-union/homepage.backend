package ussum.homepage.application.acl.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ussum.homepage.application.acl.service.AclService;
import ussum.homepage.application.acl.service.dto.request.BoardAclCreateRequest;
import ussum.homepage.application.acl.service.dto.response.BoardAclResponse;
import ussum.homepage.global.ApiResponse;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping
@RestController
public class AclController {
    private final AclService aclService;
    @GetMapping("/boards/:boardCode/acls")
    public ApiResponse<List<BoardAclResponse>> getAcls(@PathVariable(name = ":boardCode") String boardCode) {
        List<BoardAclResponse> acls = aclService.getBoardAclList(boardCode);
        return ApiResponse.onSuccess(acls);
    }
    @PostMapping("/boards/:boardCode/acls")
    public ApiResponse<BoardAclResponse> createBoardAcl(@PathVariable(name = ":boardCode") String boardCode,@RequestBody BoardAclCreateRequest boardAclCreateRequest) {
        BoardAclResponse acl = aclService.createBoardAcl(boardCode, boardAclCreateRequest);
        return ApiResponse.onSuccess(acl);
    }
}
