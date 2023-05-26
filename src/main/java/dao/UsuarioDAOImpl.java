package dao;

import java.util.List;

import db.DB;
import models.Usuario;

public class UsuarioDAOImpl implements IUsuarioDAO {

	private DB db = DB.getInstance();

	public void inserir( Usuario usuario ) {
		this.db.inserirUsuarios( usuario );
	}

	public void deletar( Long id ) {
		this.db.deletarUsuario( id );
	}

	public void atualizar( Usuario usuario ) {
		this.db.atualizarUsuario( usuario );
	}

	public List<Usuario> listarTodos() {
		return this.db.listarTodosUsuarios();
	}

	public Usuario buscarPorId( Long id ) {
		return this.db.buscarUsuarioPorID( id );
	}
}
