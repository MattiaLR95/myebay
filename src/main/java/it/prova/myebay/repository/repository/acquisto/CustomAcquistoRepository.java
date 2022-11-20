package it.prova.myebay.repository.repository.acquisto;

import java.util.List;

import it.prova.myebay.model.Acquisto;

public interface CustomAcquistoRepository {
	List<Acquisto> findByExample (Acquisto example);
}
