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
import com.inmobis.struts.form.FiltrarPisoAgenteForm;

/** 
 * MyEclipse Struts
 * Creation date: 04-19-2006
 * 
 * XDoclet definition:
 * @struts.action validate="true"
 */

//ESTE ES PARA LOS CLIENTES
public class FiltrarPisoAction extends Action {

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
		
		
		if (log.isInfoEnabled()){
			log.info("FiltrarPisoAgenteForm 1: " + ((FiltrarPisoAgenteForm)form).getMetrosMin());
			log.info("FiltrarPisoAgenteForm 2: " + ((FiltrarPisoAgenteForm)form).getMetrosMax());
			log.info("FiltrarPisoAgenteForm 3: " + ((FiltrarPisoAgenteForm)form).getNumHab());
			log.info("FiltrarPisoAgenteForm 4: " + ((FiltrarPisoAgenteForm)form).getPrecioMin());
			log.info("FiltrarPisoAgenteForm 5: " + ((FiltrarPisoAgenteForm)form).getPrecioMax());
			log.info("FiltrarPisoAgenteForm 6: " + ((FiltrarPisoAgenteForm)form).getRegimen());
			log.info("FiltrarPisoAgenteForm 7: " + ((FiltrarPisoAgenteForm)form).getTipo());
			log.info("FiltrarPisoAgenteForm 8: " + ((FiltrarPisoAgenteForm)form).getZona());
			//log.info("FiltrarPisoAgenteForm 9: " + ((FiltrarPisoAgenteForm)form).getDatosDeInteres());
			log.info("FiltrarPisoAgente 1: Antes de entrar en la base de datos");
		}
		
		Consultar consultar=CreadorConsultar.CreaConsultar("inmuebleCondicion");
		Vector listaInmuebles = consultar.listar(form);
	
		if (listaInmuebles.equals(null)){
			if (log.isInfoEnabled()){
				log.info("FiltrarPisoAgenteAction 2: Ha habido un error en la b�squeda en la bbdd");
			}
			errors.add("filtrarPiso", new ActionMessage("errors.listainmuebles.bbdd"));
			saveErrors(request,errors);
			return (mapping.findForward("error"));
		}
		else{
			if (listaInmuebles.size()==0){
				if (log.isInfoEnabled()){
					log.info("FiltrarPisoAgenteAction 3: no hay pisos con esas caracter�sticas");	
				}
				errors.add("listainmuebles", new ActionMessage("errors.listainmuebles.vacia"));
				saveErrors(request,errors);
				return (mapping.findForward("error"));
			}
			else{
				if (log.isInfoEnabled()){
					log.info("FiltrarPisoAgenteAction 4: Se ha realizado la busqueda con �xito");
					log.info("FiltrarPisoAgenteAction 5: " + listaInmuebles.size());
					int i=0;
					while (i<listaInmuebles.size()){
						log.info("Zona: " + ((InmuebleBean)listaInmuebles.elementAt(i)).getZona());
						log.info("Metros: " + ((InmuebleBean)listaInmuebles.elementAt(i)).getMetros());
						log.info("Precio: " + ((InmuebleBean)listaInmuebles.elementAt(i)).getPrecio());
						log.info("Regimen: " + ((InmuebleBean)listaInmuebles.elementAt(i)).getRegimen());
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

