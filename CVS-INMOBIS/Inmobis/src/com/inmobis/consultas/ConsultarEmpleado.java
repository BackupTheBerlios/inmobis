package com.inmobis.consultas;

import java.util.Vector;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;

import com.inmobis.bbdd.CreadorGestores;
import com.inmobis.bbdd.empleado.EmpleadoBD;
import com.inmobis.bbdd.empleado.EmpleadoBean;
import com.inmobis.bbdd.empleado.GestorEmpleadoBD;
import com.inmobis.struts.action.BorraEmpleadoAction;
import com.inmobis.struts.form.FiltrarEmpleadoForm;

public class ConsultarEmpleado extends Consultar{
	
	private static final Logger log = Logger.getLogger(ConsultarEmpleado.class);
	
	public Vector listar(ActionForm datosBusqueda){
		//Vector para guardar la lista que me devuelve la base de datos
		Vector datos = new Vector();
				
		//se crea el empleado bean		
		EmpleadoBean e = new EmpleadoBean();
		/*e.setIdEmpleado(((FiltrarEmpleadoForm)datosBusqueda).getIdEmpleado());
		e.setNombre(((FiltrarEmpleadoForm)datosBusqueda).getNombreEmpleado());
		e.setApellido1(((FiltrarEmpleadoForm)datosBusqueda).getApellido1());
		e.setApellido2(((FiltrarEmpleadoForm)datosBusqueda).getApellido2());
		e.setFechNacimiento(((FiltrarEmpleadoForm)datosBusqueda).getFechaNacimiento());		
		e.setIdDni(((FiltrarEmpleadoForm)datosBusqueda).getDniEmpleado());*/
		
		e.setIdEmpleado("");
		e.setNombre("");
		e.setApellido1("");
		e.setApellido2("");
		e.setFechNacimiento("");		
		e.setIdDni("");
		
		//se crea el empleado dase de datos		
		GestorEmpleadoBD gestorEmpleado = (GestorEmpleadoBD) CreadorGestores.crearGestor("empleado",e);
		
		/*if(log.isInfoEnabled()){
			log.info("ConsultarEmpleado 1: Antes de entrar en la base de datos " );
			log.info("ConsultarEmpleado 2:  " +
					"Nombre: "+ ((EmpleadoBean)gestorEmpleado.getBean()).getNombreEmpleado() +
					 "Apellido1: " + ((EmpleadoBean)gestorEmpleado.getBean()).getApellido1() + 
					 "Apellido2: " + ((EmpleadoBean)gestorEmpleado.getBean()).getApellido2() + 
					 "Fecha de Nacimiento: " + ((EmpleadoBean)gestorEmpleado.getBean()).getFechNacimiento() + 
					 "identificador: " + ((EmpleadoBean)gestorEmpleado.getBean()).getIdEmpleado()+
					 "dni: " + ((EmpleadoBean)gestorEmpleado.getBean()).getIdEmpleado());
		}*/
		
		try{
			/*if (((FiltrarEmpleadoForm)datosBusqueda).getIdEmpleado().equals("") &&
				    ((FiltrarEmpleadoForm)datosBusqueda).getNombreEmpleado().equals("") &&
				    ((FiltrarEmpleadoForm)datosBusqueda).getApellido1().equals("") &&
				    ((FiltrarEmpleadoForm)datosBusqueda).getApellido2().equals("") &&
				    ((FiltrarEmpleadoForm)datosBusqueda).getFechaNacimiento().equals("")&&
				    ((FiltrarEmpleadoForm)datosBusqueda).getDniEmpleado().equals("") ){*/
				EmpleadoBD cBD= new EmpleadoBD((EmpleadoBean)gestorEmpleado.getBean());
				datos=cBD.listarEmpleados();
			/*}
				//datos = ((EmpleadoBD)gestorEmpleado.getBean()).listarEmpleados();
			else datos = ((EmpleadoBD)gestorEmpleado.getBean()).BusquedaDetallada();	*/		
		}catch (Exception E){
			if(log.isInfoEnabled()){
				log.info("ConsultarEmpleado 3: Fallo en la busqueda en la base de datos " );
			}
			return datos;//si hay un error en la base de datos devuelve un vector con un elemento que indica error
		}
		return datos;
	}
}
