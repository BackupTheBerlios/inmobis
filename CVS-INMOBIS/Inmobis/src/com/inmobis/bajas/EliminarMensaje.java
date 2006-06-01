package com.inmobis.bajas;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;

import com.inmobis.bbdd.CreadorGestores;
import com.inmobis.bbdd.mensajes.GestorMensajesBD;
import com.inmobis.bbdd.mensajes.MensajesBean;
import com.inmobis.struts.form.MensajeForm;

public class EliminarMensaje extends Eliminar{

	private static final Logger log = Logger.getLogger(EliminarMensaje.class);
	@Override
	public boolean validarRegistrado(ActionForm id) {
		// Metodo que mira su existe en la base de datos
		MensajesBean msg = new MensajesBean();
		msg.setIdMensaje(((MensajeForm)id).getIdMensaje());
		msg.setOrigen(((MensajeForm)id).getOrigen());
		msg.setDestino(((MensajeForm)id).getDestino());
		msg.setFecha(((MensajeForm)id).getAnioNacimiento()+"-"+((MensajeForm)id).getMesNacimiento()+"-"+((MensajeForm)id).getDiaNacimiento());
		//se crea un empleado de la base de datos
		GestorMensajesBD gestMsg = (GestorMensajesBD) CreadorGestores.crearGestor("mensaje",msg);

		//mensajes para ver los errores
		if (log.isInfoEnabled()){
			log.info("EliminarMensaje1: Antes de la BDD tengo idMensaje: "+ msg.getIdMensaje());
		}
		//miro a ver si el mensaje está en la BBDD
		try {
			gestMsg.BusquedaDetallada();
		} catch (Exception E) {
			if (log.isInfoEnabled()){
				log.info("EliminarMensaje2: no he encontrado ese mensaje en la bbdd");
			}
			return false;
		}
		
		if (log.isInfoEnabled()){
			log.info("EliminarMensaje3: Mensaje encontrado  ");
		}
		return true;	
	}

	@Override
	public boolean eliminarDesdeED(ActionForm id) {
		MensajesBean msg = new MensajesBean();
		msg.setIdMensaje(((MensajeForm)id).getIdMensaje());
		msg.setOrigen(((MensajeForm)id).getOrigen());
		msg.setDestino(((MensajeForm)id).getDestino());
		msg.setFecha(((MensajeForm)id).getAnioNacimiento()+"-"+((MensajeForm)id).getMesNacimiento()+"-"+((MensajeForm)id).getDiaNacimiento());
		//se crea un empleado de la base de datos
		GestorMensajesBD gestMsg = (GestorMensajesBD) CreadorGestores.crearGestor("mensaje",msg);

		//mensajes para ver los errores
		if (log.isInfoEnabled()){
			log.info("EliminarMensaje1: Antes de la BDD tengo idMensaje: "+ msg.getIdMensaje());
		}
		//Borramos el mensaje
		try {
			gestMsg.delete();
		} catch (Exception E) {
			if (log.isInfoEnabled()){
				log.info("EliminarMensaje2: Fallo al borrar de la bbdd");
			}
			return false;
		}
		
		if (log.isInfoEnabled()){
			log.info("EliminarMensaje3: Mensaje Eliminado ");
		}
		return true;	
	}
}
