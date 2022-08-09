package br.com.ApiStage3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ApiStage3.model.Item_venda;
import br.com.ApiStage3.model.Produto;
import br.com.ApiStage3.model.ProdutoDTO;
import br.com.ApiStage3.model.Usuario;
import br.com.ApiStage3.model.Venda;
import br.com.ApiStage3.model.VendaDTO;
import br.com.ApiStage3.repository.Item_vendaRepository;
import br.com.ApiStage3.repository.VendaRepository;

@Service
public class VendaService {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private VendaRepository vendaRepository;
	
	@Autowired
	private Item_vendaRepository item_vendaRepository;
	
	public List<VendaDTO> getAll(){
		List<VendaDTO> lista = new ArrayList<VendaDTO>();
		List<Venda> produtos = vendaRepository.findAll();
		produtos.forEach(a -> {
			lista.add(a.toDTO());
		});
		return lista;
	}
	
	public List<VendaDTO> findByIdUsuario(Integer id_usuario){
		List<VendaDTO> lista = new ArrayList<VendaDTO>();
		List<Venda> produtos = vendaRepository.findVendaByIdUsuario(id_usuario);
		produtos.forEach(a -> {
			lista.add(a.toDTO());
		});
		return lista;
	}

	public void cadastroNovaVenda(String email, List<ProdutoDTO> produtos, double preco) {
		try {
			List<Item_venda> itens = new ArrayList<Item_venda>();
			Usuario usu = usuarioService.getUsuarioByEmail(email);
			Venda venda = new Venda(usu,preco);
			vendaRepository.save(venda);
			produtos.forEach(a ->
			{
				Produto p = produtoService.getByName(a.getNome());
				Item_venda item = new Item_venda(p, a.getQuantidade(), a.getPreco());
				item.setVenda(venda);
				item_vendaRepository.save(item);
				itens.add(item);
			});
			venda.setProdutos(itens);
			vendaRepository.save(venda);
		}catch(Exception e ) {
			e.printStackTrace();
		}
		
	}
}
