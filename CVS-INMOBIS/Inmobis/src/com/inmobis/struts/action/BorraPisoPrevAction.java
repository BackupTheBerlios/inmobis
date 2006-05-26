//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.0.0/xslt/JavaClass.xsl

package com.inmobis.struts.action;

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

import com.inmobis.bajas.CreadorEliminar;
import com.inmobis.bajas.Eliminar;
import com.inmobis.struts.form.BorraPisoPrevForm;;

/** 
 * MyEclipse Struts
 * Creation date: 04-21-2006
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class BorraPisoPrevAction extends Action {

	// --------------------------------------------------------- Instance Variables
	private static final Logger log = Logger.getLogger(BorraPisoPrevAction.class);
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
		//cojo de la sesi�n el identificador del inmueble
		((BorraPisoPrevForm)form).setIdInmueble((String) session.getAttribute("idInmueble"));
				
		//Si el inmueble que se quiere borrar no est� registrado no se puede borrar
		Eliminar eliminarE = CreadorEliminar.CreaEliminar("inmueble");
		
		if (log.isInfoEnabled()){
			log.info("borraPisoPrevAction 1:Antes de entrar en la base de datos");
		}
		
		if  (!(eliminarE.validarRegistrado(form))){
			if (log.isInfoEnabled()){
				log.info("borraPisoPrevAction 2:Despu�s de validar y que no est� el empleado en la base de datos");
			}
			errors.add("idPiso", new ActionMessage("errors.borraPiso.invalid"));
			saveErrors(request,errors);
			return mapping.findForward("error");
		}
		else{
			if (log.isInfoEnabled()){
				log.info("borraPisoPrevAction 3:El inmueble est� en la base de datos");
			}
			return mapping.findForward("exito");
		}			
	}	
}

