package com.ganesh.model;


import lombok.Data;

import javax.persistence.*;

/**
 * @created: 29/09/2021 - 11:15 AM
 * @author: Ganesh
 */

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String isbn;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;
}
