package br.com.ApiStage3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ApiStage3.model.ProdutoDTO;
import br.com.ApiStage3.model.Venda;
import br.com.ApiStage3.model.VendaDTO;
import br.com.ApiStage3.repository.VendaRepository;

@Service
public class VendaService {

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
}
