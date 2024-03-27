package ussum.homepage.application.acl.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ussum.homepage.application.acl.service.AclService;
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
}
