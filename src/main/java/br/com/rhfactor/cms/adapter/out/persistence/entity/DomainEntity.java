package br.com.rhfactor.cms.adapter.out.persistence.entity;

import br.com.rhfactor.cms.domain.Domain;
import br.com.rhfactor.cms.domain.Site;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table(name = "cms_site_domain")

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level= AccessLevel.PRIVATE)
public class DomainEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false, updatable = false, name = "site_id")
    SiteEntity site;

    String domain;

    public static DomainEntity fromDomain(Site site) {
        return DomainEntity.builder()
                .id( site.getId() )
                .domain( site.getName() )
                .build();
    }

    public Domain toDomain() {
        // TODO: Implementar
        return Domain.builder()
                .build();
    }
}
