package com.ecommerce.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    LocalDateTime Date;

    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL)
    Pagamento pagamento;

    @ManyToOne
    Endereco endereco;

    @ManyToOne
    Cliente cliente;

    @ManyToMany
    @JoinTable(
            name = "PEDIDO_PRODUTO",
            joinColumns = @JoinColumn(name = "PEDIDO_ID"),
            inverseJoinColumns = @JoinColumn(name = "PRODUTO_ID")
    )
    List<Produto> produtos = new ArrayList<>();
    public Pedido(){}
    public Pedido(LocalDateTime date, Cliente cliente,Endereco endereco) {
        Date = date;
        this.cliente = cliente;
        this.endereco = endereco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return Date;
    }

    public void setDate(LocalDateTime date) {
        Date = date;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
