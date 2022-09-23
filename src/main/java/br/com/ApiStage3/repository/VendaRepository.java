package br.com.ApiStage3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ApiStage3.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer> {

	@Query(value="SELECT * FROM VENDA WHERE excluido = false ", nativeQuery = true)
	List<Venda> findAll();
	
	@Query(value="SELECT * FROM VENDA WHERE :cod_usuario = usuario_id_usuario and excluido = 0", nativeQuery = true)
    List<Venda> findVendaByIdUsuario(@Param("cod_usuario") Integer cod_usuario);
}
