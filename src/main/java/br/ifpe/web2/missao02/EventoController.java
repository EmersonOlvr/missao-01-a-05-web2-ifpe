package br.ifpe.web2.missao02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/evento")
public class EventoController {

	@Autowired
	private EventoDAO eventosRep;
	
	@GetMapping("/")
	public ModelAndView viewEventos() {
		ModelAndView mv = new ModelAndView("eventos");
		mv.addObject("eventos", this.eventosRep.findAll());
		return mv;
	}
	
	// cadastro de um novo evento
	@GetMapping("/cadastrar")
	public ModelAndView viewCadastrarEvento(Model model) {
		model.addAttribute("action", "cadastrar/save");
		model.addAttribute("nomePagina", "Cadastrar Evento");
		model.addAttribute("mostrarCodigo", false);
		model.addAttribute("valueSubmit", "Cadastrar");
		
		ModelAndView mv = new ModelAndView("evento");
		mv.addObject("evento", new Evento());
		return mv;
	}
	@PostMapping("/cadastrar/save")
	public String cadastrarEvento(@ModelAttribute Evento evento) {
		this.eventosRep.save(evento);
		return "redirect:/evento/";
	}
	
	// edição de um evento
	@GetMapping("/editar")
	public ModelAndView viewEditarEvento(@RequestParam Integer codigo, Model model) {
		model.addAttribute("action", "editar/save");
		model.addAttribute("nomePagina", "Editar Evento");
		model.addAttribute("mostrarCodigo", true);
		model.addAttribute("valueSubmit", "Salvar");
		
		ModelAndView mv = new ModelAndView("evento");
		mv.addObject(eventosRep.getOne(codigo));
		return mv;
	}
	@PostMapping("/editar/save")
	public String editarEvento(@ModelAttribute Evento evento) {
		this.eventosRep.save(evento);
		return "redirect:/evento/editar?codigo="+evento.getCodigo();
	}
	
	// exclusão de um evento
	@PostMapping("/excluir")
	public String excluirEvento(@RequestParam Integer codigo) {
		eventosRep.deleteById(codigo);
		return "redirect:/evento/";
	}
	
}
