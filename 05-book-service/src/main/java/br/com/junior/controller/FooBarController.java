package br.com.junior.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("book-service")
@Tag(name="foo-bar")
public class FooBarController {
	
	private Logger logger = LoggerFactory.getLogger(FooBarController.class);

	@Operation(summary = "Foo-bar")
	@GetMapping(path = "/foo-bar")
//	@Retry(name = "prod", fallbackMethod = "fallbackMethod") 
//	@CircuitBreaker(name = "default", fallbackMethod = "fallbackMethod")
//	@RateLimiter(name="default")
	@Bulkhead(name="default")
	public String fooBar() {
		logger.info("Request foo-bar is received!!!");
//		ResponseEntity<String> response = new RestTemplate().getForEntity("http://localhost:8080/foo-bar", String.class);
		return "foobar";
//		return response.getBody();
	}
	
	public String fallbackMethod (Exception e) {
		return "fallbackmethod foo-bar";
	}
	
}
