package com.atc.service.usuario;

import com.atc.connection.UsuarioEM;
import com.atc.model.Usuario;

import java.util.List;

public class SearchUsuarioService {

	UsuarioEM usuarioEM;

	public SearchUsuarioService() {
		usuarioEM = new UsuarioEM();
	}

	public List<Usuario> search(String str) {
		return usuarioEM.search(str);
	}
}
