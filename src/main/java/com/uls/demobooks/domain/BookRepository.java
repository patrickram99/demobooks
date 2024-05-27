package com.uls.demobooks.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findBookByTitulo(String titulo);
    List<Book> findBookByAutor(String autor);
    List<Book> findBookByEditorial(String editorial);

}
