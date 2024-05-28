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

		ownerRepository.saveAll(Arrays.asList(owner1, owner2));
		repository.save(new Book("Gabriel García Márquez", 1967, "Harper & Row", "978-3-16-148410-0", 5, "Cien años de soledad", "No deberia haber tantos Aurelio-algo", owner1));
		repository.save(new Book("Paulo Coelho", 1988, "HarperOne", "978-0-7432-7359-5", 3, "El Alquimista", "",owner1 ));
		repository.save(new Book("George O|rwell", 1949, "Secker & Warburg", "978-0-14-243796-4", 4, "1984", "La escena final de la television es muy pesimista",owner2));
		repository.save(new Book("F. Scott Fitzgerald", 1925, "Charles Scribner's Sons", "978-0-14-118776-1", 2, "El gran Gatsby", "Sry, zzzzz",owner2));
		repository.save(new Book("Orgullo y Prejuicio", 1813, "Thomas Egerton", "978-1503290563", 1, "Jane Austen", "Como pudiste dejar a Mr Darcy por COLLINS", owner2));
	}

}
