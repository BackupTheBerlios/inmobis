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
		//if (!(((FiltrarPisoAgenteForm)datosBusqueda).getMetros().equals(null)))
			i.setMetros(((FiltrarPisoAgenteForm)datosBusqueda).getMetros());
		//if (!(((FiltrarPisoAgenteForm)datosBusqueda).getRegimen().equals(null)))
			i.setRegimen(((FiltrarPisoAgenteForm)datosBusqueda).getRegimen());
		/*if (!(((FiltrarPisoAgenteForm)datosBusqueda).getPrecio().equals(null)))
			i.setPrecio(((FiltrarPisoAgenteForm)datosBusqueda).getPrecio());
		if (!(((FiltrarPisoAgenteForm)datosBusqueda).getDatosDeInteres().equals(null)))
			i.setDatosDeInteres(((FiltrarPisoAgenteForm)datosBusqueda).getDatosDeInteres());
		if (!(((FiltrarPisoAgenteForm)datosBusqueda).getNumHab().equals(null)))
			i.setNumHab(((FiltrarPisoAgenteForm)datosBusqueda).getNumHab());
		if (!(((FiltrarPisoAgenteForm)datosBusqueda).getTipo().equals(null)))
			i.setTipo(((FiltrarPisoAgenteForm)datosBusqueda).getTipo());
		if (!(((FiltrarPisoAgenteForm)datosBusqueda).getZona().equals(null)))
			i.setZona(((FiltrarPisoAgenteForm)datosBusqueda).getZona());*/
		
		//se crea el inmueble dase de datos		
		GestorInmuebleBD gestorInmueble= (GestorInmuebleBD)CreadorGestores.crearGestor("inmueble",i);
		
		if(log.isInfoEnabled()){
			log.info("ConsultarInmuebleCondicion 1: Antes de entrar en la base de datos ");
		}
		
		try{
			datos = gestorInmueble.BusquedaDetallada();
			if(log.isInfoEnabled()){
				log.info("ConsultarInmuebleCondicion 2:Esta es la lista ");
			}
		}catch (Exception E){
			if(log.isInfoEnabled()){
				log.info("ConsultarInmuebleCondicion3: Fallo en la busqueda en la base de datos " );
			}
			return datos;
		}
		return datos;
	}

}
