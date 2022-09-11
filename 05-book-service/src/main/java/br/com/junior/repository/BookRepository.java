package br.com.junior.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.junior.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
