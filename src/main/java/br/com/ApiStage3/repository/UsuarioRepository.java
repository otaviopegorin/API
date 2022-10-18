package br.com.ApiStage3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ApiStage3.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	

	Usuario findByEmail(String email);

	@Query(value=" SELECT COUNT(id_usuario) FROM usuario", nativeQuery = true)
	int getNumeroUsuarios();
}
