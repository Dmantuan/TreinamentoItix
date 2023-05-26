package dao;

import java.util.List;

import db.DB;
import models.Cargo;

public class CargoDAOImpl implements ICargoDAO {

	private DB db = DB.getInstance();

	public void inserir( Cargo cargo ) {
		this.db.inserirCargo( cargo );
	}

	public void deletar( Long id ) {
		this.db.deletarCargo( id );
	}

	public List<Cargo> listarTodos() {
		return this.db.listarTodosCargos();
	}

}
