package com.inmobis.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class EditaClientePrevAction extends Action{

	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) {
			//Coger los datos de la lista que le llega al form y pasarselos al jsp de editarEmpleado
			return mapping.findForward("exito");
		}

}
