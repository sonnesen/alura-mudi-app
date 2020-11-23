package br.com.alura.mudi.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.alura.mudi.model.Pedido;
import br.com.alura.mudi.model.StatusPedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

	@Cacheable("pedidos")
	Page<Pedido> findByStatus(StatusPedido status, Pageable page);

	@Query("select p from Pedido p join p.usuario u where u.username = :username")
	List<Pedido> findAllByUsuario(@Param("username") String usuario);

	@Query("select p from Pedido p join p.usuario u where u.username = :username and p.status = :status")
	List<Pedido> findByStatusAndUser(@Param("status") StatusPedido statusPedidos, 
			@Param("username") String username);
}
