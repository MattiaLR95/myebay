package it.prova.myebay.exceptions;

public class FondoInsufficienteException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FondoInsufficienteException() {
	}

	public FondoInsufficienteException(String message) {
		super(message);
	}

}