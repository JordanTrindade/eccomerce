package com.ecommerce.controller;

import com.ecommerce.model.Categoria;
import com.ecommerce.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Objects;
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

    @PostMapping
    public ResponseEntity<Categoria> insereCategoria(@RequestBody Categoria categoria){
        if(!Objects.isNull(categoria)){
            categoriaService.salvaCategoria(categoria);
            URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                            .path("/{id}").buildAndExpand(categoria.getId()).toUri();
            return ResponseEntity.created(uri).build();
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Categoria> atualizandoCategoria(@PathVariable Integer id, @RequestBody Categoria Novacategoria){
        if(!Objects.isNull(Novacategoria) && !Objects.isNull(id)){
            Novacategoria.setId(id);
            categoriaService.update(Novacategoria);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.noContent().build();
    }
}
