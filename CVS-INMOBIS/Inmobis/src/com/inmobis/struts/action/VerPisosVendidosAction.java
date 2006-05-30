//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.0.0/xslt/JavaClass.xsl

package com.inmobis.struts.action;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.inmobis.consultas.Consultar;
import com.inmobis.consultas.CreadorConsultar;
import com.inmobis.struts.form.VerPisosVendidosForm;

import org.apache.log4j.Logger;

/** 
 * MyEclipse Struts
 * Creation date: 05-30-2006
 * 
 * XDoclet definition:
 * @struts.action path="/verPisosVendidos" name="verPisosVendidosForm" input="/MenuContable.jsp" scope="request" validate="true"
 */
public class VerPisosVendidosAction extends Action {

	// --------------------------------------------------------- Instance Variables
	private static final Logger log = Logger.getLogger(VerPisosAction.class);
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
		HttpSession session = request.getSession(true);
		
		if (log.isInfoEnabled()){
			log.info("VerPisosVendidosAction 1: Antes de entrar en la base de datos");
		}
		
		Consultar consultar=CreadorConsultar.CreaConsultar("inmueble");
		Vector listaInmueblesVendidos = consultar.listar(form); 
		//necesito tener una función que me liste a todos los inmuebles vendidos. Ahora lo aviso.
		
		if (listaInmueblesVendidos.size()==0){
			if (log.isInfoEnabled()){
				log.info("VerPisosVendidosAction2: Ha habido un error en la búsqueda en la bbdd");
			}
			errors.add("listainmueblesvendidos", new ActionMessage("errors.listainmueblesvendidos.bbdd"));
			saveErrors(request,errors);
			return (mapping.findForward("error"));
		}
		else{
			if (log.isInfoEnabled()){
				log.info("VerPisosVendidosAction 3: Se ha realizado el listado con éxito");
			}
			session.setAttribute("listaInmuebles",listaInmueblesVendidos);
			return (mapping.findForward("exito"));
		}
		
		
	}

}

