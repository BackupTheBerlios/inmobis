//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.0.0/xslt/JavaClass.xsl

package com.inmobis.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


public class EditaEmpleadoPrevForm extends ActionForm {

	private static final Logger i_log = Logger.getLogger(RegistraEmpleadoForm.class);
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		
	}
	
	public ActionErrors validate(ActionMapping mapping,
								HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		if (i_log.isInfoEnabled()){
			i_log.info("Antes de comprobar los errores. Nº errores: "+errors.size());
		}
		//Tendre que comprobar que solo hay 1 empleado seleccionado (la lista que me llega tiene longitud 1?) 
		
		if (i_log.isInfoEnabled()){
			i_log.info("Despues de comprobar los errores. Nº errores: "+errors.size());
		}
		
		return errors;
	}
	
	//Getters
	
	
	//Setters
	


}

