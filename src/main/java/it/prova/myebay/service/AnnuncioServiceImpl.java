package it.prova.myebay.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.myebay.exceptions.FondoInsufficienteException;
import it.prova.myebay.model.Acquisto;
import it.prova.myebay.model.Annuncio;
import it.prova.myebay.model.Utente;
import it.prova.myebay.repository.acquisto.AcquistoRepository;
import it.prova.myebay.repository.annuncio.AnnuncioRepository;
import it.prova.myebay.repository.utente.UtenteRepository;

@Service
public class AnnuncioServiceImpl implements AnnuncioService {

	@Autowired
	private AnnuncioRepository repository;

	@Autowired
	private UtenteRepository utenteRepository;

	@Autowired
	private AcquistoRepository acquistoRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Annuncio> listAll() {
		return (List<Annuncio>) repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Annuncio caricaSingoloElemento(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void aggiorna(Annuncio annuncioInstance) {
		Annuncio annuncioReloaded = repository.findById(annuncioInstance.getId()).orElse(null);
		if (annuncioReloaded == null)
			throw new RuntimeException("Elemento non trovato");

		annuncioReloaded.setTestoAnnuncio(annuncioInstance.getTestoAnnuncio());
		annuncioReloaded.setCategorie(annuncioInstance.getCategorie());
		annuncioReloaded.setPrezzo(annuncioInstance.getPrezzo());
		repository.save(annuncioReloaded);

	}

	@Override
	@Transactional
	public void inserisciNuovo(Annuncio annuncioInstance) {
		annuncioInstance.setData(new Date());
		annuncioInstance.setAperto(true);
		repository.save(annuncioInstance);

	}

	@Override
	@Transactional
	public void rimuovi(Long idToDelete) {
		repository.deleteById(idToDelete);

	}

	@Override
	public List<Annuncio> findByExample(Annuncio example) {
		return repository.findByExample(example);
	}

	@Override
	public List<Annuncio> findByExampleEager(Annuncio example) {
		return repository.findByExampleEager(example);
	}

	@Override
	public Annuncio caricaSingoloElementoConCategorie(Long id) {
		return repository.findByIdConCategorie(id).orElse(null);
	}

	@Override
	@Transactional
	public void acquista(Long id, Utente utenteInstance) {
		Annuncio annuncioDaAcquistare = repository.findById(id).orElse(null);
		Utente utenteReloaded = utenteRepository.findById(utenteInstance.getId()).orElse(null);

		if (annuncioDaAcquistare == null)
			throw new RuntimeException("Annuncio non trovato.");

		if (utenteReloaded == null)
			throw new RuntimeException("Utente non trovato.");

		if (utenteInstance.getCreditoResiduo() < annuncioDaAcquistare.getPrezzo())
			throw new FondoInsufficienteException("Credito residuo insufficiente per effettuare l'acquisto.");

		int creditoAggiornato = utenteInstance.getCreditoResiduo() - annuncioDaAcquistare.getPrezzo();

		utenteReloaded.setCreditoResiduo(creditoAggiornato);
		utenteRepository.save(utenteReloaded);

		annuncioDaAcquistare.setAperto(false);

		Acquisto nuovoAcquisto = new Acquisto(annuncioDaAcquistare.getTestoAnnuncio(), new Date(),
				annuncioDaAcquistare.getPrezzo(), utenteInstance);

		acquistoRepository.save(nuovoAcquisto);

	}

}