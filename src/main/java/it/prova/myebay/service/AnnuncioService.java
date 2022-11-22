package it.prova.myebay.service;

import java.util.List;

import it.prova.myebay.model.Annuncio;

public interface AnnuncioService {

	public List<Annuncio> listAll();

	public Annuncio caricaSingoloElemento(Long id);

	public void aggiorna(Annuncio annuncioInstance, String username);

	public void inserisciNuovo(Annuncio annuncioInstance, String username);

	public void rimuovi(Long idToDelete);

	public List<Annuncio> findByExample(Annuncio example, String username);

	public List<Annuncio> findByExampleEager(Annuncio example, String username);
	
	public Annuncio caricaSingoloElementoConCategorie(Long id, String username);

	public void acquista(Long id, String username);

}