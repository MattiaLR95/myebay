package it.prova.myebay.dto;

import javax.validation.constraints.NotBlank;

public class UtenteDTOCambioPassword {

	@NotBlank(message = "{username.notblank}")
	private String username;

	@NotBlank(message = "{password.notblank}")
	private String password;

	@NotBlank(message = "{password.notblank}")
	private String nuovaPassword;

	@NotBlank(message = "{password.notblank}")
	private String confermaNuovaPassword;

	public UtenteDTOCambioPassword() {
		super();
	}

	public UtenteDTOCambioPassword(@NotBlank(message = "{username.notblank}") String username) {
		this.username = username;
	}

	public UtenteDTOCambioPassword(@NotBlank(message = "{password.notblank}") String password,
			@NotBlank(message = "{password.notblank}") String nuovaPassword,
			@NotBlank(message = "{password.notblank}") String confermaNuovaPassword) {
		super();
		this.password = password;
		this.nuovaPassword = nuovaPassword;
		this.confermaNuovaPassword = confermaNuovaPassword;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNuovaPassword() {
		return nuovaPassword;
	}

	public void setNuovaPassword(String nuovaPassword) {
		this.nuovaPassword = nuovaPassword;
	}

	public String getConfermaNuovaPassword() {
		return confermaNuovaPassword;
	}

	public void setConfermaNuovaPassword(String confermaNuovaPassword) {
		this.confermaNuovaPassword = confermaNuovaPassword;
	}

}
