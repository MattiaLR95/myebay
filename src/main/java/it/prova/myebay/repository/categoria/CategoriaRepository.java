package it.prova.myebay.repository.categoria;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.prova.myebay.model.Categoria;

public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
	@Query("from Categoria c where c.descrizione=?1 and c.codice=?2")
	Categoria FindByDescrizioneAndCodice(String descrizione, String codice);

	@Query("from Categoria where id in ?1")
	List<Categoria> findAllCategorieByIds(Long[] ids);

}