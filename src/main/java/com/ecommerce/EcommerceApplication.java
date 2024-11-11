package com.ecommerce;

import com.ecommerce.model.Categoria;
import com.ecommerce.model.Cidade;
import com.ecommerce.model.Estado;
import com.ecommerce.model.Produto;
import com.ecommerce.repository.CidadeRepository;
import com.ecommerce.repository.EstadoRepository;
import com.ecommerce.service.CategoriaService;
import com.ecommerce.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@Profile("dev")
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

}

@Component
class DataLoader implements CommandLineRunner {
	private final CategoriaService categoriaService;

	@Autowired
	ProdutoService produtoService;
	@Autowired
	EstadoRepository estadoRepository;

	@Autowired
	CidadeRepository cidadeRepository;

    DataLoader(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @Override
	public void run(String... args) throws Exception {
		Categoria categoria1 = new Categoria("informatica");
		Categoria categoria2 = new Categoria("Escritorio");

		Produto produto1= new Produto("Computador",200.00);
		Produto produto2= new Produto("Impressora",800.00);
		Produto produto3= new Produto("Mouse",80.00);

		categoria1.setProdutos(Arrays.asList(produto1,produto2,produto3));
		categoria2.setProdutos(List.of(produto2));

		produtoService.salvaProduto(produto1);
		produtoService.salvaProduto(produto2);
		produtoService.salvaProduto(produto3);

		categoriaService.salvaCategoria(categoria1);
		categoriaService.salvaCategoria(categoria2);

		//ESTADO E CIDADE
		Estado estado1 = new Estado("Minas gerais");
		Estado estado2 = new Estado("São Paulo");

		Cidade c1 = new Cidade("Uberlandia", estado1);
		Cidade c2 = new Cidade("São Paulo", estado2);
		Cidade c3 = new Cidade("Campinas", estado2);

		estadoRepository.saveAll(Arrays.asList(estado1,estado2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));



	}
}