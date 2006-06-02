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

import com.inmobis.bbdd.*;
import com.inmobis.bbdd.empleado.ContableBD;
import com.inmobis.bbdd.empleado.GestorContableBD;
import com.inmobis.bbdd.inmueble.GestorInmuebleBD;

import java.util.Vector;

import com.inmobis.bbdd.inmueble.InmuebleBean;


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
		
		if (log.isInfoEnabled()){
			log.info("VenderPisoPrevAction 1: entro en el execute.");
		}
		
		ActionMessages errors= new ActionMessages();
		
		String target = "error";
		
		HttpSession session = request.getSession(true);
		
		//((VenderPisoForm)form).setIdInmueble(session.getAttribute(INMOCTES.idUsuario).toString());
		
		InmuebleBean i = new InmuebleBean();
		if (log.isInfoEnabled()){
			log.info("VenderPisoPrevAction2: es el idInmueble: "+ ((VenderPisoForm)form).getIdInmueble());
		}
		i.setIdInmueble(((VenderPisoForm)form).getIdInmueble());		
		i.setDatosDeInteres(null);
		i.setMetros(null);
		i.setNumHab(null);
		i.setPrecio(null);
		i.setRegimen(null);
		i.setTipo(null);
		i.setZona(null);		
		GestorInmuebleBD gestorInmueble = (GestorInmuebleBD)CreadorGestores.crearGestor("inmueble",i);
		//ContableBD cont = new ContableBD();
		
		
		//VentasBean datosPiso2;
		InmuebleBean datosPiso2;
		
		if (log.isInfoEnabled()){
			log.info("VenderPisoPrevAction 1: Antes de entrar en la base de datos");
		}		
		
		Vector listaInmuebles = gestorInmueble.BusquedaDetallada();
		//Vector listaInmuebles = gestorContable.BusquedaDetallada(i);
		
		//if (log.isInfoEnabled()){
		//	log.info("VenderPisoPrevAction11: inmueble conseguido 1 "+((VentasBean)listaInmuebles.get(0)).getIdInmueble());
		//	log.info("VenderPisoPrevAction11: inmueble conseguido 1 "+((VentasBean)listaInmuebles.get(0)).getIdAgente());
		//}
		//if (log.isInfoEnabled()){
		//	log.info("VenderPisoPrevAction12: inmueble conseguido 2 "+((VentasBean)listaInmuebles.get(1)).getIdInmueble());
		//	log.info("VenderPisoPrevAction12: inmueble conseguido 2 "+((VentasBean)listaInmuebles.get(1)).getIdAgente());
		//}
		
		
		
		//if ((listaInmuebles.size()==0)||(listaInmuebles.size()>1)){
			//if (log.isInfoEnabled()){
			//	log.info("VenderPisoPrevAction2: Ha habido un error en la búsqueda en la bbdd, el numero de elementos es distinto de uno.");
			//}
			//errors.add("menuContable", new ActionMessage("errors.listainmuebles.bbdd"));
			//saveErrors(request,errors);
		//	target = "error";			
		//}
		//else{
			if (listaInmuebles.size()>0){
			if (log.isInfoEnabled()){
				log.info("VenderPisoPrevAction 3: Se ha realizado el listado con éxito");
			}
			if (log.isInfoEnabled()){
				int i2 = 0;
				while (i2<listaInmuebles.size()){
					log.info("VenderPisoPrevAction 3: "+((InmuebleBean)listaInmuebles.get(i2)).getIdInmueble());
					datosPiso2 = (InmuebleBean)listaInmuebles.get(i2);
					VenderPisoForm datosPiso = new VenderPisoForm();					
					datosPiso.setIdInmueble(((InmuebleBean)datosPiso2).getIdInmueble());					
					//datosPiso.setIdAgente(((InmuebleBean)datosPiso2).getIdAgente());
					session.setAttribute("datosPiso",datosPiso);
					i2=i2+1;
				}
				
			}
			//datosPiso2 = (VentasBean)listaInmuebles.get(0);
			//VenderPisoForm datosPiso = new VenderPisoForm();
			//datosPiso.setIdAgente(((VentasBean)datosPiso2).getIdAgente());
			//datosPiso.setIdInmueble(((VentasBean)datosPiso2).getIdInmueble());
			//datosPiso.setPrecioFinal(((VentasBean)datosPiso2).getPrecioFinal());
			//datosPiso.setPrecioInicial(((VentasBean)datosPiso2).getPrecioInicial());
			//datosPiso.setGanancia(((VentasBean)datosPiso2).getGanancia());
			//datosPiso.setFechVenta(((VentasBean)datosPiso2).getFechVenta());
			//session.setAttribute("datosPiso",datosPiso);
			target = "exito";			
			}
			else {
				if (log.isInfoEnabled()){
						log.info("VenderPisoPrevAction2: Ha habido un error en la búsqueda en la bbdd, el numero de elementos es distinto de uno.");
					}
			}
		//}			
		return (mapping.findForward(target));
	}

}

