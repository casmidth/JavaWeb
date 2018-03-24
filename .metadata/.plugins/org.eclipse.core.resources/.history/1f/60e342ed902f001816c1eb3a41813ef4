package br.com.caelum.teste;

import java.sql.SQLException;
import java.util.Calendar;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.model.Contato;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		System.out.println("Conexao aberta!");
		
		Contato novoRegistro = new Contato();
		novoRegistro.setNome("Fulana");
		novoRegistro.setEndereco("Rua dos Bobos, 0");
		novoRegistro.setEmail("fulana@gmail.com");
		
		Calendar data = Calendar.getInstance();
		data.set(1992,  Calendar.DECEMBER, 8);
		novoRegistro.setDataNascimento(data);		
		
		ContatoDAO contatoDAO = new ContatoDAO();
		contatoDAO.adiciona(novoRegistro);
		
		System.out.println("Contato gravado!");
		
	}
}
