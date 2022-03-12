INSERT INTO cms_site (id, name) VALUES (1,'Sara Koimbra');
INSERT INTO cms_site_domain (id, domain, site_id) VALUES (1, 'sarakoimbra.com.br', 1);
INSERT INTO cms_blog (id, name, site_id) VALUES (1, 'Blog', 1);
INSERT INTO cms_blog_category (id, blog_id, name, slug) VALUES (1, 1,'Astrologia', 'astrologia');
INSERT INTO cms_blog_category (id, blog_id, name, slug) VALUES (2, 1,'Tarot', 'tarot');
INSERT INTO cms_blog_post (id, blog_id, category_id, title, slug, description, content) VALUES (1,1, 2,'Tarot', 'o-tarot','Aqui vem o conteudo, cloque','<p>Conteúdo</p>');
INSERT INTO cms_blog_post (id, blog_id, category_id, title, slug, description, content) VALUES (2,1, 1,'Astrologia', 'a-astrologia','Aqui vem o conteudo de astrologia, cloque','<p>Conteúdo de astrologia</p>');
