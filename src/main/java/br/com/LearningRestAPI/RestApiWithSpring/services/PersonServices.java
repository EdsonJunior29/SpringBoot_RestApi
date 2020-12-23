package br.com.LearningRestAPI.RestApiWithSpring.services;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.LearningRestAPI.RestApiWithSpring.model.Person;

@Service
public class PersonServices {
	
	//O mesmo vai simular um ID nobanco de dados(gerando um id novo).
	private final AtomicLong counter = new AtomicLong();
	
	//Método para buscar por ID
	public Person findById(String id) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Edson");
		person.setLastName("Junior");
		person.setAddress("Rua 1");
		person.setGender("Male");
		return person ;
	}
	
	
	

}
