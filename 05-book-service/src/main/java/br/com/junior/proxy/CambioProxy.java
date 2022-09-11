package br.com.junior.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.junior.response.Cambio;

@FeignClient(name="cambio-service")
public interface CambioProxy {
	
	@GetMapping(value = "cambio-service/{amount}/{from}/{to}")
	public Cambio findCambio(@PathVariable("amount") Double amount, @PathVariable("from") String from, @PathVariable("to") String to);

}
