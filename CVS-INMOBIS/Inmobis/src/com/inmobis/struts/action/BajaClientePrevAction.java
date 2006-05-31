//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.0.0/xslt/JavaClass.xsl

package com.inmobis.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.inmobis.struts.form.BorraClienteForm;

/** 
 * MyEclipse Struts
 * Creation date: 05-31-2006
 * 
 * XDoclet definition:
 * @struts.action path="/BajaClientePrev" name="borraClienteForm" input="/VerClientes.jsp" scope="request" validate="true"
 * @struts.action-forward name="exito" path="/editaCliente.jsp"
 * @struts.action-forward name="error" path="/VerClientes.jsp"
 */
public class BajaClientePrevAction extends Action {

	// --------------------------------------------------------- Instance Variables

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
		BorraClienteForm borraClienteForm = (BorraClienteForm) form;
		// TODO Auto-generated method stub
		return null;
	}

}

