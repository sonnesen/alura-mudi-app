package br.com.alura.mudi.config;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import br.com.alura.mudi.dto.NovoPedidoDTO;
import br.com.alura.mudi.dto.RequisicaoNovaOferta;
import br.com.alura.mudi.model.Oferta;
import br.com.alura.mudi.model.Pedido;
import br.com.alura.mudi.model.StatusPedido;

@Component
public class ModelMapperConfig {

	@Bean(name = "modelMapper")
	public ModelMapper createModelMapper() {
		ModelMapper modelMapper = new ModelMapper();

		TypeMap<RequisicaoNovaOferta, Oferta> ofertaMap = modelMapper.createTypeMap(RequisicaoNovaOferta.class,
				Oferta.class);
		ofertaMap.setConverter(context -> {
			RequisicaoNovaOferta source = (RequisicaoNovaOferta) context.getSource();
			BigDecimal valor = new BigDecimal(source.getValor());
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			LocalDate dataDaEntrega = LocalDate.parse(source.getDataDaEntrega(), formatter);

			Oferta destination = Oferta.builder()
					.comentario(source.getComentario())
					.dataDaEntrega(dataDaEntrega)
					.valor(valor)
					.build();

			return destination;
		});

		TypeMap<NovoPedidoDTO, Pedido> pedidoMap = modelMapper.createTypeMap(NovoPedidoDTO.class, Pedido.class);
		pedidoMap.setConverter(context -> {
			NovoPedidoDTO source = context.getSource();

			Pedido destination = Pedido.builder()
					.descricao(source.getDescricao())
					.nomeProduto(source.getNomeProduto())
					.status(StatusPedido.valueOf(source.getStatus().toUpperCase()))
					.urlImagem(source.getUrlImagem())
					.urlProduto(source.getUrlProduto())
					.build();

			return destination;
		});

		return modelMapper;
	}
}
