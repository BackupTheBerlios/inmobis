//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.0.0/xslt/JavaClass.xsl

package com.inmobis.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import com.inmobis.altas.CreadorIntroducir;
import com.inmobis.altas.Introducir;
import com.inmobis.struts.form.MensajeForm;

/** 
 * MyEclipse Struts
 * Creation date: 05-05-2006
 * 
 * XDoclet definition:
 * @struts.action path="/enviarMensaje" name="EnviarMensajeForm" scope="request" validate="true"
 */
public class EnviarMensajeAction extends Action {

	// --------------------------------------------------------- Instance Variables
	private static final Logger i_log = Logger.getLogger(EnviarMensajeAction.class);
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
		//MensajeForm EnviarMensajeForm = (MensajeForm) form;
		
		if (i_log.isInfoEnabled()){
			i_log.info("EnviarMensajeAction1 : Empezando");
		}

		Introducir introMsg = CreadorIntroducir.createIntroducir("mensaje");
		ActionMessages errors = introMsg.introduce(form);

		if(errors.size()>0){
			saveErrors(request, errors);
			return (mapping.findForward("error"));
		}
		return (mapping.findForward("exito"));
	}

}

