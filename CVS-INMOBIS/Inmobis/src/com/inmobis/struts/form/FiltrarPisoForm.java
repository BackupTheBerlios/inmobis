//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.0.0/xslt/JavaClass.xsl

package com.inmobis.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/** 
 * MyEclipse Struts
 * Creation date: 05-27-2006
 * 
 * XDoclet definition:
 * @struts.form name="filtrarPisoForm"
 */
public class FiltrarPisoForm extends ActionForm {

	// --------------------------------------------------------- Instance Variables
	 private String metrosMin,metrosMax;
	 private String regimen;
	 private String precioMin,precioMax;
	 private String datosDeInteres;
	 private String numHab;
	 private String tipo;
	 private String zona;
	// --------------------------------------------------------- Methods


	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.datosDeInteres = "";
		this.metrosMin = "";
		this.metrosMax = "";
		this.precioMin = "";
		this.precioMax = "";
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

		// TODO Auto-generated method stub
		return null;
	}

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */

	public String getDatosDeInteres() {
		return datosDeInteres;
	}

	public void setDatosDeInteres(String datosDeInteres) {
		this.datosDeInteres = datosDeInteres;
	}

	public String getMetrosMax() {
		return metrosMax;
	}

	public void setMetrosMax(String metrosMax) {
		this.metrosMax = metrosMax;
	}

	public String getMetrosMin() {
		return metrosMin;
	}

	public void setMetrosMin(String metrosMin) {
		this.metrosMin = metrosMin;
	}

	public String getNumHab() {
		return numHab;
	}

	public void setNumHab(String numHab) {
		this.numHab = numHab;
	}

	public String getPrecioMax() {
		return precioMax;
	}

	public void setPrecioMax(String precioMax) {
		this.precioMax = precioMax;
	}

	public String getPrecioMin() {
		return precioMin;
	}

	public void setPrecioMin(String precioMin) {
		this.precioMin = precioMin;
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

