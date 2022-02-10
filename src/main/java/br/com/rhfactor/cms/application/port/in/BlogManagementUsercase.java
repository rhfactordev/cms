package br.com.rhfactor.cms.application.port.in;

import br.com.rhfactor.cms.application.port.in.commands.CreateBlogCommand;
import br.com.rhfactor.cms.domain.Blog;

public interface BlogManagementUsercase {

    /**
     * Este método deve criar o blog dentro de um site
     * A pessoa não precisará passar todos os parametros
     *
     * @param createBlogCommand
     * @return
     */
    Blog createBlog(CreateBlogCommand createBlogCommand );


}
