//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.0.0/xslt/JavaClass.xsl

package com.inmobis.struts.action;

import java.util.Vector;

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

import com.inmobis.bbdd.inmueble.InmuebleBean;
import com.inmobis.consultas.Consultar;
import com.inmobis.consultas.CreadorConsultar;
import com.inmobis.struts.form.VerPisosVendidosForm;
import com.inmobis.bbdd.inmueble.VentasBean;

/** 
 * MyEclipse Struts
 * Creation date: 05-30-2006
 * 
 * XDoclet definition:
 * @struts.action path="/filtrarPisosVendidos" name="verPisosVendidosForm" scope="request" validate="true"
 */
public class FiltrarPisosVendidosAction extends Action {

	// --------------------------------------------------------- Instance Variables
	private static final Logger log = Logger.getLogger(FiltrarPisoAction.class);
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
		
		Consultar consultar=CreadorConsultar.CreaConsultar("inmueble");
		Vector listaInmueblesVendidos = consultar.filtrarPisosVendidos(form);
	
		if (listaInmueblesVendidos.size()==0){
			if (log.isInfoEnabled()){
				log.info("FiltrarPisoAgenteAction 2: Ha habido un error en la búsqueda en la bbdd");
			}
			errors.add("listainmuebles", new ActionMessage("errors.listainmuebles.bbdd"));
			saveErrors(request,errors);
			return (mapping.findForward("error"));
		}
		else{
			if (listaInmueblesVendidos.size()==0){
				if (log.isInfoEnabled()){
					log.info("FiltrarPisoAgenteAction 3: no hay pisos con esas características");	
				}
				errors.add("listainmueblesVendidos", new ActionMessage("errors.listainmuebles.vacia"));
				saveErrors(request,errors);
				return (mapping.findForward("error"));
			}
			else{
				if (log.isInfoEnabled()){
					log.info("FiltrarPisoAgenteAction 4: Se ha realizado la busqueda con éxito");
					log.info("FiltrarPisoAgenteAction 5: " + listaInmueblesVendidos.size());
					int i=0;
					while (i<listaInmueblesVendidos.size()){
						log.info("Desde: " + ((VentasBean)listaInmueblesVendidos.elementAt(i)).getFechaDesde());
						log.info("Hasta: " + ((VentasBean)listaInmueblesVendidos.elementAt(i)).getFechaHasta());
						log.info("Venta: " + ((VentasBean)listaInmueblesVendidos.elementAt(i)).getFechVenta());
						log.info("Ganancia: " + ((VentasBean)listaInmueblesVendidos.elementAt(i)).getGanancia());
						log.info("Id Agente: " + ((VentasBean)listaInmueblesVendidos.elementAt(i)).getIdAgente());
						log.info("Id Inmueble: " + ((VentasBean)listaInmueblesVendidos.elementAt(i)).getIdInmueble());
						log.info("Precio Final: " + ((VentasBean)listaInmueblesVendidos.elementAt(i)).getPrecioFinal());
						log.info("Precio Inicial: " + ((VentasBean)listaInmueblesVendidos.elementAt(i)).getPrecioInicial());
						i++;
					}
				}
				HttpSession session = request.getSession(true);
				session.setAttribute("listaInmueblesVendidos",listaInmueblesVendidos);
				return mapping.findForward("exito");
			}
		}
	}
}