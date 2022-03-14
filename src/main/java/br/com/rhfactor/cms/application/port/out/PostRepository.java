package br.com.rhfactor.cms.application.port.out;

import br.com.rhfactor.cms.domain.Blog;
import br.com.rhfactor.cms.domain.Page;
import br.com.rhfactor.cms.domain.PageableRequest;
import br.com.rhfactor.cms.domain.Post;

import java.util.Optional;

public interface PostRepository {

    Optional<Post> findByBlogAndSource(Blog blog, String source);

    Page<Post> findPosts(Blog blog, Optional<String> category, Optional<String> tag, PageableRequest pageableRequest);

}
