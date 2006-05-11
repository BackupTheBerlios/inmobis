package com.inmobis.modificaciones;

import java.util.Hashtable;

import org.apache.struts.action.ActionErrors;

import com.inmobis.bbdd.RowNotFoundException;
import com.inmobis.bbdd.inmueble.InmuebleBD;
import com.inmobis.bbdd.inmueble.InmuebleBean;

public class ModificarInmueble extends Modificar{
	
		public ActionErrors introduce(Hashtable<String,String> datosInmueble){
		
		ActionErrors errors= new ActionErrors();
		
		//Creamos y rellenamos el objeto Bean para el inmueble
		InmuebleBean inmueble=new InmuebleBean();
		inmueble.setMetros(datosInmueble.get("metros"));
		inmueble.setPrecio(datosInmueble.get("precio"));
		inmueble.setRegimen(datosInmueble.get("regimen"));
		inmueble.setDatosDeInteres(datosInmueble.get("datosInteres"));
		//TODO identificador del inmueble
		
		InmuebleBD inmuebleBD= new InmuebleBD(inmueble);
		
		try {
			inmuebleBD.update();
		} catch (RowNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return errors;
	}
}

