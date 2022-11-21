package it.prova.myebay.dto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import it.prova.myebay.model.Categoria;

public class CategoriaDTO {

	private Long id;
	private String descrizione;
	private String codice;

	public CategoriaDTO() {
		super();
	}

	public CategoriaDTO(Long id, String descrizione, String codice) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.codice = codice;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public static CategoriaDTO buildCategoriaDTOFromModel(Categoria categoriaModel) {
		return new CategoriaDTO(categoriaModel.getId(), categoriaModel.getDescrizione(), categoriaModel.getCodice());
	}

	public static List<CategoriaDTO> createCategoriaDTOListFromModelSet(Set<Categoria> modelListInput) {
		return modelListInput.stream().map(categoriaEntity -> {
			return CategoriaDTO.buildCategoriaDTOFromModel(categoriaEntity);
		}).collect(Collectors.toList());
	}

	public static List<CategoriaDTO> createCategoriaDTOListFromModelList(List<Categoria> modelListInput) {
		return modelListInput.stream().map(categoriaEntity -> {
			return CategoriaDTO.buildCategoriaDTOFromModel(categoriaEntity);
		}).collect(Collectors.toList());
	}

	@Override
	public String toString() {
		return descrizione;
	}

}