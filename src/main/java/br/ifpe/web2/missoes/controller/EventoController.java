package br.ifpe.web2.missoes.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.ifpe.web2.missoes.dao.EventoDAO;
import br.ifpe.web2.missoes.dao.LocalEventoDAO;
import br.ifpe.web2.missoes.model.Evento;

@Controller
@RequestMapping("/evento")
public class EventoController {

	@Autowired
	private EventoDAO eventosRep;
	@Autowired
	private LocalEventoDAO localRep;
	
	@GetMapping("/")
	public ModelAndView viewEventos(Model model, @RequestParam(required = false) String nome) {
		ModelAndView mv = new ModelAndView("eventos-lista");
		mv.addObject("eventos", this.eventosRep.findAll());
		model.addAttribute("txtBusca", "cadastrado");
		
		if (nome != null) {
			if (nome.trim().isEmpty()) {
				System.err.println("Insira um nome.");
				model.addAttribute("erro", "Insira um nome.");
				return mv;
			}
			mv.addObject("eventos", this.eventosRep.findByNome(nome));
			model.addAttribute("strBusca", nome);
			model.addAttribute("txtBusca", "encontrado");
		}
		return mv;
	}
	
	// cadastro de um novo evento
	@GetMapping("/cadastrar")
	public ModelAndView viewCadastrarEvento(Model model) {
		model.addAttribute("nomePagina", "Cadastrar Evento");
		model.addAttribute("mostrarCodigo", false);
		model.addAttribute("valueSubmit", "Cadastrar");
		
		ModelAndView mv = new ModelAndView("evento");
		mv.addObject("evento", new Evento());
		mv.addObject("locais", this.localRep.findAll());
		return mv;
	}
	@PostMapping("/cadastrar")
	public ModelAndView cadastrarEvento(Model model, @Valid @ModelAttribute Evento evento, BindingResult br) {
		if (br.hasErrors()) {
			for (FieldError err : br.getFieldErrors()) {
				System.err.println(err.getDefaultMessage());
			}
			return this.viewCadastrarEvento(model).addObject("evento", evento).addObject("locais", this.localRep.findAll());
		} else {
			this.eventosRep.save(evento);
		}
		
		return new ModelAndView("redirect:/evento/");
	}
	
	// edição de um evento
	@GetMapping("/editar")
	public ModelAndView viewEditarEvento(@RequestParam Integer codigo, Model model) {
		model.addAttribute("nomePagina", "Editar Evento");
		model.addAttribute("mostrarCodigo", true);
		model.addAttribute("valueSubmit", "Salvar");
		
		ModelAndView mv = new ModelAndView("evento");
		mv.addObject("evento", eventosRep.getOne(codigo));
		mv.addObject("locais", this.localRep.findAll());
		return mv;
	}
	@PostMapping("/editar")
	public ModelAndView editarEvento(Model model, @Valid @ModelAttribute Evento evento, BindingResult br) {
		if (br.hasErrors()) {
			return this.viewEditarEvento(evento.getCodigo(), model).addObject("evento", evento).addObject("locais", this.localRep.findAll());
		}
		this.eventosRep.save(evento);
		return this.viewEditarEvento(evento.getCodigo(), model);
	}
	
	// exclusão de um evento
	@PostMapping("/excluir")
	public String excluirEvento(@RequestParam Integer codigo) {
		eventosRep.deleteById(codigo);
		return "redirect:/evento/";
	}
	
}
