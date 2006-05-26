//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.0.0/xslt/JavaClass.xsl

package com.inmobis.struts.action;

import java.util.Hashtable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.inmobis.struts.form.BorraPisoForm;
import com.inmobis.bajas.*;
import org.apache.log4j.Logger;
/** 
 * MyEclipse Struts
 * Creation date: 03-29-2006
 * 
 * XDoclet definition:
 * @struts.action path="/borraPiso" name="borraPisoForm" input="/form/borraPiso.jsp" scope="request" validate="true"
 */
public class BorraPisoAction extends Action {

	// --------------------------------------------------------- Instance Variables
		private static final Logger log = Logger.getLogger(BorraPisoAction.class);
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
		((BorraPisoForm)form).setIdInmueble((String)session.getAttribute("idInmueble"));
		
		Eliminar eliminarI = CreadorEliminar.CreaEliminar("inmueble");
		
		if (log.isInfoEnabled()){
			log.info("BorraPisoAction1: Antes de la BDD tengo idEmpleado: "+((BorraPisoForm)form).getIdInmueble());
		}
		if (!eliminarI.eliminarDesdeED(form)){
			if (log.isInfoEnabled()){
				log.info("borraPisoAction3: Se ha intentado eliminar pero algo ha fallado");
			}
			errors.add("idInmueble",new ActionMessage("errors.AlborrarPiso.invalid"));
			saveErrors(request,errors);
			return (mapping.findForward("error"));	
		}	
		else{
			if (log.isInfoEnabled()){
				log.info("borraPisoAction4:Se ha eliminado con éxito");
			}
			saveErrors(request,errors);
			return (mapping.findForward("exito"));
		}	
	}
}

