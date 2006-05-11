package com.inmobis.bajas;


import org.apache.struts.action.ActionForm;


public abstract class Eliminar {
	public abstract boolean validarRegistrado(ActionForm id);
	public abstract boolean eliminarDesdeED(ActionForm id);
}
