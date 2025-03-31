package br.com.meusprojetos.gerenciadorprodutos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.meusprojetos.gerenciadorprodutos.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
