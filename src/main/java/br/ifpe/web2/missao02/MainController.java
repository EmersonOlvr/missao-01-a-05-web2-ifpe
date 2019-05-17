package br.ifpe.web2.missao02;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/senha/")
	public String viewSenhas() {
		return "senhas";
	}
	@GetMapping("/senha/cadastrar")
	public String viewCadastrarSenha() {
		return "senha";
	}
	@GetMapping("/senha/validar")
	public String viewValidarSenha() {
		return "validar-senha";
	}
}
