package com.inmobis.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class TraspasarClientesForm extends ActionForm {
	
	private static final Logger i_log = Logger.getLogger(TraspasarClientesForm.class);
	private String idCliente;
	private String idAgente;
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		idCliente="";
		idAgente="";
	}
	
	public ActionErrors validate(
		ActionMapping mapping,
		HttpServletRequest request) {

		ActionErrors errors=new ActionErrors();
		
		if (i_log.isInfoEnabled()){
			i_log.info("Cliente: "+idCliente +". Agente: "+idAgente);
		}
		
		return errors;
	}

	//Getter
	public String getIdCliente(){
		return this.idCliente;
	}
	public String getIdAgente(){
		return this.idAgente;
	}
	
	//Setter
	public void setIdCliente(String idC){
		this.idCliente=idC.trim();
	}
	public void setIdAgente(String idA){
		this.idAgente=idA.trim();
	}

}

