package br.com.ApiStage3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ApiStage3.model.EstagioDTO;
import br.com.ApiStage3.service.EstagioService;

@RestController
public class EstagioController {

	@Autowired
	private EstagioService estagioService;
	
	@GetMapping
	public List<EstagioDTO> getAllEstagios(){
		List<EstagioDTO> estagios = estagioService.getAllEstagios();
		return estagios;
	}
}
