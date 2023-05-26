package services.gerenciadorDAO;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import Utils.FormatadorLocalDate;
import dao.IUsuarioDAO;
import dao.UsuarioDAOImpl;
import models.Usuario;
import validation.IdadeValidation;

public class GerenciadorUsuarioService {

	private static GerenciadorUsuarioService instancia;
	private IUsuarioDAO usuarioDAO = new UsuarioDAOImpl();

	private GerenciadorUsuarioService() {}

	public static GerenciadorUsuarioService getInstancia() {
		if( GerenciadorUsuarioService.instancia == null ) {
			GerenciadorUsuarioService.instancia = new GerenciadorUsuarioService();
		}
		return GerenciadorUsuarioService.instancia;
	}

	public boolean inserir( Long id, String nome, String login, LocalDate dataNascimento, String email ) {

		if( !IdadeValidation.validador( dataNascimento ) ) {
			return false;
		}
		Usuario usuario = new Usuario( id, nome, login, dataNascimento, email );
		this.usuarioDAO.inserir( usuario );
		return true;
	}

	public List<Usuario> listarTodos() {
		return this.usuarioDAO.listarTodos();
	}

	public boolean atualizar( Long id, Scanner keybord ) {
		Usuario usuario = buscarPorId( id );
		if( usuario == null ) {
			return false;
		}

		System.out.print( "Informe o novo nome do usuario: " );
		usuario.setNome( keybord.next() );
		System.out.print( "\nInforme o novo login do usuario: " );
		usuario.setLogin( keybord.next() );
		System.out.print( "\nInforme o novo email: " );
		usuario.setEmail( keybord.next() );
		System.out.print( "\nInforme a nova data de nascimento: " );
		usuario.setDataNascimento( FormatadorLocalDate.formatarData( keybord.next() ) );

		return true;
	}

	public boolean deleletar( Long id ) {
		Usuario usuario = buscarPorId( id );
		if( usuario == null ) {
			return false;
		}
		this.usuarioDAO.deletar( id );
		return true;
	}

	public Usuario buscarPorId( Long id ) {
		return this.usuarioDAO.buscarPorId( id );
	}
}
