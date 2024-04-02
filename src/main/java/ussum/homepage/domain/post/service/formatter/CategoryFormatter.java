package ussum.homepage.domain.post.service.formatter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ussum.homepage.application.post.service.dto.response.CategoryResponse;
import ussum.homepage.domain.post.Category;
import ussum.homepage.domain.post.service.CategoryReader;
import ussum.homepage.domain.post.service.PostReader;

@Service
@RequiredArgsConstructor
public class CategoryFormatter implements ussum.homepage.domain.post.service.CategoryFormatter {
    private final CategoryReader categoryReader;

    @Override
    public CategoryResponse format(Long categoryId) {
        final Category category = categoryReader.getCategoryById(categoryId);
        return CategoryResponse.of(category);
    }
}
