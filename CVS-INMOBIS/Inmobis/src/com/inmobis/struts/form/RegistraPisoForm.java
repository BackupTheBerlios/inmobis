package com.inmobis.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.*;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import org.apache.log4j.Logger;

import com.inmobis.struts.action.RegistraPisoAction;

public class RegistraPisoForm extends ActionForm {
	
	private static final Logger i_log = Logger.getLogger(RegistraPisoForm.class);
	//Datos inmueble
	private String metros;
	private String regimen;
	private String precio;
	private String datosDeInteres;
	private String numHab;
	private String zona;
	private String tipo;
    //Direccion
	private String calle;
	private String num;
	private String piso;
	private String codPostal;
	private String poblacion;
	private String provincia;
	private String pais;
	//Datos del cliente
	private String nombreUsuario;

	
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
		this.nombreUsuario="";
	}
	
	public ActionErrors validate(
		ActionMapping mapping,
		HttpServletRequest request) {
		
		ActionErrors errors=new ActionErrors();
		
		if (i_log.isInfoEnabled()){
			i_log.info("Antes de comprobar los errores. Nº errores: "+errors.size());
		}
		
		//hay que rellenar la zona
		if(zona.equals(""))
			errors.add("zona", new ActionMessage("errors.zona.required"));
		
		//hay que rellenar el tipo
		if(tipo.equals("") || !esNombre(tipo))
			errors.add("tipo", new ActionMessage("errors.tipo.required"));
		
		//hay que rellenar en numHab
		if(numHab.equals(""))
			errors.add("numHab", new ActionMessage("errors.numHab.required"));
		else{
			try{
				new Integer(numHab);
			}catch (Exception e){
				errors.add("numHab", new ActionMessage("errors.numHab.notValid"));
			}
		}
		//hay que rellenar el tamaño
		if(metros.equals(""))
			errors.add("metros", new ActionMessage("errors.metros.required"));
		else{
			try{
				new Double(metros);
			}catch (Exception e){
				errors.add("metros", new ActionMessage("errors.metros.notValid"));
			}
		}
			
		//hay que rellenar el regimen
		if(regimen.equals(""))
			errors.add("regimen", new ActionMessage("errors.regimen.required"));
		//hay que rellenar el precio
		if(precio.equals(""))
			errors.add("precio", new ActionMessage("errors.precio.required"));
		else{
			try{
				new Double(metros);
			}catch (Exception e){
				errors.add("precio", new ActionMessage("errors.precio.notValid"));
			}
		}
		//Hay que rellenar obligatoriamente todo menos el piso
		if(calle.equals("") || num.equals("") || codPostal.equals("") || 
				poblacion.equals("") || provincia.equals("") || pais.equals(""))
			errors.add("registraPiso", new ActionMessage("errors.direccion.incomplete"));
		
		if(!esNombre(poblacion))
			errors.add("poblacion", new ActionMessage("errors.poblacion.notValid"));
		if(!esNombre(provincia))
			errors.add("provincia", new ActionMessage("errors.provincia.notValid"));
		if(!esNombre(pais))
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
		if(codPostal.length()!=5)
			errors.add("codPostal", new ActionMessage("errors.direccion.CPnotValid"));
		else{
			try{
				new Integer(codPostal).intValue();
			}catch(Exception e){
				errors.add("codPostal", new ActionMessage("errors.direccion.CPnotValid"));
			}
		}
		if (i_log.isInfoEnabled()){
			i_log.info("Despues de comprobar los erorres. Nº errores: "+errors.size());
		}
		//El nombre de usuario tiene que tener al menos 2 caractereres
		if(nombreUsuario.equals("") || nombreUsuario.length() < 2){
			errors.add("nombreUsuario", new ActionMessage("errors.nombreUsuario.required"));	
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
	
	//Getters
	public String getTipo() {
		return tipo;
	}
	public String getZona() {
		return zona;
	}
	public String getNumHab() {
		return numHab;
	}
	public String getMetros(){
		return this.metros;
	}
	public String getRegimen(){
		return this.regimen;
	}
	public String getPrecio(){
		return this.precio;
	}
	public String getDatosInteres(){
		return this.datosDeInteres;
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
	public String getNombreUsuario(){
		return this.nombreUsuario;
	}
	//Setters
	public void setTipo(String tipo) {
		this.zona = tipo.trim();
	}
	public void setNumHab(String numHab) {
		this.numHab = numHab.trim();
	}
	public void setZona(String zona) {
		this.zona = zona.trim();
	}
	public void setMetros(String m){
		this.metros=m.trim();
	}
	public void setRegimen(String r){
		this.regimen=r.trim();
	}
	public void setPrecio(String p){
		this.precio=p.trim();
	}
	public void setDatosInteres(String di){
		this.datosDeInteres=di.trim();
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
	public void setNombreUsuario(String nombre){
		this.nombreUsuario =nombre.trim();
	}
}

