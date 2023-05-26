package view;

import java.util.Scanner;

public class MainView {

	public static void exibirMenu() {
		Scanner keybord = new Scanner( System.in );
		int aux;

		do {
			MainView.menu();
			aux = keybord.nextInt();
			switch ( aux ) {
				case 1:
					UsuarioView.menuUsuario( keybord );
					break;

				case 2:
					ProfissaoView.menuProfissao( keybord );
					break;

				case 3:
					CargoView.menuCargo( keybord );
					break;

				case 4:
					System.out.println( "Ate logo" );
					break;
				default:
					System.out.println( "** Numero invalido **" );
			}
		} while( aux != 4 );

		keybord.close();
	}

	private static void menu() {
		System.out.println( "--- menu ---" );
		System.out.println( "1- Usuarios \n2- Profissao \n3- Cargo \n4- Sair" );
	}
}
