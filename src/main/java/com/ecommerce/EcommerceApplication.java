package com.ecommerce;

import com.ecommerce.enums.EstadoPagamento;
import com.ecommerce.enums.TipoCliente;
import com.ecommerce.model.*;
import com.ecommerce.repository.*;
import com.ecommerce.service.CategoriaService;
import com.ecommerce.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	EnderecoRepository enderecoRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	PagamentoRepository pagamentoRepository;


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

		Cliente cliente1 = new Cliente("Maria Silva","maria@gmail","2305262362", TipoCliente.PESSOAFISICA);
		cliente1.getCelulares().add("31971782909");
		cliente1.getCelulares().add("31243124112");

		Endereco endereco1 = new Endereco("rua serra das pedras ","300","casa","serra dourada","33202570",cliente1,c1);
		Endereco endereco2 = new Endereco("AV matos","512","apt 120","Gavea 2","123570",cliente1,c2);

		clienteRepository.save(cliente1);
		enderecoRepository.saveAll(Arrays.asList(endereco2,endereco1));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");

		LocalDateTime dataPedido = LocalDateTime.now();
		LocalDate dateVencimento = LocalDate.now().plusDays(2);

		Pedido ped1 = new Pedido(dataPedido, cliente1, endereco1);
		Pedido ped2 = new Pedido(dataPedido, cliente1, endereco2);

		cliente1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		Pagamento pagto1 = new PagamentoComCartao(EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoComBoleto(EstadoPagamento.PENDENTE, ped2,dateVencimento , null);
		ped2.setPagamento(pagto2);

		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));



	}
}