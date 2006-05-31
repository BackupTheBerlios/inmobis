package com.inmobis.consultas;

import java.util.*;
import org.apache.struts.action.ActionForm;

import com.inmobis.bbdd.direccion.InfoDirBean;
import com.inmobis.bbdd.email.InfoMailBean;
import com.inmobis.bbdd.login.UsuarioLoginBean;
import com.inmobis.bbdd.telefono.InfoTelfBean;

public abstract class Consultar {
	public abstract Vector listar(ActionForm datosBusqueda);
	
	public abstract ActionForm dameDatos (String id);
	
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
	
	//se sobreescribe en ConsultarInmueble
	public Vector listarPisosAgente(ActionForm form){
		return null;
	}
	
	//se sobreescribe en ConsultarEmpleado
	public Vector filtrarEmpleados (ActionForm form){
		return null;
	}
	
    //se sobreescribe en ConsultarCliente
	public Vector listarClientesAgente(ActionForm form){
		return null;
	}
	
    //se sobreescribe en ConsultarCliente
	public Vector filtrarClientes (ActionForm form){
		return null;
	}

	// se sobreescribe en ConsultarMensaje
	public ActionForm VerMensaje(ActionForm form){return null;}
	public Vector GetDestinosMensaje(ActionForm form){return null;}
}
