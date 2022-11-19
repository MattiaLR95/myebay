package it.prova.myebay.dto;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;

import it.prova.myebay.model.Acquisto;
import it.prova.myebay.model.Ruolo;
import it.prova.myebay.model.Utente;

public class AcquistoDTO {

	private Long id;
	@NotBlank
	private String descrizione;

	private Date data;
	@NotBlank
	private Integer prezzo;
	@NotBlank
	private UtenteDTO utente;

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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Integer prezzo) {
		this.prezzo = prezzo;
	}

	public UtenteDTO getUtente() {
		return utente;
	}

	public void setUtente(UtenteDTO utente) {
		this.utente = utente;
	}

	public AcquistoDTO() {
		super();
	}

	public AcquistoDTO(@NotBlank String descrizione, Date data, @NotBlank Integer prezzo) {
		super();
		this.descrizione = descrizione;
		this.data = data;
		this.prezzo = prezzo;
	}

	public AcquistoDTO(Long id, @NotBlank String descrizione, Date data, @NotBlank Integer prezzo) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.data = data;
		this.prezzo = prezzo;
	}

	public AcquistoDTO(Long id, @NotBlank String descrizione, Date data, @NotBlank Integer prezzo,
			@NotBlank UtenteDTO utente) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.data = data;
		this.prezzo = prezzo;
		this.utente = utente;
	}

	public Acquisto buildAcquistoModel(boolean includeIdUtente) {
		Acquisto result = new Acquisto(this.id, this.descrizione, this.data, this.prezzo);
		if (includeIdUtente && this.id != null)
			result.setId(id);

		return result;
	}

	// niente password...
	public static AcquistoDTO buildAcquistoDTOFromModel(Acquisto acquistoModel, boolean includeUtente) {
		AcquistoDTO result = new AcquistoDTO(acquistoModel.getId(), acquistoModel.getDescrizione(),
				acquistoModel.getData(), acquistoModel.getPrezzo());
		return result;
	}

	public static List<AcquistoDTO> createUtenteDTOListFromModelList(List<Acquisto> modelListInput, boolean includeUtente) {
		return modelListInput.stream().map(acquistoEntity -> {
			return AcquistoDTO.buildAcquistoDTOFromModel(acquistoEntity, includeUtente);
		}).collect(Collectors.toList());
	}

}
