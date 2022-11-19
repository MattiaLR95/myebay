package it.prova.myebay.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "descrizone")
	private String descrizione;
	@Column(name = "codice")
	private String codice;
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "categorie")
	private Set<Acquisto> articoli = new HashSet<>();

	public Categoria() {
		super();
	}

	public Categoria(String descrizione, String codice) {
		super();
		this.descrizione = descrizione;
		this.codice = codice;
	}

	public Categoria(Long id, String descrizione, String codice, Set<Acquisto> articoli) {
		super();
		this.id = id;
		this.descrizione = descrizione;
		this.codice = codice;
		this.articoli = articoli;
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

	public Set<Acquisto> getArticoli() {
		return articoli;
	}

	public void setArticoli(Set<Acquisto> articoli) {
		this.articoli = articoli;
	}

}
