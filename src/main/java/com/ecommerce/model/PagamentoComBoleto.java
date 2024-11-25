package com.ecommerce.model;

import com.ecommerce.enums.EstadoPagamento;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class PagamentoComBoleto extends Pagamento{
    private LocalDate dataVencimento;

    private LocalDate dataPagamento;

    PagamentoComBoleto(){}

    public PagamentoComBoleto(EstadoPagamento estado, Pedido pedido, LocalDate dataVencimento, LocalDate dataPagamento) {
        super(estado, pedido);
        this.dataPagamento = dataPagamento;
        this.dataVencimento = dataVencimento;
    }
}
