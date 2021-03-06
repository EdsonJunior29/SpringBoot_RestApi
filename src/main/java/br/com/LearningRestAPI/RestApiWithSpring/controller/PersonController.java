package br.com.LearningRestAPI.RestApiWithSpring.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.LearningRestAPI.RestApiWithSpring.data.vo.PersonVO;
import br.com.LearningRestAPI.RestApiWithSpring.services.PersonServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Person EndPoint" , description = "Description for person" , tags = {"PersonEndpoint"})
//@CrossOrigin
@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonServices service;
	
	//@CrossOrigin(origins = "http://localhost:8081") exemplo de CORS.
	@ApiOperation(value = "Find all people")
	@GetMapping(produces = {"application/json" , "application/xml" , "application/x-yaml"})
	public List<PersonVO> findAll(){
		List<PersonVO> persons = service.findAll();
		persons.stream().forEach(p -> p.add(linkTo(methodOn(PersonController.class)
				.findById(p.getkey())).withSelfRel()));
		return persons;
	}
	
	@ApiOperation(value = "Find by Id")
	@GetMapping(value = "/{id}" , produces = {"application/json" , "application/xml" , "application/x-yaml"})
	public PersonVO findById(@PathVariable("id") Long id){
		PersonVO personVO = service.findById(id);
		personVO.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
		return personVO;
	}
	
	@ApiOperation(value = "New People")
	@PostMapping(produces = {"application/json" , "application/xml" , "application/x-yaml"} , 
			consumes =  {"application/json" , "application/xml" , "application/x-yaml"})
	public PersonVO create(@RequestBody PersonVO person){
		PersonVO personVO = service.create(person);
		personVO.add(linkTo(methodOn(PersonController.class).findById(personVO.getkey())).withSelfRel());
		return personVO;
	}
	
	@ApiOperation(value = "Update Informations")
	@PutMapping(produces = {"application/json" , "application/xml" , "application/x-yaml"} , 
			consumes =  {"application/json" , "application/xml" , "application/x-yaml"})
	public PersonVO update(@RequestBody PersonVO person){
		PersonVO personVO = service.update(person);
		personVO.add(linkTo(methodOn(PersonController.class).findById(personVO.getkey())).withSelfRel());
		return personVO;
	}
	
	@ApiOperation(value = "Delete people")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	
}
