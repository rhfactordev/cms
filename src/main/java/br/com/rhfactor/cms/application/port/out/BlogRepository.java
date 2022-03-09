package br.com.rhfactor.cms.application.port.out;

import br.com.rhfactor.cms.domain.Blog;
import br.com.rhfactor.cms.domain.Site;

import java.util.Optional;

public interface BlogRepository {

    Blog save(Blog blog);

    /**
     * Verificar se já existe blog para este site
     * @param site
     * @return
     */
    boolean existsBySite(Site site);

    Optional<Blog> findByDomain(String domain);
}
