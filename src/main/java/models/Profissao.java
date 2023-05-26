package models;

public class Profissao {

	private Long id;
	private String nome;
	private Float salarioBase;

	public Profissao( Long id, String nome, Float salarioBase ) {

		this.id = id;
		this.nome = nome;
		this.salarioBase = salarioBase;

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

	public Float getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase( Float salarioBase ) {
		this.salarioBase = salarioBase;
	}

	@Override
	public String toString() {
		return "id: " + String.valueOf( this.id ) + ", Nome: " + this.nome + ", SalarioBase: R$" + String.valueOf( this.salarioBase ) + "\n";
	}

}
