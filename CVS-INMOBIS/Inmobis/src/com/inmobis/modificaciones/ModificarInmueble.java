package com.inmobis.modificaciones;

import java.util.Hashtable;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;

import com.inmobis.bbdd.RowNotFoundException;
import com.inmobis.bbdd.inmueble.InmuebleBD;
import com.inmobis.bbdd.inmueble.InmuebleBean;

public class ModificarInmueble extends Modificar{
	
		public ActionErrors modifica(ActionForm datosInmueble){
		
		ActionErrors errors= new ActionErrors();
		return errors;
	}
}

