package com.inmobis.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class TraspasarClientesPrevForm extends ActionForm {
	private String idCliente;
	private static final Logger i_log = Logger.getLogger(TraspasarClientesPrevForm.class);
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		idCliente="";		
	}
	
	public ActionErrors validate(
		ActionMapping mapping,
		HttpServletRequest request) {
		ActionErrors errors=new ActionErrors();
		
		if (i_log.isInfoEnabled()){
			i_log.info("Cliente: "+idCliente);
		}

		return errors;
	}
	
	//Getter
	public String getIdCliente(){
		return this.idCliente;
	}
	
	//Setter
	public void setIdCliente(String id){
		this.idCliente=id.trim();
	}
	

}

