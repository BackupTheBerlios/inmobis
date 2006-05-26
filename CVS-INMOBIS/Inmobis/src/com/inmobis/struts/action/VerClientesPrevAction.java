//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.0.0/xslt/JavaClass.xsl

package com.inmobis.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import java.util.Vector;
import com.inmobis.consultas.Consultar;
import com.inmobis.consultas.CreadorConsultar;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.inmobis.bbdd.cliente.*;
import com.inmobis.INMOCTES;

import com.inmobis.struts.form.VerClientesPrevForm;

/** 
 * MyEclipse Struts
 * Creation date: 04-20-2006
 * 
 * XDoclet definition:
 * @struts.action path="/verClientesPrev" name="verClientesPrevForm" input="/MenuGerente.jsp" scope="request" validate="true"
 */
public class VerClientesPrevAction extends Action {

	// --------------------------------------------------------- Instance Variables
	private static final Logger log = Logger.getLogger(VerClientesPrevAction.class);
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
			log.info("VerClientesPrevAction 1: Antes de entrar en la base de datos");
		}
		
		HttpSession session = request.getSession(true);
		
		Consultar consultar=CreadorConsultar.CreaConsultar("cliente");
		//ActionForm formClientesGerente = new VerClientesPrevForm();
		
		//formClientesGerente.reset(mapping,request);
		
		//String uG = session.getAttribute(INMOCTES.tipoUsuario).toString();
		
		
		Vector listaClientes = new Vector();//null;
		ActionForm form2 = null;
		//if (uG.equals("gerente"))
		//Vector listaClientes = consultar.listar(formClientesGerente);
		listaClientes = consultar.listar(form2);
		//else listaClientes = null;
		 
		
		
		session.setAttribute("listaClientes",listaClientes);
		 
				
		if (listaClientes.size()==0){
			if (log.isInfoEnabled()){
				log.info("VerClientesPrevAction2: Ha habido un error en la búsqueda en la bbdd");
			}
			errors.add("listaclientes", new ActionMessage("errors.listacliente.bbdd"));
			saveErrors(request,errors);
			return (mapping.findForward("error"));
		}
		else{
			if (log.isInfoEnabled()){
				log.info("VerClientesPrevAction 3: Se ha realizado el listado con éxito");
			}
			return mapping.findForward("exito");
		}
	}
    
   
}

