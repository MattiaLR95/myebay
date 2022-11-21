package it.prova.myebay.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.prova.myebay.model.Categoria;
import it.prova.myebay.repository.categoria.CategoriaRepository;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	@Override
	@Transactional(readOnly = true)
	public List<Categoria> listAll() {
		return (List<Categoria>) repository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Categoria caricaSingoloElemento(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void aggiorna(Categoria categoriaInstance) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void inserisciNuovo(Categoria categoriaInstance) {
		repository.save(categoriaInstance);

	}

	@Override
	@Transactional
	public void rimuovi(Long idToDelete) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional(readOnly = true)
	public Categoria cercaPerDescrizioneECodice(String descrizione, String codice) {
		return repository.findByDescrizioneAndCodice(descrizione, codice);
	}

	@Override
	public List<Categoria> cercaCategorieByIds(Long[] ids) {
		return repository.findAllCategorieByIds(ids);
	}

}