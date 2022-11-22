package it.prova.myebay.service;

import java.util.List;

import it.prova.myebay.model.Annuncio;
import it.prova.myebay.model.Utente;

public interface AnnuncioService {

	public List<Annuncio> listAll();

	public Annuncio caricaSingoloElemento(Long id);

	public Annuncio caricaSingoloElementoConCategorie(Long id);

	public void aggiorna(Annuncio annuncioInstance);

	public void inserisciNuovo(Annuncio annuncioInstance, String username);

	public void rimuovi(Long idToDelete);

	public List<Annuncio> findByExample(Annuncio example);

	public List<Annuncio> findByExampleEager(Annuncio example);

	public void acquista(Long id, Utente utenteInstance);

}