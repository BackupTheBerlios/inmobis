package com.inmobis.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class EditaClientePrevForm extends ActionForm{
	private static final Logger i_log = Logger.getLogger(EditaClientePrevForm.class);
	private String idCliente;
	//datos personales
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String fechaNacimiento;
	private String dni;

	public void reset(ActionMapping mapping, HttpServletRequest request){
		idCliente="";
		nombre="";
		apellido1="";
		apellido2="";
		dni="";
		fechaNacimiento="";
	}
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
	{
		ActionErrors errors = new ActionErrors();
			//TODO ver que hay solo 1 seleccionado
		if (i_log.isInfoEnabled()){
			i_log.info("Datos obtenidos del Ver: "+idCliente+" "+nombre+" "+apellido1+" "+apellido2+" "+dni+" "+fechaNacimiento);
		}
		return errors;
	}

	//Getters
	public String getIdCliente(){
		return this.idCliente;
	}
	public String getNombre(){
		return this.nombre;
	}
	public String getApellido1(){
		return this.apellido1;
	}
	public String getApellido2(){
		return this.apellido2;
	}
	public String getDni(){
		return this.dni;
	}
	public String getFechaNacimiento(){
		return this.fechaNacimiento;
	}
	
	//Setters
	public void setIdCliente(String id){
		this.idCliente=id.trim();
	}
	public void setNombre(String nombre){
		this.nombre=nombre.trim();
	}
	public void setApellido1(String ap1){
		this.apellido1=ap1.trim();
	}
	public void setApellido2(String ap2){
		this.apellido2=ap2.trim();
	}
	public void setDni(String dni){
		this.dni=dni.trim();
	}
	public void setFechaNacimiento(String fecha){
		this.fechaNacimiento=fecha.trim();
	}
}
