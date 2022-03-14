package br.com.rhfactor.cms.application.port.out;

import br.com.rhfactor.cms.domain.Blog;
import br.com.rhfactor.cms.domain.Category;

import java.util.List;

public interface CategoryRepository {

    List<Category> listAllCategoriesFromBlog(Blog blog);
}
