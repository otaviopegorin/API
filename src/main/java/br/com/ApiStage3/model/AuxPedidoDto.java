package br.com.ApiStage3.model;

public class AuxPedidoDto {

	private String img_usuario;
	private String nomeProduto;
	private String data_venda;
	private int quantidade;
	private String nomeUsuario;
	private int id_venda;
	
	public AuxPedidoDto() {}
	
	public AuxPedidoDto(String img_usuario, String nomeProduto, String data_venda, int quantidade, String nomeUsuario,
			int id_venda) {
		super();
		this.img_usuario = img_usuario;
		this.nomeProduto = nomeProduto;
		this.data_venda = data_venda;
		this.quantidade = quantidade;
		this.nomeUsuario = nomeUsuario;
		this.id_venda = id_venda;
	}
	public String getImg_usuario() {
		return img_usuario;
	}
	public void setImg_usuario(String img_usuario) {
		this.img_usuario = img_usuario;
	}
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getData_venda() {
		return data_venda;
	}
	public void setData_venda(String data_venda) {
		this.data_venda = data_venda;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
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
