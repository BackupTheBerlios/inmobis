package com.inmobis.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import java.util.Vector;

public class VerPisosAgenteForm extends ActionForm{
	//	 --------------------------------------------------------- Instance Variables
		private String idAgente;
	// --------------------------------------------------------- Methods

		public String getIdAgente() {
			return idAgente;
		}

		public void setIdAgente(String idAgente) {
			this.idAgente = idAgente;
		}

}
