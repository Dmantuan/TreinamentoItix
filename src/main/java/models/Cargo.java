package models;

import java.time.LocalDate;

public class Cargo {

	private Long id;
	private Usuario usuario;
	private Profissao profissao;
	private LocalDate dataInicio;
	private Float salarioExercicido;

	public Cargo( Long id, Usuario usuario, Profissao profissao, LocalDate dtInicio, Float salario ) {
		this.id = id;
		this.usuario = usuario;
		this.profissao = profissao;
		this.dataInicio = dtInicio;
		this.salarioExercicido = salario;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio( LocalDate dataInicio ) {
		this.dataInicio = dataInicio;
	}

	public Float getSalarioExercicido() {
		return salarioExercicido;
	}

	public void setSalarioExercicido( Float salarioExercicido ) {
		this.salarioExercicido = salarioExercicido;
	}

	public void setId( Long id ) {
		this.id = id;
	}

	public Long getId() {
		return this.id;
	}

	@Override
	public String toString() {
		return "id: " + String.valueOf( this.id ) + ", idUsuario: " + String.valueOf( this.usuario.getId() ) + ", idProfissao: " + String.valueOf( this.profissao.getId() ) + ", dtInicio: " + this.dataInicio + ", SalarioExercido: " + String.valueOf( this.salarioExercicido );
	}

	public Profissao getProfissao() {
		return this.profissao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario( Usuario usuario ) {
		this.usuario = usuario;
	}

}
