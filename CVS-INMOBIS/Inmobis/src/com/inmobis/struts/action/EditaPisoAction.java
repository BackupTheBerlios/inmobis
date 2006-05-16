package com.inmobis.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

//import org.apache.log4j.Logger;
import java.util.*;

import com.inmobis.modificaciones.CreadorModificar;
import com.inmobis.modificaciones.Modificar;
import com.inmobis.struts.form.EditaClienteForm;
import com.inmobis.struts.form.EditaPisoForm;

/**
 * @author Mike Robinson
 *
 */
public class EditaPisoAction extends Action 

{
	private static final Logger i_log = Logger.getLogger(EditaPisoAction.class);
	
	public ActionForward execute( 	ActionMapping mapping,
									ActionForm form,
									HttpServletRequest request,
									HttpServletResponse response)
									throws Exception
	{
		
		
		HttpSession session = request.getSession(true);
		//Miro si se ha pulsado cancelar
		Boolean bCancel = (Boolean)request.getAttribute("org.apache.struts.action.CANCEL");
		if(bCancel != null)
			if(bCancel.booleanValue())
				return (mapping.findForward("cancel"));
		//Miro si se ha pulsado resetear
		Boolean resetear =(Boolean)request.getAttribute("org.spache.struts.action.RESET");
		if (resetear !=null)
			if (resetear.booleanValue())
				return (mapping.findForward("reset"));

//		session.setAttribute("metros",((EditaPisoForm)form).getMetros());
//		session.setAttribute("datosdeinteres",((EditaPisoForm)form).getDatosDeInteres());
//		session.setAttribute("precio",((EditaPisoForm)form).getPrecio());
//		session.setAttribute("regimen",((EditaPisoForm)form).getRegimen());

		if (i_log.isInfoEnabled()){
			i_log.info("Voy a modificar al inmueble: "+((EditaPisoForm)form).getCalle());
		}
		
		Modificar modif=CreadorModificar.createModificar("piso");
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
		

