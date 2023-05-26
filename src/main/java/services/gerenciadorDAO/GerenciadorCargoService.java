package services.gerenciadorDAO;

import java.time.LocalDate;

import dao.ICargoDAO;
import models.Cargo;
import models.Profissao;
import models.Usuario;
import validation.SalarioValidation;

public class GerenciadorCargoService {

	private ICargoDAO cargoDAO;

	public GerenciadorCargoService( ICargoDAO cargoDAO ) {
		this.cargoDAO = cargoDAO;
	}

	public boolean inserir( Long id, Usuario usuario, Profissao profissao, LocalDate dataInicio, Float salario ) {

		if( !SalarioValidation.validador( profissao, salario ) ) {
			return false;
		}
		Cargo cargo = new Cargo( id, usuario, profissao, dataInicio, salario );
		this.cargoDAO.inserir( cargo );
		return true;
	}

	public void deletar( Long id ) {
		this.cargoDAO.deletar( id );
	}

	public void listarTodos() {
		System.out.println( this.cargoDAO.listarTodos() );
	}
}
