package com.inmobis.consultas;

import java.util.*;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;

import com.inmobis.bbdd.CreadorGestores;
import com.inmobis.bbdd.inmueble.*;
import com.inmobis.struts.form.FiltrarPisoAgenteForm;

public class ConsultarInmuebleCondicion extends Consultar{

	private static final Logger log = Logger.getLogger(ConsultarInmuebleCondicion.class);
	
	public Vector listar(ActionForm datosBusqueda){
		//Vector para guardar la lista que me devuelve la base de datos
		Vector datos = new Vector();
		//Vector para ir guardando el resultado final
		Vector datosfinal = new Vector();
		//se crea el empleado bean		
		InmuebleBean i = new InmuebleBean();
		if (!(((FiltrarPisoAgenteForm)datosBusqueda).getRegimen().equals(null)) &&
				!(((FiltrarPisoAgenteForm)datosBusqueda).getRegimen().equals("")))
			i.setRegimen(((FiltrarPisoAgenteForm)datosBusqueda).getRegimen());
		if (!(((FiltrarPisoAgenteForm)datosBusqueda).getNumHab().equals(null)) &&
				!(((FiltrarPisoAgenteForm)datosBusqueda).getNumHab().equals("")))
			i.setNumHab(((FiltrarPisoAgenteForm)datosBusqueda).getNumHab());
		if (!(((FiltrarPisoAgenteForm)datosBusqueda).getTipo().equals(null)) &&
				!(((FiltrarPisoAgenteForm)datosBusqueda).getTipo().equals("")))
			i.setTipo(((FiltrarPisoAgenteForm)datosBusqueda).getTipo());
		if (!(((FiltrarPisoAgenteForm)datosBusqueda).getZona().equals(null)) &&
				!(((FiltrarPisoAgenteForm)datosBusqueda).getZona().equals("")))
			i.setZona(((FiltrarPisoAgenteForm)datosBusqueda).getZona());
		
		//se crea el inmueble dase de datos		
		GestorInmuebleBD gestorInmueble= (GestorInmuebleBD)CreadorGestores.crearGestor("inmueble",i);
		
		//var para poner el precio
		Integer preciomin,preciomax;
		if(!(((FiltrarPisoAgenteForm)datosBusqueda).getPrecioMin()).equals("") &&
				!(((FiltrarPisoAgenteForm)datosBusqueda).getPrecioMax()).equals("") &&
				!(((FiltrarPisoAgenteForm)datosBusqueda).getPrecioMin()).equals(null) &&
				!(((FiltrarPisoAgenteForm)datosBusqueda).getPrecioMax()).equals(null) ){
			if(log.isInfoEnabled()){
				log.info("ConsultarInmuebleCondicion 1: estoy declarando preciomin y preciomax ");
			}
			preciomin= new Integer(((FiltrarPisoAgenteForm)datosBusqueda).getPrecioMin());
			preciomax= new Integer(((FiltrarPisoAgenteForm)datosBusqueda).getPrecioMax());
		}
		else{
			if(log.isInfoEnabled()){
				log.info("ConsultarInmuebleCondicion 2: estoy declarando preciomin y preciomax vacios");
			}
			preciomin = new Integer(-1);
			preciomax = new Integer (-1);
		}//fin declaración precio
		
		//var para poner los metros
		Integer metrosmin;
		Integer metrosmax;
		if(!(((FiltrarPisoAgenteForm)datosBusqueda).getMetrosMin()).equals("") &&
				!(((FiltrarPisoAgenteForm)datosBusqueda).getMetrosMax()).equals("") &&
				!(((FiltrarPisoAgenteForm)datosBusqueda).getMetrosMin()).equals(null)  &&
				!(((FiltrarPisoAgenteForm)datosBusqueda).getMetrosMax()).equals(null)){
			if(log.isInfoEnabled()){
				log.info("ConsultarInmuebleCondicion 3: estoy declarando metrosmin y metrosmax ");
			}
			metrosmin= new Integer(((FiltrarPisoAgenteForm)datosBusqueda).getMetrosMin());
			metrosmax= new Integer(((FiltrarPisoAgenteForm)datosBusqueda).getMetrosMax());
		}
		else{
			if(log.isInfoEnabled()){
				log.info("ConsultarInmuebleCondicion 4: estoy declarando metrosmin y metrosmax vacios ");
			}
			metrosmin = new Integer(-1);
			metrosmax = new Integer (-1);
		}//fin declaración metros
		
		for (int j=preciomin.intValue();j <= preciomax.intValue();j++){
			for (int t=metrosmin.intValue(); t <= metrosmax.intValue(); t++){
				if(log.isInfoEnabled()){
					log.info("ConsultarInmuebleCondicion 5: estoy en el bucle ");
					log.info( j);
					log.info( t);
				}
				
				//se ponen los nuevos valores para metros y para precio
				if (!(metrosmin.intValue()==-1 && metrosmax.intValue()==-1))
					((InmuebleBean)gestorInmueble.getBean()).setMetros(new Integer(t).toString());
				if (!(preciomin.intValue()==-1 && preciomax.intValue()==-1))
					((InmuebleBean)gestorInmueble.getBean()).setPrecio(new Integer(j).toString());
				
				if(log.isInfoEnabled()){
					log.info("ConsultarInmuebleCondicion 6: Antes de entrar en la base de datos ");
					log.info(((InmuebleBean)gestorInmueble.getBean()).getPrecio());
					log.info(((InmuebleBean)gestorInmueble.getBean()).getMetros());
				}
				try{
					//se realiza la busqueda en la base de datos
					datos = gestorInmueble.BusquedaDetallada();
				}catch (Exception E){
					if(log.isInfoEnabled()){
						log.info("ConsultarInmuebleCondicion 7: Fallo en la busqueda en la base de datos " );
					}
					return datos;
				}
				if(log.isInfoEnabled()){
					log.info("ConsultarInmuebleCondicion 8: voy a copiar al vector final ");
					log.info("ConsultarInmuebleCondicion 9: " + datos.size());
				}
				//se introducen los nuevos inmuebles buscados en el vector final
				for (int z=0; z < datos.size(); z++){
					datosfinal.addElement(datos.elementAt(z));
				}
				if(log.isInfoEnabled()){
					log.info("ConsultarInmuebleCondicion 10:la lista se generó con éxito ");
					log.info("ConsultarInmuebleCondicion 11: " + datosfinal.size());
				}
			}//fin del forprecio
		}//fin del whilemetros
		if(log.isInfoEnabled()){
			log.info("ConsultarInmuebleCondicion 12: he acabado de buscar ");
		}
		return datosfinal;
	}
}
