//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.0.0/xslt/JavaClass.xsl

package com.inmobis.struts.action;


import com.inmobis.INMOCTES;
import com.inmobis.bajas.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.log4j.Logger;

/** 
 * MyEclipse Struts
 * Creation date: 03-29-2006
 * 
 * XDoclet definition:
 * @struts.action path="/borraEmpleado" name="borraEmpleadoForm" input="/form/borraEmpleado.jsp" scope="request" validate="true"
 */
public class BorraEmpleadoAction extends Action {

	// --------------------------------------------------------- Instance Variables
	private static final Logger log = Logger.getLogger(BorraEmpleadoAction.class);
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
		String tipoUsuario;
		
//		Si el empleado que se quiere borrar no est� registrado no se puede borrar
		if (!(((String)session.getAttribute(INMOCTES.tipoUsuario)).equals("administrador"))){
			tipoUsuario ="empleado";
		}
		else{
			tipoUsuario = "administrador";
		}
		Eliminar eliminarE = CreadorEliminar.CreaEliminar(tipoUsuario);
		
		if (log.isInfoEnabled()){
			log.info("borraEmpleadoAction1:Antes de la BDD ");
		}
		if (!eliminarE.eliminarDesdeED(form)){
			if (log.isInfoEnabled()){
				log.info("borraEmpleadoAction3: Se ha intentado eliminar pero algo ha fallado");
			}
			errors.add("idEmpleado", new ActionMessage ("errors.AlborrarEmpleado.invalid"));
			saveErrors(request,errors);
			return (mapping.findForward("borraEmpleado"));
		}
		else{
			if (log.isInfoEnabled()){
				log.info("borraEmpleadoAction4:Se ha eliminado con �xito");
			}
			return (mapping.findForward("exito"));
		}
	}	
}



