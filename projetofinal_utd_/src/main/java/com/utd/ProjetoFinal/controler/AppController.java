package com.utd.ProjetoFinal.controler;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.utd.ProjetoFinal.model.Livro;
import com.utd.ProjetoFinal.service.LivroService;

@Controller
public class AppController {
	@Autowired
	private LivroService servico;

	@RequestMapping("/")
	public String paginaInicial(Model model) {
		List<Livro> livros = servico.listarTodos();
		livros.sort(Comparator.comparingLong(Livro::getId));
		model.addAttribute("livros", livros);
		return "index";
	}

	@RequestMapping("/novo")
	public String novoProduto(Model model) {
		Livro livro = new Livro();
		model.addAttribute("livro", livro);
		return "cadastrarlivro";
	}

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(@ModelAttribute("livro") Livro livro) {
		servico.adicionar(livro);
		return "redirect:/";

	}

	@RequestMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable(name = "id") long id) {
		ModelAndView mav = new ModelAndView("editarlivro");
		Livro livro = servico.modificar(id);
		mav.addObject("livro", livro);
		return mav;
	}

	@RequestMapping("/deletar/{id}")
	public String deletar(@PathVariable(name = "id") long id) {
		servico.deletar(id);
		return "redirect:/";
	}
}
