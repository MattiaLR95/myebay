package it.prova.myebay.security;

import java.util.List;

import it.prova.myebay.model.Annuncio;

public interface AnnuncioService {
	public List<Annuncio> listAllElements();

	public Annuncio caricaSingoloElemento(Long id);

	public Annuncio caricaSingoloElementoEager(Long id);

	public void aggiorna(Annuncio annuncioInstance);

	public void inserisciNuovo(Annuncio annuncioInstance);

	public void rimuovi(Long idAnnunncioToDelete);

	public List<Annuncio> findByExample(Annuncio example);
}
