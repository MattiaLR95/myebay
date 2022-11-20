package it.prova.myebay.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;

import it.prova.myebay.model.Acquisto;

public class AcquistoDTO {

	private Long id;
	@NotBlank
	private String descrizione;

	private Date data;
	@NotBlank
	private Integer prezzo;
	@NotBlank
	private UtenteDTO utenteAcquirente;

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

	public UtenteDTO getUtenteAcquirente() {
		return utenteAcquirente;
	}

	public void setUtenteAcquirente(UtenteDTO utenteAcquirente) {
		this.utenteAcquirente = utenteAcquirente;
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
			@NotBlank UtenteDTO utenteAcquirente) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.data = data;
		this.prezzo = prezzo;
		this.utenteAcquirente = utenteAcquirente;
	}

	public Acquisto buildAcquistoModel(boolean includeIdUtente) {
		Acquisto result = new Acquisto(this.id, this.descrizione, this.data, this.prezzo);
		if (includeIdUtente && this.id != null)
			result.setId(id);

		return result;
	}

	// niente password...
	public static AcquistoDTO buildAcquistoDTOFromModel(Acquisto acquistoModel) {
		AcquistoDTO result = new AcquistoDTO(acquistoModel.getId(), acquistoModel.getDescrizione(),
				acquistoModel.getData(), acquistoModel.getPrezzo());
		return result;
	}

	public static List<AcquistoDTO> createAcquistoDTOListFromModelList(List<Acquisto> modelListInput) {
		return modelListInput.stream().map(acquistoEntity -> {
			return AcquistoDTO.buildAcquistoDTOFromModel(acquistoEntity);
		}).collect(Collectors.toList());
	}

}
