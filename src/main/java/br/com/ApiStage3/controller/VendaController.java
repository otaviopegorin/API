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

import br.com.ApiStage3.model.AuxItemVendaDto;
import br.com.ApiStage3.model.AuxItensVenda;
import br.com.ApiStage3.model.AuxPedidoDto;
import br.com.ApiStage3.model.VendaDTO;
import br.com.ApiStage3.repository.TesteRepository;
import br.com.ApiStage3.service.VendaService;

@RestController()
public class VendaController {

	@Autowired
	private VendaService vendaService;
	
	@Autowired
	private TesteRepository testeRepository;
	
	@CrossOrigin
	@GetMapping("/vendas")
	public List<VendaDTO> getAllVendas() {
		return vendaService.getAll();
	}
	
	@CrossOrigin
	@GetMapping("/pedidosHoje")
	public List<AuxPedidoDto> getPedidosHoje() {
		return testeRepository.getPedidosHoje();
	}
	
	@CrossOrigin
	@GetMapping("/ultimosPedidos")
	public List<AuxPedidoDto> getUltimosPedidos() {
		return testeRepository.getUltimosPedidos();
	}
	
	@CrossOrigin
	@GetMapping(value="/vendas/{id}")
	public List<VendaDTO> getAllUsuarios(@PathVariable("id") Integer id) {
		return vendaService.findByIdUsuario(id);
	}
	
	@CrossOrigin
	@PostMapping(path =  "/venda",consumes = MediaType.APPLICATION_JSON_VALUE)
	public int cadastroNovaVenda(@RequestBody AuxItensVenda itensVenda) {
		return vendaService.cadastroNovaVenda(itensVenda.getEmail(), itensVenda.getProdutos(), itensVenda.getPreco());
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
	
	@CrossOrigin
	@GetMapping("/pedidos")
	public List<AuxPedidoDto> pedidosEmAndamento() {
		List<AuxPedidoDto> list = testeRepository.getPedidosEmAndamento();
		return list;
	}
	
	@CrossOrigin
	@GetMapping("/todospedidos")
	public List<AuxPedidoDto> pedidos() {
		List<AuxPedidoDto> list = testeRepository.getPedidos();
		return list;
	}
	
	@CrossOrigin
	@GetMapping("/pedidos/{email}")
	public List<AuxPedidoDto> pedidosEmail(@PathVariable("email") String email) {
		List<AuxPedidoDto> list = testeRepository.getByEmail(email);
		return list;
	}
	
	@CrossOrigin
	@GetMapping("/itensVenda/{id}")
	public List<AuxItemVendaDto> getItensVendaPorIdVenda(@PathVariable("id") int id) {
		List<AuxItemVendaDto> list = testeRepository.getItensPedidoPorIdVenda(id);
		return list;
	}
	
	@CrossOrigin
	@GetMapping("/concluirPedido/{id}")
	public void concluirPedido(@PathVariable("id") int id) {
		vendaService.concluirPedido(id);
	}
	
	@CrossOrigin
	@GetMapping("/cancelarPedido/{id}")
	public void cancelarPedido(@PathVariable("id") int id) {
		vendaService.cancelarPedido(id);
	}
	
}
