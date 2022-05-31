package br.com.ApiStage3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ApiStage3.model.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer>{

}
