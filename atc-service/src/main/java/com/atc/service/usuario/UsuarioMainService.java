package com.atc.service.usuario;

import com.atc.connection.UsuarioEM;
import com.atc.model.Usuario;

import java.util.List;

public class UsuarioMainService {

	UsuarioEM usuarioEM;
	
	public UsuarioMainService() {
		usuarioEM = new UsuarioEM();
	}
	
	public List<Usuario> getAllUsuarios(){
		return usuarioEM.getAll();
	}
 	
}
