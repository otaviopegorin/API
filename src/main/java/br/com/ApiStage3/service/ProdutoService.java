package br.com.ApiStage3.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.commons.net.ftp.FTPClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.ApiStage3.model.Produto;
import br.com.ApiStage3.model.ProdutoDTO;
import br.com.ApiStage3.repository.ProdutoRepository;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;



	public List<ProdutoDTO> getAll() {
		List<ProdutoDTO> lista = new ArrayList<ProdutoDTO>();
		List<Produto> produtos = produtoRepository.findAll();
		produtos.forEach(a -> {
			lista.add(a.toDTO());
		});
		return lista;
	}

	public ProdutoDTO getByName(String nome) {
		Produto produto = produtoRepository.findByNome(nome);
		return produto.toDTO();
	}
	
	public Produto getProdutoByName(String nome) {
		Produto produto = produtoRepository.findByNome(nome);
		return produto;
	}

	
	public List<ProdutoDTO> getByCategoria(String categoria) {
		List<ProdutoDTO> lista = new ArrayList<ProdutoDTO>();
		if (verificaCategoria(categoria)) {
			List<Produto> produtos = produtoRepository.findByCategoria(categoria);
			produtos.forEach(a -> {
				lista.add(a.toDTO());
			});
			return lista;
		}
		return null;
	}

	public Boolean verificaCategoria(String categoria) {
		if (categoria.equals("REFEICAO") || categoria.equals("LANCHES") || categoria.equals("BEBIDAS")
				|| categoria.equals("DOCES") || categoria.equals("DOCES") || categoria.equals("SALGADOS")
				|| categoria.equals("BALAS") || categoria.equals("SORVETES")) {
			return true;
		}
		return false;
	}

	public Boolean salvarProduto(Produto produto) {
		try {
			produtoRepository.save(produto);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
}
