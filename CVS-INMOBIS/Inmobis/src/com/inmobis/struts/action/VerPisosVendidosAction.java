//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.0.0/xslt/JavaClass.xsl

package com.inmobis.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.inmobis.struts.form.VerPisosVendidosForm;

/** 
 * MyEclipse Struts
 * Creation date: 05-30-2006
 * 
 * XDoclet definition:
 * @struts.action path="/verPisosVendidos" name="verPisosVendidosForm" input="/MenuContable.jsp" scope="request" validate="true"
 */
public class VerPisosVendidosAction extends Action {

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
		VerPisosVendidosForm verPisosVendidosForm = (VerPisosVendidosForm) form;
		// TODO Auto-generated method stub
		return null;
	}

}

