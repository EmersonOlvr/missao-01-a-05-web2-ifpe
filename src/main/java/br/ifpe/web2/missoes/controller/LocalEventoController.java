package br.ifpe.web2.missoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ifpe.web2.missoes.dao.EventoDAO;
import br.ifpe.web2.missoes.dao.LocalEventoDAO;
import br.ifpe.web2.missoes.model.Evento;
import br.ifpe.web2.missoes.model.LocalEvento;

@Controller
@RequestMapping("/local")
public class LocalEventoController {

	@Autowired
	private LocalEventoDAO localRep;
	@Autowired
	private EventoDAO eventoRep;
	
	@GetMapping("/")
	public ModelAndView viewLocais() {
		ModelAndView mv = new ModelAndView("locais-lista");
		mv.addObject("locais", this.localRep.findAll());
		return mv;
	}
	
	// cadastro de um novo local
	@GetMapping("/cadastrar")
	public ModelAndView viewCadastrarLocalEvento(Model model) {
		model.addAttribute("nomePagina", "Cadastrar Local");
		model.addAttribute("mostrarCodigo", false);
		model.addAttribute("valueSubmit", "Cadastrar");
		
		ModelAndView mv = new ModelAndView("local");
		mv.addObject("local", new LocalEvento());
		return mv;
	}
	@PostMapping("/cadastrar")
	public String cadastrarLocalEvento(@ModelAttribute LocalEvento localEvento) {
		this.localRep.save(localEvento);
		return "redirect:/local/";
	}
	
	// edição de um local
	@GetMapping("/editar")
	public ModelAndView viewEditarLocalEvento(@RequestParam Integer codigo, Model model) {
		model.addAttribute("nomePagina", "Editar Local");
		model.addAttribute("mostrarCodigo", true);
		model.addAttribute("valueSubmit", "Salvar");
		
		ModelAndView mv = new ModelAndView("local");
		mv.addObject("local", localRep.getOne(codigo));
		return mv;
	}
	@PostMapping("/editar")
	public String editarLocalEvento(@ModelAttribute LocalEvento localEvento) {
		this.localRep.save(localEvento);
		return "redirect:/local/editar?codigo="+localEvento.getCodigo();
	}
	
	// exclusão de um local
	@PostMapping("/excluir")
	public String excluirLocalEvento(@RequestParam Integer codigo, RedirectAttributes ra) {
		try {
			LocalEvento localEvento = this.localRep.getOne(codigo);
			List<Evento> listaEventosByLocalEvento = this.eventoRep.findByLocalEvento(localEvento);
			if (listaEventosByLocalEvento.size() > 0) {
				ra.addFlashAttribute("erro", "\""+localEvento.getNome()+"\" não pode ser excluído porque está sendo usado em "+listaEventosByLocalEvento.size()+ " evento(s).");
				return "redirect:/local/";
			}
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return "redirect:/local/?erro";
		}
		
		localRep.deleteById(codigo);
		return "redirect:/local/";
	}
	
}
