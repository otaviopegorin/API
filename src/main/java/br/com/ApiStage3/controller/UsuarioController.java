package br.com.ApiStage3.controller;

import java.util.List;

import javax.websocket.server.ServerEndpoint;

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

@ServerEndpoint("/usuario")
@RestController()
@CrossOrigin()
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	
	@GetMapping("/usuarios")
	public List<UsuarioDTO> getAllUsuarios() {
		return usuarioService.getAllUsuarios();
	}
	@GetMapping(value="/usuarios/{id}")
	public UsuarioDTO getUsuarioById(@PathVariable("id") Integer id){
		UsuarioDTO usuarioDTO = usuarioService.getUsuarioById(id);
		return usuarioDTO;
	}
	@PostMapping("/usuario")
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
	@PostMapping("/usuario/autentica")
	public int autenticaUsuario(@RequestBody Usuario usuario) {
		System.out.println("Email: "+usuario.getEmail()+", Senha: "+usuario.getSenha());
		return usuarioService.autenticaUsuario(usuario.getEmail(),usuario.getSenha());
	}
	
	@PostMapping("/usuario/recuperaSenha")
	public int recuperarSenha(@RequestBody Usuario usuario){
		return usuarioService.recuperaSenha(usuario.getEmail());
	}
	@PostMapping("/usuario/cadastroNovaSenha")
	public boolean cadastroNovaSenha(@RequestBody Usuario usuario){
		return usuarioService.cadastroNovaSenha(usuario.getEmail(),usuario.getSenha());
	}
	
	@GetMapping("/getUsuarioByEmail/{email}")
	public UsuarioDTO getUsuarioByEmail(@PathVariable("email") String email) {
		Usuario u = usuarioService.getUsuarioByEmail(email);
		UsuarioDTO dto = u.toUsuarioDTO();
		return dto;
	}
	
}
