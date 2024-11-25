package com.ecommerce.model;

import com.ecommerce.enums.EstadoPagamento;
import jakarta.persistence.Entity;

@Entity
public class PagamentoComCartao extends Pagamento{

    private Integer numeroDeParcelas;

    public PagamentoComCartao() {
    }

    public PagamentoComCartao(EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
        super(estado, pedido);
        this.numeroDeParcelas = numeroDeParcelas;
    }
}
