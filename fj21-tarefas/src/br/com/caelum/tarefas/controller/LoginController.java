package br.com.caelum.tarefas.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.JdbcUsuarioDao;
import br.com.caelum.tarefas.modelo.Usuario;

@Controller
@RequestMapping("/usuario")
public class LoginController {

	private JdbcUsuarioDao dao;
	
	@Autowired
	public LoginController(JdbcUsuarioDao dao) {
		this.dao = dao;
	}
	@RequestMapping("/autenticado")
	public String autentica(Usuario usuario, HttpSession session){
		if(dao.existeUsuario(usuario)){
			session.setAttribute("usuario", usuario);
			return "home";
		}
		return "redirect:/login?error=Login invalido";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/login?goodbye=Para voltar e so logar!";
	}
	
	//criar novo usuario
	@RequestMapping("/novo")
	public String novo(){
		return "/form/formulario-usuario";
	}
	
	@RequestMapping("/criar")
	public String criar(Usuario usuario){
		dao.criarNovoUsuario(usuario);
		return "redirect:/login?newUser=Entre com seu novo login";
	}
}
