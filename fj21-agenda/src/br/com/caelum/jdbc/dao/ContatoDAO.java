package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.model.Contato;
import br.com.caelum.util.FixDateFormating;

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
			
			Date date = FixDateFormating.setCalendarToDate(contato.getDataNascimento());
			smtm.setDate(4,  date);
			
			System.out.println(smtm);
			smtm.execute();
			smtm.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public List<Contato> getList(){
		
		List<Contato> contatos = new ArrayList<>();
		
		try {
			PreparedStatement smtm = this.connection.prepareStatement("select * from contato");
			ResultSet resultSet = smtm.executeQuery(); //control+2 L
			
			while(resultSet.next()){
				Contato contato = new Contato();
				contato.setNome(resultSet.getString("nome"));
				contato.setEmail(resultSet.getString("email"));
				contato.setEndereco(resultSet.getString("endereco"));
				
				contato.setDataNascimento(FixDateFormating.setDateToCalendar(resultSet.getDate("dataNascimento")));
				
				contatos.add(contato);
				
			}
			resultSet.close();
			smtm.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		return contatos;
	}
	
	public void printTodosContatos(List<Contato> contatos){
		
		for(Contato contato : contatos){
			System.out.println("ID: " + contato.getId());
			System.out.println("Nome: " + contato.getNome());
			System.out.println("Endereco: " + contato.getEndereco());
			System.out.println("Email: " + contato.getEmail());
			System.out.println("Data Nascimento: " + contato.getDataNascimento());
			System.out.println("-----------------------------------------------");
		}
	}
	
}
