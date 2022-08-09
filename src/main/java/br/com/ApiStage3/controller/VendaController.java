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
	public int cadastroNovaVenda(@RequestBody String email, @RequestBody int preco, @RequestBody List<ProdutoDTO> produtos) {
		System.out.println(email);
		System.out.println(preco);
		vendaService.cadastroNovaVenda(email,produtos,preco);
		return 0;
	}
	
}
