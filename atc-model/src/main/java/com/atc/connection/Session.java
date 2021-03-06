package com.atc.connection;

import com.atc.model.Usuario;

import java.util.Date;

public enum Session {

	INSTANCE;

	private Usuario userSession;
	private String pathFolderDocs;
	private Date lastDateMovimiento;

	public Usuario getUserSession() {
		return userSession;
	}

	public void setUserSession(Usuario userSession) {
		this.userSession = userSession;
	}

	public String getPathFolderDocs() {
		return pathFolderDocs;
	}

	public void setPathFolderDocs(String pathFolderDocs) {
		this.pathFolderDocs = pathFolderDocs;
	}

	public Date getLastDateMovimiento() {
		return lastDateMovimiento;
	}

	public void setLastDateMovimiento(Date lastDateMovimiento) {
		this.lastDateMovimiento = lastDateMovimiento;
	}

	

}
