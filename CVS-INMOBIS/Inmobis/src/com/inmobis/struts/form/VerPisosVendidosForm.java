//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.0.0/xslt/JavaClass.xsl

package com.inmobis.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/** 
 * MyEclipse Struts
 * Creation date: 05-30-2006
 * 
 * XDoclet definition:
 * @struts.form name="verPisosVendidosForm"
 */
public class VerPisosVendidosForm extends ActionForm {

	// --------------------------------------------------------- Instance Variables
	 String idAgente;
	 String idInmueble;
	 String fechVenta;
	 String precioInicial;
	 String precioFinal;
	 String ganacia;
	 
	 //para el rango
	 String fechIni;
	 String fechFin;	 
	 
	// --------------------------------------------------------- Methods

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
		this.idAgente="";
		this.idInmueble="";		
		this.fechVenta="";
		this.precioInicial="";
		this.precioFinal="";
		this.ganacia="";		
	}

	public String getFechFin() {
		return fechFin;
	}

	public void setFechFin(String fechFin) {
		this.fechFin = fechFin;
	}

	public String getFechIni() {
		return fechIni;
	}

	public void setFechIni(String fechIni) {
		this.fechIni = fechIni;
	}

	public String getFechVenta() {
		return fechVenta;
	}

	public void setFechVenta(String fechVenta) {
		this.fechVenta = fechVenta;
	}

	public String getGanacia() {
		return ganacia;
	}

	public void setGanacia(String ganacia) {
		this.ganacia = ganacia;
	}

	public String getIdAgente() {
		return idAgente;
	}

	public void setIdAgente(String idAgente) {
		this.idAgente = idAgente;
	}

	public String getIdInmueble() {
		return idInmueble;
	}

	public void setIdInmueble(String idInmueble) {
		this.idInmueble = idInmueble;
	}

	public String getPrecioFinal() {
		return precioFinal;
	}

	public void setPrecioFinal(String precioFinal) {
		this.precioFinal = precioFinal;
	}

	public String getPrecioInicial() {
		return precioInicial;
	}

	public void setPrecioInicial(String precioInicial) {
		this.precioInicial = precioInicial;
	}

}

