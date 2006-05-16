package com.inmobis.modificaciones;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.inmobis.bbdd.CreadorGestores;
import com.inmobis.bbdd.direccion.InfoDirBean;
import com.inmobis.bbdd.inmueble.GestorInmuebleBD;
import com.inmobis.bbdd.inmueble.InmuebleBean;
import com.inmobis.struts.form.EditaPisoForm;

public class ModificarInmueble extends Modificar{
	private static final Logger i_log = Logger.getLogger(ModificarInmueble.class);
	
		public ActionMessages modifica(ActionForm datosInmueble){
		
		ActionMessages errors= new ActionErrors();
		
		if (i_log.isInfoEnabled()){
			i_log.info("Entro en Modificar Inmueble");
		}
		//Creamos y rellenamos el objeto Bean para el inmueble
		InmuebleBean inmueble=new InmuebleBean();
		inmueble.setNumHab(((EditaPisoForm)datosInmueble).getNumHab());
		inmueble.setMetros(((EditaPisoForm)datosInmueble).getMetros());
		inmueble.setZona(((EditaPisoForm)datosInmueble).getZona());
		inmueble.setTipo(((EditaPisoForm)datosInmueble).getTipo());
		inmueble.setPrecio(((EditaPisoForm)datosInmueble).getPrecio());
		inmueble.setRegimen(((EditaPisoForm)datosInmueble).getRegimen());
		inmueble.setDatosDeInteres(((EditaPisoForm)datosInmueble).getDatosDeInteres());
		//TODO cambiar cuando funcione lo de coger IdInmueble
		//inmueble.setIdInmueble(((EditaPisoForm)datosInmueble).getIdInmueble());
		inmueble.setIdInmueble("I101");
		
		CreadorGestores gestor=new CreadorGestores(); 
		GestorInmuebleBD gestorInmueble= (GestorInmuebleBD)gestor.crearGestor("inmueble",inmueble);
		
		//Creamos un Bean de Direccion asociada al inmueble ya creado
		InfoDirBean direccion=gestorInmueble.newInfoDirInmuebles("casa");
		//Rellenamos el bean 
		direccion.setCalle(((EditaPisoForm)datosInmueble).getCalle());
		direccion.setNum(((EditaPisoForm)datosInmueble).getNum());
		direccion.setPiso(((EditaPisoForm)datosInmueble).getPiso());
		direccion.setCodPostal(((EditaPisoForm)datosInmueble).getCodPostal());
		direccion.setPoblacion(((EditaPisoForm)datosInmueble).getPoblacion());
		direccion.setProvincia(((EditaPisoForm)datosInmueble).getProvincia());
		direccion.setPais(((EditaPisoForm)datosInmueble).getPais());
		
		if(i_log.isInfoEnabled())
			i_log.info("Nuevos datos :" + direccion.getCalle() +". "+
					inmueble.getNumHab() +" "+inmueble.getZona() +" "+inmueble.getTipo()
					+" "+inmueble.getPrecio() +" "+inmueble.getRegimen() +" "+inmueble.getMetros() 
					+" "+inmueble.getdatosDeInteres());
		//TODO Actualizar direccion con update del gestor
		try{
			gestorInmueble.update();
			//gestorInmueble.insertaDir(direccion);
			if(i_log.isInfoEnabled())
				i_log.info("Actualizado el piso de la calle :" + direccion.getCalle());
		}catch (Exception e) {
			errors.add("registraPiso", new ActionMessage("errors.bbdd.clave"));
			if(i_log.isInfoEnabled())
				i_log.info("Fallo en identificadores de tabla de BBDD :" + e.toString());
		}
		
		return errors;
	}
}


