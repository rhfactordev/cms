package br.com.rhfactor.cms.adapter.out.persistence.repository;

import br.com.rhfactor.cms.adapter.out.persistence.entity.BlogEntity;
import br.com.rhfactor.cms.adapter.out.persistence.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostEntityRepository extends JpaRepository<PostEntity, Long>, JpaSpecificationExecutor<PostEntity> {

    Optional<PostEntity> findByBlogAndId(BlogEntity blog, Long id);

}
