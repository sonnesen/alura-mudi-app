package br.com.alura.mudi.controller;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.alura.mudi.dto.PedidoDTO;
import br.com.alura.mudi.model.Pedido;
import br.com.alura.mudi.model.StatusPedido;
import br.com.alura.mudi.service.PedidoService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/home")
@RequiredArgsConstructor
public class HomeController {

	private final PedidoService pedidoService;

	private final ModelMapper modelMapper;

	@GetMapping
	public ModelAndView home(Pageable page) {
		Sort sort = Sort.by("dataDaEntrega").descending();
		PageRequest pageRequest = PageRequest.of(page.getPageNumber(), page.getPageSize(), sort);
		Page<Pedido> pedidos = pedidoService.findByStatus(StatusPedido.ENTREGUE, pageRequest);
		Page<PedidoDTO> dtos = pedidos.map(pedido -> modelMapper.map(pedido, PedidoDTO.class));
		
		ModelAndView modelAndView = new ModelAndView("home");
		modelAndView.addObject("pedidos", dtos);

		return modelAndView;
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}
}
