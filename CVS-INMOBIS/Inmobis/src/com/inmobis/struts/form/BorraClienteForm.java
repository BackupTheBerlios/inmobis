//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.0.0/xslt/JavaClass.xsl

package com.inmobis.struts.form;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/** 
 * MyEclipse Struts
 * Creation date: 03-29-2006
 * 
 * XDoclet definition:
 * @struts.form name="borraClienteForm"
 */
public class BorraClienteForm extends ActionForm {
	
	// --------------------------------------------------------- Instance Variables
	private String idUsuario;
	// --------------------------------------------------------- Methods
	
	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.idUsuario="";
		
	}
	/** 
	 * Method validate
	 * @param mapping
	 * @param request
	 * @return ActionErrors
	 */
	public ActionErrors validate(ActionMapping mapping,HttpServletRequest request) {

		ActionErrors errors= new ActionErrors();
		if (idUsuario == null || idUsuario.length() < 1)
			errors.add("nombreUsuario",new ActionMessage("errors.nombreUsuario.required"));
		return errors;
	}
	
	
	public String getIDUsuario() {
		return idUsuario;
	}
	public void setIDUsuario(String nombreUsuario) {
		this.idUsuario = nombreUsuario;
	}
	

}

