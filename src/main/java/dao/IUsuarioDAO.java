package dao;

import java.util.List;

import models.Usuario;

public interface IUsuarioDAO {

	public void inserir( Usuario usuario );

	public void deletar( Long id );

	public List<Usuario> listarTodos();

	public Usuario buscarPorId( Long id );
}
