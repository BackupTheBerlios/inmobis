//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.1/xslt/JavaClass.xsl

package com.inmobis.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

@SuppressWarnings("serial")
public class VerPisoDetalleForm extends ActionForm {
	
	private String idInmueble;
	//Datos inmueble
    private String numHab;
    private String tipo;
    private String zona;
	private String metros;
    private String regimen;
    private String precio;
    private String datosDeInteres;
    //Direccion
	private String calle;
	private String num;
	private String piso;
	private String codPostal;
	private String poblacion;
	private String provincia;
	private String pais;
	private String foto1;
	private String foto2;
	
	
    public void reset(ActionMapping mapping, HttpServletRequest request) {
    	this.idInmueble="";
    	this.numHab="";
    	this.tipo="";
    	this.zona="";
    	this.metros="";
	    this.regimen="";
	    this.precio="";
	    this.datosDeInteres="";	
	    this.calle="";
	    this.num="";
	    this.piso="";
	    this.codPostal="";
	    this.poblacion="";
	    this.provincia="";
	    this.pais="";
	    this.foto1="";
	    this.foto2="";
	}
    

	public ActionErrors validate( ActionMapping mapping, HttpServletRequest request) {
		return null;
	}

	//getters
	public String getFoto1() {
		return foto1;
	}
	public String getFoto2() {
		return foto2;
	}
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
	public String getCalle(){
		return this.calle;
	}
	public String getNum(){
		return this.num;
	}
	public String getPiso(){
		return this.piso;
	}
	public String getCodPostal(){
		return this.codPostal;
	}
	public String getPoblacion(){
		return this.poblacion;
	}
	public String getProvincia(){
		return this.provincia;
	}
	public String getPais(){
		return this.pais;
	}
	//setters
	public void setFoto1(String foto1) {
		this.foto1 = foto1;
	}
	public void setFoto2(String foto2) {
		this.foto2 = foto2;
	}
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
	public void setCalle(String calle){
		this.calle=calle.trim();
	}
	public void setNum(String num){
		this.num=num.trim();
	}
	public void setPiso(String piso){
		this.piso=piso.trim();
	}
	public void setCodPostal(String cp){
		this.codPostal=cp.trim();
	}
	public void setPoblacion(String pob){
		this.poblacion=pob.trim();
	}
	public void setProvincia(String prov){
		this.provincia=prov.trim();
	}
	public void setPais(String pais){
		this.pais=pais.trim();
	}


}

