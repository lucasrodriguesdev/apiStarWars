package br.com.planeta.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.planeta.entities.Planeta;

@Repository
public interface PlanetaRepository extends JpaRepository<Planeta, Long> {

	Optional<Planeta> findByName(String name);
	
}
