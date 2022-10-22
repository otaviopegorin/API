package br.com.ApiStage3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ApiStage3.model.ProdutoDTO;
import br.com.ApiStage3.model.VendaDTO;
import br.com.ApiStage3.service.VendaService;

@RestController()
public class VendaController {

	@Autowired
	private VendaService vendaService;
	
	
	@GetMapping("/vendas")
	public List<VendaDTO> getAllVendas() {
		return vendaService.getAll();
	}
	
	@GetMapping(value="/vendas/{id}")
	public List<VendaDTO> getAllUsuarios(@PathVariable("id") Integer id) {
		return vendaService.findByIdUsuario(id);
	}
	
	@PostMapping(path =  "/venda",consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public int cadastroNovaVenda(@RequestBody List<ProdutoDTO> produtos) {
		produtos.forEach(a->{
			System.out.println(a.getNome());
		});
		return 0;
//		return vendaService.cadastroNovaVenda(content.getEmail(), content.getProdutos(), content.getPreco());
	}
	
	@CrossOrigin
	@GetMapping("novosPedidos")
	public int numeroDeVendas() {
		return vendaService.getNumeroPedidos();
	}
	
	@CrossOrigin
	@GetMapping("lucroDiario")
	public double lucroDiario() {
		return vendaService.lucroDiario();
	}
	
}
