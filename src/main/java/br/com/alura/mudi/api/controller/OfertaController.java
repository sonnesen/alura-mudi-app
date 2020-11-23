package br.com.alura.mudi.api.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.mudi.dto.RequisicaoNovaOferta;
import br.com.alura.mudi.exception.PedidoNaoEncontradoException;
import br.com.alura.mudi.model.Oferta;
import br.com.alura.mudi.model.Pedido;
import br.com.alura.mudi.service.PedidoService;
import lombok.RequiredArgsConstructor;

@RestController("ofertasrest")
@RequestMapping("/api/ofertas")
@RequiredArgsConstructor
public class OfertaController {

	private final PedidoService pedidoService;

	private final ModelMapper modelMapper;

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<Oferta> criarOferta(@Valid @RequestBody RequisicaoNovaOferta requisicao)
			throws PedidoNaoEncontradoException {
		Pedido pedido = pedidoService.findById(requisicao.getPedidoId());

		Oferta nova = modelMapper.map(requisicao, Oferta.class);
		nova.setPedido(pedido);
		pedido.addOferta(nova);

		pedidoService.save(pedido);

		return ResponseEntity.ok().body(nova);
	}
}
