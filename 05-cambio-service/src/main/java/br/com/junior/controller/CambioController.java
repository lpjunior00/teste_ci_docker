package br.com.junior.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.junior.model.Cambio;
import br.com.junior.repository.CambioRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("cambio-service")
@Tag(name= "Cambio service API")
public class CambioController {
	
	@Autowired
	private Environment environment; 
	
	@Autowired
	private CambioRepository repository;

	@Operation(summary="Get cambio from currency")
	@GetMapping(value = "/{amount}/{from}/{to}")
	public Cambio findCambio(@PathVariable("amount") BigDecimal amount, @PathVariable("from") String from, @PathVariable("to") String to) {
		
		String port = environment.getProperty("local.server.port");
		Cambio cambio = repository.findByFromAndTo(from, to);
		if(cambio == null) {
			throw new RuntimeException("Currency unsported");
		}
		
		BigDecimal convertionFactor = cambio.getConversion_factor();
		BigDecimal convertedValue = convertionFactor.multiply(amount);
		cambio.setConvertion_value(convertedValue.setScale(2, RoundingMode.CEILING));
		cambio.setEnviroment(port);
		
		return cambio;
	}
		
}
