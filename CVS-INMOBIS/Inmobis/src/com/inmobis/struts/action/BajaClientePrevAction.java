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
import com.inmobis.consultas.Consultar;
import com.inmobis.consultas.CreadorConsultar;
import com.inmobis.struts.form.BorraClienteForm;
import com.inmobis.struts.form.BorraPisoPrevForm;
import com.inmobis.struts.form.EditaClienteForm;
import org.apache.log4j.Logger;

/** 
 * MyEclipse Struts
 * Creation date: 05-31-2006
 * 
 * XDoclet definition:
 * @struts.action path="/BajaClientePrev" name="borraClienteForm" input="/VerClientes.jsp" scope="request" validate="true"
 * @struts.action-forward name="exito" path="/editaCliente.jsp"
 * @struts.action-forward name="error" path="/VerClientes.jsp"
 */
public class BajaClientePrevAction extends Action {

	// --------------------------------------------------------- Instance Variables
	private static final Logger log = Logger.getLogger(BajaClientePrevAction.class);
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
		EditaClienteForm aux = new EditaClienteForm();
				
		//Si el inmueble que se quiere borrar no está registrado no se puede borrar
		Eliminar eliminarE = CreadorEliminar.CreaEliminar("cliente");
		Consultar datos = CreadorConsultar.CreaConsultar("cliente");
		
		if (log.isInfoEnabled()){
			log.info("bajaClientePrevAction 1:Antes de entrar en la base de datos");
		}
		
		if  (!(eliminarE.validarRegistrado(form))){
			if (log.isInfoEnabled()){
				 log.info("bajaClientePrevAction 2:Después de validar y que no esté el cliente en la base de datos");
			}
			errors.add("idCliente", new ActionMessage("borraCliente.error"));
			saveErrors(request,errors);
			return mapping.findForward("error");
		}
		else{
			if (log.isInfoEnabled()){
				log.info("borraPisoPrevAction 3:El cliente está en la base de datos");
			}
			aux = (EditaClienteForm)datos.dameDatos(((BorraClienteForm)form).getIdCliente());
			((BorraClienteForm)form).setApellido1(aux.getApellido1());
			((BorraClienteForm)form).setApellido2(aux.getApellido2());
			((BorraClienteForm)form).setDniCliente(aux.getDni());
			((BorraClienteForm)form).setFechaNacimiento(aux.getDiaNacimiento()+"/"+aux.getMesNacimiento()+"/"+aux.getAnioNacimiento());
			((BorraClienteForm)form).setNombreCliente(aux.getNombre());
			session.setAttribute("clientes",form);
			return mapping.findForward("exito");
		}			
	}

}

