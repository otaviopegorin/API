package br.com.ApiStage3.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import br.com.ApiStage3.model.Usuario;
import br.com.ApiStage3.model.UsuarioDTO;
import br.com.ApiStage3.repository.UsuarioRepository;


@Service
public class UsuarioService {
	@Autowired(required = true)
	private JavaMailSender mailSender;
	
	@Autowired(required = true)
	private UsuarioRepository usuarioRepository;
	
	public List<UsuarioDTO> getAllUsuarios() {
		List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();
		List<Usuario> usuarios = new ArrayList<Usuario>(usuarioRepository.findAll());
		for (Usuario usuario : usuarios) {
			usuariosDTO.add(usuario.toUsuarioDTO());
		}
		return usuariosDTO;
	}
	
	public UsuarioDTO getUsuarioById(Integer id) {
		Usuario usuario = usuarioRepository.buscarUsuarioPeloId(id);
		UsuarioDTO usuarioDTO = usuario.toUsuarioDTO();
		return usuarioDTO;
	}
	
	public Boolean salvaUsuario(Usuario usuario) {
		String strHash = codificaSenha(usuario.getSenha());
		usuario.setSenha(strHash);
		try {
			usuarioRepository.save(usuario);
			return true;
		}catch(Exception e){
			System.out.println("Erro ao salvar usuario: "+e.getMessage());
			return false;
		}
	}

	public int autenticaUsuario(String email, String senha) {
		try {
			System.out.println("email: "+email+" senha: "+senha);
			Usuario usuario = usuarioRepository.getUsuarioByEmail(email);
			System.out.println(usuario);
			String strHash = codificaSenha(senha);
			if(strHash.equals(usuario.getSenha())) {
				if(usuario.getRecuperarSenha() == true) {
					return -1;
				}
				return 1;
			}else {
				return 0;
			}
		}catch(Exception e) {
			System.out.println(e.toString());
			return -2;
		}
		
	}
	
	public String codificaSenha(String senhaParam) {
		byte[] senha = senhaParam.getBytes();
		byte[] hash = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			hash = md.digest(senha);
		}catch(NoSuchAlgorithmException e){
			System.out.println("Erro ao transformar a senha em md5:" + e.getMessage());
			e.printStackTrace();
		}
		StringBuilder strBuilder = new StringBuilder();
		for(byte b:hash) {
			strBuilder.append(String.format("%02x", b));
		}
		String strHash = strBuilder.toString();
		return strHash;
	}
	
	public String recuperaSenha(String email) {
		Usuario usuario = usuarioRepository.getUsuarioByEmail(email);
		if(usuario == null) {
			return "Email não cadastrado";
		}
		usuario.setRecuperarSenha(true);
		UUID uuid = UUID.randomUUID();
		String senhaTemporaria = codificaSenha(uuid.toString());
		usuario.setSenha(senhaTemporaria);
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("Email de recuperação de senha");
        message.setText("Email para recuperação da conta"
        		+ "\n Para Recuperar sua conta tente entrar novamente"
        		+ "\n usando a seguinte senha: "+uuid.toString());
        message.setTo(email);
        message.setFrom("grupoStage3Tcc@gmail.com");
        usuarioRepository.save(usuario);
        try {
            mailSender.send(message);
            return "Email enviado com sucesso!";
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro ao enviar email.";
        }
		
	}
}
