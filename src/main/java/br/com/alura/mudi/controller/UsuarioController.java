package br.com.alura.mudi.controller;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.alura.mudi.dto.PedidoDTO;
import br.com.alura.mudi.model.Pedido;
import br.com.alura.mudi.model.StatusPedido;
import br.com.alura.mudi.service.PedidoService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

	private final PedidoService pedidoService;

	private final ModelMapper modelMapper;

	@GetMapping("/pedidos")
	public ModelAndView home(Principal principal) {
		List<Pedido> pedidos = pedidoService.findAllByUsuario(principal.getName());
		List<PedidoDTO> dtos = pedidos.stream().map(pedido -> modelMapper.map(pedido, PedidoDTO.class))
				.collect(Collectors.toList());

		ModelAndView modelAndView = new ModelAndView("/usuarios/pedidos");
		modelAndView.addObject("pedidos", dtos);

		return modelAndView;
	}

	@GetMapping("/pedidos/{status}")
	public ModelAndView findByStatus(@PathVariable String status, Principal principal) {
		StatusPedido statusPedido = StatusPedido.valueOf(status.toUpperCase());
		String username = principal.getName();

		List<Pedido> pedidos = pedidoService.findByStatusAndUser(statusPedido, username);
		List<PedidoDTO> dtos = pedidos.stream().map(pedido -> modelMapper.map(pedido, PedidoDTO.class))
				.collect(Collectors.toList());

		ModelAndView modelAndView = new ModelAndView("/usuarios/pedidos");
		modelAndView.addObject("pedidos", dtos);
		modelAndView.addObject("status", status);

		return modelAndView;
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/usuarios/pedidos";
	}
}
