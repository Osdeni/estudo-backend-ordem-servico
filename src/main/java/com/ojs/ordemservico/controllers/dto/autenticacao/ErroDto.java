package com.ojs.ordemservico.controllers.dto.autenticacao;

public class ErroDto implements AutenticacaoDto {
    private String erro;

    public ErroDto(String erro) {
        this.erro = erro;
    }

    public String getErro() {
        return erro;
    }
}
