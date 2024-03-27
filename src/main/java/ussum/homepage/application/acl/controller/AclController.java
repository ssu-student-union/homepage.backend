package ussum.homepage.application.acl.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ussum.homepage.application.acl.service.dto.response.BoardAclResponse;
import ussum.homepage.global.ApiResponse;

@RequiredArgsConstructor
@RequestMapping
@RestController
public class AclController {
    @GetMapping("/boards/:boardCode/acls")
    public ApiResponse<BoardAclResponse> getAcls() {

        return ApiResponse.onSuccess();
    }
}
