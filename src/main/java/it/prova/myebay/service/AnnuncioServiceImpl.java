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
		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void aggiorna(Annuncio annuncioInstance, String username) {
		Annuncio annuncioReloaded = repository.findById(annuncioInstance.getId()).orElse(null);
		if (annuncioReloaded == null)
			throw new RuntimeException("Elemento non trovato");
		if (username == null)
			throw new RuntimeException("Username non trovato!");

		annuncioReloaded.setTestoAnnuncio(annuncioInstance.getTestoAnnuncio());
		annuncioReloaded.setCategorie(annuncioInstance.getCategorie());
		annuncioReloaded.setPrezzo(annuncioInstance.getPrezzo());
		Utente utenteInSessione = utenteRepository.findByUsername(username).orElse(null);
		annuncioReloaded.setUtente(utenteInSessione);

		repository.save(annuncioReloaded);

	}

	@Override
	@Transactional
	public void inserisciNuovo(Annuncio annuncioInstance, String username) {

		if (username == null)
			throw new RuntimeException("Username non trovato.");

		annuncioInstance.setData(new Date());
		annuncioInstance.setAperto(true);
		Utente utenteInSessione = utenteRepository.findByUsername(username).orElse(null);
		annuncioInstance.setUtente(utenteInSessione);

		repository.save(annuncioInstance);

	}

	@Override
	@Transactional
	public void rimuovi(Long idToDelete) {
		repository.deleteById(idToDelete);

	}

	@Override
	public List<Annuncio> findByExample(Annuncio example, String username) {
		if (username != null) {
			Utente utenteInSessione = utenteRepository.findByUsername(username).orElse(null);
			example.setUtente(utenteInSessione);
		}
		return repository.findByExample(example);
	}

	@Override
	public List<Annuncio> findByExampleEager(Annuncio example, String username) {
		if (username != null) {
			Utente utenteInSessione = utenteRepository.findByUsername(username).orElse(null);
			example.setUtente(utenteInSessione);
		}
		return repository.findByExampleEager(example);
	}

	@Override
	public Annuncio caricaSingoloElementoConCategorie(Long id, String username) {
		Annuncio annuncioEager = repository.findByIdConCategorie(id).orElse(null);
		if (username != null) {
			Utente utenteInSessione = utenteRepository.findByUsername(username).orElse(null);
			annuncioEager.setUtente(utenteInSessione);
		}
		return annuncioEager;
	}

	@Override
	@Transactional
	public void acquista(Long id, String username) {
		Annuncio annuncioDaAcquistare = repository.findById(id).orElse(null);
		if (username == null)
			throw new RuntimeException("Utente non trovato.");

		Utente utenteInSessione = utenteRepository.findByUsername(username).orElse(null);

		Utente utenteReloaded = utenteRepository.findById(utenteInSessione.getId()).orElse(null);

		if (annuncioDaAcquistare == null)
			throw new RuntimeException("Annuncio non trovato.");

		if (utenteInSessione.getCreditoResiduo() < annuncioDaAcquistare.getPrezzo())
			throw new FondoInsufficienteException("Credito residuo insufficiente per effettuare l'acquisto.");

		int creditoAggiornato = utenteInSessione.getCreditoResiduo() - annuncioDaAcquistare.getPrezzo();

		utenteReloaded.setCreditoResiduo(creditoAggiornato);
		utenteRepository.save(utenteReloaded);

		annuncioDaAcquistare.setAperto(false);

		Acquisto nuovoAcquisto = new Acquisto(annuncioDaAcquistare.getTestoAnnuncio(), new Date(),
				annuncioDaAcquistare.getPrezzo(), utenteInSessione);

		acquistoRepository.save(nuovoAcquisto);

	}

}