package com.ecommerce.controller;

import com.ecommerce.model.Categoria;
import com.ecommerce.service.CategoriaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public List<Categoria> buscaCategorias(){
        return categoriaService.buscaCategorias();
    }

    @GetMapping("/{id_categoria}")
    public Categoria buscaCategoriaPorId(@PathVariable Integer id_categoria){
        return categoriaService.buscaCategoriaPorId(id_categoria);
    }

    @DeleteMapping("/{id_categoria}")
    public void deleteCategoriaPorId(@PathVariable Integer id_categoria){
        categoriaService.deleteCategoria(id_categoria);
    }
}
