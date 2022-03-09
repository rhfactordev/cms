package br.com.rhfactor.cms.adapter.out.persistence.repository;

import br.com.rhfactor.cms.adapter.out.persistence.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostEntityRepository extends JpaRepository<PostEntity, Long> {
}
