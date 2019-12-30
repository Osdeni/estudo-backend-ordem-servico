package com.ojs.ordemservico.enums;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Status {
    ABERTO("Aberto", "secondary"),
    ANDAMENTO("Andamento", "warning"),
    AGUARDANDO_PECAS("Aguardando peças", "primary"),
    FINALIZADA("Finalizada", "success");

    private String label;

    private String cssClass;

    Status(String label, String cssClass) {
        this.label = label;
        this.cssClass = cssClass;
    }

    public String getLabel() {
        return label;
    }

    public String getCssClass() {
        return "badge-" + cssClass;
    }

    public String getIndex() {
        return name();
    }
}
