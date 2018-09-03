package com.atc.service;

import com.atc.connection.UsuarioEM;
import com.atc.model.Usuario;

import java.util.List;

public class AuthService {

	UsuarioEM usuarioEM;

	public AuthService() {
		usuarioEM = new UsuarioEM();
	}

	public Usuario getUsuario(String user) {
		return usuarioEM.getUsuarioByUser(user);
	}

	public Usuario[] getAllUsuario() {
		List<Usuario> user = usuarioEM.getAll();
		Usuario[] usersArray = new Usuario[user.size()];
		usersArray = user.toArray(usersArray);
		return usersArray;
	}

}
