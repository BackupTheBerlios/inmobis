package com.inmobis.consultas;

import java.util.Vector;

import org.apache.struts.action.ActionForm;
//import com.inmobis.bbdd.CreadorGestores;
import com.inmobis.bbdd.empleado.*;
//import com.inmobis.struts.form.*;
import org.apache.log4j.Logger;


public class ConsultarAgente extends Consultar{

	private static final Logger log = Logger.getLogger(ConsultarAgente.class);
	
	public Vector listar(ActionForm datosBusqueda){
		//Vector para guardar la lista que me devuelve la base de datos
		Vector datos = new Vector();				
		try{
			AgenteBean a = new AgenteBean();
			AgenteBD gestorAgente = new AgenteBD(a);
			if(log.isInfoEnabled()){
				log.info("ConsultarAgente 1: Antes de entrar en la base de datos " );						
			}
			datos = gestorAgente.listarAgentes();		
		}catch (Exception E){
			if(log.isInfoEnabled()){
				log.info("ConsultarAgente 3: Fallo en la busqueda en la base de datos " );
			}
			
			return datos;//si hay un error en la base de datos devuelve un vector con un elemento que indica error
		}
		return datos;
	}
	public ActionForm dameDatos (ActionForm id){
		return null;
	}
	
}
