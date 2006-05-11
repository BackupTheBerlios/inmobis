//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.0.0/xslt/JavaClass.xsl

package com.inmobis.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/** 
 * MyEclipse Struts
 * Creation date: 04-19-2006
 * 
 * XDoclet definition:
 * @struts.form name="filtrarEmpleadoForm"
 */
public class FiltrarEmpleadoForm extends ActionForm {

	// --------------------------------------------------------- Instance Variables
	private String idEmpleado;
	private String nombreEmpleado;
	private String apellido1;
	private String apellido2;
	private String fechaNacimiento;
	private String dniEmpleado;
	// --------------------------------------------------------- Methods

	public String getDniEmpleado() {
		return dniEmpleado;
	}

	public void setDniEmpleado(String dniEmpleado) {
		this.dniEmpleado = dniEmpleado;
	}

	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
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

		ActionErrors errors= new ActionErrors();
		
		if (apellido1.equals(null) && apellido2.equals(null) && fechaNacimiento.equals(null) &&
				idEmpleado.equals(null) && nombreEmpleado.equals(null)&& dniEmpleado.equals(null))
			errors.add("vacio", new ActionMessage("errors.vacio.required"));
			
		return errors;
	}

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		this.apellido1="";
		this.apellido2="";
		this.fechaNacimiento="";
		this.idEmpleado="";
		this.nombreEmpleado="";
		this.dniEmpleado="";
	}
	
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apel1) {
		apellido1 = apel1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apel2) {
		apellido2 = apel2;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechNacimiento) {
		fechaNacimiento = fechNacimiento;
	}
	public String getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmplado(String idEmpl) {
		this.idEmpleado = idEmpl;
	}
	public String getNombreEmpleado() {
		return nombreEmpleado;
	}
	public void setNombreEmpleado(String nombreEmpl) {
		nombreEmpleado = nombreEmpl;
	}

}

