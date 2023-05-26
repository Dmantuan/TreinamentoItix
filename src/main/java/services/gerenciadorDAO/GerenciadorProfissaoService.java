package services.gerenciadorDAO;

import java.util.List;
import java.util.Scanner;

import dao.IProfissaoDAO;
import dao.ProfissaoDAOImpl;
import models.Profissao;

public class GerenciadorProfissaoService {

	private static GerenciadorProfissaoService instancia;
	private IProfissaoDAO profissaoDAO = new ProfissaoDAOImpl();

	private GerenciadorProfissaoService() {}

	public static GerenciadorProfissaoService getInstance() {
		if( GerenciadorProfissaoService.instancia == null ) {
			GerenciadorProfissaoService.instancia = new GerenciadorProfissaoService();
		}
		return GerenciadorProfissaoService.instancia;
	}

	public void inserir( Long id, String nome, Float salarioBase ) {
		Profissao profissao = new Profissao( id, nome, salarioBase );
		this.profissaoDAO.inserir( profissao );
	}

	public boolean deletar( Long id ) {
		Profissao profissao = buscarPorId( id );
		if( profissao == null ) {
			return false;
		}
		this.profissaoDAO.deletar( id );
		return true;
	}

	public boolean atualizar( Long id, Scanner keybord ) {
		Profissao profissao = buscarPorId( id );
		if( profissao == null ) {
			return false;
		}

		System.out.print( "Novo nome: " );
		profissao.setNome( keybord.next() );
		System.out.print( "Nome valor: " );
		profissao.setSalarioBase( keybord.nextFloat() );

		return true;
	}

	public List<Profissao> listarTodos() {
		return this.profissaoDAO.listarTodas();
	}

	public Profissao buscarPorId( Long id ) {
		return this.profissaoDAO.buscarPorID( id );
	}

}
