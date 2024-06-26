package ussum.homepage.domain.acl.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ussum.homepage.application.acl.service.dto.request.BoardAclCreateRequest;
import ussum.homepage.domain.acl.BoardAcl;
import ussum.homepage.domain.acl.BoardAclRepository;

@Service
@RequiredArgsConstructor
public class AclAppender {
    private final BoardAclRepository boardAclRepository;
    @Transactional
    public BoardAcl appendBoardAcl(BoardAcl boardAcl){
         return boardAclRepository.save(boardAcl);
    }
}
