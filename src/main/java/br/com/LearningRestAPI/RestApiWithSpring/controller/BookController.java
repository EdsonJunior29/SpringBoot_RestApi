package br.com.LearningRestAPI.RestApiWithSpring.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.LearningRestAPI.RestApiWithSpring.data.vo.BookVO;
import br.com.LearningRestAPI.RestApiWithSpring.services.BookServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Book EndPoint" , description = "Description for book" , tags = {"BookEndpoint"})
@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	private BookServices service;
	
	@ApiOperation(value = "Find all books")
	@GetMapping(produces = {"application/json" , "application/xml" , "application/x-yaml"})
	public List<BookVO> findAll(){
		List<BookVO> books = service.findAll();
		books.stream().forEach(p -> p.add(linkTo(methodOn(BookController.class)
				.findById(p.getKey())).withSelfRel()));
		return books;
	}
	
	@ApiOperation(value = "Find By Id")
	@GetMapping(value = "/{id}" , produces = {"application/json" , "application/xml" , "application/x-yaml"})
	public BookVO findById(@PathVariable("id") Long id){
		BookVO bookVO = service.findById(id);
		bookVO.add(linkTo(methodOn(BookController.class).findById(id)).withSelfRel());
		return bookVO;
	}
	
	@ApiOperation(value = "Create new book")
	@PostMapping(produces = {"application/json" , "application/xml" , "application/x-yaml"} , 
			consumes =  {"application/json" , "application/xml" , "application/x-yaml"})
	public BookVO create(@RequestBody BookVO book){
		BookVO bookVO = service.create(book);
		bookVO.add(linkTo(methodOn(BookController.class).findById(bookVO.getKey())).withSelfRel());
		return bookVO;
	}
	
	@ApiOperation(value = "Update information")
	@PutMapping(produces = {"application/json" , "application/xml" , "application/x-yaml"} , 
			consumes =  {"application/json" , "application/xml" , "application/x-yaml"})
	public BookVO update(@RequestBody BookVO book){
		BookVO bookVO = service.update(book);
		bookVO.add(linkTo(methodOn(PersonController.class).findById(bookVO.getKey())).withSelfRel());
		return bookVO;
	}
	
	@ApiOperation(value = "Delete Book for Id")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") Long id){
		service.delete(id);
		return ResponseEntity.ok().build();
	}
	
}

