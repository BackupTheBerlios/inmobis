package com.inmobis.consultas;

import java.util.Vector;

import org.apache.struts.action.ActionForm;
import com.inmobis.bbdd.CreadorGestores;
import com.inmobis.bbdd.empleado.EmpleadoBD;
import com.inmobis.bbdd.empleado.EmpleadoBean;
import com.inmobis.bbdd.empleado.GestorEmpleadoBD;
import com.inmobis.struts.form.*;
import org.apache.log4j.Logger;


public class ConsultarAgente extends Consultar{

	private static final Logger log = Logger.getLogger(ConsultarAgente.class);
	
	public Vector listar(ActionForm datosBusqueda){
		//Vector para guardar la lista que me devuelve la base de datos
		Vector datos = new Vector();
		
		//se crea el empleado bean		
		EmpleadoBean e = new EmpleadoBean();
		
		e.setIdEmpleado(((FiltrarEmpleadoForm)datosBusqueda).getIdEmpleado());
		e.setNombre(((FiltrarEmpleadoForm)datosBusqueda).getNombreEmpleado());
		e.setApellido1(((FiltrarEmpleadoForm)datosBusqueda).getApellido1());
		e.setApellido2(((FiltrarEmpleadoForm)datosBusqueda).getApellido2());
		e.setFechNacimiento(((FiltrarEmpleadoForm)datosBusqueda).getFechaNacimiento());	
		e.setIdDni(((FiltrarEmpleadoForm)datosBusqueda).getDniEmpleado());	
		
		//se crea el empleado dase de datos		
		GestorEmpleadoBD gestorAgente = (GestorEmpleadoBD) CreadorGestores.crearGestor("empleado",e);
		
		if(log.isInfoEnabled()){
			log.info("ConsultarAgente 1: Antes de entrar en la base de datos " );
			log.info("ConsultarAgente 2:  " +					 
					 "identificador: " + ((EmpleadoBean)gestorAgente.getBean()).getIdEmpleado());
		}
		
		try{
			if (((FiltrarEmpleadoForm)datosBusqueda).getIdEmpleado().equals("") &&
			    ((FiltrarEmpleadoForm)datosBusqueda).getNombreEmpleado().equals("") &&
			    ((FiltrarEmpleadoForm)datosBusqueda).getApellido1().equals("") &&
			    ((FiltrarEmpleadoForm)datosBusqueda).getApellido2().equals("") &&
			    ((FiltrarEmpleadoForm)datosBusqueda).getFechaNacimiento().equals("") &&
			    ((FiltrarEmpleadoForm)datosBusqueda).getDniEmpleado().equals(""))
			    datos = ((EmpleadoBD)gestorAgente.getBean()).listarEmpleados();
			else datos = ((EmpleadoBD)gestorAgente.getBean()).BusquedaDetallada();
			
		}catch (Exception E){
			if(log.isInfoEnabled()){
				log.info("ConsultarAgente 3: Fallo en la busqueda en la base de datos " );
			}
			return datos;//si hay un error en la base de datos devuelve un vector con un elemento que indica error
		}
		return datos;
	}
	
}
