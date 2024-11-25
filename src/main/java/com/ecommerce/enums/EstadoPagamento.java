package com.ecommerce.enums;

public enum EstadoPagamento {

    PENDENTE("PENDENTE",1),
    QUITADO("QUITADO",2),
    CANCELADO("CANCELADO",3);

    private final String descricao;
    private final Integer codigo;

     EstadoPagamento(String descricao, Integer codigo){
         this.descricao = descricao;
        this.codigo =  codigo;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public EstadoPagamento integerToEstadoPagemento(Integer codigo){
         if(codigo == null){
             return null;
         }
        for (EstadoPagamento estado : EstadoPagamento.values()) {
            if (codigo.equals(estado.getCodigo())) {
                return estado;
            }
        }
        throw new IllegalArgumentException("Id inválido " + codigo);

    }

}
