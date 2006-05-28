package com.inmobis.consultas;

//import java.util.Vector;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;

import com.inmobis.bbdd.CreadorGestores;
import com.inmobis.bbdd.mensajes.*;
import com.inmobis.struts.form.MensajeForm;
import java.util.Vector;

public class ConsultarMensaje extends Consultar {

	private static final Logger log = Logger.getLogger(ConsultarAgente.class);
	
	@Override
	public Vector listar(ActionForm datosBusqueda) {
		//hacemos el cast de la clase
		MensajeForm msgForm = (MensajeForm) datosBusqueda;

		
		Vector datos = new Vector();

		MensajesBean msg = new MensajesBean();
		msg.setOrigen(msgForm.getOrigen());
		
		GestorMensajesBD gestmsg = (GestorMensajesBD)CreadorGestores.crearGestor("mensaje",msg);

		if(log.isInfoEnabled()){
			log.info("ConsultarMensaje 1: Antes de entrar en la base de datos " );
			log.info("ConsultarMensaje 2:  " +					 
					 "Origen del mensaje: " + msgForm.getOrigen());
		}
		
		try{
			datos = gestmsg.BusquedaDetallada();
		}catch (Exception E){
			if(log.isInfoEnabled()){
				log.info("ConsultarMensaje 3: Fallo en BBDD: " + E.getMessage());
			}
			return datos;//si hay un error en la base de datos devuelve un vector con un elemento que indica error
		}
		return datos;
	}
	
	public ActionForm dameDatos (String id){
		return null;
	}
}
