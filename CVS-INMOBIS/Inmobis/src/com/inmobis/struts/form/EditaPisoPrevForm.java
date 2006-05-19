package com.inmobis.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class EditaPisoPrevForm extends ActionForm{
	private static final Logger i_log = Logger.getLogger(EditaClientePrevForm.class);
	private String idInmueble;
	//Datos inmueble
    private String numHab;
    private String tipo;
    private String zona;
	private String metros;
    private String regimen;
    private String precio;
    private String datosDeInteres;

	public void reset(ActionMapping mapping, HttpServletRequest request){
		this.idInmueble="";
    	this.numHab="";
    	this.tipo="";
    	this.zona="";
    	this.metros="";
	    this.regimen="";
	    this.precio="";
	    this.datosDeInteres="";	
	}
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
	{
		ActionErrors errors = new ActionErrors();
			//TODO ver que hay solo 1 seleccionado
		if (i_log.isInfoEnabled()){
			i_log.info("Datos obtenidos del Ver: "+idInmueble+" "+numHab+" "+tipo+" "+zona+" "+metros+" "+precio+" "+datosDeInteres);
		}
		return errors;
	}

	//Getters
	//getters
	public String getIdInmueble(){
		return idInmueble;
	}
	public String getNumHab() {
		return numHab;
	}
	public String getTipo() {
		return tipo;
	}
	public String getZona() {
		return zona;
	}
	public String getDatosDeInteres() {
		return datosDeInteres;
	}
	public String getMetros() {
		return metros;
	}
	public String getPrecio() {
		return precio;
	}
	public String getRegimen() {
		return regimen;
	}
	//Setters
	public void setIdInmueble(String id){
		this.idInmueble=id.trim();
	}
	public void setNumHab(String numHab) {
		this.numHab = numHab.trim();
	}	
	public void setTipo(String tipo) {
		this.tipo = tipo.trim();
	}	
	public void setZona(String zona) {
		this.zona = zona.trim();
	}
	public void setDatosDeInteres(String datosDeInteres) {
		this.datosDeInteres = datosDeInteres.trim();
	}
	public void setMetros(String metros) {
		this.metros = metros.trim();
	}
	public void setPrecio(String precio) {
		this.precio = precio.trim();
	}
	public void setRegimen(String regimen) {
		this.regimen = regimen.trim();
	}
}

