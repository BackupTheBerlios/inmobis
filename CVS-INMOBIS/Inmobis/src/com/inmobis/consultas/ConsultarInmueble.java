package com.inmobis.consultas;

import java.util.*;

import org.apache.struts.action.ActionForm;
import org.apache.log4j.Logger;

import com.inmobis.bbdd.direccion.InfoDirBean;
import com.inmobis.bbdd.empleado.AgenteBD;
import com.inmobis.bbdd.empleado.AgenteBean;
import com.inmobis.bbdd.empleado.EmpleadoBean;
import com.inmobis.bbdd.empleado.GestorEmpleadoBD;
import com.inmobis.bbdd.inmueble.GestorInmuebleBD;
import com.inmobis.bbdd.inmueble.InmuebleBean;
import com.inmobis.bbdd.empleado.GestorContableBD;
import com.inmobis.bbdd.empleado.ContableBD;
import com.inmobis.bbdd.inmueble.VentasBean;

import com.inmobis.bbdd.*;
import com.inmobis.struts.form.*;

public class ConsultarInmueble extends Consultar{
	
	private static final Logger log = Logger.getLogger(ConsultarInmueble.class);
	
	public Vector listar(ActionForm datosBusqueda){
		//Vector para guardar la lista que me devuelve la base de datos
		Vector datos = new Vector();
		
		//se crea el bean del inmueble
		InmuebleBean inmueble = new InmuebleBean();
		//se crea el inmueble dase de datos	
		GestorInmuebleBD gestorInmueble=(GestorInmuebleBD)CreadorGestores.crearGestor("inmueble",inmueble);
		
		try{
			if(log.isInfoEnabled()){
				log.info("ConsultarInmueble 1: Se van a listar todos los inmuebles disponibles en la bd " );
			}
			datos = gestorInmueble.listarInmuebles();
		}catch (Exception E){
			if(log.isInfoEnabled()){
				log.info("ConsultarInmueble 2: Fallo en la busqueda en la base de datos " );
			}
			return datos;
		}

		if(log.isInfoEnabled()){
			log.info("ConsultarInmueble 3: Exito " );
		}
		return datos;	
	}
	
	public Vector listarPisosAgente(ActionForm datosBusqueda){
//		Vector para guardar la lista que me devuelve la base de datos
		Vector datos = new Vector();
//		se crea un bean del agente
		AgenteBean e = new AgenteBean();
		e.setIdAgente(((VerPisosAgenteForm)datosBusqueda).getIdAgente());
		//LLamada al gestor de la base de datos 
		AgenteBD agente = new AgenteBD(e);
		
		try{
			if(log.isInfoEnabled()){
				log.info("ConsultarInmueble 4: Se van a listar todos los inmuebles del agente disponibles en la bd " );
			}
			datos = agente.listarInmueblesAgentes();
		}catch (Exception E){
			if(log.isInfoEnabled()){
				log.info("ConsultarInmueble 5: Fallo en la busqueda en la base de datos " );
			}
			return datos;
		}
		if(log.isInfoEnabled()){
			log.info("ConsultarInmueble 6: Exito " );
		}
	return datos;
	}
	
	public Vector filtrarPisosVendidos(ActionForm datosBusqueda){
        //Vector para guardar el resultado de la búsqueda
		Vector datos= new Vector();
		//crear el bean
		VentasBean pisoVend = new VentasBean();
		
		//se rellean el bean con los datos que se han recogido del formulario
		if (!(((VerPisosVendidosForm)datosBusqueda).getFechFin().equals(null)) &&
				!(((VerPisosVendidosForm)datosBusqueda).getFechFin().equals("")))
			pisoVend.setFechaHasta(((VerPisosVendidosForm)datosBusqueda).getFechFin());
		if (!(((VerPisosVendidosForm)datosBusqueda).getFechIni().equals(null)) &&
				!(((VerPisosVendidosForm)datosBusqueda).getFechIni().equals("")))
			pisoVend.setFechaDesde(((VerPisosVendidosForm)datosBusqueda).getFechIni());
		if (!(((VerPisosVendidosForm)datosBusqueda).getFechVenta().equals(null)) &&
				!(((VerPisosVendidosForm)datosBusqueda).getFechVenta().equals("")))
			pisoVend.setFechVenta(((VerPisosVendidosForm)datosBusqueda).getFechVenta());
		if (!(((VerPisosVendidosForm)datosBusqueda).getGanacia().equals(null)) &&
				!(((VerPisosVendidosForm)datosBusqueda).getGanacia().equals("")))
			pisoVend.setGanancia(((VerPisosVendidosForm)datosBusqueda).getGanacia());
		if (!(((VerPisosVendidosForm)datosBusqueda).getIdAgente().equals(null)) &&
				!(((VerPisosVendidosForm)datosBusqueda).getIdAgente().equals("")))
			pisoVend.setIdAgente(((VerPisosVendidosForm)datosBusqueda).getIdAgente());
		if (!(((VerPisosVendidosForm)datosBusqueda).getIdInmueble().equals(null)) &&
				!(((VerPisosVendidosForm)datosBusqueda).getIdInmueble().equals("")))
			pisoVend.setIdInmueble(((VerPisosVendidosForm)datosBusqueda).getIdInmueble());
		if (!(((VerPisosVendidosForm)datosBusqueda).getPrecioFinal().equals(null)) &&
				!(((VerPisosVendidosForm)datosBusqueda).getPrecioFinal().equals("")))
			pisoVend.setPrecioFinal(((VerPisosVendidosForm)datosBusqueda).getPrecioFinal());
		if (!(((VerPisosVendidosForm)datosBusqueda).getPrecioInicial().equals(null)) &&
				!(((VerPisosVendidosForm)datosBusqueda).getPrecioInicial().equals("")))
			pisoVend.setPrecioInicial(((VerPisosVendidosForm)datosBusqueda).getPrecioInicial());
		
		
		
		//se crea el empleado dase de datos		
		GestorContableBD gestorContable = (GestorContableBD) CreadorGestores.crearGestor("contable",pisoVend);
		
		try{
			datos=gestorContable.BusquedaDetallada(pisoVend);
		}catch (Exception E){
			if(log.isInfoEnabled()){
				log.info("ConsultarImueble 2: Fallo en la busqueda en la base de datos " );
			}
			return datos;
		}
		if(log.isInfoEnabled()){
			log.info("ConsultarInmueble 3: Exito " );
		}
		return datos;
	}
	
	public Vector listarPisosVendidos(ActionForm datosBusqueda){
		//Vector para guardar la lista que me devuelve la base de datos
		Vector datos = new Vector();
		
		//se crea el bean del inmueble
		VentasBean inmuebleVen = new VentasBean();
		//se crea el inmueble dase de datos	
		//GestorContableBD gestorContable=(GestorContableBD)CreadorGestores.crearGestor("contable",inmuebleVen);
		ContableBD gestorContable = new ContableBD();
		
		try{
			if(log.isInfoEnabled()){
				log.info("ConsultarInmueble 1: Se van a listar todos los inmuebles vendidos disponibles en la bd " );
			}
			datos = gestorContable.listadoVentas();
		}catch (Exception E){
			if(log.isInfoEnabled()){
				log.info("ConsultarInmueble 2: Fallo en la busqueda en la base de datos de los inmuebles vendidos " );
			}
			return datos;
		}

		if(log.isInfoEnabled()){
			log.info("ConsultarInmueble 3: Exito en el listado de los inmuebles vendidos. " );
		}
		return datos;	
	}
	
	public static void main(String [] args){
		ConsultarInmueble i = new ConsultarInmueble();
		ActionForm form = null;
		i.listarPisosVendidos(form);
	}
	
	public ActionForm dameDatos (String id){
		
		//form que va a tener los datos y se va a devolver
		EditaPisoForm form=new EditaPisoForm();
		
		//se crea un inmueble bean
		InmuebleBean inmueble=new InmuebleBean();
		inmueble.setIdInmueble(id);

		GestorInmuebleBD gestorInmueble= (GestorInmuebleBD)CreadorGestores.crearGestor("inmueble",inmueble);
		
		InfoDirBean direccion=new InfoDirBean();
		
		try {
			gestorInmueble.consultaDirPorId(id);
			direccion=gestorInmueble.getDireccionBean();
		} catch (RowNotFoundException e) {
			if(log.isInfoEnabled())
				log.info("Error1: "+e );
		}
		
		try {
			gestorInmueble.select();
		} catch (RowNotFoundException e) {
			if(log.isInfoEnabled())
				log.info("Error2: "+e );
		}
		
		inmueble=(InmuebleBean)gestorInmueble.getBean();
		
		if(log.isInfoEnabled())
			log.info("direccion "+direccion.getCalle() );
		if(log.isInfoEnabled())
			log.info("tipo "+inmueble.getTipo() );
		
		form.setCalle(direccion.getCalle());
		form.setCodPostal(direccion.getCodPostal());
		form.setNum(direccion.getNum());
		form.setPais(direccion.getPais());
		form.setPiso(direccion.getPiso());
		form.setPoblacion(direccion.getPoblacion());
		form.setProvincia(direccion.getProvincia());
		form.setCodPostal(direccion.getCodPostal());
		form.setDatosDeInteres(inmueble.getdatosDeInteres());
		form.setMetros(inmueble.getMetros());
		form.setIdInmueble(inmueble.getIdInmueble());
		form.setNumHab(inmueble.getNumHab());
		form.setPrecio(inmueble.getPrecio());
		form.setRegimen(inmueble.getRegimen());
		form.setTipo(inmueble.getTipo());
		form.setZona(inmueble.getZona());
		
		
		return form;
	}
}
