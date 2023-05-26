package dao;

import java.util.List;

import models.Profissao;

public interface IProfissaoDAO {

	void inserir( Profissao profissao );

	void deletar( Long id );

	List<Profissao> listarTodas();

	Profissao buscarPorID( Long id );
}
