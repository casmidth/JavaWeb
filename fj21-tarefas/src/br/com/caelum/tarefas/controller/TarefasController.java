package br.com.caelum.tarefas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	public String adicionar(@Valid Tarefa novaTarefa, BindingResult result){
		if(result.hasFieldErrors()){
			return "/form/adiciona-tarefa";
		}
		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.adiciona(novaTarefa);
		return "tarefa-adicionada";
	}
	
	@RequestMapping("/listar")
	public String lista(Model model){
		JdbcTarefaDao dao = new JdbcTarefaDao();
		List<Tarefa> tarefas = dao.lista();
		model.addAttribute("listaTarefas", tarefas);
		return "tarefa-listada";
	}
	
	@RequestMapping("/remover")
	public String remove(Tarefa tarefa){
		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.remove(tarefa);
		return "redirect:listar";
	}
	
	@RequestMapping("/context")
	public String pegarContext(Tarefa tarefa, Model model){
		JdbcTarefaDao dao = new JdbcTarefaDao();
		model.addAttribute("tarefa", dao.buscaPorId(tarefa.getId()));
		return "/form/visualizar-context";
	}
	
	@RequestMapping("/alterar")
	public String alterar(Tarefa tarefa){
		JdbcTarefaDao dao = new JdbcTarefaDao();
		dao.altera(tarefa);
		return "redirect:listar"; 
			
	}
}
