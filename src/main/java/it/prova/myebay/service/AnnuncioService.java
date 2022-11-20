package it.prova.myebay.service;

import java.util.List;

import it.prova.myebay.model.Annuncio;

public interface AnnuncioService {
	public List<Annuncio> listAllAnnunci();

	public Annuncio caricaSingoloAnnuncio(Long id);

	public void aggiorna(Annuncio annuncio);

	public void inserisciNuovo(Annuncio annuncio);

	public void rimuovi(Long idToDelete);

	public List<Annuncio> findByExample(Annuncio example);
}
