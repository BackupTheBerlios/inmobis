//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.0.0/xslt/JavaClass.xsl

package com.inmobis.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/** 
 * MyEclipse Struts
 * Creation date: 04-21-2006
 * 
 * XDoclet definition:
 * @struts.form name="filtrarPisoAgenteForm"
 */
public class FiltrarPisoAgenteForm extends ActionForm {

	// --------------------------------------------------------- Instance Variables
	 private String idInmueble;
	 private String metros;
	 private String regimen;
	 private String precio;
	 private String datosDeInteres;
	 private String numHab;
	 private String tipo;
	 private String zona;
	// --------------------------------------------------------- Methods

	public String getNumHab() {
		return numHab;
	}
	public void setNumHab(String numHab) {
		this.numHab = numHab;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getZona() {
		return zona;
	}
	public void setZona(String zona) {
		this.zona = zona;
	}
		/** 
		 * Method reset
		 * @param mapping
		 * @param request
		 */
		public void reset(ActionMapping mapping, HttpServletRequest request) {
			this.datosDeInteres = "";
			this.idInmueble = "";
			this.metros = "";
			this.precio = "";
			this.regimen = "";
			this.numHab = "";
			this.tipo ="";
			this.zona = "";
			
		}
	/** 
	 * Method validate
	 * @param mapping
	 * @param request
	 * @return ActionErrors
	 */
	public ActionErrors validate(
		ActionMapping mapping,
		HttpServletRequest request) {
		
		ActionErrors errors= new ActionErrors();
		
		if (idInmueble.equals(null) && metros.equals(null) && regimen.equals(null) &&
				precio.equals(null) && datosDeInteres.equals(null) && numHab.equals(null) &&
				tipo.equals(null) && zona.equals(null))
			errors.add("vacio", new ActionMessage("errors.vacio.required"));
			
		return errors;
	}


	public String getDatosDeInteres() {
		return datosDeInteres;
	}

	public void setDatosDeInteres(String datosDeInteres) {
		this.datosDeInteres = datosDeInteres;
	}

	public String getIdInmueble() {
		return idInmueble;
	}

	public void setIdInmueble(String idInmueble) {
		this.idInmueble = idInmueble;
	}

	public String getMetros() {
		return metros;
	}

	public void setMetros(String metros) {
		this.metros = metros;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public String getRegimen() {
		return regimen;
	}

	public void setRegimen(String regimen) {
		this.regimen = regimen;
	}

}

