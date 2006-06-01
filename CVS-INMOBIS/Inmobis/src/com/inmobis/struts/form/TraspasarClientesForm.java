package com.inmobis.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class TraspasarClientesForm extends ActionForm {
	
	private static final Logger i_log = Logger.getLogger(TraspasarClientesForm.class);
	private String idCliente;
	private String idEmpleado;
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		idEmpleado="";
		idCliente="";
	}
	
	public ActionErrors validate(
		ActionMapping mapping,
		HttpServletRequest request) {

		if (i_log.isInfoEnabled()){
			i_log.info("Cliente: "+idCliente +". Agente: "+idEmpleado);
		}
		ActionErrors errors=new ActionErrors();
		if (idCliente.equals(""))
			errors.add("traspasarCliente", new ActionMessage("No ha elegido un cliente"));
		if ( idEmpleado.equals(""))
			errors.add("traspasarCliente", new ActionMessage("No ha elegido un agente"));
		
		return errors;
	}

	//Getter
	public String getIdCliente(){
		return this.idCliente;
	}
	public String getIdEmpleado(){
		return this.idEmpleado;
	}
	
	//Setter
	public void setIdCliente(String idC){
		this.idCliente=idC;
	}
	public void setIdEmpleado(String idA){
		this.idEmpleado=idA;
	}

}

