package view;

import java.util.Scanner;

import services.gerenciadorDAO.GerenciadorProfissaoService;

public class ProfissaoView {

	private static GerenciadorProfissaoService gerenciadorProfissao = GerenciadorProfissaoService.getInstance();

	public static void menuProfissao( Scanner keybord ) {
		System.out.println( "--- Menu Profissao ---" );
		System.out.println( "1- Inserir \n2- Editar \n3- Excluir \n4- Listar" );

		Long auxLong;
		String auxString;
		float auxFloat;

		int aux = keybord.nextInt();
		switch ( aux ) {
			case 1:
				System.out.println( "Informe o ID" );
				auxLong = keybord.nextLong();
				System.out.println( "Informe o nome" );
				auxString = keybord.next();
				System.out.println( "Informe o salarioExercido" );
				auxFloat = keybord.nextFloat();

				ProfissaoView.gerenciadorProfissao.inserir( auxLong, auxString, auxFloat );
				break;
			case 2:
				if( ProfissaoView.gerenciadorProfissao.listarTodos().isEmpty() ) {
					System.out.println( "\n** Lista vazia ** \n" );
					break;
				}
				System.out.println( "\nProfissoes cadastradas" );
				System.out.println( ProfissaoView.gerenciadorProfissao.listarTodos() );
				System.out.println( "\nInforme o ID que deseja atualizar" );
				auxLong = keybord.nextLong();

				if( !ProfissaoView.gerenciadorProfissao.atualizar( auxLong, keybord ) ) {
					System.out.println( "\n** ERROR: id de profissao invalido **\n" );
					break;
				}

				System.out.println( "\n** Dado Alterado com sucesso! **\n" );

				break;
			case 3:
				if( ProfissaoView.gerenciadorProfissao.listarTodos().isEmpty() ) {
					System.out.println( "\n** Lista vazia ** \n" );
					break;
				}
				System.out.println( "\nProfissoes cadastradas" );
				System.out.println( ProfissaoView.gerenciadorProfissao.listarTodos() );
				System.out.print( "\nInforme o ID que deseja excluir: " );
				auxLong = keybord.nextLong();

				if( !ProfissaoView.gerenciadorProfissao.deletar( auxLong ) ) {
					System.out.println( "\n** ERROR: id de profissao invalido **\n" );
					break;
				}

				System.out.println( "\n** Dado deletado com sucesso! **\n" );
				break;
			case 4:
				ProfissaoView.gerenciadorProfissao.listarTodos();
				break;
		}
	}
}
