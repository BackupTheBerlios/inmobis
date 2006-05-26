package com.inmobis.consultas;

import java.util.Vector;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;

import com.inmobis.bbdd.CreadorGestores;
import com.inmobis.bbdd.empleado.EmpleadoBean;
import com.inmobis.bbdd.empleado.GestorEmpleadoBD;
import com.inmobis.struts.form.FiltrarEmpleadoForm;;

public class ConsultarEmpleado extends Consultar{
	
	private static final Logger log = Logger.getLogger(ConsultarEmpleado.class);
	
	public Vector listar(ActionForm datosBusqueda){
		//Vector para guardar la lista que me devuelve la base de datos
		Vector datos = new Vector();
				
		//se crea el empleado bean		
		EmpleadoBean e = new EmpleadoBean();
		
		//se crea el empleado dase de datos		
		GestorEmpleadoBD gestorEmpleado = (GestorEmpleadoBD) CreadorGestores.crearGestor("empleado",e);
		
		if(log.isInfoEnabled()){
			log.info("ConsultarEmpleado 1: Antes de entrar en la base de datos " );
		}
		
		try{
			datos=gestorEmpleado.listarEmpleados();
		}catch (Exception E){
			if(log.isInfoEnabled()){
				log.info("ConsultarEmpleado 2: Fallo en la busqueda en la base de datos " );
			}
			return datos;
		}
		if(log.isInfoEnabled()){
			log.info("ConsultarEmpleado 3: Exito " );
		}
		return datos;
	}
	
	public Vector filtrarEmpleados (ActionForm datosBusqueda){
		//Vector para guardar el resultado de la búsqueda
		Vector datos= new Vector();
		//crear el bean
		EmpleadoBean e = new EmpleadoBean();
		
		//se rellean el bean con los datos que se han recogido del formulario
		if (!(((FiltrarEmpleadoForm)datosBusqueda).getApellido1().equals(null)) &&
				!(((FiltrarEmpleadoForm)datosBusqueda).getApellido1().equals("")))
			e.setApellido1(((FiltrarEmpleadoForm)datosBusqueda).getApellido1());
		if (!(((FiltrarEmpleadoForm)datosBusqueda).getApellido2().equals(null)) &&
				!(((FiltrarEmpleadoForm)datosBusqueda).getApellido2().equals("")))
			e.setApellido2(((FiltrarEmpleadoForm)datosBusqueda).getApellido2());
		if (!(((FiltrarEmpleadoForm)datosBusqueda).getDniEmpleado().equals(null)) &&
				!(((FiltrarEmpleadoForm)datosBusqueda).getDniEmpleado().equals("")))
			e.setIdDni(((FiltrarEmpleadoForm)datosBusqueda).getDniEmpleado());
		if (!(((FiltrarEmpleadoForm)datosBusqueda).getFechaNacimiento().equals(null)) &&
				!(((FiltrarEmpleadoForm)datosBusqueda).getFechaNacimiento().equals("")))
			e.setFechNacimiento(((FiltrarEmpleadoForm)datosBusqueda).getFechaNacimiento());
		if (!(((FiltrarEmpleadoForm)datosBusqueda).getNombreEmpleado().equals(null)) &&
				!(((FiltrarEmpleadoForm)datosBusqueda).getNombreEmpleado().equals("")))
			e.setNombre(((FiltrarEmpleadoForm)datosBusqueda).getNombreEmpleado());
		
		//se crea el empleado dase de datos		
		GestorEmpleadoBD gestorEmpleado = (GestorEmpleadoBD) CreadorGestores.crearGestor("empleado",e);
		
		try{
			datos=gestorEmpleado.BusquedaDetallada();
		}catch (Exception E){
			if(log.isInfoEnabled()){
				log.info("ConsultarEmpleado 2: Fallo en la busqueda en la base de datos " );
			}
			return datos;
		}
		if(log.isInfoEnabled()){
			log.info("ConsultarEmpleado 2: Exito " );
		}
		return datos;
		
	}
}
