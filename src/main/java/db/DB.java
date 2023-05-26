package db;

import java.util.ArrayList;
import java.util.List;

import models.Cargo;
import models.Profissao;
import models.Usuario;

public class DB {

	private static DB db;

	private List<Cargo> cargoDB = new ArrayList<Cargo>();
	private List<Usuario> usuarioDB = new ArrayList<Usuario>();
	private List<Profissao> profissaoDB = new ArrayList<Profissao>();

	private DB() {

	}

	public static DB getInstance() {
		if( db == null ) {
			DB.db = new DB();
		}
		return DB.db;
	}

	// CARGO

	public void inserirCargo( Cargo cargo ) {
		this.cargoDB.add( cargo );
	}

	public void deletarCargo( Long id ) {
		for( Cargo cargo : cargoDB ) {
			if( cargo.getId() == id ) {
				this.cargoDB.remove( cargo );
			}
		}
	}

	public List<Cargo> listarTodosCargos() {
		return this.cargoDB;
	}

	public Cargo buscarCargoPorID( Long id ) {
		for( Cargo cargo : cargoDB ) {
			if( cargo.getId() == id ) {
				return cargo;
			}
		}
		return null;
	}

	// PROFISSAO

	public void inserirProfissao( Profissao profissao ) {
		this.profissaoDB.add( profissao );
	}

	public void deletarProfissao( Long id ) {
		for( Profissao profissao : profissaoDB ) {
			if( profissao.getId() == id ) {
				this.profissaoDB.remove( profissao );
			}
		}
	}

	public void atualizarProfissao( Profissao profissao ) {
		for( Profissao profissaoAux : profissaoDB ) {
			if( profissaoAux.getId() == profissao.getId() ) {
				profissaoAux = profissao;
			}
		}
	}

	public List<Profissao> listarTodasProfissoes() {
		return this.profissaoDB;
	}

	public Profissao buscarProfissaoPorID( Long id ) {
		for( Profissao profissao : profissaoDB ) {
			if( profissao.getId() == id ) {
				return profissao;
			}
		}
		return null;
	}

	// USUARIOS

	public void inserirUsuarios( Usuario usuario ) {
		this.usuarioDB.add( usuario );
	}

	public void deletarUsuario( Long id ) {
		for( Usuario usuario : usuarioDB ) {
			if( usuario.getId() == id ) {
				this.usuarioDB.remove( usuario );
			}
		}
	}

	public void atualizarUsuario( Usuario usuario ) {
		for( Usuario usuarioAux : usuarioDB ) {
			if( usuarioAux.getId() == usuario.getId() ) {
				usuarioAux = usuario;
			}
		}
	}

	public List<Usuario> listarTodosUsuarios() {
		return this.usuarioDB;
	}

	public Usuario buscarUsuarioPorID( Long id ) {
		for( Usuario usuario : usuarioDB ) {
			if( usuario.getId() == id ) {
				return usuario;
			}
		}
		return null;
	}

}
