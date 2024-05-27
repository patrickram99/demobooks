package com.uls.demobooks.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findBookByTitulo(String titulo);
    List<Book> findBookByAutor(String autor);

    List<Book> findBookByEditorial(@Param("editorial") String edtorial);

}
