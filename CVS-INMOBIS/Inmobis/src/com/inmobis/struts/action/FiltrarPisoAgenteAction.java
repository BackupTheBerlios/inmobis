//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.0.0/xslt/JavaClass.xsl

package com.inmobis.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import java.util.Vector;
import com.inmobis.consultas.*;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.inmobis.struts.form.FiltrarPisoAgenteForm;

/** 
 * MyEclipse Struts
 * Creation date: 04-21-2006
 * 
 * XDoclet definition:
 * @struts.action path="/filtrarPisoAgente" name="filtrarPisoAgenteForm" input="filtrarPisoAgente.jsp" scope="request" validate="true"
 */

//ESTE ES PARA LOS AGENTES QUE BUSCAN PISOS
public class FiltrarPisoAgenteAction extends Action {

	// --------------------------------------------------------- Instance Variables
	private static final Logger log = Logger.getLogger(FiltrarPisoAgenteAction.class);
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
			log.info("FiltrarPisoAgente 1: Antes de entrar en la base de datos");
		}
		
		Consultar consultar=CreadorConsultar.CreaConsultar("inmueble");
		Vector listaInmuebles = consultar.listar(form);
	
		if (listaInmuebles.equals(null)){
			if (log.isInfoEnabled()){
				log.info("FiltrarPisoAgente 2: Ha habido un error en la b�squeda en la bbdd");
			}
			errors.add("listainmuebles", new ActionMessage("errors.listainmuebles.bbdd"));
			saveErrors(request,errors);
			return (mapping.findForward("error"));
		}
		else{
			if (log.isInfoEnabled()){
				log.info("FiltrarPisoAgente 3: Se ha realizado la busqueda con �xito");
			}
			return mapping.findForward("exito");
		}
		
		
	}

}

