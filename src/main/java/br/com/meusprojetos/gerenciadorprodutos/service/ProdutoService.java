package br.com.meusprojetos.gerenciadorprodutos.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.meusprojetos.gerenciadorprodutos.entity.Produto;
import br.com.meusprojetos.gerenciadorprodutos.repository.ProdutoRepository;
import br.com.meusprojetos.gerenciadorprodutos.exception.ProdutoNaoEncontradoException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto inserirProduto(Produto produto) {
		return produtoRepository.save(produto); 		
	}
	
	public List<Produto> consultarTodos() {
		return produtoRepository.findAll();	
	}
	
	public Optional<Produto> consultarPorId(Long id) {
		var produtoExistente = produtoRepository.findById(id);
		
		if(produtoExistente.isPresent()) {
			return produtoRepository.findById(id);
		} else {
			throw new ProdutoNaoEncontradoException("Produto não encontrado com o ID: " + id);
		}						
	}
	
	public void atualizarProduto(Long id, Produto produto) {
		var produtoExistente = produtoRepository.findById(id);
		
		if(produtoExistente.isPresent()) {
			Produto produtoAtualizado = produtoExistente.get();
			
			produtoAtualizado.setNome(produto.getNome());
			produtoAtualizado.setPreco(produto.getPreco());
			produtoAtualizado.setTipo(produto.getTipo());
			produtoAtualizado.setQuantidade(produto.getQuantidade());
			
			produtoRepository.save(produtoAtualizado);
		} else {
	        throw new ProdutoNaoEncontradoException("Produto não encontrado com o ID: " + id);
	    }
	}
	public void deletarProduto(Long id) {
	    if (produtoRepository.existsById(id)) {
    		produtoRepository.deleteById(id); 	    	
	    } else {
	        throw new ProdutoNaoEncontradoException("Produto não encontrado com o ID: " + id);
	    }
	}
}
