package br.com.LearningRestAPI.RestApiWithSpring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.LearningRestAPI.RestApiWithSpring.exception.ResourceNotFoundException;
import br.com.LearningRestAPI.RestApiWithSpring.converter.DozerConverter;
import br.com.LearningRestAPI.RestApiWithSpring.data.model.Person;
import br.com.LearningRestAPI.RestApiWithSpring.data.vo.PersonVO;
import br.com.LearningRestAPI.RestApiWithSpring.repository.PersonRepository;

@Service
public class PersonServices {
	
	@Autowired
	PersonRepository repository;
	
	//Método para buscar por ID
	public PersonVO findById(Long id) {
		var entity = repository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		return DozerConverter.parseObject(entity, PersonVO.class);
	}
	
	public List<PersonVO> findAll(){	
		return DozerConverter.parseListObjects(repository.findAll(), PersonVO.class);
	}
	
	public PersonVO create(PersonVO person) {
		var entity = DozerConverter.parseObject(person, Person.class);
		var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	public PersonVO update(PersonVO person) {
		Person entity = repository.findById(person.getkey()).
		orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		var vo = DozerConverter.parseObject(repository.save(entity) , PersonVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		Person entity = repository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}
	
}
