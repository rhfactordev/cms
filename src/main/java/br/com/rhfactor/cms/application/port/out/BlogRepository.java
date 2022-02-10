package br.com.rhfactor.cms.application.port.out;

import br.com.rhfactor.cms.domain.Blog;
import br.com.rhfactor.cms.domain.Site;

public interface BlogRepository {

    Blog save(Blog blog);

    /**
     * Verificar se já existe blog para este site
     * @param site
     * @return
     */
    boolean existsBySite(Site site);
}
