package ussum.homepage.application.acl.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ussum.homepage.application.acl.service.dto.response.BoardAclResponse;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AclService {
    public BoardAclResponse getBoardAclList(String boardCode){

    }
}
