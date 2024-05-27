package com.uls.demobooks;

import com.uls.demobooks.domain.BookRepository;
import com.uls.demobooks.domain.Owner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uls.demobooks.domain.Book;

import com.uls.demobooks.domain.Owner;
import com.uls.demobooks.domain.OwnerRepository;

import java.util.Arrays;

@SpringBootApplication
public class DemobooksApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(DemobooksApplication.class);
	@Autowired
	private BookRepository repository;

	@Autowired
	private OwnerRepository ownerRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemobooksApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Owner owner1 = new Owner("Juan", "Gomez");
		Owner owner2 = new Owner("Maria", "Perez");
|
		ownerRepository.saveAll(Arrays.asList(owner1, owner2));
		repository.save(new Book("Gabriel García Márquez", 1967, "Harper & Row", "978-3-16-148410-0", 1, "Cien años de soledad", owner1));
		repository.save(new Book("Paulo Coelho", 1988, "HarperOne", "978-0-7432-7359-5", 1, "El Alquimista", owner1));
		repository.save(new Book("George Orwell", 1949, "Secker & Warburg", "978-0-14-243796-4", 1, "1984", owner2));
		repository.save(new Book("F. Scott Fitzgerald", 1925, "Charles Scribner's Sons", "978-0-14-118776-1", 1, "El gran Gatsby", owner2));
		repository.save(new Book("J.D. Salinger", 1951, "Little, Brown and Company", "978-0-618-05699-6", 1, "El guardián entre el centeno", owner2));
	}

}
