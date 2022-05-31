package br.com.ApiStage3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ApiStage3.model.Estagio;
import br.com.ApiStage3.model.EstagioDTO;
import br.com.ApiStage3.repository.EstagioRepository;

@Service
public class EstagioService {
	
	@Autowired
	private EstagioRepository estagioRepository;
	
	public List<EstagioDTO> getAllEstagios(){
		List<Estagio> estagios = new ArrayList<Estagio>(estagioRepository.findAll());
		List<EstagioDTO> estagiosDto = new ArrayList<EstagioDTO>();
		for (Estagio estagio : estagios) {
			estagiosDto.add(estagio.toEstagioDTO());
		}
		return estagiosDto;
	}
	
//	public List<EstagioDTO> getEstagioByStatusDisponivel(){
//		List<Estagio> estagios = new ArrayList<Estagio>(estagioRepository);
//	}
}
