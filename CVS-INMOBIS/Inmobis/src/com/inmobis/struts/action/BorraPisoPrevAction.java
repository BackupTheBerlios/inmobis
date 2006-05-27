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
import com.inmobis.consultas.*;
import com.inmobis.struts.form.BorraPisoPrevForm;
import com.inmobis.struts.form.EditaPisoForm;

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
		BorraPisoPrevForm b = new BorraPisoPrevForm();
		EditaPisoForm e = new EditaPisoForm();
		ActionForm aux;
				
		//Si el inmueble que se quiere borrar no está registrado no se puede borrar
		Eliminar eliminarE = CreadorEliminar.CreaEliminar("inmueble");
		Consultar datos = CreadorConsultar.CreaConsultar("inmueble");
		
		if (log.isInfoEnabled()){
			log.info("borraPisoPrevAction 1:Antes de entrar en la base de datos");
		}
		
		if  (!(eliminarE.validarRegistrado(form))){
			if (log.isInfoEnabled()){
				 log.info("borraPisoPrevAction 2:Después de validar y que no esté el empleado en la base de datos");
			}
			errors.add("idPiso", new ActionMessage("errors.borraPiso.invalid"));
			saveErrors(request,errors);
			return mapping.findForward("error");
		}
		else{
			if (log.isInfoEnabled()){
				log.info("borraPisoPrevAction 3:El inmueble está en la base de datos");
			}
			e.setIdInmueble(((BorraPisoPrevForm)form).getIdInmueble());
			aux = datos.dameDatos(e);
			b.setIdInmueble(((EditaPisoForm)aux).getIdInmueble());
			b.setMetros(((EditaPisoForm)aux).getMetros());
			b.setNumHab(((EditaPisoForm)aux).getNumHab());
			b.setPrecio(((EditaPisoForm)aux).getPrecio());
			b.setRegimen(((EditaPisoForm)aux).getRegimen());
			b.setTipo(((EditaPisoForm)aux).getTipo());
			b.setZona(((EditaPisoForm)aux).getZona());
			session.setAttribute("datos",b);
			return mapping.findForward("exito");
		}			
	}	
}

