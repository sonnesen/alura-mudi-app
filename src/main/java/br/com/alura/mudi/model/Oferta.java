package br.com.alura.mudi.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "ofertas")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Oferta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "valor", nullable = false)
	private BigDecimal valor;

	@Column(name = "data_da_entrega", nullable = false)
	private LocalDate dataDaEntrega;

	@Column(name = "comentario", nullable = true, length = 2000)
	private String comentario;

	@ManyToOne(fetch = FetchType.LAZY)
	private Pedido pedido;
}
