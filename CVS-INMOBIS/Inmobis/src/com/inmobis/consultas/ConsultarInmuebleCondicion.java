package com.inmobis.consultas;

import java.util.*;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;

import com.inmobis.bbdd.CreadorGestores;
import com.inmobis.bbdd.cliente.GestorClienteBD;
import com.inmobis.bbdd.inmueble.*;
import com.inmobis.struts.form.FiltrarPisoAgenteForm;

public class ConsultarInmuebleCondicion extends Consultar{

	private static final Logger log = Logger.getLogger(ConsultarInmuebleCondicion.class);
	
	public Vector listar(ActionForm datosBusqueda){
		//Vector para guardar la lista que me devuelve la base de datos
		Vector datos = new Vector();
		//Vector para ir guardando el resultado final
		Vector datosfinal = new Vector();
		//var para poner el precio
		Integer preciomin,preciomax;
		if(!(((FiltrarPisoAgenteForm)datosBusqueda).getPrecioMin()).equals("") &&
				!(((FiltrarPisoAgenteForm)datosBusqueda).getPrecioMax()).equals("")){
			preciomin= new Integer(((FiltrarPisoAgenteForm)datosBusqueda).getPrecioMin());
			preciomax= new Integer(((FiltrarPisoAgenteForm)datosBusqueda).getPrecioMax());
		}
		else{
			preciomin = new Integer(-1);
			preciomax = new Integer (-1);
		}
		//var para poner los metros
		Integer metrosmin;
		Integer metrosmax;
		if(!(((FiltrarPisoAgenteForm)datosBusqueda).getMetrosMin()).equals("") &&
				!(((FiltrarPisoAgenteForm)datosBusqueda).getMetrosMax()).equals("")){
			metrosmin= new Integer(((FiltrarPisoAgenteForm)datosBusqueda).getMetrosMin());
			metrosmax= new Integer(((FiltrarPisoAgenteForm)datosBusqueda).getMetrosMax());
		}
		else{
			metrosmin = new Integer(-1);
			metrosmax = new Integer (-1);
		}
		
		while (preciomin.intValue() <= preciomax.intValue()){
			while (metrosmin.intValue() <= metrosmax.intValue()){
				//se crea el empleado bean		
				InmuebleBean i = new InmuebleBean();
				//se rellena el bean
				if (!(metrosmin.intValue()==-1 && metrosmax.intValue()==-1))
					i.setMetros(metrosmin.toString());
				if (!(preciomin.intValue()==-1 && preciomax.intValue()==-1))
					i.setPrecio(preciomin.toString());
				if (!(((FiltrarPisoAgenteForm)datosBusqueda).getRegimen().equals(null)))
					i.setRegimen(((FiltrarPisoAgenteForm)datosBusqueda).getRegimen());
				if (!(((FiltrarPisoAgenteForm)datosBusqueda).getNumHab().equals(null)))
					i.setNumHab(((FiltrarPisoAgenteForm)datosBusqueda).getNumHab());
				if (!(((FiltrarPisoAgenteForm)datosBusqueda).getTipo().equals(null)))
					i.setTipo(((FiltrarPisoAgenteForm)datosBusqueda).getTipo());
				if (!(((FiltrarPisoAgenteForm)datosBusqueda).getZona().equals(null)))
					i.setZona(((FiltrarPisoAgenteForm)datosBusqueda).getZona());
			
			//se crea el inmueble dase de datos		
			GestorInmuebleBD gestorInmueble= (GestorInmuebleBD)CreadorGestores.crearGestor("inmueble",i);
			
			if(log.isInfoEnabled()){
				log.info("ConsultarInmuebleCondicion 1: Antes de entrar en la base de datos ");
			}
			try{
				datos = gestorInmueble.BusquedaDetallada();
				if(log.isInfoEnabled()){
					log.info("ConsultarInmuebleCondicion 2: voy a copiar al vector final ");
				}
				//se introducen los nuevos inmuebles buscados en el vector final
				int j=0;
				while (j < datos.size()){
					datosfinal.add(datos.elementAt(j));
				}
				if(log.isInfoEnabled()){
					log.info("ConsultarInmuebleCondicion 3:la lista se generó con éxito ");
				}
			}catch (Exception E){
				if(log.isInfoEnabled()){
					log.info("ConsultarInmuebleCondicion4: Fallo en la busqueda en la base de datos " );
				}
				return datosfinal;
			}
			metrosmin++;
		}//fin del whilemetros
		preciomin++;
	}//fin del whileprecio
	return datosfinal;
	}
}
