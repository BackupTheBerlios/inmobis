//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.0.0/xslt/JavaClass.xsl

package com.inmobis.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.inmobis.struts.form.VerPisosAgenteForm;
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

/** 
 * MyEclipse Struts
 * Creation date: 04-19-2006
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class VerPisosAction extends Action {

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
			log.info("VerPisosAction 1: Antes de entrar en la base de datos");
		}
		
		Consultar consultar=CreadorConsultar.CreaConsultar("inmueble");
		Vector listaInmuebles = consultar.listar(form);
		
		if (listaInmuebles.size()==0){
			if (log.isInfoEnabled()){
				log.info("VerPisosAction2: Ha habido un error en la búsqueda en la bbdd");
			}
			errors.add("verPisos", new ActionMessage("errors.listainmuebles.bbdd"));
			saveErrors(request,errors);
			return (mapping.findForward("error"));
		}
		else{
			if (log.isInfoEnabled()){
				log.info("VerPisosAction 3: Se ha realizado el listado con éxito");
			}
			session.setAttribute("listaInmuebles",listaInmuebles);
			return (mapping.findForward("exito"));
		}
	}

}

