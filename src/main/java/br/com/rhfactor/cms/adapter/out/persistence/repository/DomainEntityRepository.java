package br.com.rhfactor.cms.adapter.out.persistence.repository;

import br.com.rhfactor.cms.adapter.out.persistence.entity.DomainEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DomainEntityRepository extends JpaRepository<DomainEntity, Long> {

    Optional<DomainEntity> findByDomain(String domain);

}
