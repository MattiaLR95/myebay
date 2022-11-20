package it.prova.myebay.repository.repository.annuncio;

import org.springframework.data.repository.CrudRepository;

import it.prova.myebay.model.Annuncio;

public interface AnnuncioRepository extends CrudRepository<Annuncio, Long>, CustomAnnuncioRepository{

}
