package br.com.rhfactor.cms.application.port.out;

public interface DomainRepository {

    /**
     * Verificar se o domínio já existe em algum cadastro
     * @param domain
     * @return
     */
    boolean doesTheDomainExists(String domain);
}
