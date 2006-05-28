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
		
		//se crean variables que contiene los metros y el precio, ya que pueden ser un rango
		String metrosMin=((FiltrarPisoAgenteForm)datosBusqueda).getMetrosMin();
		String metrosMax=((FiltrarPisoAgenteForm)datosBusqueda).getMetrosMax();
		String precioMin =((FiltrarPisoAgenteForm)datosBusqueda).getPrecioMin();
		String precioMax =((FiltrarPisoAgenteForm)datosBusqueda).getPrecioMax();
		
		//se crea el empleado bean	y se meten todos los datos excepto el precio y los metros
		//que son los que pueden variar
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
		
		//caso en el que se rellena el precio y no se rellenan los metros
		if ( !(precioMin.equals("")) && !(precioMin.equals(null)) &&
			 !(precioMax.equals("")) && !(precioMax.equals(null)) &&
			 ( metrosMin.equals("")|| metrosMin.equals(null)) &&
			 (metrosMax.equals("") || metrosMax.equals(null))){
			
			if (log.isInfoEnabled()){
				log.info("FiltrarPisoAgenteAction 1: Antes de entrar en la base de datos");
			}
			
			try{
				datos = gestorInmueble.BusquedaDetalladaConPrecio(precioMin,precioMax);
			}catch (Exception e){
				if (log.isInfoEnabled()){
					log.info("FiltrarPisoAgenteAction 2: Ha habido un error en la búsqueda en la bbdd");
					log.info(e);
				}
				return datos;
			}
			if (log.isInfoEnabled()){
				log.info("FiltrarPisoAgenteAction 3: Exito");
			}
			return datos;
		}
		
		//caso en el que se rellenan los metros y no se rellena el precio
		if ( !(metrosMin.equals("")) && !(metrosMin.equals(null)) &&
				 !(metrosMax.equals("")) && !(metrosMax.equals(null)) &&
				 ( precioMin.equals("")|| precioMin.equals(null)) &&
				 (precioMax.equals("") || precioMax.equals(null))){
			
			if (log.isInfoEnabled()){
				log.info("FiltrarPisoAgenteAction 1: Antes de entrar en la base de datos");
			}
			
			try{
				datos = gestorInmueble.BusquedaDetalladaConMetros(metrosMin,metrosMax);
			}catch (Exception e){
				if (log.isInfoEnabled()){
					log.info("FiltrarPisoAgenteAction 2: Ha habido un error en la búsqueda en la bbdd");
					log.info(e);
				}
				return datos;
			}
			if (log.isInfoEnabled()){
				log.info("FiltrarPisoAgenteAction 3: Exito");
			}
			return datos;
				
			}
		
		//caso en el que se rellenan los dos (precio y metros)
		if ( !(metrosMin.equals("")) && !(metrosMin.equals(null)) &&
				 !(metrosMax.equals("")) && !(metrosMax.equals(null)) &&
				 !(precioMin.equals("")) && !(precioMin.equals(null)) &&
				 !(precioMax.equals(""))  && !(precioMax.equals(null))){
				
			if (log.isInfoEnabled()){
				log.info("FiltrarPisoAgenteAction 1: Antes de entrar en la base de datos");
			}
			
			try{
				datos = gestorInmueble.BusquedaDetalladaMetrosPrecio(metrosMin,metrosMax,precioMin,precioMax);
			}catch (Exception e){
				if (log.isInfoEnabled()){
					log.info("FiltrarPisoAgenteAction 2: Ha habido un error en la búsqueda en la bbdd");
					log.info(e);
				}
				return datos;
			}
			if (log.isInfoEnabled()){
				log.info("FiltrarPisoAgenteAction 3: Exito");
			}
			return datos;
				
			}
		
		//caso en el que no se rellena ninguno
		if ( (metrosMin.equals("") || metrosMin.equals(null)) &&
				(metrosMax.equals("") || metrosMax.equals(null)) &&
				(precioMin.equals("") || precioMin.equals(null)) &&
				(precioMax.equals("") ||precioMax.equals(null))){
				
			if (log.isInfoEnabled()){
				log.info("FiltrarPisoAgenteAction 1: Antes de entrar en la base de datos");
			}
			
			try{
				datos = gestorInmueble.BusquedaDetallada();
			}catch (Exception e){
				if (log.isInfoEnabled()){
					log.info("FiltrarPisoAgenteAction 2: Ha habido un error en la búsqueda en la bbdd");
					log.info(e);
				}
				return datos;
			}
			if (log.isInfoEnabled()){
				log.info("FiltrarPisoAgenteAction 3: Exito");
			}
			return datos;	
			}
		return datos;
	}
		
	
	public ActionForm dameDatos (String id){
		return null;
	}
}
