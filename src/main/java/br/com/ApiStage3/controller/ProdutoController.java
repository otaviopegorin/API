package br.com.ApiStage3.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

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
	@GetMapping(value = "/getProdutoByName/{name}")
	public List<ProdutoDTO> getProdutoByName(@PathVariable("name") String name) {
		List<ProdutoDTO> p = produtoService.getLikeByName(name);
		return p;
	}

	@CrossOrigin
	@GetMapping(value = "/getProdutoByCategoria/{categoria}")
	public List<ProdutoDTO> getProdutoByCategoria(@PathVariable("categoria") String categoria) {
		return produtoService.getByCategoria(categoria);
	}

	@CrossOrigin
	@PostMapping("/criarProduto")
	public Boolean criaProduto(@RequestParam String UUID, @RequestParam String nome, @RequestParam String preco,
			@RequestParam String categoria, @RequestParam String descricao, @RequestParam String qtd_estoque,
			@RequestParam MultipartFile foto) {
		Produto p = new Produto(nome, Double.valueOf(preco), categoria, descricao, Integer.valueOf(qtd_estoque),
				"http://projetoscti.com.br/projetoscti02/testesPegorin/" + UUID + foto.getOriginalFilename());
		return produtoService.salvarProduto(p);
	}

	@CrossOrigin
	@PostMapping("/alterarProduto")
	public Boolean alterarProduto(@RequestParam String ID, @RequestParam String UUID, @RequestParam String nome,
			@RequestParam String preco, @RequestParam String categoria, @RequestParam String descricao,
			@RequestParam String qtd_estoque, @RequestParam MultipartFile foto) throws IOException {
		Produto p = produtoService.getProdutoById(ID);
		if (p == null) {
			return false;
		}
		p.setNome(nome);
		p.setCategoria(categoria);
		p.setDescricao(descricao);
		p.setQtd_estoque(Integer.valueOf(qtd_estoque));
		p.setPreco(Integer.valueOf(preco));
		System.out.println("teste" + foto.getOriginalFilename());
		if (foto.getOriginalFilename().trim() == null || foto.getOriginalFilename().trim().equals("")
				|| foto.getOriginalFilename().isEmpty() || foto.getOriginalFilename().trim().isEmpty()) {
			System.out.println("está vazio");
		} else {
			p.setImg_produto(
					"http://projetoscti.com.br/projetoscti02/testesPegorin/" + UUID + foto.getOriginalFilename());
		}

		try {
			produtoService.salvarProduto(p);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@CrossOrigin
	@PostMapping("/excluiProduto")
	public Boolean excluirProduto(@RequestParam String id) {
		Produto p = produtoService.getProdutoById(id);
		p.setData_excluido(LocalDateTime.now().toString());
		p.setExcluido(true);
		return produtoService.salvarProduto(p);
	}

}
