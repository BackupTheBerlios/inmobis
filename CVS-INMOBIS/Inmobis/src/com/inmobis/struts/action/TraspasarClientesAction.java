package com.inmobis.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import com.inmobis.modificaciones.CreadorModificar;
import com.inmobis.modificaciones.Modificar;
import com.inmobis.struts.form.TraspasarClientesForm;


public class TraspasarClientesAction extends Action {

	private static final Logger i_log = Logger.getLogger(TraspasarClientesAction.class);
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response) {

		if (i_log.isInfoEnabled()){
			i_log.info("idCliente a traspasar: "+((TraspasarClientesForm)form).getIdCliente());
			i_log.info("idAgente al que se traspasa: "+((TraspasarClientesForm)form).getIdEmpleado());
		}
		
		Modificar traspaso=CreadorModificar.createModificar("traspasar");
		ActionMessages errors=traspaso.modifica(form);
		HttpSession session = request.getSession(true);		
		session.setAttribute("ids",form);
		if(errors.size()>0){
			saveErrors(request, errors);
			return (mapping.findForward("error"));
		}
		return mapping.findForward("exito");

	}

}

