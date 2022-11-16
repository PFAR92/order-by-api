package com.apirest.orderby.resources;

import com.apirest.orderby.entities.Book;
import com.apirest.orderby.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/books")
public class BookResource {

    @Autowired
    private BookRepository repository;

    @GetMapping
    public ResponseEntity<List<Book>> findAll(){
        List<Book> result = repository.findAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/sortByName")
    public ResponseEntity<List<Book>> findOrderByName(){
        List<Book> result = repository.findByOrderByName();
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/sortByAuthorAndDate")
    public ResponseEntity<List<Book>> findOrderByAuthorAndDate(){
        List<Book> result = repository.findByOrderByAuthorAscPublicationDateDesc();
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/sort")
    public ResponseEntity<List<Book>> findOrderSort(){
        List<Book> result = repository.findAll(Sort.by(Sort.Direction.ASC, "name")); //ordenar pelo nome por aqui
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/sort2")
    public ResponseEntity<List<Book>> findOrderSort2(){
        Sort sort = Sort.by(Sort.Order.asc("author"), Sort.Order.desc("publicationDate"));
        List<Book> result = repository.findAll(sort);
        return ResponseEntity.ok(result);
    }

}
