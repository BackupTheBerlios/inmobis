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
	
	public ActionForm VerMensaje(ActionForm form){
		MensajeForm msgForm = (MensajeForm) form;
		
		MensajesBean msgBean = new MensajesBean();
		msgBean.setIdMensaje(msgForm.getIdMensaje());
		msgBean.setOrigen(msgForm.getOrigen());
		msgBean.setDestino(msgForm.getDestino());
		msgBean.setFecha(msgForm.getFecha());

		GestorMensajesBD gestmsg = (GestorMensajesBD)CreadorGestores.crearGestor("mensaje",msgBean);

		if(log.isInfoEnabled()){
			log.info("ConsultarMensaje 1: Antes de entrar en la base de datos " );
			log.info("ConsultarMensaje 2:  " +					 
					 "Origen del mensaje: " + msgForm.getOrigen());
		}
		
		try{
			gestmsg.select();
			msgBean = (MensajesBean) gestmsg.getBean();
			msgForm.setAsunto(msgBean.getAsunto());
			msgForm.setDestino(msgBean.getDestino());
			msgForm.setFecha(msgBean.getFecha());
			msgForm.setIdMensaje(msgBean.getIdMensaje());
			msgForm.setLeido(msgBean.getLeido());
			msgForm.setNombreDestino(msgBean.getNombreDestino());
			msgForm.setNombreOrigen(msgBean.getNombreOrigen());
			msgForm.setOrigen(msgBean.getOrigen());
			msgForm.setDestino(msgBean.getDestino());
			msgForm.setTexto(msgBean.getTexto());
		}catch (Exception E){
			if(log.isInfoEnabled()){
				log.info("ConsultarMensaje 3: Fallo en BBDD: " + E.getMessage());
			}
			return msgForm;//Devolvemos el Form
		}

		return form;
	}	
	
	public ActionForm dameDatos (String id){
		return null;
	}
}
