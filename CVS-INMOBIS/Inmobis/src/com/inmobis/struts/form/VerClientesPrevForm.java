//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.0.0/xslt/JavaClass.xsl

package com.inmobis.struts.form;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/** 
 * MyEclipse Struts
 * Creation date: 04-20-2006
 * 
 * XDoclet definition:
 * @struts.form name="verClientesPrevForm"
 */
public class VerClientesPrevForm extends ActionForm {

	// --------------------------------------------------------- Instance Variables
	private String idCliente;
	private String nombreCliente;
	private String apellido1;
	private String apellido2;
	private String fechaNacimiento;
	private String dniCliente;
	
	private boolean esBusqueda;
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

		ActionErrors errors= new ActionErrors();
		
		if (apellido1.equals(null) && apellido2.equals(null) && fechaNacimiento.equals(null) &&
				idCliente.equals(null) && nombreCliente.equals(null) && dniCliente.equals(null))
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
		this.idCliente="";
		this.nombreCliente="";
		this.dniCliente="";
		
		this.esBusqueda=false;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getDniCliente() {
		return dniCliente;
	}

	public void setDniCliente(String dniCliente) {
		this.dniCliente = dniCliente;
	}

	public boolean isEsBusqueda() {
		return esBusqueda;
	}

	public void setEsBusqueda(boolean esBusqueda) {
		this.esBusqueda = esBusqueda;
	}

}

