package br.com.ApiStage3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ApiStage3.model.Item_venda;

@Repository
public interface Item_vendaRepository extends JpaRepository<Item_venda, Integer>{

}
