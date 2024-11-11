package com.ecommerce.service;

import com.ecommerce.model.Categoria;
import com.ecommerce.model.Produto;
import com.ecommerce.repository.ProdutoRepository;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    ProdutoRepository produtoRepository;

    public void salvaProduto(Produto produto){
        produtoRepository.save(produto);
    }

    public List<Produto> buscaProdutos(){
        return produtoRepository.findAll();
    }

    public Produto BuscaProdutoPorId(Integer id){
        return produtoRepository.findById(id).orElse(null);
    }

    public void deleteProduto(Integer idProduto) {
        Produto produto = produtoRepository.findById(idProduto)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produto.getCategorias().forEach(categoria ->{
            categoria.getProdutos().remove(produto);
        });

        produtoRepository.deleteById(idProduto);
    }
}
