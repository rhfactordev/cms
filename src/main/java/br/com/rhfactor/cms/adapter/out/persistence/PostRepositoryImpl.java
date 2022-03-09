package br.com.rhfactor.cms.adapter.out.persistence;

import br.com.rhfactor.cms.application.port.out.CategoryRepository;
import br.com.rhfactor.cms.application.port.out.PostRepository;
import br.com.rhfactor.cms.domain.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Slf4j
@Component
@RequiredArgsConstructor
public class PostRepositoryImpl implements PostRepository {

    @Override
    public Optional<Post> findByBlogAndSource(Blog blog, String source) {
        return Optional.empty();
    }

    @Override
    public Page<Post> findPosts(Blog blog, Optional<String> category, Optional<String> tag, PageRequest pageRequest) {
        return null;
    }
}
