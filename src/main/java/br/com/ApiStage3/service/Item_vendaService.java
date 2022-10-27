package br.com.ApiStage3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ApiStage3.model.Item_venda;
import br.com.ApiStage3.model.Item_vendaDTO;
import br.com.ApiStage3.repository.Item_vendaRepository;

@Service
public class Item_vendaService {

	@Autowired
	private Item_vendaRepository itemVendaRepository;
	
	public List<Item_vendaDTO> getItensVendaPorIdVenda(int idVenda) {
		List<Item_vendaDTO> itensDTO = new ArrayList<Item_vendaDTO>();
		List<Item_venda> itens = new ArrayList<Item_venda>(itemVendaRepository.getItens_VendaPorIdVenda(idVenda));
		for (Item_venda item_venda : itens) {
			itensDTO.add(item_venda.toDTO());
		}
		return itensDTO;
	}
	
}
