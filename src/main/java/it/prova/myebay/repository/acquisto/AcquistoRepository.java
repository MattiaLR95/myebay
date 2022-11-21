package it.prova.myebay.repository.acquisto;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.prova.myebay.model.Acquisto;

public interface AcquistoRepository extends CrudRepository<Acquisto, Long>, CustomAcquistoRepository {

	@Query("from Acquisto a join a.utente u where u.id = ?1")
	public List<Acquisto> findAcquistiUtente(Long id);
}