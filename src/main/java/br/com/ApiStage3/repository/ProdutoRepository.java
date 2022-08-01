package br.com.ApiStage3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.ApiStage3.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	
	@Query(value="SELECT * FROM PRODUTO WHERE excluido = false ", nativeQuery = true)
	List<Produto> findAll();
	
	@Query(value="SELECT * FROM PRODUTO WHERE nomeProduto = :nome and excluido = false ", nativeQuery = true)
	Produto findByNome(@Param("nomeProduto") String nome);
	
	@Query(value="SELECT * FROM PRODUTO WHERE categoria = :categoria and excluido = false ", nativeQuery = true)
	List<Produto> findByCategoria(@Param("categoria")String categoria);
}
