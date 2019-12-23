package com.ojs.ordemservico.enums;

public enum Status {
    ABERTO("Aberto"),
    ANDAMENTO("Andamento"),
    AGUARDANDO_PECAS("Aguardando peças"),
    FINALIZADA("Finalizada");

    private String label;

    Status(String label) {
        this.label = label;
    }
}
