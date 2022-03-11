INSERT INTO cms_site (id, name) VALUES (1,'Sara Koimbra');
INSERT INTO cms_site_domain (id, domain, site_id) VALUES (1, 'sarakoimbra.com.br', 1);
INSERT INTO cms_blog (id, name, site_id) VALUES (1, 'Blog', 1);
INSERT INTO cms_blog_category (id, blog_id, name, slug) VALUES (1, 1,'Astrologia', 'astrologia');
INSERT INTO cms_blog_category (id, blog_id, name, slug) VALUES (2, 1,'Tarot', 'tarot');
