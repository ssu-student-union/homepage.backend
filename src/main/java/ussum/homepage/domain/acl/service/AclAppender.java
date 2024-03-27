package ussum.homepage.domain.acl.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ussum.homepage.application.acl.service.dto.request.BoardAclCreateRequest;
import ussum.homepage.domain.acl.BoardAcl;
import ussum.homepage.domain.acl.BoardAclRepository;

@Service
@RequiredArgsConstructor
public class AclAppender {
    private final BoardAclRepository boardAclRepository;
    public BoardAcl appendBoardAcl(BoardAcl boardAcl){
         boardAclRepository.save(boardAcl);
         return boardAcl;
    }
}
