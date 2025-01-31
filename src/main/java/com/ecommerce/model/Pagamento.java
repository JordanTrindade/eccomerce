package com.ecommerce.model;

import com.ecommerce.enums.EstadoPagamento;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    Integer estado;

    @OneToOne
    Pedido pedido;

    public Pagamento(){}

    public Pagamento(EstadoPagamento estado, Pedido pedido) {
        this.estado = estado.getCodigo();
        this.pedido = pedido;
    }
}
