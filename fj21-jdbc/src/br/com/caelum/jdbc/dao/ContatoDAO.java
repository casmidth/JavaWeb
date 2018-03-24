package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.model.Contato;

public class ContatoDAO {

	private Connection connection;
	
	public ContatoDAO(){
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Contato contato){
		
		String sql = "insert into contato (nome,email,endereco,dataNascimento) values (?,?,?,?)";
		try {
			PreparedStatement smtm = this.connection.prepareStatement(sql);
			smtm.setString(1, contato.getNome());
			smtm.setString(2, contato.getEmail());
			smtm.setString(3, contato.getEndereco());
			
			Date date = new Date(contato.getDataNascimento().getTimeInMillis());
			smtm.setDate(4,  date);
			
			System.out.println(smtm);
			smtm.execute();
			smtm.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		
		
	}
}