package it.prova.myebay.service;

import java.util.List;

import it.prova.myebay.model.Acquisto;

public interface AcquistoService {
	public List<Acquisto> listAllAcquisto();

	public Acquisto caricaSingoloAcquisto(Long id);

	public void aggiorna(Acquisto acquisto);

	public void inserisciNuovo(Acquisto acquisto);

	public void rimuovi(Long idToDelete);

	public List<Acquisto> findByExample(Acquisto example);
}
