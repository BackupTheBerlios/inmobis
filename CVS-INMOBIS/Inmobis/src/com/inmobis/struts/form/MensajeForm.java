//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.0.0/xslt/JavaClass.xsl

package com.inmobis.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

/** 
 * MyEclipse Struts
 * Creation date: 04-21-2006
 * 
 * XDoclet definition:
 * @struts.form name="MensajeForm"
 */
@SuppressWarnings("serial")
public class MensajeForm extends ActionForm {
	protected String idMensaje;
	protected String asunto;
	protected String texto;
	protected String origen;
	protected String destino;
	protected Character leido;  //vale s/n
	protected String fecha;
	//para devolver los nombre de origen y destino en vez de los id
	protected String nombreOrigen;
	protected String nombreDestino;
	// --------------------------------------------------------- Instance Variables

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

		// TODO Auto-generated method stub
		return null;
	}

	/** 
	 * Method reset
	 * @param mapping
	 * @param request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {

		// TODO Auto-generated method stub
	}

	public String getNombreDestino() {
		return nombreDestino;
	}

	public void setNombreDestino(String nombreDestino) {
		this.nombreDestino = nombreDestino;
	}

	public String getNombreOrigen() {
		return nombreOrigen;
	}

	public void setNombreOrigen(String nombreOrigen) {
		this.nombreOrigen = nombreOrigen;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getIdMensaje() {
		return idMensaje;
	}

	public void setIdMensaje(String idMensaje) {
		this.idMensaje = idMensaje;
	}

	public Character getLeido() {
		return leido;
	}

	public void setLeido(Character leido) {
		this.leido = leido;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}

