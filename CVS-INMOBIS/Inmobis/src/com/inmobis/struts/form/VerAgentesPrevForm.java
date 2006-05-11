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
 * @struts.form name="verAgentesPrevForm"
 */
public class VerAgentesPrevForm extends ActionForm {

	// --------------------------------------------------------- Instance Variables
	private String idAgente;
	private String nombreAgente;
	private String apellido1;
	private String apellido2;
	private String fechaNacimiento;
	private String dniAgente;
	// --------------------------------------------------------- Methods

	public String getDniAgente() {
		return dniAgente;
	}

	public void setDniAgente(String dniAgente) {
		this.dniAgente = dniAgente;
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
				idAgente.equals(null) && nombreAgente.equals(null) && dniAgente.equals(null))
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
		this.idAgente="";
		this.nombreAgente="";
		this.dniAgente = "";
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

	public String getIdAgente() {
		return idAgente;
	}

	public void setIdAgente(String idAgente) {
		this.idAgente = idAgente;
	}

	public String getNombreAgente() {
		return nombreAgente;
	}

	public void setNombreAgente(String nombreAgente) {
		this.nombreAgente = nombreAgente;
	}

}

