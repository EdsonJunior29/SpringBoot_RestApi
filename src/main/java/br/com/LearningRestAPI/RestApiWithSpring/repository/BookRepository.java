package br.com.LearningRestAPI.RestApiWithSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.LearningRestAPI.RestApiWithSpring.data.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}
