package ussum.homepage.domain.post.service;

import ussum.homepage.application.post.service.dto.response.CategoryResponse;
import ussum.homepage.application.post.service.dto.response.PostResponse;

public interface CategoryFormatter {
    CategoryResponse format(Long categoryId);
}
