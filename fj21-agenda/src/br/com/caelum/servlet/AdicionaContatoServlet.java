package br.com.caelum.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDAO;
import br.com.caelum.model.Contato;
import br.com.caelum.util.MensagemAoUsuario;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		ContatoDAO dao = new ContatoDAO();
		dao.adiciona(contato);
		
		MensagemAoUsuario.mandarHeader1(response, "Contato " + contato.getNome() + " adicionado com sucesso");
		
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
