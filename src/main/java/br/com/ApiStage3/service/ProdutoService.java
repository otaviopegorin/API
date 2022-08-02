package br.com.ApiStage3.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.ApiStage3.model.Produto;
import br.com.ApiStage3.model.ProdutoDTO;
import br.com.ApiStage3.repository.ProdutoRepository;

@Service
public class ProdutoService {

	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Value("${contato.disco.raiz}")
	private String raiz;
	
	@Value("${contato.disco.diretorio-fotos}")
	private String diretorioFotos;
	
	public List<ProdutoDTO> getAll(){
		List<ProdutoDTO> lista = new ArrayList<ProdutoDTO>();
		List<Produto> produtos = produtoRepository.findAll();
		produtos.forEach(a -> {
			lista.add(a.toDTO());
		});
		return lista;
	}
	
	public ProdutoDTO getByName(String nome){
		Produto produto = produtoRepository.findByNome(nome);
		return produto.toDTO();
	}
	
	public List<ProdutoDTO> getByCategoria(String categoria){
		List<ProdutoDTO> lista = new ArrayList<ProdutoDTO>();
		if(verificaCategoria(categoria)) {
			List<Produto> produtos = produtoRepository.findByCategoria(categoria);
			produtos.forEach(a -> {
				lista.add(a.toDTO());
			});
			return lista;
		}
		return null;
	}
	
	public Boolean verificaCategoria(String categoria) {
		if(categoria.equals("REFEICAO") 
		|| categoria.equals("LANCHES") 
		|| categoria.equals("BEBIDAS") 
		|| categoria.equals("DOCES") 
		|| categoria.equals("DOCES") 
		|| categoria.equals("SALGADOS")
		|| categoria.equals("BALAS")
		|| categoria.equals("SORVETES")) {
			return true;
		}
		return false;
	}

	public Boolean salvarProduto(Produto produto) {
		try {
			produtoRepository.save(produto);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public void salvar(MultipartFile foto) {
		this.salvar(this.diretorioFotos, foto);
	}

	public void salvar(String diretorio, MultipartFile foto) {
		Path diretorioPath = Paths.get(this.raiz, diretorio);
		Path arquivoPath = diretorioPath.resolve(foto.getOriginalFilename());
		
		try {
			Files.createDirectories(diretorioPath);
			foto.transferTo(arquivoPath.toFile());
		}catch(Exception e ) {
			e.printStackTrace();
		}
	}
	
	
}
