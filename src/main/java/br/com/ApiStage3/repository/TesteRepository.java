package br.com.ApiStage3.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.ApiStage3.model.AuxItemVendaDto;
import br.com.ApiStage3.model.AuxPedidoDto;

@Repository
public class TesteRepository {

	@Autowired
	private EntityManager entityManager;

	public List<AuxPedidoDto> getPedidos() {
		Query query = entityManager.createQuery(
				"select u.img_usuario, u.nomeUsuario,u.email, v.data_venda, v.id_venda, v.statusVenda from Usuario u "
				+ "inner join u.vendas v "
				);
		
		List<AuxPedidoDto> resultList = query.getResultList();
		
		System.out.println("teste "+ resultList);
		return resultList;
	}
	
	public List<AuxPedidoDto> getPedidosEmAndamento() {
		Query query = entityManager.createQuery(
				"select u.img_usuario, u.nomeUsuario,u.email, v.data_venda, v.id_venda from Usuario u "
				+ "inner join u.vendas v "
				+ " where v.statusVenda like 'EM ANDAMENTO'"
				);
		
		List<AuxPedidoDto> resultList = query.getResultList();
		
		System.out.println("teste "+ resultList);
		return resultList;
	}
	
	public List<AuxItemVendaDto> getItensPedidoPorIdVenda(int id) {
		Query query = entityManager.createQuery(
				"select iv.quantidade,p.nomeProduto from Item_venda iv  "
				+ "inner join iv.produto p "
				+ "where iv.venda = "+id
				);
		
		List<AuxItemVendaDto> resultList = query.getResultList();
		
		System.out.println("teste "+ resultList);
		return resultList;
	}

	public List<AuxPedidoDto> getByEmail(String email) {
		Query query = entityManager.createQuery(
				"select p.img_produto,u.img_usuario, u.nomeUsuario, v.data_venda,v.id_venda, iv.quantidade,p.nomeProduto from Usuario u "
				+ "inner join u.vendas v "
				+ "inner join v.itens iv "
				+ "inner join iv.produto p"
				+ " where v.statusVenda like 'EM ANDAMENTO' and u.email like '"+email+"'"
				);
		
		List<AuxPedidoDto> resultList = query.getResultList();
		
		System.out.println("teste "+ resultList);
		return resultList;
	}

//	select u.img_usuario, u.nome, v.data_venda, iv.quantidade, p.nome, v.id_venda 
//	from usuario u 
//	inner join venda v on u.id_usuario = v.usuario_id_usuario
//	inner join item_venda iv on iv.venda_id_venda = v.id_venda 
//	inner join produto p on p.id_produto = iv.produto_id_produto 
}
