package it.prova.myebay.repository.repository.annuncio;

import java.util.List;

import it.prova.myebay.model.Annuncio;

public interface CustomAnnuncioRepository {
	List<Annuncio> findByExample(Annuncio example);
}
