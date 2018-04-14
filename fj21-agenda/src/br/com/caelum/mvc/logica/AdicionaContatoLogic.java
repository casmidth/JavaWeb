package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.model.Contato;

public class AdicionaContatoLogic implements Logica{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
	try {
		Contato contato = new Contato();
		contato.setNome(request.getParameter("nome"));
		contato.setEmail(request.getParameter("email"));
		contato.setEndereco(request.getParameter("endereco"));

		String dateString = request.getParameter("dataNascimento");
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Calendar dateCalendar = Calendar.getInstance();
		dateCalendar.setTime(format.parse(dateString));

		contato.setDataNascimento(dateCalendar);
		
		ContatoDAO dao = new ContatoDAO((Connection)request.getAttribute("conexao"));
		dao.adiciona(contato);
		
		return "/WEB-INF/jsp/contato-adicionado.jsp";
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
	return null;
	}

}
