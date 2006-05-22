//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.0.0/xslt/JavaClass.xsl

package com.inmobis.struts.action;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.inmobis.INMOCTES;
import com.inmobis.bbdd.inmueble.InmuebleBean;
import com.inmobis.consultas.Consultar;
import com.inmobis.consultas.CreadorConsultar;
import com.inmobis.struts.form.LoginForm;
import com.inmobis.struts.form.MensajeForm;

/** 
 * MyEclipse Struts
 * Creation date: 05-05-2006
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class ListaMensajesPrevAction extends Action {

	// --------------------------------------------------------- Instance Variables
	private static final Logger log = Logger.getLogger(VerPisosAgenteAction.class);

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

		ActionMessages errors= new ActionMessages();

		form = new MensajeForm(); //Me da igual lo que me pasen, lo creo
		HttpSession session = request.getSession(true);
		((MensajeForm) form).setOrigen((String)session.getAttribute(INMOCTES.userName));

		//Pongo en el log el origen para listar.
		if (log.isInfoEnabled()){
			log.info("ListaMensajesPrevAction: Antes de entrar en la base de datos Origen = "+
					((MensajeForm) form).getOrigen());
		}

		Consultar consultar=CreadorConsultar.CreaConsultar("mensaje");
		Vector listaMensajes = consultar.listar(form);

		if (listaMensajes.equals(null)){
			if (log.isInfoEnabled()){
				log.info("ListaMensajesPrevAction 2: Error en bbdd");
			}
			errors.add("listaMensajes", new ActionMessage("errors.listamensajes.bbdd"));
			saveErrors(request,errors);
			return (mapping.findForward("error"));
		}
		else{
			if (log.isInfoEnabled()){
				log.info("ListaMensajesPrevAction 3: Se han recuperado "+ listaMensajes.size()+" mensajes");
			}
			session.setAttribute("listaMensajes",listaMensajes);
			return (mapping.findForward("exito"));
		}
	}
}

