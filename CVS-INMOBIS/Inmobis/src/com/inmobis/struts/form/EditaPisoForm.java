//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.1.1/xslt/JavaClass.xsl

package com.inmobis.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class EditaPisoForm extends ActionForm {
	
	private static final Logger i_log = Logger.getLogger(EditaPisoForm.class);
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

    public void reset(ActionMapping mapping, HttpServletRequest request) {
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
	}
    

	public ActionErrors validate( ActionMapping mapping, HttpServletRequest request) {

	ActionErrors errors = new ActionErrors();
		if (i_log.isInfoEnabled()){
			i_log.info("Antes de comprobar los errores. Nº errores: "+errors.size());
		}
		
		if(numHab.equals("") && tipo.equals("") && zona.equals("") && metros.equals("") && regimen.equals("") &&
				precio.equals("") && datosDeInteres.equals("") && calle.equals("") && num.equals("") && piso.equals("") &&
				codPostal.equals("") && poblacion.equals("") && provincia.equals("") && pais.equals(""))
			errors.add("editaPiso", new ActionMessage("error.editaPiso.invalid"));
		
		//El numHab tiene que ser un numero
		if(!numHab.equals("")){
			try{
				new Integer(numHab);
			}catch (Exception e){
				errors.add("numHab", new ActionMessage("errors.numHab.notValid"));
			}
		}
		
		//El tamaño tiene que ser un numero
		if(!metros.equals("")){
			try{
				new Double(metros);
			}catch (Exception e){
				errors.add("metros", new ActionMessage("errors.metros.notValid"));
			}
		}
		//TODO tipo y regimen?? van a ser comboboxes
		//La poblacion, provincia y pais solo pueden tener letras
		if(!zona.equals("") && !esNombre(zona))
			errors.add("zona", new ActionMessage("errors.zona.notValid"));
		if(!poblacion.equals("") && !esNombre(poblacion))
			errors.add("poblacion", new ActionMessage("errors.poblacion.notValid"));
		if(!provincia.equals("") && !esNombre(provincia))
			errors.add("provincia", new ActionMessage("errors.provincia.notValid"));
		if(!pais.equals("") && !esNombre(pais))
			errors.add("pais", new ActionMessage("errors.pais.notValid"));
		
		//El numero solo puede contener digitos
		if(!num.equals("")){
			try{
				new Integer(num).intValue();
			}catch(Exception e){
				errors.add("num", new ActionMessage("errors.num.notValid"));
			}
		}
		//El codigo postal debe tenr 5 digitos
		if (!codPostal.equals("")){
			if(codPostal.length()!=5)
				errors.add("codPostal", new ActionMessage("errors.direccion.CPnotValid"));
			else{
				try{
					new Integer(codPostal).intValue();
				}catch(Exception e){
					errors.add("codPostal", new ActionMessage("errors.direccion.CPnotValid"));
				}
			}
		}
		
		if (i_log.isInfoEnabled()){
			i_log.info("Despues de comprobar los erorres. Nº errores: "+errors.size());
		}
		return errors;
	}
	
	//Metodo para saber si una cadena solo tiene letras
	boolean esNombre(String cadena){
		boolean valido=true;
		char[] chars = cadena.toCharArray();
		int i=0;
		while(i<chars.length && valido){
			if (!Character.isLetter(chars[i])&& !Character.isSpace(chars[i]))
				valido=false;	
			i++;
		}
		return valido;
	}
	
	//getters
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

