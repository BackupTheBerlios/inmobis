//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.0.0/xslt/JavaClass.xsl

package com.inmobis.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionMessage;
import com.inmobis.consultas.CreadorConsultar;
import com.inmobis.consultas.Consultar;
import java.util.Vector;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.inmobis.struts.form.VerAgentesPrevForm;

/** 
 * MyEclipse Struts
 * Creation date: 04-20-2006
 * 
 * XDoclet definition:
 * @struts.action path="/verAgentesPrev" name="verAgentesPrevForm" input="/MenuGerente.jsp" scope="request" validate="true"
 */
public class VerAgentesPrevAction extends Action {

	// --------------------------------------------------------- Instance Variables
	private static final Logger log = Logger.getLogger(VerAgentesPrevAction.class);
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
			log.info("VerAgentesPrev 1: Antes de entrar en la base de datos");
		}		
		Consultar consultar=CreadorConsultar.CreaConsultar("agente");
		Vector listaEmpleados = consultar.listar(form);
		
		if (listaEmpleados.size()==0){
			if (log.isInfoEnabled()){
				log.info("VerAgentesPrev 2: Ha habido un error en la búsqueda en la bbdd");
			}
			errors.add("VerEmpleados", new ActionMessage("errors.listaempleados.bbdd"));
			saveErrors(request,errors);
			return (mapping.findForward("error"));
		}
		else{
			if (log.isInfoEnabled()){
				log.info("VerAgentesPrev 3: Se ha realizado el listado con éxito");
			}
			session.setAttribute("listaEmpleados",listaEmpleados);
			return mapping.findForward("exito");
		}
	}

}

