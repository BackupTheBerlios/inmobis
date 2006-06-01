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

import com.inmobis.INMOCTES;
import com.inmobis.bajas.CreadorEliminar;
import com.inmobis.bajas.Eliminar;
import com.inmobis.consultas.CreadorConsultar;
import com.inmobis.consultas.Consultar;
import com.inmobis.struts.form.BorraEmpleadoPrevForm;
import com.inmobis.struts.form.EditaEmpleadoForm;

/** 
 * MyEclipse Struts
 * Creation date: 04-19-2006
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */
public class BorraEmpleadoPrevAction extends Action {

	// --------------------------------------------------------- Instance Variables
	private static final Logger log = Logger.getLogger(BorraEmpleadoPrevAction.class);
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
		EditaEmpleadoForm aux = new EditaEmpleadoForm();
		String tipoUsuario="";
		
		
		if (log.isInfoEnabled()){
			log.info("borraEmpleadoPrevAction 0:id: "+((BorraEmpleadoPrevForm)form).getIdEmpleado());
		}
		Consultar datos = CreadorConsultar.CreaConsultar("empleado");
		tipoUsuario=datos.dameTipoUsuario(((BorraEmpleadoPrevForm)form).getIdEmpleado());
		if (!(tipoUsuario.toLowerCase().equals("administrador")))
			tipoUsuario="empleado";
		if (log.isInfoEnabled()){
			log.info("borraEmpleadoPrevAction1: "+tipoUsuario);
		}
		Eliminar eliminarE = CreadorEliminar.CreaEliminar(tipoUsuario);
		
		
		if (log.isInfoEnabled()){
			log.info("borraEmpleadoPrevAction 1:Antes de entrar en la base de datos");
		}
		
		if  (!(eliminarE.validarRegistrado(form))){
			if (log.isInfoEnabled()){
				log.info("borraEmpleadoPrevAction 2:Después de validar y que no esté el empleado en la base de datos");
			}
			errors.add("idEmpleado", new ActionMessage("errors.borraEmpleado.invalid"));
			saveErrors(request,errors);
			return mapping.findForward("error");
		}
		else{
			if (log.isInfoEnabled()){
				log.info("borraEmpleadoPrevAction 2:El empleado está en la base de datos");
			}
			aux = (EditaEmpleadoForm)datos.dameDatos(((BorraEmpleadoPrevForm)form).getIdEmpleado());
			((BorraEmpleadoPrevForm)form).setApellido1(aux.getApellido1());
			((BorraEmpleadoPrevForm)form).setApellido2(aux.getApellido2());	
			((BorraEmpleadoPrevForm)form).setNombre(aux.getNombre());
			session.setAttribute("empleado",form);
			return mapping.findForward("exito");
		}		
	}
}

