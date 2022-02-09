package br.com.rhfactor.cms.adapter.in.responses;

import br.com.rhfactor.cms.domain.Site;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level= AccessLevel.PRIVATE)
public class SiteResponse {

    Long id;

    public static SiteResponse fromDomain(Site site) {
        return SiteResponse.builder()
                .id( site.getId() )
                .build();
    }
}
