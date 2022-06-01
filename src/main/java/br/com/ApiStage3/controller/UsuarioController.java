package br.com.ApiStage3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.ApiStage3.model.Usuario;
import br.com.ApiStage3.model.UsuarioDTO;
import br.com.ApiStage3.service.UsuarioService;

@RestController()
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@CrossOrigin
	@GetMapping("/usuarios")
	public List<UsuarioDTO> getAllUsuarios() {
		return usuarioService.getAllUsuarios();
	}
	
	@CrossOrigin
	@GetMapping(value="/getUsuarioById/{id}")
	public UsuarioDTO getUsuarioById(@PathVariable("id") Integer id){
		UsuarioDTO usuarioDTO = usuarioService.getUsuarioById(id);
		return usuarioDTO;
	}
	
	@CrossOrigin
	@PostMapping("/criarUsuario")
	public Boolean criaUsuario(@RequestBody Usuario usuario) {
		return usuarioService.salvaUsuario(usuario);
	}
//	{
//	    "estagios":[],
//	    "nome":"Otavio",
//	    "email":"Otaviogmail",
//	    "senha":"123",
//	    "telefone":"2932983",
//	    "adm":true,
//		"recuperarsenha":false
//	}
	
	@CrossOrigin
	@PostMapping("/autenticarUsuario")
	public int autenticaUsuario(@RequestBody Usuario usuario) {
		return usuarioService.autenticaUsuario(usuario.getEmail(),usuario.getSenha());
	}
	
	@CrossOrigin
	@PostMapping("/recuperaSenha")
	public int recuperarSenha(@RequestBody Usuario usuario){
		return usuarioService.recuperaSenha(usuario.getEmail());
	}
}
