package com.inmobis.bajas;

import org.apache.struts.action.ActionForm;
import com.inmobis.struts.form.BorraPisoForm;
import com.inmobis.struts.form.BorraPisoPrevForm;

import org.apache.log4j.Logger;
import com.inmobis.bbdd.inmueble.InmuebleBD;
import com.inmobis.bbdd.inmueble.InmuebleBean;
import com.inmobis.struts.action.BorraClienteAction;

public class EliminarInmueble extends Eliminar{
	
	private static final Logger log = Logger.getLogger(BorraClienteAction.class);
	
	public boolean validarRegistrado(ActionForm id){	
		//	se crea un Bean para el inmueble 
		InmuebleBean inmueble = new InmuebleBean();
		inmueble.setIdInmueble(((BorraPisoPrevForm)id).getIdInmueble());
		//se crea un inmueble de la base de datos
		InmuebleBD inmueblebd = new InmuebleBD(inmueble);
		//mensajes para ver los errores
		if (log.isInfoEnabled()){
			log.info("EliminarInmueble1: Antes de la BDD tengo idInmueble: "+ ((InmuebleBean)inmueblebd.getBean()).getIdInmueble());
			log.info("EliminarInmueble2: Voy a entrar en la base de datos, para validar");
		}
		//miro a ver si el inmueble está en la BBDD
		try {
			inmueblebd.select();
		} catch (Exception E) {
			if (log.isInfoEnabled()){
				log.info("EliminarInmueble3: no ha visto al inmueble en la base de datos");
			}
			return false;
		}
		if (log.isInfoEnabled()){
			log.info("EliminarInmueble4:Datos de Interés:  "+ ((InmuebleBean)inmueblebd.getBean()).getdatosDeInteres()+
				"ID del inmueble: " + ((InmuebleBean)inmueblebd.getBean()).getIdInmueble()+ 
				"Metros: " + ((InmuebleBean)inmueblebd.getBean()).getMetros()+
				"Precio: " + ((InmuebleBean)inmueblebd.getBean()).getPrecio()+ 
				"Regimen: " + ((InmuebleBean)inmueblebd.getBean()).getRegimen());
		}
		return true;
	}
	
	public boolean eliminarDesdeED(ActionForm id){		
//		se crea un Bean inmueble
		InmuebleBean inmueble = new InmuebleBean();
		inmueble.setIdInmueble(((BorraPisoForm)id).getIdInmueble());
		//se crea inmueble de la base de datos
		InmuebleBD inmueblebd = new InmuebleBD (inmueble);
		//mensajes de error del log
		if (log.isInfoEnabled()){
			log.info("EliminarInmueble6:Antes de la BDD tengo idInmueble: "+ ((InmuebleBean)inmueblebd.getBean()).getIdInmueble());
			log.info("EliminarInmueble7:voy a entrar en la base de datos para borrar el inmueble");
		}
		//se borra el inmueble
		try {
			inmueblebd.delete();
		} catch (Exception E) {
			if (log.isInfoEnabled()){
				log.info("EliminarInmueble8:ha lanzado una excepción y no ha eliminado el inmueble");
			}
			return false;
		}
		if (log.isInfoEnabled()){
			log.info("EliminarInmueble 9:se ha eliminado con exito");
		}
		return true;
	}
}
