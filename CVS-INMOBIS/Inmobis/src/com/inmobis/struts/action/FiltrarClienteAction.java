//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.0.0/xslt/JavaClass.xsl

package com.inmobis.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionMessage;
import org.apache.log4j.Logger;

import com.inmobis.consultas.CreadorConsultar;
import com.inmobis.consultas.Consultar;
import java.util.*;


/** 
 * MyEclipse Struts
 * Creation date: 04-20-2006
 * 
 * XDoclet definition:
 * @struts.action path="/filtrarCliente" name="filtrarClienteForm" input="/FiltrarCliente.jsp" scope="request" validate="true"
 */
public class FiltrarClienteAction extends Action {

	// --------------------------------------------------------- Instance Variables
	private static final Logger log = Logger.getLogger(BorraClienteAction.class);
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
			log.info("FiltrarCliente1: Antes de entrar en la base de datos");
		}
		
		HttpSession session = request.getSession(true);
		Consultar consultar=CreadorConsultar.CreaConsultar("cliente");
		Vector listaClientes = consultar.filtrarClientes(form);
		
		if (listaClientes.size()==0){
			if (log.isInfoEnabled()){
				log.info("FiltrarCliente 2: Ha habido un error en la búsqueda en la bbdd");
			}
			errors.add("listaclientes", new ActionMessage("errors.listacliente.bbdd"));
			saveErrors(request,errors);
			return (mapping.findForward("error"));
		}
		else{
			if (log.isInfoEnabled()){
				log.info("FiltrarCliente 3: Se ha realizado la busqueda con éxito");
			}
			session.setAttribute("listaClientes",listaClientes);
			return mapping.findForward("exito");
		}
	}
}

