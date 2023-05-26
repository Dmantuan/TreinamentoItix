package view;

import java.time.LocalDate;
import java.util.Scanner;

import Utils.FormatadorLocalDate;
import services.gerenciadorDAO.GerenciadorCargoService;
import services.gerenciadorDAO.GerenciadorProfissaoService;
import services.gerenciadorDAO.GerenciadorUsuarioService;

public class CargoView {

	private static GerenciadorCargoService gerenciadorCargo;
	private static GerenciadorProfissaoService gerenciadorProfissao = GerenciadorProfissaoService.getInstance();
	private static GerenciadorUsuarioService gerenciadorUsuario = GerenciadorUsuarioService.getInstancia();

	public static void menuCargo( Scanner keybord ) {
		System.out.println( "--- Menu cargo ---" );
		System.out.println( "1- Inserir \n2- Excluir \n3- Listar " );

		int aux = keybord.nextInt();
		long auxLong1, auxLong2, auxLong3;
		LocalDate auxLocalDate;
		float auxFloat;
		switch ( aux ) {
			case 1:

				if( gerenciadorUsuario.listarTodos().isEmpty() || gerenciadorProfissao.listarTodos().isEmpty() ) {
					System.out.println( "\n** Lista vazia de usuario ou de profissao esta vazia ** \n" );
					break;
				}
				System.out.println( "\nProfissoes cadastradas" );
				System.out.println( gerenciadorUsuario.listarTodos() );
				System.out.println( "\nUsuarios cadastrados" );
				System.out.println( gerenciadorProfissao.listarTodos() );

				System.out.println( "Informe o id do cargo: " );
				auxLong1 = keybord.nextLong();
				System.out.println( "Informe o id do usuario: " );
				auxLong2 = keybord.nextLong();
				System.out.println( "Informe o id da profissao" );
				auxLong3 = keybord.nextLong();
				System.out.println( "Informe o salario:" );
				auxFloat = keybord.nextFloat();
				System.out.println( "Informe a data" );
				auxLocalDate = FormatadorLocalDate.formatarData( keybord.next() );

				if( !CargoView.gerenciadorCargo.inserir( auxLong1, gerenciadorUsuario.buscarPorId( auxLong2 ), gerenciadorProfissao.buscarPorId( auxLong3 ), auxLocalDate, auxFloat ) ) {
					System.out.println( "O salario e menor do que o salarioBase" );
					break;
				}

				System.out.println( "\n** Cargo Adicionado com sucesso **\n" );

				break;
			case 2:
				CargoView.gerenciadorCargo.deletar( null );
				break;
			case 3:
				CargoView.gerenciadorCargo.listarTodos();
				break;
		}
	}
}
