package com.inmobis.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.inmobis.bbdd.cliente.ClienteBean;
import com.inmobis.bbdd.direccion.InfoDirBean;
import com.inmobis.bbdd.email.InfoMailBean;
import com.inmobis.bbdd.inmueble.InmuebleBean;
import com.inmobis.bbdd.login.UsuarioLoginBean;
import com.inmobis.bbdd.telefono.InfoTelfBean;
import com.inmobis.consultas.Consultar;
import com.inmobis.consultas.CreadorConsultar;
import com.inmobis.struts.form.EditaClientePrevForm;
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
		InmuebleBean piso=new InmuebleBean();
		piso.setDatosDeInteres(((EditaPisoPrevForm)form).getDatosDeInteres());
		piso.setIdInmueble(((EditaPisoPrevForm)form).getIdInmueble());
		piso.setMetros(((EditaPisoPrevForm)form).getMetros());
		piso.setNumHab(((EditaPisoPrevForm)form).getNumHab());
		piso.setPrecio(((EditaPisoPrevForm)form).getPrecio());
		piso.setRegimen(((EditaPisoPrevForm)form).getRegimen());
		piso.setTipo(((EditaPisoPrevForm)form).getTipo());
		piso.setZona(((EditaPisoPrevForm)form).getZona());
		
		Consultar consult=CreadorConsultar.CreaConsultar("inmueble");
		InfoDirBean dir=consult.getDir(form);
		
		if (i_log.isInfoEnabled()){
			i_log.info("Direccion "+dir.getCalle());
		}
		//Poner los datos en una variable de sesion
		HttpSession session = request.getSession(true);
		session.setAttribute("piso",piso);
		session.setAttribute("direccion",dir);
		return mapping.findForward("exito");
	}

}

