package br.com.ApiStage3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import br.com.ApiStage3.service.Item_vendaService;

@RestController()
public class Item_vendaController {

	@Autowired
	private Item_vendaService produtoService;
	
	
}
