package br.com.ApiStage3.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import br.com.ApiStage3.model.Usuario;
import br.com.ApiStage3.model.UsuarioDTO;
import br.com.ApiStage3.repository.UsuarioRepository;


@Service
public class UsuarioService {

	@Autowired
    private JavaMailSender mailSender;
	
	@Autowired(required = true)
	private UsuarioRepository usuarioRepository;
	
	Random gerador = new Random();
	
	public List<UsuarioDTO> getAllUsuarios() {
		List<UsuarioDTO> usuariosDTO = new ArrayList<UsuarioDTO>();
		List<Usuario> usuarios = new ArrayList<Usuario>(usuarioRepository.findAll());
		for (Usuario usuario : usuarios) {
			usuariosDTO.add(usuario.toUsuarioDTO());
		}
		return usuariosDTO;
	}
	
	public Usuario getUsuarioByEmail(String email) {
		Usuario usu = usuarioRepository.findByEmail(email);
		return usu;
	}
	
	public UsuarioDTO getUsuarioById(Integer id) {
		Usuario usuario = usuarioRepository.getById(id);
		UsuarioDTO usuarioDTO = usuario.toUsuarioDTO();
		return usuarioDTO;
	}
	
	public int salvaUsuario(Usuario usuario) {
		if(usuario.getSenha() == null || usuario.getSenha() == "") {
			Usuario usu = usuarioRepository.findByEmail(usuario.getEmail());
			usu.setNotificacao(usuario.getNotificacao());
			usuarioRepository.save(usu);
			return 1;
		}
		Usuario u = usuarioRepository.findByEmail(usuario.getEmail());
		if(u != null) {
			return -1;
		}
		String strHash = codificaSenha(usuario.getSenha());
		int a = gerador.nextInt(20);
		usuario.setImg_usuario("http://projetoscti.com.br/projetoscti02/testesPegorin/files/icon"+a+".png");
		usuario.setSenha(strHash);
		try {
			usuarioRepository.save(usuario);
			return 1;
		}catch(Exception e){
			System.out.println("Erro ao salvar usuario: "+e.getMessage());
			return 0;
		}
		
	}

	public int autenticaUsuario(String email, String senha) {
		try {
			Usuario usuario = usuarioRepository.findByEmail(email);
			String strHash = codificaSenha(senha);
			if(strHash.equals(usuario.getSenha())) {
				if(usuario.getRecuperarSenha() == true) {
					return -1;
				}
				if(usuario.getAdm() == true) {
					return 2;
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
	
	public int recuperaSenha(String email) {
		Usuario usuario = usuarioRepository.findByEmail(email);
		if(usuario == null) {
			return 0;
		}
		usuario.setRecuperarSenha(true);
		UUID uuid = UUID.randomUUID();
		String senhaTemporaria = codificaSenha(uuid.toString());
		usuario.setSenha(senhaTemporaria);
		
		
		String from = "grupoStage3Tcc@gmail.com";
		String to = email;
		 
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
        try {
        	helper.setSubject("Email para recuperação de senha");
    		helper.setFrom(from);
    		helper.setTo(to);
    		 
    		boolean html = true;
    		helper.setText("<html>\r\n"
    				+ "<head>\r\n"
    				+ "    <title>Recuperação de senha</title>\r\n"
    				+ "    <meta charset=\"UTF-8\">\r\n"
    				+ "</head>\r\n"
    				+ "<body>\r\n"
    				+ "\r\n"
    				+ "<div dir=\"ltr\" style=\"margin:0; padding:0; background-color:#ffffff\">\r\n"
    				+ "<table cellspacing=\"0\" cellpadding=\"0\" width=\"100%;\" id=\"x_email_table\" border=\"0\" style=\"border-collapse:collapse\">\r\n"
    				+ "<tbody>\r\n"
    				+ "<tr>\r\n"
    				+ "<td id=\"x_email_content\" style=\" font-family: 'Source Sans Pro', sans-serif; background:#ffffff\">\r\n"
    				+ "<table cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" style=\"border-collapse:collapse\">\r\n"
    				+ "<tbody>\r\n"
    				+ "<tr style=\"\">\r\n"
    				+ "<td height=\"20\" colspan=\"3\" style=\"line-height:20px\">&nbsp;</td>\r\n"
    				+ "</tr>\r\n"
    				+ "<tr>\r\n"
    				+ "<td height=\"1\" colspan=\"3\" style=\"line-height:1px\"><span style=\"color:#FFFFFF; display:none!important; font-size:1px\">&nbsp; Alguém solicitou recentemente para redefinir sua senha do Sistema Semadec'16. Utilize essa senha para realizar o login e redefinir sua senha"+uuid.toString()+" Não solicitou esta alteração? Se você não solicitou a alteração de sua senha, desconsidere este e-mail . &nbsp;</span></td>\r\n"
    				+ "</tr>\r\n"
    				+ "<tr>\r\n"
    				+ "<td width=\"15\" style=\"display:block; width:15px\">&nbsp;&nbsp;&nbsp;</td>\r\n"
    				+ "<td style=\"\">\r\n"
    				+ "<table cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" style=\"border-collapse:collapse\">\r\n"
    				+ "<tbody>\r\n"
    				+ "<tr style=\"\">\r\n"
    				+ "<td height=\"16\" colspan=\"3\" style=\"line-height:16px\">&nbsp;</td>\r\n"
    				+ "</tr>\r\n"
    				+ "<tr>\r\n"
    				+ "<p width=\"100%\" style=\"\"><a target=\"_blank\" style=\"color:rgb(12, 137, 209); text-decoration:none; font-family: 'Helvetica Neue', sans-serif; font-size:23px; line-height:32px\">Email para recuperação de senha</a></p>\r\n"
    				+ "</tr>\r\n"
    				+ "<tr style=\"border-bottom:solid 1px #e5e5e5\">\r\n"
    				+ "<td height=\"16\" colspan=\"3\" style=\"line-height:16px\">&nbsp;</td>\r\n"
    				+ "</tr>\r\n"
    				+ "</tbody>\r\n"
    				+ "</table>\r\n"
    				+ "</td>\r\n"
    				+ "<td width=\"15\" style=\"display:block; width:15px\">&nbsp;&nbsp;&nbsp;</td>\r\n"
    				+ "</tr>\r\n"
    				+ "<tr>\r\n"
    				+ "<td width=\"15\" style=\"display:block; width:15px\">&nbsp;&nbsp;&nbsp;</td>\r\n"
    				+ "<td style=\"\">\r\n"
    				+ "<table cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" style=\"border-collapse:collapse\">\r\n"
    				+ "<tbody>\r\n"
    				+ "<tr style=\"\">\r\n"
    				+ "<td height=\"28\" style=\"line-height:28px\">&nbsp;</td>\r\n"
    				+ "</tr>\r\n"
    				+ "<tr>\r\n"
    				+ "<td style=\"\"><span style=\" font-family: 'Source Sans Pro', sans-serif; font-size:17px; line-height:21px; color:#141823\">\r\n"
    				+ "    <div><span style=\"color:#333333; font-weight:bold\">Esse é um email automatico</span></div>\r\n"
    				+ "<p> Para cadastrar uma nova senha basta logar no app usando a seguinte senha:  <label>"+uuid.toString()+"</label> </p>\r\n"
    				+ "<h1> </h1>\r\n"
    				+ "<div><span style=\"color:#333333; font-weight:bold\">Não solicitou alteração?</span></div>\r\n"
    				+ "Se você não solicitou a alteração de sua senha, desconsidere este e-mail.</span></td>\r\n"
    				+ "</tr>\r\n"
    				+ "<tr style=\"\">\r\n"
    				+ "<td height=\"14\" style=\"line-height:14px\">&nbsp;</td>\r\n"
    				+ "</tr>\r\n"
    				+ "</tbody>\r\n"
    				+ "</table>\r\n"
    				+ "</td>\r\n"
    				+ "<td width=\"15\" style=\"display:block; width:15px\">&nbsp;&nbsp;&nbsp;</td>\r\n"
    				+ "</tr>\r\n"
    				+ "<tr>\r\n"
    				+ "<td width=\"15\" style=\"display:block; width:15px\">&nbsp;&nbsp;&nbsp;</td>\r\n"
    				+ "<td style=\"\">\r\n"
    				+ "<table cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" style=\"border-collapse:collapse\">\r\n"
    				+ "<tbody>\r\n"
    				+ "<tr style=\"\">\r\n"
    				+ "<td height=\"2\" colspan=\"3\" style=\"line-height:2px\">&nbsp;</td>\r\n"
    				+ "</tr>\r\n"
    				+ "<tr>\r\n"
    				+ "<td class=\"x_mb_blk\" style=\"\">\r\n"
    				+ "</td>\r\n"
    				+ "<td width=\"100%\" class=\"x_mb_hide\" style=\"\"></td>\r\n"
    				+ "</tr>\r\n"
    				+ "</tbody>\r\n"
    				+ "</table>\r\n"
    				+ "</td>\r\n"
    				+ "<td width=\"15\" style=\"display:block; width:15px\">&nbsp;&nbsp;&nbsp;</td>\r\n"
    				+ "</tr>\r\n"
    				+ "<tr>\r\n"
    				+ "<td width=\"15\" style=\"display:block; width:15px\">&nbsp;&nbsp;&nbsp;</td>\r\n"
    				+ "<td style=\"\">\r\n"
    				+ "<table cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" style=\"border-collapse:collapse\">\r\n"
    				+ "<tbody>\r\n"
    				+ "<tr style=\"border-top:solid 1px #e5e5e5\">\r\n"
    				+ "<td height=\"16\" style=\"line-height:16px\">&nbsp;</td>\r\n"
    				+ "</tr>\r\n"
    				+ "<tr>\r\n"
    				+ "<td style=\"font-family: 'Source Sans Pro', sans-serif; font-size:11px; color:#aaaaaa; line-height:16px\">\r\n"
    				+ "Essa mensagem foi enviada pela equipe Wave.<br>\r\n"
    				+ "</td>\r\n"
    				+ "</tr>\r\n"
    				+ "</tbody>\r\n"
    				+ "</table>\r\n"
    				+ "</td>\r\n"
    				+ "<td width=\"15\" style=\"display:block; width:15px\">&nbsp;&nbsp;&nbsp;</td>\r\n"
    				+ "</tr>\r\n"
    				+ "<tr style=\"\">\r\n"
    				+ "<td height=\"20\" colspan=\"3\" style=\"line-height:20px\">&nbsp;</td>\r\n"
    				+ "</tr>\r\n"
    				+ "</tbody>\r\n"
    				+ "</table>\r\n"
    				+ "</td>\r\n"
    				+ "</tr>\r\n"
    				+ "</tbody>\r\n"
    				+ "</table>\r\n"
    				+ "</div>\r\n"
    				+ "\r\n"
    				+ "\r\n"
    				+ "<div style=\"display: none;\"></div> \r\n"
    				+ "\r\n"
    				+ "</body>\r\n"
    				+ "</html>", html);
    		
    		mailSender.send(message);
    		usuarioRepository.save(usuario);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
	}
	
	public boolean cadastroNovaSenha(String email,String senha) {
		System.out.println("Email: "+email+" Senha: "+senha);
		try {
			Usuario usuario = usuarioRepository.findByEmail(email);
			if(!usuario.getRecuperarSenha()) {
				return false;
			}
			usuario.setSenha(codificaSenha(senha));
			usuario.setRecuperarSenha(false);
			usuarioRepository.save(usuario);
			return true;
		}catch(Exception e) {
			System.out.println(e.toString());
			return false;
		}
		
	}

	public int getNumeroDeUsuarios() {
		return 	usuarioRepository.getNumeroUsuarios();
	}

}
