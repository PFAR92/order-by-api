package com.apirest.orderby.repositories;

import com.apirest.orderby.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    public List<Book> findByOrderByName();//Ordena pelo nome de maneira crescente

    public List<Book>findByOrderByAuthorAscPublicationDateDesc();//Ordena pelo autor e data de publicação decrescente


}
