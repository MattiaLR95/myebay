package it.prova.myebay.repository.acquisto;

import java.util.List;

import it.prova.myebay.model.Acquisto;

public interface CustomAcquistoRepository {
	public List<Acquisto> findByExample(Acquisto example);
}