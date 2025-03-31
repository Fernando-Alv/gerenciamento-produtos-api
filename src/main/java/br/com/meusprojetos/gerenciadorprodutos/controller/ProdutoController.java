package br.com.meusprojetos.gerenciadorprodutos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.meusprojetos.gerenciadorprodutos.entity.Produto;
import br.com.meusprojetos.gerenciadorprodutos.service.ProdutoService;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping
	public ResponseEntity<Produto> inserirProduto(@RequestBody Produto produto){
		Produto novoProduto = produtoService.inserirProduto(produto);
		
		return ResponseEntity.status(201).body(novoProduto);
	}
	
	@GetMapping
	public ResponseEntity<List<Produto>> consultarTodos() {
		List<Produto> produtos = produtoService.consultarTodos();
		
		return ResponseEntity.ok().body(produtos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> consultarPorId(@PathVariable Long id) {
		var produto = produtoService.consultarPorId(id);
		
			return ResponseEntity.ok().body(produto.get());
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {
		produtoService.atualizarProduto(id, produto);
		
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Produto> deletarProduto(@PathVariable Long id) {	
			produtoService.deletarProduto(id);
			
			return ResponseEntity.noContent().build();	
	}
	
}
