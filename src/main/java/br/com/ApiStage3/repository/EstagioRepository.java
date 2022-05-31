package br.com.ApiStage3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ApiStage3.model.Estagio;
import br.com.ApiStage3.model.StatusEstagio;

@Repository
public interface EstagioRepository extends JpaRepository<Estagio, Integer>{

	@Query(value=" SELECT * from PEGORIN_Estagio where statusestagio = :statusestagio", nativeQuery=true)
	public List<Estagio> getUsuarioByStatusDisponivel(StatusEstagio statusestagio);
}
