package br.com.rhfactor.cms.adapter.out.persistence.entity;

import br.com.rhfactor.cms.adapter.in.responses.LinkResponse;
import br.com.rhfactor.cms.domain.Post;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Calendar;


/**
 * @see br.com.rhfactor.cms.domain.Post
 */
@Entity
@Table(name = "cms_blog_post", uniqueConstraints = {
        @UniqueConstraint(name = "UN_post_slug", columnNames = {"category_id","slug"}),
        @UniqueConstraint(name = "UN_post_title", columnNames = {"category_id","title"})
})

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level= AccessLevel.PRIVATE)
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(optional = false)
    @JoinColumn(updatable = false, nullable = false, name = "blog_id")
    BlogEntity blog;

    @ManyToOne(optional = false)
    @JoinColumn(updatable = false, nullable = false, name = "category_id")
    CategoryEntity category;

    @NotNull
    @NotEmpty
    String title;

    @NotNull
    @NotEmpty
    @Length(min = 1)
//    @Pattern(regexp = "[a-zA-Z0-9-_]")
    String slug;

    @Column(columnDefinition = "TEXT")
    String description;

    @Lob
    String content;

    @Column(length = 200)
    String image;

    @Builder.Default
    Calendar creationDate = Calendar.getInstance();

    Calendar publishedDate;

    Calendar lastUpdateDate;

    public static <R> Post toDomain(PostEntity postEntity) {
        return Post.builder()
                .id(postEntity.getId())
                .blog(postEntity.getBlog().toDomain())
                .category( CategoryEntity.toDomain(postEntity.getCategory()) )
                .title(postEntity.getTitle())
                .slug(postEntity.getSlug())
                .description(postEntity.getDescription())
                .content(postEntity.getContent())
                .image(postEntity.getImage())
                .build();
    }

    public static PostEntity fromDomain(Post post) {
        return PostEntity.builder()
                .id(post.getId())
                .blog( BlogEntity.fromDomain( post.getBlog() ) )
                .category( CategoryEntity.fromDomain( post.getCategory() ) )
                .title(post.getTitle())
                .slug(post.getSlug())
                .description(post.getDescription())
                .content(post.getContent())
                .image(post.getImage())
                .build();
    }
}
