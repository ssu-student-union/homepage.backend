package ussum.homepage.domain.post.service;

import ussum.homepage.application.post.service.dto.response.PostResponse;

public interface PostFormatter {
    PostResponse format(Long postId);
}
