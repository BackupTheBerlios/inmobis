package com.inmobis.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/** 
 * MyEclipse Struts
 * Creation date: 03-29-2006
 * 
 * XDoclet definition:
 * @struts.form name="borraPisoForm"
 */
public class BorraPisoPrevForm extends ActionForm {

	// --------------------------------------------------------- Instance Variables
	String idInmueble;
	String zona;
	String numHab;
	String metros;
	String regimen;
	String tipo;
	String precio;
	// --------------------------------------------------------- Methods
	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.idInmueble = "";
		this.metros="";
		this.numHab="";
		this.precio="";
		this.regimen="";
		this.tipo="";
		this.zona="";
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

	public String getNumHab() {
		return numHab;
	}

	public void setNumHab(String numHab) {
		this.numHab = numHab;
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
}

