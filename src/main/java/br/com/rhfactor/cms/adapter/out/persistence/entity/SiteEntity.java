package br.com.rhfactor.cms.adapter.out.persistence.entity;

import br.com.rhfactor.cms.domain.Site;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "cms_site")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level= AccessLevel.PRIVATE)
public class SiteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    public static SiteEntity fromDomain(Site site) {
        return SiteEntity.builder()
                .id( site.getId() )
                .name( site.getName() )
                .build();
    }

    public Site toDomain() {
        return Site.builder()
                .id( id )
                .name( name )
                .build();
    }
}
