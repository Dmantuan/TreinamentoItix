package models;

import java.time.LocalDate;

public class Usuario {

	private Long id;
	private String nome;
	private String login;
	private LocalDate dataNascimento;
	private String email;

	public Usuario( Long id, String nome, String login, LocalDate dataNascimento, String email ) {
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.dataNascimento = dataNascimento;
		this.email = email;
	}

	public Long getId() {
		return this.id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome( String nome ) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin( String login ) {
		this.login = login;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento( LocalDate dataNascimento ) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail( String email ) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "id: " + String.valueOf( this.id ) + ", Nome: " + this.nome + ", Login: " + this.login + ", DataNascimento: " + this.dataNascimento + ", Email: " + this.email + "\n";
	}

}
