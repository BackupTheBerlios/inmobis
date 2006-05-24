//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.0.0/xslt/JavaClass.xsl

package com.inmobis.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import java.util.Vector;

import com.inmobis.bbdd.inmueble.InmuebleBean;
import com.inmobis.consultas.*;
import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.inmobis.struts.form.FiltrarPisoAgenteForm;

/** 
 * MyEclipse Struts
 * Creation date: 04-21-2006
 * 
 * XDoclet definition:
 * @struts.action path="/filtrarPisoAgente" name="filtrarPisoAgenteForm" input="filtrarPisoAgente.jsp" scope="request" validate="true"
 */

//ESTE ES PARA LOS AGENTES QUE BUSCAN PISOS
public class FiltrarPisoAgenteAction extends Action {

	// --------------------------------------------------------- Instance Variables
	private static final Logger log = Logger.getLogger(FiltrarPisoAgenteAction.class);
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
		
		
		if (log.isInfoEnabled()){
			//la jsp coge los valores min y max al reves!!!!!
			log.info("FiltrarPisoAgenteForm 1: " + ((FiltrarPisoAgenteForm)form).getMetrosMin());
			log.info("FiltrarPisoAgenteForm 1: " + ((FiltrarPisoAgenteForm)form).getMetrosMax());
			log.info("FiltrarPisoAgenteForm 2: " + ((FiltrarPisoAgenteForm)form).getNumHab());
			log.info("FiltrarPisoAgenteForm 3: " + ((FiltrarPisoAgenteForm)form).getPrecioMin());
			log.info("FiltrarPisoAgenteForm 1: " + ((FiltrarPisoAgenteForm)form).getPrecioMax());
			log.info("FiltrarPisoAgenteForm 4: " + ((FiltrarPisoAgenteForm)form).getRegimen());
			log.info("FiltrarPisoAgenteForm 5: " + ((FiltrarPisoAgenteForm)form).getTipo());
			log.info("FiltrarPisoAgenteForm 6: " + ((FiltrarPisoAgenteForm)form).getZona());
			log.info("FiltrarPisoAgenteForm 7: " + ((FiltrarPisoAgenteForm)form).getDatosDeInteres());
		}
		
		if (log.isInfoEnabled()){
			log.info("FiltrarPisoAgente 1: Antes de entrar en la base de datos");
		}
		
		//Consultar consultar=CreadorConsultar.CreaConsultar("inmuebleCondicion");
		ConsultarInmuebleCondicion consultar = new ConsultarInmuebleCondicion();
		Vector listaInmuebles = consultar.listar(form);
	
		if (listaInmuebles.equals(null)){
			if (log.isInfoEnabled()){
				log.info("FiltrarPisoAgenteAction 2: Ha habido un error en la búsqueda en la bbdd");
			}
			errors.add("listainmuebles", new ActionMessage("errors.listainmuebles.bbdd"));
			saveErrors(request,errors);
			return (mapping.findForward("error"));
		}
		else{
			if (listaInmuebles.size()==0){
				if (log.isInfoEnabled()){
					log.info("FiltrarPisoAgenteAction 3: no hay pisos con esas características");	
				}
				errors.add("listainmuebles", new ActionMessage("errors.listainmuebles.vacia"));
				saveErrors(request,errors);
				return (mapping.findForward("error"));
			}
			else{
				if (log.isInfoEnabled()){
					log.info("FiltrarPisoAgenteAction 4: Se ha realizado la busqueda con éxito");
					log.info("FiltrarPisoAgenteAction 5: " + listaInmuebles.size());
					int i=0;
					while (i<listaInmuebles.size()){
						log.info("Identificador: " + ((InmuebleBean)listaInmuebles.elementAt(i)).getIdInmueble());
						log.info("Zona: " + ((InmuebleBean)listaInmuebles.elementAt(i)).getZona());
						log.info("Metros: " + ((InmuebleBean)listaInmuebles.elementAt(i)).getMetros());
						log.info("Precio: " + ((InmuebleBean)listaInmuebles.elementAt(i)).getPrecio());
						log.info("Regimen: " + ((InmuebleBean)listaInmuebles.elementAt(i)).getRegimen());
						log.info("Datos Interes: " + ((InmuebleBean)listaInmuebles.elementAt(i)).getdatosDeInteres());
						i++;
					}
				}
				HttpSession session = request.getSession(true);
				session.setAttribute("listaInmuebles",listaInmuebles);
				return mapping.findForward("exito");
			}
		}	
	}
}

