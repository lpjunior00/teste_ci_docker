package br.com.junior.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.junior.model.Cambio;

public interface CambioRepository extends JpaRepository<Cambio, Long>{

	Cambio findByFromAndTo(String from, String to);
	
}
