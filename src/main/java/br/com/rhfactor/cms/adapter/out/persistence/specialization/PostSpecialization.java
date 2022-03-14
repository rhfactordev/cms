package br.com.rhfactor.cms.adapter.out.persistence.specialization;

import br.com.rhfactor.cms.adapter.out.persistence.entity.BlogEntity;
import br.com.rhfactor.cms.adapter.out.persistence.entity.CategoryEntity;
import br.com.rhfactor.cms.adapter.out.persistence.entity.PostEntity;
import br.com.rhfactor.cms.adapter.out.persistence.entity.PostEntity_;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;

public class PostSpecialization {

    public static Specification<PostEntity> blog(Long blogId){
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get(PostEntity_.BLOG).get("id") , blogId );
        };
    }

    public static Specification<PostEntity> category(Optional<Long> categoryId){
        if( categoryId.isEmpty() ){
            return null;
        }
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get(PostEntity_.CATEGORY).get("id") , categoryId.get() );
        };
    }

    public static Specification<PostEntity> categorySource(Optional<String> slug) {
        if( slug.isEmpty() ){
            return null;
        }
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal( root.get(PostEntity_.CATEGORY).get("slug") , slug.get() );
        };
    }

    public static Specification<PostEntity> source(Optional<String> slug) {
        if( slug.isEmpty() ){
            return null;
        }
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal( root.get(PostEntity_.SLUG) , slug.get() );
        };
    }
}
