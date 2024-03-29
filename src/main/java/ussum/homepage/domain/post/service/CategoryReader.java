package ussum.homepage.domain.post.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ussum.homepage.domain.post.Category;
import ussum.homepage.domain.post.CategoryRepository;
import ussum.homepage.global.error.exception.GeneralException;

import static ussum.homepage.global.error.status.ErrorStatus.CATEGORY_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class CategoryReader {
    private final CategoryRepository categoryRepository;

    public Category getCategoryWithCode(String categoryCode) {
        return categoryRepository.findByMajorCode(categoryCode)
                .orElseThrow(() -> new GeneralException(CATEGORY_NOT_FOUND));
    }
}
