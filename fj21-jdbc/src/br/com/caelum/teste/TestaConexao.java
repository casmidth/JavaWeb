package br.com.caelum.teste;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.model.Contato;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		System.out.println("Conexao aberta!");
		
//		//primeiro registro
//		Contato novoRegistro = new Contato();
//		novoRegistro.setNome("Fulana");
//		novoRegistro.setEndereco("Rua dos Bobos, 0");
//		novoRegistro.setEmail("fulana@gmail.com");
//		
//		Calendar niverFulana = Calendar.getInstance();
//		niverFulana.set(1992,  Calendar.DECEMBER, 8);
//		novoRegistro.setDataNascimento(niverFulana);		
//		
//		ContatoDAO contatoDAO = new ContatoDAO();
//		contatoDAO.adiciona(novoRegistro);
//		
//		//outro registro
//		Contato outroRegistro = new Contato();
//		outroRegistro.setNome("Juninho");
//		outroRegistro.setEndereco("Rua dos Juniors, 0");
//		outroRegistro.setEmail("juni@gmail.com");
//		
//		Calendar niveJuninho = Calendar.getInstance();
//		niveJuninho.set(1800,  Calendar.DECEMBER, 10);
//		outroRegistro.setDataNascimento(niveJuninho);		
//		
//		contatoDAO.adiciona(outroRegistro);
//		
//		System.out.println("Contato gravado!");
	
		ContatoDAO contatoDAO2 = new ContatoDAO();
		List<Contato> lista = contatoDAO2.createList();
		contatoDAO2.printTodosContatos(lista);
		
	}
	
}
