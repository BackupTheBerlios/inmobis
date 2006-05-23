package com.inmobis.consultas;

import java.util.*;
import org.apache.struts.action.ActionForm;

import com.inmobis.bbdd.direccion.InfoDirBean;
import com.inmobis.bbdd.email.InfoMailBean;
import com.inmobis.bbdd.login.UsuarioLoginBean;
import com.inmobis.bbdd.telefono.InfoTelfBean;

public abstract class Consultar {
	public abstract Vector listar(ActionForm datosBusqueda);
	
	//Metodo que se sobreescribe en ConsultarEmpleado, Cliente y Piso
	public InfoDirBean getDir(ActionForm datos){
		return null;
	}
	// Metodos que se sobreescriben en ConsultarEmpleado y Cliente
	public InfoTelfBean getTelf(ActionForm datos){
		return null;
	}
	public InfoMailBean getMail(ActionForm datos){
		return null;
	}
	public UsuarioLoginBean getLogin(ActionForm datos){
		return null;
	}
}
