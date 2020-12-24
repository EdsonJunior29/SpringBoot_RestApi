package br.com.LearningRestAPI.RestApiWithSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.LearningRestAPI.RestApiWithSpring.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
