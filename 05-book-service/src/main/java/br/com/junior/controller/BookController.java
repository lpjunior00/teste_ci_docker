package br.com.junior.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.junior.model.Book;
import br.com.junior.proxy.CambioProxy;
import br.com.junior.repository.BookRepository;
import br.com.junior.response.Cambio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("book-service")
@Tag(name="Book endpoint")
public class BookController {

	@Autowired
	private Environment environment;
	
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CambioProxy proxy;
	
	@Operation(summary = "Find a specific book with id")
	@GetMapping(value= "/{id}/{currency}")
	public Book findBook(@PathVariable("id") Long id, @PathVariable("currency") String currency) {
		
		
		Book book = repository.findById(id).orElseThrow(() -> new RuntimeException("book not found"));
		Cambio cambio = proxy.findCambio(book.getPrice(), "USD", currency);
		
		String port = environment.getProperty("local.server.port");
		book.setEnvironment("Book port: " + port + " cambio port: " + cambio.getEnviroment());
		book.setPrice(cambio.getConvertion_value());
		
		return book;
	}
	
}
