package com.inmobis.consultas;

import java.util.Vector;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;

import com.inmobis.bbdd.mensajes.GestorMensajesBD;
import com.inmobis.bbdd.mensajes.RelMensajesBean;
import com.inmobis.struts.form.LoginForm;
import com.inmobis.struts.form.MensajeForm;

public class ConsultarMensaje extends Consultar {

	private static final Logger log = Logger.getLogger(ConsultarAgente.class);
	
	@Override
	public Vector listar(ActionForm datosBusqueda) {
		//hacemos el cast de la clase
		MensajeForm msgForm = (MensajeForm) datosBusqueda;

		
		Vector datos = new Vector();

		RelMensajesBean msg = new RelMensajesBean();
		
		GestorMensajesBD gestmsg = new GestorMensajesBD();

		if(log.isInfoEnabled()){
			log.info("ConsultarMensaje 1: Antes de entrar en la base de datos " );
			log.info("ConsultarAgente 2:  " +					 
					 "Origen del mensaje: " + msgForm.getOrigen());
		}

		
		try{
			
		}catch (Exception E){
			if(log.isInfoEnabled()){
				log.info("ConsultarMensaje 3: Fallo en BBDD: " + E.getMessage());
			}
			return datos;//si hay un error en la base de datos devuelve un vector con un elemento que indica error
		}
		return datos;
	}
}
