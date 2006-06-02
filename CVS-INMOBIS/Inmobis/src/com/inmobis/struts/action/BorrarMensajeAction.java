//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.0.0/xslt/JavaClass.xsl

package com.inmobis.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.inmobis.bajas.CreadorEliminar;
import com.inmobis.bajas.Eliminar;
import com.inmobis.struts.form.MensajeForm;

/** 
 * MyEclipse Struts
 * Creation date: 05-05-2006
 * 
 * XDoclet definition:
 * @struts.action path="/borrarMensaje" name="BorrarMensajeForm" scope="request" validate="true"
 */
public class BorrarMensajeAction extends Action {

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
		MensajeForm BorrarMensajeForm = (MensajeForm) form;
		ActionMessages errors= new ActionMessages();
		
		Eliminar eliminarM = CreadorEliminar.CreaEliminar("mensaje");
		
		if (log.isInfoEnabled()){
			log.info("BorrarMensajeAction1: Antes de la BDD tengo idMensaje: "+BorrarMensajeForm.getIdMensaje());
		}
		if (!eliminarM.eliminarDesdeED(BorrarMensajeForm)){
			if (log.isInfoEnabled()){
				log.info("borrarMesajeAction2: Se ha intentado eliminar pero algo ha fallado");
			}
			errors.add("ListaMensaje",new ActionMessage("errors.mensaje.borrar"));
			saveErrors(request,errors);
			return (mapping.findForward("error"));	
		}	
		else{
			if (log.isInfoEnabled()){
				log.info("borrarMensajeAction4:Se ha eliminado con éxito");
			}
			errors.add("ListaMensaje",new ActionMessage("exito.mensaje.borrar"));
			saveErrors(request,errors);
			return (mapping.findForward("exito"));
		}	
	}
}

