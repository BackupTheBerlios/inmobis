//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.0.0/xslt/JavaClass.xsl

package com.inmobis.struts.action;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

//ESTE ES PARA LOS CLIENTES
public class FiltrarPisoAction extends Action {

	// --------------------------------------------------------- Instance Variables
	private static final Logger log = Logger.getLogger(FiltrarPisoAction.class);
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
			log.info("FiltrarPisoAction 1: Antes de entrar en la base de datos");
		}
		
		Consultar consultar=CreadorConsultar.CreaConsultar("inmueble");
		Vector listaInmuebles = consultar.listar(form);
	
		if (listaInmuebles.equals(null)){
			if (log.isInfoEnabled()){
				log.info("FiltrarPisoAction 2: Ha habido un error en la búsqueda en la bbdd");
			}
			errors.add("listainmuebles", new ActionMessage("errors.listainmuebles.bbdd"));
			saveErrors(request,errors);
			return (mapping.findForward("error"));
		}
		else{
			if (log.isInfoEnabled()){
				log.info("FiltrarPisoAction 3: Se ha realizado la busqueda con éxito");
			}
			return mapping.findForward("exito");
		}
	}

}

