package it.prova.myebay.service;

import java.util.List;

import it.prova.myebay.model.Ruolo;

public interface RuoloService {
	public List<Ruolo> listAll() ;
	
	public Ruolo caricaSingoloElemento(Long id) ;

	public void aggiorna(Ruolo ruoloInstance) ;

	public void inserisciNuovo(Ruolo ruoloInstance) ;

	public void rimuovi(Long idToDelete) ;

	public Ruolo cercaPerDescrizioneECodice(String descrizione, String codice) ;

}
