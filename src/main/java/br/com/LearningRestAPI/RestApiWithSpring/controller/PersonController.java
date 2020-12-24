package br.com.LearningRestAPI.RestApiWithSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.LearningRestAPI.RestApiWithSpring.model.Person;
import br.com.LearningRestAPI.RestApiWithSpring.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonServices service;
	
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public List<Person> findAll(){
		return service.findAll();
	}
	
	@RequestMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public Person findById(@PathVariable("id") Long id){
		return service.findById(id);
	}
	
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public Person create(@RequestBody Person person){
		return service.create(person);
	}
	
	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
	public Person update(@RequestBody Person person){
		return service.update(person);
	}
	
	@RequestMapping(value = "/{id}", 
			method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id){
		service.delete(id);
	}
	
}
