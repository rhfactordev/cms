package br.com.rhfactor.cms.adapter.out.persistence.repository;

import br.com.rhfactor.cms.adapter.out.persistence.entity.BlogEntity;
import br.com.rhfactor.cms.adapter.out.persistence.entity.SiteEntity;
import br.com.rhfactor.cms.domain.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlogEntityRepository extends JpaRepository<BlogEntity, Long> {

    Optional<BlogEntity> findBySite(SiteEntity site);

}
