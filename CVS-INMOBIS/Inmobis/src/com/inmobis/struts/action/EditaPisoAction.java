package com.inmobis.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

//import org.apache.log4j.Logger;
import java.util.*;

import com.inmobis.struts.form.EditaClienteForm;
import com.inmobis.struts.form.EditaPisoForm;

/**
 * @author Mike Robinson
 *
 */
public class EditaPisoAction extends Action 

{
//	private static final Logger milog = Logger.getLogger(EditaPisoAction.class);
	/**
	 * Handles user's request for login
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @throws Exception
	 * @return ActionForward
	 */
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
		
		//Edito los datos del usuario
		session.setAttribute("idInmueble",((EditaPisoForm)form).getIdInmueble());
		session.setAttribute("metros",((EditaPisoForm)form).getMetros());
		session.setAttribute("datosdeinteres",((EditaPisoForm)form).getDatosDeInteres());
		session.setAttribute("precio",((EditaPisoForm)form).getPrecio());
		session.setAttribute("regimen",((EditaPisoForm)form).getRegimen());

		return (mapping.findForward("exito"));
	
	}
}
		

