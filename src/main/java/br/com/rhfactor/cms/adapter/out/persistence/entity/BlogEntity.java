package br.com.rhfactor.cms.adapter.out.persistence.entity;

import br.com.rhfactor.cms.domain.Blog;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "cms_blog")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level= AccessLevel.PRIVATE)
public class BlogEntity {

    public BlogEntity(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false, updatable = false, name = "site_id")
    SiteEntity site;



    public static BlogEntity fromDomain(Blog blog) {
        return BlogEntity.builder()
                .id( blog.getId() )
                .site( blog.getSite() == null ? null : SiteEntity.fromDomain( blog.getSite() ) )
                .name( blog.getTitle() )
                .build();
    }

    public Blog toDomain() {
        return Blog.builder()
                .id( id )
                .title( name )
                .site( site.toDomain() )
                .build();
    }
}
