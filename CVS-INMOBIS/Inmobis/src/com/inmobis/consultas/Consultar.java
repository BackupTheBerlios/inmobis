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

	//se sobreescribe en ConsultarInmueble
	public Vector listarPisosAgente(ActionForm form){
		return null;
	}
	
    //se sobreescribe en ConsultarInmueble
	public Vector listarPisosVendidos(ActionForm form){
		return null;
	} 
	
    //se sobreescribe en ConsultarInmueble
	public Vector filtrarPisosVendidos(ActionForm form){
		return null;
	} 
		
	public ActionForm dameDatosFoto(String Id){
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
	
	//se sobreescribe en ConsultarMensaje
	public ActionForm VerMensaje(ActionForm form){return null;}
	public Vector GetDestinosMensajeAgente(ActionForm form){return null;}
	public Vector GetDestinosMensajeCliente(ActionForm form){return null;}
	public Vector listarAgente(ActionForm form){return null;}
	//se sobreescribe 
	public String dameTipoUsuario(String id){return null;}

}
