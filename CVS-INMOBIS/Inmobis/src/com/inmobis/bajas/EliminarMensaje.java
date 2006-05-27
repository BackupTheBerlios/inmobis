package com.inmobis.bajas;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;

import com.inmobis.struts.action.BorraClienteAction;

public class EliminarMensaje extends Eliminar{

	private static final Logger log = Logger.getLogger(BorraClienteAction.class);
	@Override
	public boolean validarRegistrado(ActionForm id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminarDesdeED(ActionForm id) {
		// TODO Auto-generated method stub
		return false;
	}

}
