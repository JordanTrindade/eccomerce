package com.ecommerce.service;

import com.ecommerce.service.exceptions.EntityNotFoundException;
import com.ecommerce.model.Categoria;
import com.ecommerce.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    public void salvaCategoria(Categoria categoria){
        categoriaRepository.save(categoria);
    }

    public List<Categoria> buscaCategorias(){
       return categoriaRepository.findAll();
    }

    public Categoria buscaCategoriaPorId(Integer id){
        Optional<Categoria> categoria = categoriaRepository.findById(id);

        return categoria.orElse(null);
    }

    public void deleteCategoria(Integer id){
        if(!categoriaRepository.existsById(id)){
            throw new EntityNotFoundException("Caegoria com ID " + id + " Não encontrado");
        }
        categoriaRepository.deleteById(id);
    }

    public void update(Categoria novacategoria) {
        Categoria categoria = this.buscaCategoriaPorId(novacategoria.getId());
        if(Objects.isNull(categoria)){
            return;
        }
        categoria.setNome(novacategoria.getNome());
        categoriaRepository.save(categoria);
    }
}
