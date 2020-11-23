package br.com.alura.mudi.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.mudi.interceptor.InterceptadorDeAcessos;
import br.com.alura.mudi.interceptor.InterceptadorDeAcessos.Acesso;

@RestController
@RequestMapping("/api/acessos")
public class AcessoController {

	@GetMapping
	public List<Acesso> listar() {
		return InterceptadorDeAcessos.acessos;
	}

}
