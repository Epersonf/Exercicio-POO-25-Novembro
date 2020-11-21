package me.br.ex1.exceptions;

public class ClienteJaExistenteException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClienteJaExistenteException(String message) {
		super(message);
	}
}
