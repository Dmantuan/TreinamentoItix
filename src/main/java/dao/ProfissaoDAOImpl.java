package dao;

import java.util.List;

import db.DB;
import models.Profissao;

public class ProfissaoDAOImpl implements IProfissaoDAO {

	private DB db = DB.getInstance();

	public void inserir( Profissao profissao ) {
		this.db.inserirProfissao( profissao );
	}

	public void deletar( Long id ) {
		this.db.deletarProfissao( id );
	}

	public List<Profissao> listarTodas() {
		return this.db.listarTodasProfissoes();
	}

	public Profissao buscarPorID( Long id ) {
		return this.db.buscarProfissaoPorID( id );
	}

}
