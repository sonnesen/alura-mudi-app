package br.com.alura.mudi.service;

import java.util.List;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.alura.mudi.exception.PedidoNaoEncontradoException;
import br.com.alura.mudi.model.Pedido;
import br.com.alura.mudi.model.StatusPedido;
import br.com.alura.mudi.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PedidoService {

	private final PedidoRepository pedidoRepository;

	@CacheEvict("pedidos")
	public void save(Pedido pedido) {
		pedidoRepository.save(pedido);
	}

	public List<Pedido> findAll() {
		return pedidoRepository.findAll();
	}

	public Page<Pedido> findByStatus(StatusPedido status, Pageable page) {
		return pedidoRepository.findByStatus(status, page);
	}

	public List<Pedido> findAllByUsuario(String usuario) {
		return pedidoRepository.findAllByUsuario(usuario);
	}

	public List<Pedido> findByStatusAndUser(StatusPedido statusPedidos, String username) {
		return pedidoRepository.findByStatusAndUser(statusPedidos, username);
	}

	public Pedido findById(Long pedidoId) throws PedidoNaoEncontradoException {
		return pedidoRepository.findById(pedidoId).orElseThrow(() -> new PedidoNaoEncontradoException(pedidoId));				
	}

}
