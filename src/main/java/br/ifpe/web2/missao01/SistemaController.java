package br.ifpe.web2.missao01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SistemaController {
	
	@GetMapping("/cadastrar/evento")
	public String cadastrarEvento() {
		return "cadastrar-evento";
	}
	@GetMapping("/excluir/evento")
	public String excluirEvento() {
		return "excluir-evento";
	}
	
	@GetMapping("/cadastrar/senha")
	public String cadastrarSenha() {
		return "cadastrar-senha";
	}
	@GetMapping("/excluir/senha")
	public String excluirSenha() {
		return "excluir-senha";
	}
	
	@GetMapping("/validarsenha")
	public String validarSenha() {
		return "validar-senha";
	}
}
