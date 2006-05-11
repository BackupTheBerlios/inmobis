package com.inmobis.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import org.apache.log4j.Logger;

import com.inmobis.INMOCTES;
import com.inmobis.login.*;
import com.inmobis.struts.form.LoginForm;


public class LoginAction extends Action 
{
	private static final Logger milog = Logger.getLogger(LoginAction.class);
	/**
	 * Handles user's request for login
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @throws Exception
	 * @return ActionForward
	 */
	public ActionForward execute( 	ActionMapping mapping,
									ActionForm form,
									HttpServletRequest request,
									HttpServletResponse response)
									throws Exception
	{
		//por defecto que vuelva a la pagina de login
		String target = new String("fallo");
		//Capturo los parametros despues de la validacion
		
		if (milog.isInfoEnabled()){
			milog.info("Antes de la BDD tengo Usuario: "+((LoginForm)form).getUserName()
					+" pass: "+((LoginForm)form).getPassword());
		}

		// Creamos el objeto login y hacemos login
		// Guardamos los errores que nos dan en un action errors	
		Login miLogin = CreadorLogin.CreateLogin(((LoginForm)form).getTipoUsuario());
		ActionMessages errors = miLogin.HazLogin(form);
		saveErrors(request,errors); //Hay que guardarlos.
		if (errors.isEmpty()) //Si no hay errores
		{
			if (milog.isInfoEnabled()){
				milog.info("Login con éxito: "+((LoginForm)form).getUserName()
						+" Tipousu: "+((LoginForm)form).getTipoUsuario()
						+" Ident: "+ ((LoginForm)form).getIdUsuario());
			}
			//Creamos la variable session y le ponemos el usuario y tipo 	
			HttpSession session = request.getSession(true);
			session.setAttribute(INMOCTES.userName,((LoginForm)form).getUserName());
			session.setAttribute(INMOCTES.tipoUsuario,((LoginForm)form).getTipoUsuario());			
			session.setAttribute(INMOCTES.idUsuario,((LoginForm)form).getIdUsuario());			
			//Actualizar la vista con el objetivo apropiado
			if (((LoginForm)form).getTipoUsuario().trim().equals(INMOCTES.rolCliente)) target = "exitoCliente"; 
			else if (((LoginForm)form).getTipoUsuario().trim().equals(INMOCTES.rolAdmin)) target = "exitoAdmin"; 
			else if (((LoginForm)form).getTipoUsuario().trim().equals(INMOCTES.rolGerente)) target = "exitoGerente"; 
			else if (((LoginForm)form).getTipoUsuario().trim().equals(INMOCTES.rolContable)) target = "exitoContable"; 
			else target = "exitoAgente"; 
			return (mapping.findForward(target));		
		}else
		{
			//actualizar la vista con el fallo
			return (mapping.findForward(target));		
		}

	}
}
