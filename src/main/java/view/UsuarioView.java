package view;

import java.time.LocalDate;
import java.util.Scanner;

import Utils.FormatadorLocalDate;
import services.gerenciadorDAO.GerenciadorUsuarioService;

public class UsuarioView {

	private static GerenciadorUsuarioService gerenciadorUsuario = GerenciadorUsuarioService.getInstancia();

	public static void menuUsuario( Scanner keybord ) {
		System.out.println( "--- Menu usuarios ---" );
		System.out.println( "1- Inserir \n2- Editar \n3- Excluir \n4- Listar" );

		long auxLong;
		String auxString1, auxString2, auxString3;
		LocalDate auxLocalDate;

		int aux = keybord.nextInt();

		switch ( aux ) {
			case 1:
				System.out.println( "Informe o id do usuario" );
				auxLong = keybord.nextLong();
				System.out.println( "Informe o nome:" );
				auxString1 = keybord.next();
				System.out.println( "Informe o login:" );
				auxString2 = keybord.next();
				System.out.println( "Informe a data:" );
				auxLocalDate = FormatadorLocalDate.formatarData( keybord.next() );
				System.out.println( "Informe o email:" );
				auxString3 = keybord.next();

				if( !UsuarioView.gerenciadorUsuario.inserir( auxLong, auxString1, auxString2, auxLocalDate, auxString3 ) ) {
					System.out.println( "\n** O usuario e menor de idade **\n" );
					break;
				}

				System.out.println( "\n** Usuario adicionado com sucesso **\n" );
				break;
			case 2:
				if( UsuarioView.gerenciadorUsuario.listarTodos().isEmpty() ) {
					System.out.println( "\n** Lista vazia ** \n" );
					break;
				}
				System.out.println( "\nProfissoes cadastradas" );
				System.out.println( UsuarioView.gerenciadorUsuario.listarTodos() );
				System.out.println( "\nInforme o ID que deseja atualizar" );
				auxLong = keybord.nextLong();

				if( !UsuarioView.gerenciadorUsuario.atualizar( auxLong, keybord ) ) {
					System.out.println( "\n** ERROR: id de profissao invalido **\n" );
					break;
				}

				System.out.println( "\n** Dado Alterado com sucesso! **\n" );
				break;
			case 3:
				if( UsuarioView.gerenciadorUsuario.listarTodos().isEmpty() ) {
					System.out.println( "\n** Lista vazia ** \n" );
					break;
				}
				System.out.println( "\nUsuarios cadastradas" );
				System.out.println( UsuarioView.gerenciadorUsuario.listarTodos() );
				System.out.print( "\nInforme o ID que deseja excluir: " );
				auxLong = keybord.nextLong();

				if( !UsuarioView.gerenciadorUsuario.deleletar( auxLong ) ) {
					System.out.println( "\n** ERROR: id de usuario invalido **\n" );
					break;
				}

				System.out.println( "\n** Dado deletado com sucesso! **\n" );
				break;
			case 4:
				System.out.println( UsuarioView.gerenciadorUsuario.listarTodos() );
				break;
		}
	}
}
