package br.com.ApiStage3.model;

public class AuxPedidoDto {

	private String img_usuario;
	private String data_venda;
	private String nomeUsuario;
	private int id_venda;
	private String statusVenda;
	
	public AuxPedidoDto(String img_usuario, String data_venda, String nomeUsuario, int id_venda, String statusVenda) {
		super();
		this.img_usuario = img_usuario;
		this.data_venda = data_venda;
		this.nomeUsuario = nomeUsuario;
		this.id_venda = id_venda;
		this.statusVenda = statusVenda;
	}

	public String getStatusVenda() {
		return statusVenda;
	}

	public void setStatusVenda(String statusVenda) {
		this.statusVenda = statusVenda;
	}

	public AuxPedidoDto() {}
	
	public AuxPedidoDto(String img_usuario, String nomeProduto, String data_venda, int quantidade, String nomeUsuario,
			int id_venda) {
		super();
		this.img_usuario = img_usuario;
		this.data_venda = data_venda;
		this.nomeUsuario = nomeUsuario;
		this.id_venda = id_venda;
	}
	public String getImg_usuario() {
		return img_usuario;
	}
	public void setImg_usuario(String img_usuario) {
		this.img_usuario = img_usuario;
	}
	public String getData_venda() {
		return data_venda;
	}
	public void setData_venda(String data_venda) {
		this.data_venda = data_venda;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public int getId_venda() {
		return id_venda;
	}
	public void setId_venda(int id_venda) {
		this.id_venda = id_venda;
	}
	
	
}
