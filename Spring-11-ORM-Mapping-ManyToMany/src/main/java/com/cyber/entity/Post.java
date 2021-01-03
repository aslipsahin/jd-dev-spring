package com.cyber.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Post {

    /*
    In OneToOne, OneToMany, ManyToOne --> there is one primary key and one id column
    In ManyToMany --> there are 2 primary keys and 2 id columns in each table, and 1 extra joint table will be created by spring.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;

    //  When you use List, hibernate sometimes runs queries twice, so it is better to use Set instead of List.
    @ManyToMany(cascade = CascadeType.ALL)
//  I do not need to ise @JoinTable annotation, in this case Spring's default join table naming is "post-tags".
//  But i can change the joint table name by using this annotation.
//  I can also change the column names in the joint table as follow; joinColumns is for the column coming from this class,
//    and inverseJoinColums is for the column coming from the other class.
//  Also add @ManyToMany(mappedBy="tags") to the other class Tag.
    @JoinTable(name = "post_tag_rel",
            joinColumns = {@JoinColumn(name = "post_id")}, inverseJoinColumns = {@JoinColumn(name = "tag_id")})
    private Set<Tag> tags = new HashSet<>();


    public Post(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
