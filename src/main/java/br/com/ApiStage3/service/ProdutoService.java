package br.com.ApiStage3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ApiStage3.model.CategoriaProduto;
import br.com.ApiStage3.model.Produto;
import br.com.ApiStage3.model.ProdutoDTO;
import br.com.ApiStage3.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<ProdutoDTO> getAll(){
		List<ProdutoDTO> lista = new ArrayList<ProdutoDTO>();
		List<Produto> produtos = produtoRepository.findAll();
		produtos.forEach(a -> {
			lista.add(a.toDTO());
		});
		return lista;
	}
	
	public ProdutoDTO getByName(String nome){
		Produto produto = produtoRepository.findByNome(nome);
		return produto.toDTO();
	}
	
	public List<ProdutoDTO> getByCategoria(String categoria){
		List<ProdutoDTO> lista = new ArrayList<ProdutoDTO>();
		if(verificaCategoria(categoria)) {
			List<Produto> produtos = produtoRepository.findByCategoria(categoria);
			produtos.forEach(a -> {
				lista.add(a.toDTO());
			});
			return lista;
		}
		return null;
	}
	
	public Boolean verificaCategoria(String categoria) {
		if(categoria.equals("REFEICAO") 
		|| categoria.equals("LANCHES") 
		|| categoria.equals("BEBIDAS") 
		|| categoria.equals("DOCES") 
		|| categoria.equals("DOCES") 
		|| categoria.equals("SALGADOS")
		|| categoria.equals("BALAS")
		|| categoria.equals("SORVETES")) {
			return true;
		}
		return false;
	}

	public Boolean salvaUsuario(Produto produto) {
		try {
			produtoRepository.save(produto);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
