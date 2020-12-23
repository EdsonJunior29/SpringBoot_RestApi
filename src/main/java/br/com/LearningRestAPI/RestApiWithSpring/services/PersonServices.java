package br.com.LearningRestAPI.RestApiWithSpring.services;

import java.util.ArrayList;
import java.util.List;
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
	
	public List<Person> findAll(){
		List<Person> persons = new ArrayList<Person>();
		for (int i = 0; i < 8; i++) {
			Person person = mockPerson(i);
			persons.add(person);
		}
		return persons;
	}
	
	public Person create(Person person) {
		return person;
	}
	
	public Person update(Person person) {
		return person;
	}
	
	public void delete(String id) {
		
	}

	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person name " + i);
		person.setLastName("Last name " + i);
		person.setAddress("Address " + i);
		person.setGender("Male");
		return person;
	}
	
	
	

}
