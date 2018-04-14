package br.com.caelum.tarefas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.caelum.tarefas.dao.JdbcTarefaDao;
import br.com.caelum.tarefas.modelo.Tarefa;

@Controller
@RequestMapping("/tarefa")
public class TarefasController {

	@RequestMapping("/formulario")
	public String formulario(){
		return "/form/adiciona-tarefa";
	}
	
	@RequestMapping("/adicionar")
	public String adicionar(Tarefa novaTarefa){
		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.adiciona(novaTarefa);
		return "tarefa-adicionada";
	}
}
