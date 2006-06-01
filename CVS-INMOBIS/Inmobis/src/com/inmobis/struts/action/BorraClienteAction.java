//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.0.0/xslt/JavaClass.xsl

package com.inmobis.struts.action;

import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.inmobis.struts.form.BorraClienteForm;
import com.inmobis.bajas.*;
import org.apache.log4j.Logger;


/** 
 * MyEclipse Struts
 * Creation date: 03-29-2006
 * 
 * XDoclet definition:
 * @struts.action path="/borraCliente" name="borraClienteForm" input="/form/borraCliente.jsp" scope="request" validate="true"
 */
public class BorraClienteAction extends Action {

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
		HttpServletResponse response) throws Exception{
		
		ActionMessages errors= new ActionMessages();
		//Si el cliente que se quiere borrar no está registrado no se puede borrar
		
		Eliminar eliminarC = CreadorEliminar.CreaEliminar("cliente");
		
		if (log.isInfoEnabled()){
			log.info("BorraClienteAction1: Antes de la BDD tengo idCliente: "+ ((BorraClienteForm)form).getIdCliente());
		}
		
		if (!eliminarC.eliminarDesdeED(form)){
			if (log.isInfoEnabled()){
				log.info("borraClienteAction3: Se ha intentado eliminar pero algo ha fallado");
			}
			errors.add("verPisosAgente", new ActionMessage ("errors.AlborrarCliente.invalid"));
			saveErrors(request,errors);
			return (mapping.findForward("error"));
		}
		else{
			if (log.isInfoEnabled()){
				log.info("borraClienteAction4: Se ha eliminado con éxito");
			}
			saveErrors(request,errors);
			return (mapping.findForward("exito"));
		}		
	}	
}


