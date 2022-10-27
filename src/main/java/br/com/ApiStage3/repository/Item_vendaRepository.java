package br.com.ApiStage3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ApiStage3.model.Item_venda;

@Repository
public interface Item_vendaRepository extends JpaRepository<Item_venda, Integer>{

	@Query(value="SELECT * FROM item_venda where venda_id_venda = :id_venda ", nativeQuery = true)
	List<Item_venda> getItens_VendaPorIdVenda(@Param("id_venda") int id_venda);
}
