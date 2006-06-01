//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.1/xslt/JavaClass.xsl

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

import com.inmobis.altas.CreadorIntroducir;
import com.inmobis.altas.Introducir;
import com.inmobis.struts.form.VenderPisoForm;

import com.inmobis.bbdd.empleado.ContableBD;

import java.util.Vector;

import com.inmobis.bbdd.inmueble.VentasBean;


import com.inmobis.INMOCTES;

/** 
 * MyEclipse Struts
 * Creation date: 05-31-2006
 * 
 * XDoclet definition:
 * @struts.action path="/venderPiso" name="venderPisoForm" input="/form/venderPiso.jsp" scope="request" validate="true"
 */
public class VenderPisoPrevAction extends Action {

	// --------------------------------------------------------- Instance Variables
	private static final Logger log = Logger.getLogger(VenderPisoPrevAction.class);
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
		
		String target = null;
		
		HttpSession session = request.getSession(true);
		
		//((VenderPisoForm)form).setIdInmueble(session.getAttribute(INMOCTES.idUsuario).toString());
		
		VentasBean i = new VentasBean();
		i.setIdInmueble(((VenderPisoForm)form).getIdInmueble());
		ContableBD cont = new ContableBD();
		Vector listaInmuebles = cont.BusquedaDetallada(i);
		
		if (log.isInfoEnabled()){
			log.info("VerPisosVendidosAction 1: Antes de entrar en la base de datos");
		}		
		
		
		
		//necesito tener una función que me liste a todos los inmuebles vendidos. Ahora lo aviso.
		
		if ((listaInmuebles.size()==0)||(listaInmuebles.size()>1)){
			if (log.isInfoEnabled()){
				log.info("VerPisosVendidosAction2: Ha habido un error en la búsqueda en la bbdd, el numero de elementos es distinto de uno.");
			}
			errors.add("menuContable", new ActionMessage("errors.listainmuebles.bbdd"));
			saveErrors(request,errors);
			target = "error";			
		}
		else{
			if (listaInmuebles.size()==1){
			if (log.isInfoEnabled()){
				log.info("VerPisosVendidosAction 3: Se ha realizado el listado con éxito");
			}
			session.setAttribute("listaInmuebles",listaInmuebles);
			target = "exito";			
			}
		}
		return (mapping.findForward(target));
	}

}

