package br.com.alura.mudi.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pedidos")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome_produto", length = 255, nullable = false)
	private String nomeProduto;

	@Column(name = "valor_negociado", nullable = true)
	private BigDecimal valorNegociado;

	@Column(name = "data_da_entrega", nullable = true)
	private LocalDate dataDaEntrega;

	@Column(name = "url_produto", length = 2000, nullable = false)
	private String urlProduto;

	@Column(name = "url_imagem", length = 2000, nullable = false)
	private String urlImagem;

	@Column(name = "descricao", length = 2000, nullable = false)
	private String descricao;

	@Column(name = "status", length = 255, nullable = false)
	@Enumerated(EnumType.STRING)
	private StatusPedido status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario")
	@JsonIgnore
	private User usuario;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido", fetch = FetchType.LAZY)
	@JsonIgnore
	@Builder.Default
	private List<Oferta> ofertas = new ArrayList<>();

	public void addOferta(Oferta oferta) {
		this.ofertas.add(oferta);
	}
}