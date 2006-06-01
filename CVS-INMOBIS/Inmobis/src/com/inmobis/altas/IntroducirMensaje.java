package com.inmobis.altas;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.inmobis.bbdd.CreadorGestores;
import com.inmobis.bbdd.GeneradorDeCodigos;
import com.inmobis.bbdd.mensajes.GestorMensajesBD;
import com.inmobis.bbdd.mensajes.MensajesBean;
import com.inmobis.struts.form.MensajeForm;

public class IntroducirMensaje extends Introducir{
	private static final Logger i_log = Logger.getLogger(IntroducirMensaje.class);
	
	@Override
	public ActionMessages introduce(ActionForm form) {
		MensajeForm msgForm = (MensajeForm) form;
		ActionMessages errors= new ActionMessages();
		if(i_log.isInfoEnabled())
			i_log.info("IntroducirMensaje: Entro");
		
		if (((msgForm.getOrigen()== null)||(msgForm.getDestino()== null))||(((msgForm.getOrigen().equalsIgnoreCase("")) || (msgForm.getDestino().equalsIgnoreCase(""))))){
			errors.add("insertaMensaje", new ActionMessage("errors.mensaje.vacios"));
			return errors;
		}		
		
		GeneradorDeCodigos gc=GeneradorDeCodigos.getGeneradorDeCodigos();
		//Creamos y rellenamos el objeto Bean para el mensaje
		MensajesBean msgBean = new MensajesBean();
		msgBean.setIdMensaje(gc.asignaCodigoMensaje());
		msgBean.setOrigen(msgForm.getOrigen());
		msgBean.setDestino(msgForm.getDestino());
		msgBean.setFecha(msgForm.getFecha());
		msgBean.setAsunto(msgForm.getAsunto());
		msgBean.setLeido('N');
		msgBean.setTexto(msgForm.getTexto());

		if(i_log.isInfoEnabled())
			i_log.info("InsertarMensaje1:" + msgBean.getIdMensaje());
		
		GestorMensajesBD gestMsg = (GestorMensajesBD) CreadorGestores.crearGestor("mensajes",msgBean);
		try {
			gestMsg.insert();
		} catch (Exception E) {
			if (i_log.isInfoEnabled()){
				i_log.info("InsertarMensaje2: Error al insertar en la BBDD");
			}
			errors.add("insertaMensaje", new ActionMessage(E.toString()));
			return errors;
		}
		
		if (i_log.isInfoEnabled()){
			i_log.info("InsertarMensaje3: Mensaje insertado");
		}
		
		return errors;
	}

}
