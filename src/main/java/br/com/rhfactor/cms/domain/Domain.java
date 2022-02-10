package br.com.rhfactor.cms.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Domain {

    Long id;

    Site site;

    String url;

    Boolean active;

    LocalDateTime creationDate;

}
