package com.inmobis.login;


import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.inmobis.bbdd.login.UsuarioLoginBD;
import com.inmobis.bbdd.login.UsuarioLoginBean;
import com.inmobis.struts.form.LoginForm;

public class LoginCliente extends Login{
	private static final Logger milog = Logger.getLogger(LoginCliente.class);

	@Override
	public ActionMessages HazLogin(Object objLogin) {

		if (milog.isInfoEnabled()){
			milog.info("Estoy en HazLogin de LoginCliente");
		}
		ActionMessages errors = new ActionMessages();
		//Creo la Bean de Usuario
		UsuarioLoginBean usuLogin = new UsuarioLoginBean();
		//Le paso el parámetro que necesita
		usuLogin.setNombreUsuario(((LoginForm)objLogin).getUserName());	
		//Creo el LoginBD
		UsuarioLoginBD usuLoginBD = new UsuarioLoginBD(usuLogin);
		//Y lo ejecuto para que me devuelva los datos del cliente strUsu
		try{
			usuLoginBD.select();
		}
		catch (Exception E)
		{
			errors.add("login", new ActionMessage("errors.bbdd.conexion"));
			if (milog.isInfoEnabled()){
				milog.info("LoginCliente Excepcion en la base de datos:"+E.getMessage());
			}
			return errors;
		}
		if (milog.isInfoEnabled()){
			milog.info("LoginCliente mipass:"+((LoginForm)objLogin).getPassword()
					+" la de la BBDD: " +usuLogin.getPassword());
			milog.info("LoginCliente tipousu:"+usuLogin.getTipoUsuario()+" ident: " +usuLogin.getIdUsuario());
		}

		if (((LoginForm)objLogin).getPassword().trim().equals(usuLogin.getPassword().trim()))
		{
			((LoginForm)objLogin).setIdUsuario(usuLogin.getIdUsuario());
			((LoginForm)objLogin).setTipoUsuario(usuLogin.getTipoUsuario());
		}else{
			if (usuLogin.getPassword().trim().equals(""))  
				errors.add("login", new ActionMessage("error.password.invalid"));
			else
				errors.add("login", new ActionMessage("error.username.noexiste"));
		}
		return errors;
	}

}
