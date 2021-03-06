//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.0.0/xslt/JavaClass.xsl

package com.inmobis.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionMessage;
import java.util.Vector;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.inmobis.bbdd.cliente.ClienteBean;
import com.inmobis.INMOCTES;
import com.inmobis.consultas.CreadorConsultar;
import com.inmobis.consultas.Consultar;
import com.inmobis.struts.form.VerClientesAgentePrevForm;

/** 
 * MyEclipse Struts
 * Creation date: 04-20-2006
 * 
 * XDoclet definition:
 * @struts.action path="/verClientesAgentePrev" name="verClientesAgentePrevForm" input="/MenuAgente.jsp" scope="request" validate="true"
 */
public class VerClientesAgentePrevAction extends Action {

	// --------------------------------------------------------- Instance Variables
	private static final Logger log = Logger.getLogger(VerClientesAgentePrevAction.class);
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
			log.info("VerClientesAgentePrevAction 1: Antes de entrar en la base de datos");
		}
		
		HttpSession session = request.getSession(true);
		
		String agente = (session.getAttribute(INMOCTES.idUsuario)).toString();
		((VerClientesAgentePrevForm)form).setIdAgente(agente);
		
		Consultar consultar=CreadorConsultar.CreaConsultar("cliente");	
		
		Vector listaClientesAgente = consultar.listarClientesAgente(form);		
		
		if (listaClientesAgente.size()==0){
			if (log.isInfoEnabled()){
				log.info("VerClientesAgentePrevAction2: Ha habido un error en la b�squeda en la bbdd");
			}
			errors.add("menuAgente", new ActionMessage("errors.listaclientes.bbdd"));
			saveErrors(request,errors);
			return (mapping.findForward("error"));
		}
		else{			
			
			if (log.isInfoEnabled()){
				log.info("VerClientesAgentePrevAction 3: Se ha realizado el listado con �xito");
			}
			session.setAttribute("listaClientes",listaClientesAgente);
			return mapping.findForward("exito");
		}
	}

}

