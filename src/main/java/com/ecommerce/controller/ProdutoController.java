package com.ecommerce.controller;

import com.ecommerce.model.Categoria;
import com.ecommerce.model.Produto;
import com.ecommerce.service.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public List<Produto> buscaProdutos(){
        return produtoService.buscaProdutos();
    }

    @GetMapping("/{id_produto}")
    public Produto buscaProdutoPorId(@PathVariable Integer id_produto){
        return produtoService.BuscaProdutoPorId(id_produto);
    }

    @DeleteMapping("/{id_produto}")
    public void deleteProdutoPorId(@PathVariable Integer id_produto){
        produtoService.deleteProduto(id_produto);
    }
}
