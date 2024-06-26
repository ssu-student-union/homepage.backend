package ussum.homepage.domain.acl.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ussum.homepage.domain.acl.BoardAcl;
import ussum.homepage.domain.acl.BoardAclRepository;
import ussum.homepage.domain.acl.PostAcl;
import ussum.homepage.domain.acl.PostAclRepository;
import ussum.homepage.global.error.exception.GeneralException;

import java.util.List;

import static ussum.homepage.global.error.status.ErrorStatus.BOARD_ACL_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class AclReader {
    private final BoardAclRepository boardAclRepository;
    private final PostAclRepository postAclRepository;
    public List<BoardAcl> getBoardAclList(Long boardId){
        return boardAclRepository.findByBoardId(boardId);
    }

//    public List<PostAcl> getPostAclList(Long postId) {
//        return postAclRepository.findByPostId(postId);
//    }

    public BoardAcl getBoardAcl(Long boarAclId){
        return boardAclRepository.findById(boarAclId).orElseThrow(()-> new GeneralException(BOARD_ACL_NOT_FOUND));
    }
}
