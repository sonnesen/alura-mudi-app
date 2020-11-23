package br.com.alura.mudi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class PedidoNaoEncontradoException extends Exception {

	private static final long serialVersionUID = 1L;

	public PedidoNaoEncontradoException(Long pedidoId) {
		super(String.format("Pedido %s não encontrado!", pedidoId));
	}

}
