package com.inmobis.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.inmobis.consultas.Consultar;
import com.inmobis.consultas.CreadorConsultar;
import com.inmobis.struts.form.EditaClienteForm;
import com.inmobis.struts.form.EditaClientePrevForm;

public class EditaClientePrevAction extends Action{

	private static final Logger i_log = Logger.getLogger(EditaClientePrevAction.class);
	
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) {
			
		//Coger los datos de la lista que le llega al form, obtener los
		//datos que faltan de la BBDD y pasarselos al jsp de editaUsuario
		if (i_log.isInfoEnabled()){
			i_log.info("Voy a coger los datos del usuario: "+((EditaClientePrevForm)form).getIdUsuario());
		}
		
		
		Consultar consult=CreadorConsultar.CreaConsultar("cliente");
		
		EditaClienteForm datosCliente=((EditaClienteForm)consult.dameDatos(((EditaClientePrevForm)form).getIdUsuario()));
		
		if (i_log.isInfoEnabled()){
			i_log.info("Direccion "+datosCliente.getCalle());
		}
		//Poner los datos en una variable de sesion
		HttpSession session = request.getSession(true);
		session.setAttribute("datosCliente",datosCliente);
		return (mapping.findForward("exito"));
		}

}