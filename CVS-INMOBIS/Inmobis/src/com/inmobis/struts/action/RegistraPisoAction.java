package com.inmobis.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.inmobis.altas.CreadorIntroducir;
import com.inmobis.altas.Introducir;
import com.inmobis.struts.form.RegistraPisoForm;

public class RegistraPisoAction extends Action {

	private static final Logger i_log = Logger.getLogger(RegistraPisoAction.class);
	
	public ActionForward execute(ActionMapping mapping,
									ActionForm form,
									HttpServletRequest request,
									HttpServletResponse response) {
		RegistraPisoForm registraPisoForm = (RegistraPisoForm) form;
		
		if (i_log.isInfoEnabled()){
			i_log.info("Empiezo a ejecutar la accion");
		}
		//Miro si se ha pulsado cancelar
		Boolean cancelar = (Boolean)request.getAttribute("org.apache.struts.action.CANCEL");
		if(cancelar != null)
			if(cancelar.booleanValue())
				return (mapping.findForward("cancel"));
		//Miro si se ha pulsado resetear
		Boolean resetear =(Boolean)request.getAttribute("org.spache.struts.action.RESET");
		if (resetear !=null)
			if (resetear.booleanValue())
				return (mapping.findForward("reset"));
		
		Introducir intro=CreadorIntroducir.createIntroducir("piso");
		ActionMessages errors=intro.introduce(form);
		
		if(errors.size()>0){
			saveErrors(request, errors);
			return (mapping.findForward("error"));
		}
		return (mapping.findForward("exito"));
	}

}

