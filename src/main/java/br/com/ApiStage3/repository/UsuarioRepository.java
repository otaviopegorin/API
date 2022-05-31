package br.com.ApiStage3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ApiStage3.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	@Query(value=" SELECT * from PEGORIN_usuario where id_usuario = :id", nativeQuery=true)
	public Usuario buscarUsuarioPeloId(Integer id);

	public Usuario getUsuarioByEmail(String email);
}
