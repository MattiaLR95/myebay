package it.prova.myebay.service;

import java.util.List;

import it.prova.myebay.model.Categoria;

public interface CategoriaService {

	public List<Categoria> listAll();

	public Categoria caricaSingoloElemento(Long id);

	public void aggiorna(Categoria categoriaInstance);

	public void inserisciNuovo(Categoria categoriaInstance);

	public void rimuovi(Long idToDelete);
	
	public Categoria cercaPerDescrizioneECodice(String descrizione, String codice) ;
	
	public List<Categoria> cercaCategorieByIds(Long[] ids);

	
}