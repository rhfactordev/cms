package br.com.rhfactor.cms.adapter.out.persistence;

import br.com.rhfactor.cms.adapter.out.persistence.entity.SiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SiteEntityRepository extends JpaRepository<SiteEntity, Long> {
}
