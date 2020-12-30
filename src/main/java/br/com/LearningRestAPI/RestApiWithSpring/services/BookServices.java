package br.com.LearningRestAPI.RestApiWithSpring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.LearningRestAPI.RestApiWithSpring.converter.DozerConverter;
import br.com.LearningRestAPI.RestApiWithSpring.data.model.Book;
import br.com.LearningRestAPI.RestApiWithSpring.data.vo.BookVO;
import br.com.LearningRestAPI.RestApiWithSpring.exception.ResourceNotFoundException;
import br.com.LearningRestAPI.RestApiWithSpring.repository.BookRepository;

@Service
public class BookServices {
	
	@Autowired
	BookRepository repository;
	
	//Método para buscar por ID
	public BookVO findById(Long id) {
		var entity = repository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		return DozerConverter.parseObject(entity, BookVO.class);
	}
	
	public List<BookVO> findAll(){	
		return DozerConverter.parseListObjects(repository.findAll(), BookVO.class);
	}
	
	public BookVO create(BookVO book) {
		var entity = DozerConverter.parseObject(book, Book.class);
		var vo = DozerConverter.parseObject(repository.save(entity), BookVO.class);
		return vo;
	}
	
	public BookVO update(BookVO book) {
		Book entity = repository.findById(book.getKey()).
		orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		
		entity.setAuthor(book.getAuthor());
		entity.setLaunchDate(book.getLaunchDate());
		entity.setPrice(book.getPrice());
		entity.setTitle(book.getTitle());
		var vo = DozerConverter.parseObject(repository.save(entity) , BookVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		Book entity = repository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
		repository.delete(entity);
	}
	
}
