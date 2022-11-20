package it.prova.myebay.repository.repository.annuncio;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.prova.myebay.model.Annuncio;
import it.prova.myebay.model.Utente;

public interface AnnuncioRepository extends CrudRepository<Annuncio, Long>, CustomAnnuncioRepository{
//	@Query("from Annuncio a where a.utente.nickname = ?1")
//	List<Annuncio> findListAnnunci(Utente input);
}
