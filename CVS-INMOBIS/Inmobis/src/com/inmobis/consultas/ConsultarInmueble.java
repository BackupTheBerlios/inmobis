package com.inmobis.consultas;

import java.util.*;

import org.apache.struts.action.ActionForm;
import org.apache.log4j.Logger;

import com.inmobis.bbdd.empleado.AgenteBD;
import com.inmobis.bbdd.empleado.AgenteBean;
import com.inmobis.bbdd.inmueble.GestorInmuebleBD;
import com.inmobis.bbdd.inmueble.InmuebleBean;
import com.inmobis.bbdd.inmueble.InmuebleBD;
import com.inmobis.bbdd.*;
import com.inmobis.struts.form.*;

public class ConsultarInmueble extends Consultar{
	
	private static final Logger log = Logger.getLogger(ConsultarInmueble.class);
	
	public Vector listar(ActionForm datosBusqueda){
		//Vector para guardar la lista que me devuelve la base de datos
		Vector datos = new Vector();
		
		//se crea el bean del inmueble
		InmuebleBean inmueble = new InmuebleBean();
		//se crea el inmueble dase de datos	
		GestorInmuebleBD gestorInmueble=(GestorInmuebleBD)CreadorGestores.crearGestor("inmueble",inmueble);
		
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

		if(log.isInfoEnabled()){
			log.info("ConsultarInmueble 3: Exito " );
		}
		return datos;	
	}
	
	public Vector listarPisosAgente(ActionForm datosBusqueda){
//		Vector para guardar la lista que me devuelve la base de datos
		Vector datos = new Vector();
//		se crea un bean del agente
		AgenteBean e = new AgenteBean();
		e.setIdAgente(((VerPisosAgenteForm)datosBusqueda).getIdAgente());
		//LLamada al gestor de la base de datos 
		AgenteBD agente = new AgenteBD(e);
		
		try{
			if(log.isInfoEnabled()){
				log.info("ConsultarInmueble 4: Se van a listar todos los inmuebles del agente disponibles en la bd " );
			}
			datos = agente.listarInmueblesAgentes();
		}catch (Exception E){
			if(log.isInfoEnabled()){
				log.info("ConsultarInmueble 5: Fallo en la busqueda en la base de datos " );
			}
			return datos;
		}
		if(log.isInfoEnabled()){
			log.info("ConsultarInmueble 6: Exito " );
		}
	return datos;
	}
}
