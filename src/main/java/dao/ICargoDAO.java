package dao;

import java.util.List;

import models.Cargo;

public interface ICargoDAO {

	void inserir( Cargo cargo );

	void deletar( Long id );

	List<Cargo> listarTodos();

}
