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

import com.inmobis.consultas.Consultar;
import com.inmobis.consultas.CreadorConsultar;
import com.inmobis.modificaciones.ModificarRelClienteAgente;
import com.inmobis.struts.form.BorraPisoForm;
import com.inmobis.struts.form.EditaClienteForm;
import com.inmobis.struts.form.TraspasarClientesPrevForm;

public class TraspasarClientesPrevAction extends Action {

	private static final Logger i_log = Logger.getLogger(TraspasarClientesPrevAction.class);
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response) {

		if (i_log.isInfoEnabled()){
			i_log.info("idCliente a traspasar: "+((TraspasarClientesPrevForm)form).getIdCliente());
		}
		Consultar consultar=CreadorConsultar.CreaConsultar("agente");
		Vector listaAgentes = consultar.listar(form);
		consultar=CreadorConsultar.CreaConsultar("cliente");
		EditaClienteForm datosCliente=(EditaClienteForm)consultar.dameDatos(((TraspasarClientesPrevForm)form).getIdCliente());
		
		HttpSession session = request.getSession(true);	
		session.setAttribute("listaEmpleados",listaAgentes);
		session.setAttribute("idCliente",((TraspasarClientesPrevForm)form).getIdCliente());
		session.setAttribute("clienteTraspasado", datosCliente.getNombreUsuario());
		return mapping.findForward("exito");
	}

}

