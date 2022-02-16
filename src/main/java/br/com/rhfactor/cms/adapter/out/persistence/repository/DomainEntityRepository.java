package br.com.rhfactor.cms.adapter.out.persistence.repository;

import br.com.rhfactor.cms.adapter.out.persistence.entity.DomainEntity;
import br.com.rhfactor.cms.adapter.out.persistence.entity.SiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomainEntityRepository extends JpaRepository<DomainEntity, Long> {
}
