package me.br.ex1;

import java.util.Date;

import me.br.ex1.exceptions.DadoInvalidoException;

public class Cliente {
	private String cpf;
	private String nome;
	private String email;
	private Date aniversario;
	
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
	public Date getAniversario() {
		return aniversario;
	}
	public void setAniversario(Date aniversario) {
		this.aniversario = aniversario;
	}
	
	public Cliente(String cpf, String nome, String email, Date aniversario) throws DadoInvalidoException {
		setCpf(cpf);
		setNome(nome);
		setEmail(email);
		setAniversario(aniversario);
	}
}
