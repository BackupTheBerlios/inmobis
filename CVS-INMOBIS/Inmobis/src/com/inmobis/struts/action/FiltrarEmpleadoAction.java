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

import com.inmobis.consultas.Consultar;
import com.inmobis.consultas.CreadorConsultar;

/** 
 * MyEclipse Struts
 * Creation date: 04-19-2006
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class FiltrarEmpleadoAction extends Action {

	// --------------------------------------------------------- Instance Variables
	private static final Logger log = Logger.getLogger(FiltrarEmpleadoAction.class);
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
		
		if (log.isInfoEnabled()){
			log.info("FiltrarEmpleado1: Antes de entrar en la base de datos");
		}
		
		HttpSession session = request.getSession(true);
		Consultar consultar=CreadorConsultar.CreaConsultar("empleado");
		Vector listaEmpleados = consultar.filtrarEmpleados(form);
		
		if (listaEmpleados.size()==0){
			if (log.isInfoEnabled()){
				log.info("FiltrarEmpleado2: Ha habido un error en la búsqueda en la bbdd");
			}
			errors.add("FiltrarEmpleado", new ActionMessage("errors.listaempleados.bbdd"));
			saveErrors(request,errors);
			return (mapping.findForward("error"));
		}
		else{
			if (log.isInfoEnabled()){
				log.info("FiltrarEmpleado3: Se ha realizado la busqueda con éxito");
			}
			session.setAttribute("listaEmpleados",listaEmpleados);
			return mapping.findForward("exito");
		}
	}

}

