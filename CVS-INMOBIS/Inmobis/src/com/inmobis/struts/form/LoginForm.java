package com.inmobis.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import org.apache.log4j.Logger;

public class LoginForm extends ActionForm 
{
	private String userName;
	private String password;
	private String tipoUsuario;
	private String idUsuario;
	
	/**
	 * Resets data fields to initial values on loginform
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request)
	{
		this.password = "";
		this.userName = "";
		this.tipoUsuario="";
		
	}
	
	/**
	 * Performs validation of data on loginform
	 * @param mapping
	 * @param request
	 * @return ActionErrors
	 */
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
	{
		ActionErrors errors = new ActionErrors();
		
		if((userName == null) || (userName.length() < 1))
			errors.add("userName", new ActionMessage("error.username.required"));
		if((password == null) || (password.length() < 1))
			errors.add("password", new ActionMessage("error.password.required"));
		/*if((tipoUsuario==null) ||(tipoUsuario.length()<1))
			errors.add("tipoUsuario", new ActionError("error.tipousuario.required"));
			*/
		return errors;
			
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getUserName() {
		return userName;
	}

	public String getTipoUsuario(){
		return tipoUsuario;
	}
	public void setPassword(String string) {
		this.password = string;
	}
	
	public void setUserName(String string) {
		this.userName = string;
	}
	
	public void setTipoUsuario(String tipo){
		this.tipoUsuario= tipo;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

}
