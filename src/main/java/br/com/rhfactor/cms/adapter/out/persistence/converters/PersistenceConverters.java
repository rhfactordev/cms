package br.com.rhfactor.cms.adapter.out.persistence.converters;

import br.com.rhfactor.cms.domain.PageableRequest;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class PersistenceConverters {

    public static Pageable toPeageable(PageableRequest request){
        return PageRequest.of(request.getPageNumber(), request.getPageSize());
    }

    public static PageableRequest toPeageableRequest(Pageable request){
        return PageableRequest.of(request.getPageNumber(), request.getPageSize());
    }

    public static org.springframework.data.domain.Page toPage( br.com.rhfactor.cms.domain.Page domainPage ){

        List<?> list = domainPage.getContent();
        Pageable page = toPeageable(domainPage.getPageRequest());
        long total = domainPage.getTotalElements();

        return new PageImpl<>( list , page , total );
    }





}
