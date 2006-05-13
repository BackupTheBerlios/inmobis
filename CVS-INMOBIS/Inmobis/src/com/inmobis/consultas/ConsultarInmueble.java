package com.inmobis.consultas;

import java.util.*;

import org.apache.struts.action.ActionForm;
import org.apache.log4j.Logger;

import com.inmobis.bbdd.CreadorGestores;
import com.inmobis.bbdd.inmueble.GestorInmuebleBD;
import com.inmobis.bbdd.inmueble.InmuebleBean;
import com.inmobis.bbdd.inmueble.InmuebleBD;

public class ConsultarInmueble extends Consultar{
	
	private static final Logger log = Logger.getLogger(ConsultarInmueble.class);
	
	public Vector listar(ActionForm datosBusqueda){
		//Vector para guardar la lista que me devuelve la base de datos
		Vector datos = new Vector();
		//se crea un bean del inmueble
		InmuebleBean e = new InmuebleBean();
//		LLamada al gestor de la base de datos 
		GestorInmuebleBD gestorInmueble= (GestorInmuebleBD)CreadorGestores.crearGestor("inmueble",e);
		try{
			if(log.isInfoEnabled()){
				log.info("ConsultarInmueble 1: Se van a listar todos los inmuebles disponibles en la bd " );
			}
			datos = gestorInmueble.listarInmuebles();
		}catch (Exception E){
			if(log.isInfoEnabled()){
				log.info("ConsultarInmueble 2: Fallo en la busqueda en la base de datos " );
			}
			return datos;
		}
		return datos;	
	}	
}
