package com.challenge.model;

public enum ETipoRelaciones {
    PADRE("padre"), HERMANO("hijo"),
    MADRE("madre"), PRIMO("primo")
    ,TIO("tio");

    private String relacion;


    private ETipoRelaciones (String relacion){
        this.relacion = relacion;

    }

    public String getRelacion() {
        return relacion;
    }
}
