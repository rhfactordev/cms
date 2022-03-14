package br.com.rhfactor.cms.adapter.out.persistence.converters;

import br.com.rhfactor.cms.domain.PageableRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class PersistenceConverters {

    public static Pageable convert(PageableRequest request){
        return PageRequest.of(request.getPageNumber(), request.getPageSize());
    }

}
