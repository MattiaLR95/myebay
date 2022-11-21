package it.prova.myebay.repository.utente;

import java.util.List;

import it.prova.myebay.model.Utente;

public interface CustomUtenteRepository {
	List<Utente> findByExample(Utente example);

}