//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.1/xslt/JavaClass.xsl

package com.inmobis.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/** 
 * MyEclipse Struts
 * Creation date: 04-05-2006
 * 
 * XDoclet definition:
 * @struts.form name="editaPisoForm"
 */
@SuppressWarnings("serial")
public class EditaPisoForm extends ActionForm {

	// --------------------------------------------------------- Instance Variables
    private String idInmueble;
    private String numHab;
    private String tipo;
    private String zona;
	private String metros;
    private String regimen;
    private String precio;
    private String datosDeInteres;
	
	// --------------------------------------------------------- Methods
	
	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
    public void reset(ActionMapping mapping, HttpServletRequest request) {
	    this.idInmueble="";
    	this.metros="";
	    this.regimen="";
	    this.precio="";
	    this.datosDeInteres="";	
	}
    
	/** 
	 * Method validate
	 * @param mapping
	 * @param request
	 * @return ActionErrors
	 */
	public ActionErrors validate( ActionMapping mapping, HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();
		
		if((idInmueble.equals("")) && (metros.equals("")) && (regimen.equals("")) &&
				(precio.equals("")) && (datosDeInteres.equals("")))
			errors.add("editaPiso", new ActionMessage("error.editaPiso.invalid"));
		
		return errors;
	}
	
	public String getIdInmueble() {
		return idInmueble;
	}
	public void setIdInmueble(String idInmueble) {
		this.idInmueble = idInmueble;
	}
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
	public String getDatosDeInteres() {
		return datosDeInteres;
	}
	public void setDatosDeInteres(String datosDeInteres) {
		this.datosDeInteres = datosDeInteres;
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

