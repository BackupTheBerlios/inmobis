package com.inmobis.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import java.util.Vector;

public class VerPisosAgenteForm extends ActionForm{
	//	 --------------------------------------------------------- Instance Variables
		private Vector ListaInmuebles = new Vector();
	// --------------------------------------------------------- Methods

	/*public Vector getListaInmuebles() {
			return ListaInmuebles;
		}

	public void setListaInmuebles(Vector listaInmuebles) {
			ListaInmuebles = listaInmuebles;
		}*/

	/** 
	 * Method validate
	 * @param mapping
	 * @param request
	 * @return ActionErrors
	 */
	public ActionErrors validate(
		ActionMapping mapping,
		HttpServletRequest request) {
		return null;
	}

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {

	}

	public Vector getListaInmuebles() {
		return ListaInmuebles;
	}

	public void setListaInmuebles(Vector listaInmuebles) {
		ListaInmuebles = listaInmuebles;
	}

}
