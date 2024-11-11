package com.ecommerce.model;

import com.ecommerce.enums.TipoCliente;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private String email;
    private String cpfOuCnpj;
    private Integer tipo;

    @ElementCollection
    @CollectionTable(name = "celular")
    private Set<String> celulares = new HashSet<>();

    @OneToMany(mappedBy = "cliente")
    private List<Endereco> enderecos = new ArrayList<>();

    public Cliente(String nome, String email, String cpfOuCnpj, TipoCliente tipo) {
        this.nome = nome;
        this.email = email;
        this.cpfOuCnpj = cpfOuCnpj;
        this.tipo = tipo.getId();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpfOuCnpj() {
        return cpfOuCnpj;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public TipoCliente getTipo() {
        return TipoCliente.IntegertoTipoCliente(tipo);
    }

    public void setTipo(TipoCliente tipo) {
        this.tipo = tipo.getId();
    }

    public Set<String> getCelulares() {
        return celulares;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setCelulares(Set<String> celulares) {
        this.celulares = celulares;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }
}
