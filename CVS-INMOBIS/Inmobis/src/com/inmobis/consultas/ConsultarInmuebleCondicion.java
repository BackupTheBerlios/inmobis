package com.inmobis.consultas;

import java.util.*;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;

import com.inmobis.bbdd.CreadorGestores;
import com.inmobis.bbdd.cliente.GestorClienteBD;
import com.inmobis.bbdd.inmueble.*;
import com.inmobis.struts.form.FiltrarPisoAgenteForm;

public class ConsultarInmuebleCondicion extends Consultar{

	private static final Logger log = Logger.getLogger(ConsultarInmuebleCondicion.class);
	
	public Vector listar(ActionForm datosBusqueda){
		//Vector para guardar la lista que me devuelve la base de datos
		Vector datos = new Vector();
		
		
		
		//se crea el empleado bean		
		InmuebleBean i = new InmuebleBean();
		//se rellena el bean
		i.setIdInmueble(((FiltrarPisoAgenteForm)datosBusqueda).getIdInmueble());
		i.setMetros(((FiltrarPisoAgenteForm)datosBusqueda).getMetros());
		i.setRegimen(((FiltrarPisoAgenteForm)datosBusqueda).getRegimen());
		i.setPrecio(((FiltrarPisoAgenteForm)datosBusqueda).getPrecio());
		i.setDatosDeInteres(((FiltrarPisoAgenteForm)datosBusqueda).getDatosDeInteres());
		i.setNumHab(((FiltrarPisoAgenteForm)datosBusqueda).getNumHab());
		i.setTipo(((FiltrarPisoAgenteForm)datosBusqueda).getTipo());
		i.setZona(((FiltrarPisoAgenteForm)datosBusqueda).getZona());
		
		//se crea el empleado dase de datos		
		GestorClienteBD gestorInmueble= (GestorClienteBD)CreadorGestores.crearGestor("inmuebleCondicion",i);
		
		if(log.isInfoEnabled()){
			log.info("ConsultarInmuebleCondicion 1: Antes de entrar en la base de datos " );
			log.info("ConsultarInmuebleCondicion 2:  " +
					"IdInmueble: "+ ((InmuebleBean)gestorInmueble.getBean()).getIdInmueble() +
					 "Metros: " + ((InmuebleBean)gestorInmueble.getBean()).getMetros() + 
					 "Régimen: " + ((InmuebleBean)gestorInmueble.getBean()).getRegimen() + 
					 "Precio: " + ((InmuebleBean)gestorInmueble.getBean()).getPrecio() + 
					 "Otros Datos de Interés: " + ((InmuebleBean)gestorInmueble.getBean()).getdatosDeInteres()+
					 "numero de habitaciones: " + ((InmuebleBean)gestorInmueble.getBean()).getRegimen()+
					 "tipo: " + ((InmuebleBean)gestorInmueble.getBean()).getRegimen()+
					 "zona: " + ((InmuebleBean)gestorInmueble.getBean()).getRegimen());
		}
		
		try{
			datos = ((InmuebleBD)gestorInmueble.getBean()).BusquedaDetallada();			
		}catch (Exception E){
			if(log.isInfoEnabled()){
				log.info("ConsultarInmuebleCondicion: Fallo en la busqueda en la base de datos " );
			}
			return datos;//si hay un error en la base de datos devuelve un vector con un elemento que indica error
		}
		return datos;
	}

}
