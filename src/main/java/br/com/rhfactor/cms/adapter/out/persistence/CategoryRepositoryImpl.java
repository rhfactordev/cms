package br.com.rhfactor.cms.adapter.out.persistence;

import br.com.rhfactor.cms.application.port.out.CategoryRepository;
import br.com.rhfactor.cms.domain.Blog;
import br.com.rhfactor.cms.domain.Category;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;


@Slf4j
@Component
@RequiredArgsConstructor
public class CategoryRepositoryImpl implements CategoryRepository {

    @Override
    public List<Category> listAllCategoriesFromBlog(Blog blog) {
        return null;
    }
}
