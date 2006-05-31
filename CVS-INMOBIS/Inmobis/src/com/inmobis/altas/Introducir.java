package com.inmobis.altas;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMessages;

public abstract class Introducir {
	public abstract ActionMessages introduce(ActionForm form);
	
	//se sobreescribe en IntroducirInmueble
	public ActionMessages introduceVendido(ActionForm form){
		return null;
	}
}
