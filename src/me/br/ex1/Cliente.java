package me.br.ex1;


import java.io.Serializable;

import me.br.ex1.exceptions.DadoInvalidoException;

public class Cliente implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cpf;
	private String nome;
	private String email;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) throws DadoInvalidoException {
		if (!email.contains("@")) throw new DadoInvalidoException("Email invalido!");
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Cliente(String cpf, String nome, String email) throws DadoInvalidoException {
		setCpf(cpf);
		setNome(nome);
		setEmail(email);
	}
	
	public String stringify() {
		return this.cpf + ";" + nome + ";" + email;
	}
	
	public String getDados() {
		return "CPF: " + getCpf() + ", Nome: " + getNome() + ", Email: " + getEmail();
	}
}
