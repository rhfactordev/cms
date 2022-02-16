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
public class DomainEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    public static DomainEntity fromDomain(Site site) {
        return DomainEntity.builder()
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
