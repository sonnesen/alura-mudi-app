package br.com.alura.mudi.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.alura.mudi.dto.NovoPedidoDTO;
import br.com.alura.mudi.model.Pedido;
import br.com.alura.mudi.service.PedidoService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/pedidos")
@RequiredArgsConstructor
public class PedidoController {

	private final ModelMapper modelMapper;
	private final PedidoService pedidosService;
	
	@GetMapping("/formulario")
	public String formulario(Model model) {
		model.addAttribute("novoPedido", new NovoPedidoDTO());
		return "/pedidos/formulario";
	}
	
	@PostMapping("/novo")
	public String novo(@Valid @ModelAttribute(name = "novoPedido") NovoPedidoDTO novoPedido, BindingResult result) {
		if (result.hasErrors()) {
			return "/pedidos/formulario";
		}
		
		Pedido pedido = modelMapper.map(novoPedido, Pedido.class);
		pedidosService.save(pedido);
		
		return "redirect:/home";
	}
}
