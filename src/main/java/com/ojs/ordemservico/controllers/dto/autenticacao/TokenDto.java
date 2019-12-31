package com.ojs.ordemservico.controllers.dto.autenticacao;

public class TokenDto implements AutenticacaoDto {

	private String token;
	private String tipo;
	private UsuarioDto usuario;

	public TokenDto(String token, String tipo, UsuarioDto usuario) {
		this.token = token;
		this.tipo = tipo;
		this.usuario = usuario;
	}

	public String getToken() {
		return token;
	}

	public String getTipo() {
		return tipo;
	}

	public UsuarioDto getUsuario() {
		return usuario;
	}

}
