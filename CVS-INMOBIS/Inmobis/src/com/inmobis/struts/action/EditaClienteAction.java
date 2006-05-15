package com.inmobis.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import com.inmobis.modificaciones.CreadorModificar;
import com.inmobis.modificaciones.Modificar;
import com.inmobis.struts.form.EditaClienteForm;
import com.inmobis.struts.form.RegistraClienteForm;

/**
 * @author Mike Robinson
 *
 */
public class EditaClienteAction extends Action {

	private static final Logger i_log = Logger.getLogger(EditaClienteAction.class);
	
	public ActionForward execute( 	ActionMapping mapping,
									ActionForm form,
									HttpServletRequest request,
									HttpServletResponse response)
									throws Exception{
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
		
		if (i_log.isInfoEnabled()){
			i_log.info("Voy a modificar al usuario: "+((EditaClienteForm)form).getNombreUsuario());
		}
		
		Modificar modif=CreadorModificar.createModificar("cliente");
		ActionMessages errors=modif.modifica(form);
		
		if(errors.size()>0){
			saveErrors(request, errors);
			if (i_log.isInfoEnabled()){
				i_log.info("Hay erorres");
			}
			return (mapping.findForward("error"));
		}
		if (i_log.isInfoEnabled()){
			i_log.info("No hay erorres");
		}
		return (mapping.findForward("exito"));
		
	}
}
