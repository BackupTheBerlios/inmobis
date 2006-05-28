package com.inmobis.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class EditaEmpleadoPrevForm extends ActionForm{
	private static final Logger i_log = Logger.getLogger(EditaEmpleadoPrevForm.class);
	private String idEmpleado;
	//datos personales
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String fechaNacimiento;
	private String tipoEmpleado;
	private String porcentaje;
	private String dni;

	public void reset(ActionMapping mapping, HttpServletRequest request){
		idEmpleado="";
		nombre="";
		apellido1="";
		apellido2="";
		dni="";
		tipoEmpleado="";
		porcentaje="";
		fechaNacimiento="";
	}
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
	{
		ActionErrors errors = new ActionErrors();
			//TODO ver que hay solo 1 seleccionado
		if (i_log.isInfoEnabled()){
			i_log.info("Datos obtenidos del Ver: "+idEmpleado+" "+nombre+" "+apellido1+" "+apellido2+" "+dni+" "+fechaNacimiento+" "+tipoEmpleado);
		}
		return errors;
	}

	//Getters
	public String getIdEmpleado(){
		return this.idEmpleado;
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
	public String getTipoEmpleado(){
		return this.tipoEmpleado;
	}
	public String porcentaje(){
		return this.porcentaje;
	}
	
	//Setters
	public void setIdEmpleado(String id){
		this.idEmpleado=id.trim();
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
	public void setTipoEmpleado(String tipo){
		this.tipoEmpleado=tipo.trim();
	}
	public void setPorcentaje(String p){
		this.porcentaje=p.trim();
	}
}


