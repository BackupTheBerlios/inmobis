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

import com.inmobis.consultas.Consultar;
import com.inmobis.consultas.CreadorConsultar;
import com.inmobis.struts.form.VerPisoDetalleForm;

/** 
 * MyEclipse Struts
 * Creation date: 05-30-2006
 * 
 * XDoclet definition:
 * @struts.action path="/verDetallePiso" name="filtrarPisoAgenteForm" input="/VerPisos.jsp" scope="request" validate="true"
 */
public class VerDetallePisoAction extends Action {

	// --------------------------------------------------------- Instance Variables
	private static final Logger i_log = Logger.getLogger(VerDetallePisoAction.class);
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
		VerPisoDetalleForm pisoDetalleForm = (VerPisoDetalleForm) form;
		//Coger los datos de la lista que le llega al form, obtener los
		//datos que faltan de la BBDD y pasarselos al jsp de editaPiso
		if (i_log.isInfoEnabled()){
			i_log.info("VerDetallePisoAction: Voy a coger los datos del piso: "+pisoDetalleForm.getTipo()+", zona: "+pisoDetalleForm.getZona());
		}
				
		Consultar consult=CreadorConsultar.CreaConsultar("inmueble");
		VerPisoDetalleForm datosPiso=(VerPisoDetalleForm)consult.dameDatos(pisoDetalleForm.getIdInmueble());
		
		if (i_log.isInfoEnabled()){
			i_log.info("VerDetallePisoAction: Select con exito.");
		}
		//Poner los datos en una variable de sesion
		HttpSession session = request.getSession(true);
		session.setAttribute("datosPiso",datosPiso);
		return mapping.findForward("exito");
	}

}

