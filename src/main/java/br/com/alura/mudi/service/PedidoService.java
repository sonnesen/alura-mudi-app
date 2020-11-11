package br.com.alura.mudi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.alura.mudi.model.Pedido;
import br.com.alura.mudi.model.StatusPedido;
import br.com.alura.mudi.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoService {

	private final PedidoRepository pedidoRepository;

	public void save(Pedido pedido) {
		pedidoRepository.save(pedido);
	}

	public List<Pedido> findAll() {
		return pedidoRepository.findAll();
	}

	public List<Pedido> findByStatus(StatusPedido status) {
		return pedidoRepository.findByStatus(status);
	}
	
}
