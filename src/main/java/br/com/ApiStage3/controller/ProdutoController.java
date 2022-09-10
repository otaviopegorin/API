package br.com.ApiStage3.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@CrossOrigin
	@GetMapping("/geraUUID")
	public String geraUUid() {
		UUID hash = UUID.randomUUID();
		String s = hash.toString();
		return s;
	}
	@CrossOrigin
	@GetMapping("/produtos")
	public List<ProdutoDTO> getAllProdutos() {
		return produtoService.getAll();
	}
	@CrossOrigin
	@GetMapping(value="/getProdutoByName/{name}")
	public List<ProdutoDTO> getProdutoByName(@PathVariable("name") String name) {
		List<ProdutoDTO> p = produtoService.getLikeByName(name);
		return p;
	}
	@CrossOrigin
	@GetMapping(value="/getProdutoByCategoria/{categoria}")
	public List<ProdutoDTO> getProdutoByCategoria(@PathVariable("categoria") String categoria) {
		return produtoService.getByCategoria(categoria);
	}
	@CrossOrigin
	@PostMapping("/criarProduto" )
	public ResponseEntity<Object> criaUsuario( @RequestParam String UUID,
								@RequestParam String nome, 
								@RequestParam String preco, 
								@RequestParam String categoria,
								@RequestParam String descricao,
								@RequestParam String qtd_estoque,
								@RequestParam MultipartFile foto) {
		System.out.println(UUID);
		Produto p = new Produto(nome, Double.valueOf(preco), categoria, descricao, Integer.valueOf(qtd_estoque),"http://projetoscti.com.br/projetoscti02/testesPegorin/"+UUID+foto.getOriginalFilename());
		if(produtoService.salvarProduto(p)) {
			return ResponseEntity
			        .status(HttpStatus.MOVED_PERMANENTLY)
			        .header(HttpHeaders.LOCATION, "/app-projetosestagio-api/src/main/resources/views/succes.html")
			        .build();
		}else {
			return ResponseEntity
			        .status(HttpStatus.MOVED_PERMANENTLY)
			        .header(HttpHeaders.LOCATION, "/app-projetosestagio-api/src/main/resources/views/error.html")
			        .build();		}
	} 
	
	
}
