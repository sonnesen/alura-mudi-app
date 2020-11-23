package br.com.alura.mudi.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RequisicaoNovaOferta {

	private Long pedidoId;

	@Pattern(regexp = "^\\d+(\\.\\d{2})?$")
	@NotNull
	private String valor;

	@Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$")
	@NotNull
	private String dataDaEntrega;

	private String comentario;
}
