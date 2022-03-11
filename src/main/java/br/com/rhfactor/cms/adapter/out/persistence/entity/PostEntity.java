package br.com.rhfactor.cms.adapter.out.persistence.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cms_blog_post")

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


    String description;

    @Lob
    String content;


}
