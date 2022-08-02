package br.com.ApiStage3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.ApiStage3.model.Produto;
import br.com.ApiStage3.model.ProdutoDTO;
import br.com.ApiStage3.service.ProdutoService;

@RestController()
@CrossOrigin()
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	
	
	@GetMapping("/produtos")
	public List<ProdutoDTO> getAllProdutos() {
		return produtoService.getAll();
	}
	
	@GetMapping(value="/getProdutoByName/{name}")
	public ProdutoDTO getProdutoByName(@PathVariable("name") String name) {
		return produtoService.getByName(name);
	}
	
	@GetMapping(value="/getProdutoByCategoria/{categoria}")
	public List<ProdutoDTO> getProdutoByCategoria(@PathVariable("categoria") String categoria) {
		return produtoService.getByCategoria(categoria);
	}
	
	@PostMapping("/criarProduto")
	public Boolean criaUsuario(@RequestParam Produto produto) {
		return produtoService.salvarProduto(produto);
	} 
	
	@PostMapping("/carregarImagem")
	public void upload(@RequestParam MultipartFile foto) {
		produtoService.salvar(foto);
	}
}
