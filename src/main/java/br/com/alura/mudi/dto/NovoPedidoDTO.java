package br.com.alura.mudi.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.alura.mudi.model.StatusPedido;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class NovoPedidoDTO {

	@NotBlank
	@Size(max = 256)
	private String nomeProduto;

	@NotBlank
	@Size(max = 2000)
	private String urlProduto;

	@NotBlank
	@Size(max = 2000)
	private String urlImagem;

	@NotBlank
	@Size(max = 2000)
	private String descricao;
	
	@Builder.Default
	private String status = StatusPedido.AGUARDANDO.name();
}
