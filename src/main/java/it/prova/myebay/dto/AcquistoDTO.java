package it.prova.myebay.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import it.prova.myebay.model.Acquisto;

public class AcquistoDTO {

	private Long id;
	private String descrizione;
	private Date data;
	private Integer prezzo;
	
	private UtenteDTO utente;

	public AcquistoDTO() {
		super();
	}

	public AcquistoDTO(Long id, String descrizione, Date data, Integer prezzo, UtenteDTO utente) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.data = data;
		this.prezzo = prezzo;
		this.utente = utente;
	}
	
	public AcquistoDTO(Long id, String descrizione, Date data, Integer prezzo) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.data = data;
		this.prezzo = prezzo;
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
	
	public Acquisto buildAcquistoModel() {
		return new Acquisto(this.id, this.descrizione, this.data, this.prezzo, this.utente.buildUtenteModel(false));
	}
	
	public static AcquistoDTO buildAcquistoDTOFromModel(Acquisto acquistoModel, boolean includeUtente) {
		AcquistoDTO result = new AcquistoDTO(acquistoModel.getId(), acquistoModel.getDescrizione(), acquistoModel.getData(), acquistoModel.getPrezzo());
		
		if(includeUtente)
			result.setUtente(UtenteDTO.buildUtenteDTOFromModel(acquistoModel.getUtente(), false));
		
		return result;
	}
	
	public static List<AcquistoDTO> createAcquistoDTOFromModelList(List<Acquisto> modelListInput, boolean includeUtente) {
		return modelListInput.stream().map(acquistoEntity -> {
			return AcquistoDTO.buildAcquistoDTOFromModel(acquistoEntity, includeUtente);
		}).collect(Collectors.toList());
	}
	
}