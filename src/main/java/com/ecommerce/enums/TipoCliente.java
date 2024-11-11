package com.ecommerce.enums;

public enum TipoCliente {
        PESSOAFISICA(1,"PESSOA FISICA"),
        PESSOAJURICICA(2,"PESSOA JURIDICA");

        private final Integer id;
        private final String descricao;

        TipoCliente(Integer id, String descricao){
                this.id = id;
                this.descricao = descricao;
        }

        public Integer getId() {
                return id;
        }

        public String getDescricao() {
                return descricao;
        }

        public static TipoCliente IntegertoTipoCliente(Integer id) {

                if (id == null) {
                        return null;
                }

                for (TipoCliente tipo : TipoCliente.values()) {
                        if (id.equals(tipo.getId())) {
                                return tipo;
                        }
                }
                throw new IllegalArgumentException("Id inválido " + id);
        }
}
