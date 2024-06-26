package com.uls.demobooks.domain;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="owner")
    private Owner owner;

    private String isbn, autor, titulo, editorial, opinion;
    private int añoPublicacion, rating;

    public Book() {}

    public Book(String autor, int añoPublicacion, String editorial, String isbn, int rating, String titulo, String opinion, Owner owner) {
        this.autor = autor;
        this.opinion = opinion;
        this.añoPublicacion = añoPublicacion;
        this.editorial = editorial;
        this.isbn = isbn;
        this.rating = rating;
        this.titulo = titulo;
        this.owner = owner;
    }

    public String getOpinion() {
        return opinion;
    }

    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAñoPublicacion() {
        return añoPublicacion;
    }

    public void setAñoPublicacion(int añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getrating() {
        return rating;
    }

    public void setrating(int rating) {
        this.rating = rating;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
