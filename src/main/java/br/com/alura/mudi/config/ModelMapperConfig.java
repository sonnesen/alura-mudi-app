package br.com.alura.mudi.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import br.com.alura.mudi.dto.NovoPedidoDTO;
import br.com.alura.mudi.model.Pedido;
import br.com.alura.mudi.model.StatusPedido;

@Component
public class ModelMapperConfig {

	@Bean(name = "modelMapper")
	public ModelMapper createModelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.addConverter(context -> {
			Pedido destination = (Pedido) context.getDestination();
			NovoPedidoDTO source = (NovoPedidoDTO) context.getSource();
			destination.setStatus(StatusPedido.valueOf(source.getStatus().toUpperCase()));
			return destination;
		});
		
		return modelMapper;
	}
}
