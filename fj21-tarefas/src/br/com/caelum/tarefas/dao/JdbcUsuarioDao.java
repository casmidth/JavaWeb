package br.com.caelum.tarefas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.caelum.tarefas.ConnectionFactory;
import br.com.caelum.tarefas.modelo.Usuario;

public class JdbcUsuarioDao {
	private Connection connection;

	public JdbcUsuarioDao() {
		try {
			connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public boolean existeUsuario(Usuario usuario) {

		if (usuario == null) {
			throw new IllegalArgumentException("Usuário não deve ser nulo");
		}

		try {
			PreparedStatement stmt = this.connection
					.prepareStatement("select * from usuarios where login = ? and senha = ?");
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());
			ResultSet rs = stmt.executeQuery();

			boolean encontrado = rs.next();
			rs.close();
			stmt.close();

			return encontrado;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void criarNovoUsuario(Usuario usuario){
		
		String sql = "insert into usuarios (login, senha) values (?, ?)";
		PreparedStatement smtm;
		try {
			 smtm = this.connection.prepareStatement(sql);
			 
			 smtm.setString(1, usuario.getLogin());
			 smtm.setString(2, usuario.getSenha());
			 System.out.println(smtm);
			 smtm.execute();
			 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
}
