//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.0.0/xslt/JavaClass.xsl

package com.inmobis.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.inmobis.consultas.Consultar;
import com.inmobis.consultas.CreadorConsultar;
import com.inmobis.struts.form.MensajeForm;

/** 
 * MyEclipse Struts
 * Creation date: 05-05-2006
 * 
 * XDoclet definition:
 * @struts.action path="/verMensaje" name="VerMensajeForm" scope="request" validate="true"
 */
public class VerMensajeAction extends Action {

	// --------------------------------------------------------- Instance Variables
	private static final Logger log = Logger.getLogger(VerMensajeAction.class);
	// --------------------------------------------------------- Methods

	/** 
	 * Method execute
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return ActionForward
	 */
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response) {
		MensajeForm VerMensajeForm = (MensajeForm) form;

		ActionMessages errors= new ActionMessages();
		
		//vamos a traer el mensaje de la base de datos.
		Consultar consultaM = CreadorConsultar.CreaConsultar("mensaje");
		
		if (log.isInfoEnabled()){
			log.info("VerMensajeAction 1:Antes de entrar en la base de datos");
		}
		
		MensajeForm msgForm = (MensajeForm) consultaM.VerMensaje(VerMensajeForm);
		
		if (msgForm.getIdMensaje().equalsIgnoreCase("ERROR"))
		{
			if (log.isInfoEnabled()){
				log.info("VerMensajeAction 2:Error al recuperar el mensaje");
			}
			errors.add("ListaMensaje",new ActionMessage("errors.listamensajes.bbdd"));
			saveErrors(request,errors);
			return mapping.findForward("error");
		}
		else{
			if (log.isInfoEnabled()){
				log.info("VerMensajeAction 2:Mensaje recuperado");
			}
			HttpSession session = request.getSession(true);
			session.setAttribute("mensaje",msgForm);
			return mapping.findForward("exito");
		}	
	}

}

