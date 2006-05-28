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
import com.inmobis.struts.form.EditaPisoForm;
import com.inmobis.struts.form.EditaPisoPrevForm;


public class EditaPisoPrevAction extends Action {

	private static final Logger i_log = Logger.getLogger(EditaPisoPrevAction.class);
	
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response) {
		//Coger los datos de la lista que le llega al form, obtener los
		//datos que faltan de la BBDD y pasarselos al jsp de editaPiso
		if (i_log.isInfoEnabled()){
			i_log.info("Voy a coger los datos del piso: "+((EditaPisoPrevForm)form).getTipo()+", zona: "+((EditaPisoPrevForm)form).getZona());
		}
				
		Consultar consult=CreadorConsultar.CreaConsultar("inmueble");
		EditaPisoForm datosPiso=(EditaPisoForm)consult.dameDatos(((EditaPisoPrevForm)form).getIdInmueble());
		
		if (i_log.isInfoEnabled()){
			i_log.info("Direccion "+datosPiso.getCalle());
		}
		//Poner los datos en una variable de sesion
		HttpSession session = request.getSession(true);
		session.setAttribute("datosPiso",datosPiso);
		return mapping.findForward("exito");
	}

}

