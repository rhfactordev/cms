package br.com.rhfactor.cms.adapter.out.persistence.entity;

import br.com.rhfactor.cms.domain.Blog;
import br.com.rhfactor.cms.domain.Category;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "cms_blog_category", uniqueConstraints = {
        @UniqueConstraint(name = "UN_blog_category_slug", columnNames = {"blog_id", "slug" }),
        @UniqueConstraint(name = "UN_blog_category_name", columnNames = {"blog_id", "name" })
})

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level= AccessLevel.PRIVATE)
public class CategoryEntity {

    public CategoryEntity(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(optional = false)
    @JoinColumn(updatable = false, nullable = false, name = "blog_id")
    BlogEntity blog;

    @NotNull
    @NotEmpty
    String name;

    @NotNull
    @NotEmpty
    @Length(min = 1)
//    @Pattern(regexp = "[a-zA-Z0-9-_]")
    String slug;

    // TODO: Testar
    public static <R> Category toDomain(CategoryEntity categoryEntity) {
        return Category.builder()
                .id(categoryEntity.getId())
                .blog(categoryEntity.getBlog().toDomain())
                .name(categoryEntity.getName())
                .slug(categoryEntity.getSlug())
                .build();
    }

    public static CategoryEntity fromDomain(Category category) {
        return CategoryEntity.builder()
                .id(category.getId())
                .blog( category.getBlog() == null ? null : BlogEntity.fromDomain( category.getBlog() ) )
                .name(category.getName())
                .slug(category.getSlug())
                .build();
    }
}
