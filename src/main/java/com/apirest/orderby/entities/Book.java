package com.apirest.orderby.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_book")
public class Book implements Serializable {
    private static final long serialVersionUDI = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String publisher;
    private Integer publicationDate;
    private String author;
}
