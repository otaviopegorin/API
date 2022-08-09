package br.com.ApiStage3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping(value="/getVendaPorIdUsuario/{id}")
	public List<VendaDTO> getAllUsuarios(@PathVariable("id") Integer id) {
		return vendaService.findByIdUsuario(id);
	}
	
	@PostMapping("/cadastroNovaVenda")
<<<<<<< HEAD
	public int cadastroNovaVenda(@RequestBody String email, @RequestBody int preco, @RequestBody List<ProdutoDTO> produtos) {
=======
	public int cadastroNovaVenda(@RequestParam String email, @RequestParam int preco) {
>>>>>>> 6732352299b518046642d3b2151b1d35f72dd39c
		System.out.println(email);
		System.out.println(preco);
		for (ProdutoDTO produtoDTO : produtos) {
			System.out.println(produtoDTO);
		}
		vendaService.cadastroNovaVenda(email,produtos, preco);
		return 0;
	}
	
}
