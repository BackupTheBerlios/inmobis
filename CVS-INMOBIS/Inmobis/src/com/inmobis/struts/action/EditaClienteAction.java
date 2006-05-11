package com.inmobis.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.inmobis.struts.form.EditaClienteForm;

/**
 * @author Mike Robinson
 *
 */
public class EditaClienteAction extends Action 

{
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
		//TODO
		return mapping.findForward("success");
		
	}
}
