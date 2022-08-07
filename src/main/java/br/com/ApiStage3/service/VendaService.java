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
import br.com.ApiStage3.repository.VendaRepository;

@Service
public class VendaService {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private VendaRepository vendaRepository;
	
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

	public void cadastroNovaVenda(String email, List<ProdutoDTO> produtos, int preco) {
		Usuario usu = usuarioService.getUsuarioByEmail(email);
		List<Produto> prods = new ArrayList<Produto>();
		produtos.forEach(a -> {
			Produto p = produtoService.getProdutoByName(a.getNome());
			p.setQuantidade(p.getQuantidade());
			prods.add(p);
		});
		prods.forEach(a ->{
			
			Item_venda i = new Item_venda();
		});
		Venda a = new Venda();
		
	}
}
