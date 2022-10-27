package br.com.ApiStage3.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TesteRepository {

	@Autowired
	private EntityManager entityManager;

	public List<Object> get() {
		Query query = entityManager.createQuery(
				"select u.img_usuario, u.nome, v.data_venda, iv.quantidade, p.nome, v.id_venda from Usuario u "
				+ "inner join u.vendas v "
				+ "inner join v.itens iv "
				+ "inner join iv.produto p "
				);
		
		List<Object> resultList = query.getResultList();
		
		System.out.println("tese "+ resultList);
		return resultList;
	}

//	select u.img_usuario, u.nome, v.data_venda, iv.quantidade, p.nome, v.id_venda 
//	from usuario u 
//	inner join venda v on u.id_usuario = v.usuario_id_usuario
//	inner join item_venda iv on iv.venda_id_venda = v.id_venda 
//	inner join produto p on p.id_produto = iv.produto_id_produto 
}
