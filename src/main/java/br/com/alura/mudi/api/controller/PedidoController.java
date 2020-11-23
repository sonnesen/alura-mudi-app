package br.com.alura.mudi.api.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.mudi.model.Pedido;
import br.com.alura.mudi.model.StatusPedido;
import br.com.alura.mudi.service.PedidoService;
import lombok.RequiredArgsConstructor;

@RestController("pedidosrest")
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
public class PedidoController {

	private final PedidoService pedidoService;
	
	@GetMapping("/aguardando")
	public Page<Pedido> getPedidosAguardandoOfertas(Pageable page) {
		return pedidoService.findByStatus(StatusPedido.AGUARDANDO, page);
	}
}
