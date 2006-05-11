package com.inmobis.bajas;

import org.apache.struts.action.ActionForm;
import com.inmobis.struts.form.BorraEmpleadoForm;
import org.apache.log4j.Logger;
import com.inmobis.bbdd.empleado.EmpleadoBD;
import com.inmobis.bbdd.empleado.EmpleadoBean;
import com.inmobis.struts.action.BorraClienteAction;


public class EliminarEmpleado extends Eliminar{
	
	private static final Logger log = Logger.getLogger(BorraClienteAction.class);
	
	public boolean validarRegistrado(ActionForm id){	
		//se crea un Bean para el empleado 
		EmpleadoBean empleado = new EmpleadoBean();
		empleado.setIdEmpleado(((BorraEmpleadoForm)id).getIdEmpleado());
		//se crea un empleado de la base de datos
		EmpleadoBD empleadobd = new EmpleadoBD(empleado);
		//mensajes para ver los errores
		if (log.isInfoEnabled()){
			log.info("EliminarEmpleado1: Antes de la BDD tengo idEmpleado: "+ ((EmpleadoBean)empleadobd.getBean()).getIdEmpleado());
			log.info("EliminarEmpleado2: Voy a entrar en la base de datos, para validar");
		}
		//miro a ver si el empleado está en la BBDD
		try {
			empleadobd.select();
		} catch (Exception E) {
			if (log.isInfoEnabled()){
				log.info("EliminarEmpleado3: no ha visto al empleado en la base de datos");
			}
			return false;
		}
		
		if (log.isInfoEnabled()){
			log.info("EliminarEmpleado4:Nombre del empleado:  "+ ((EmpleadoBean)empleadobd.getBean()).getNombreEmpleado()+
				"Apellido1: " + ((EmpleadoBean)empleadobd.getBean()).getApellido1()+ 
				"Apellido2: " + ((EmpleadoBean)empleadobd.getBean()).getApellido2()+
				"Fecha de Nacimiento: " + ((EmpleadoBean)empleadobd.getBean()).getFechNacimiento() + 
				"Identificador del empleado" + ((EmpleadoBean)empleadobd.getBean()).getIdEmpleado());
			log.info("NombreBean5: "+((EmpleadoBean)empleadobd.getBean()).getNombreEmpleado());
		}
		return true;
	}
	
	public boolean eliminarDesdeED(ActionForm id){	
		//se crea un Bean empleado
		EmpleadoBean empleado = new EmpleadoBean();
		empleado.setIdEmpleado(((BorraEmpleadoForm)id).getIdEmpleado());
		//se crea empleado de la base de datos
		EmpleadoBD emple = new EmpleadoBD (empleado);
		//mensajes de error del log
		if (log.isInfoEnabled()){
			log.info("EliminarEmpleado6:Antes de la BDD tengo idEmpleado: "+ empleado.getIdEmpleado());
			log.info("EliminarEmpleado7:voy a entrar en la base de datos para borrar al empleado");
		}
		//se borra el empleado
		try {
			emple.delete();
		} catch (Exception E) {
			if (log.isInfoEnabled()){
				log.info("EliminarEmpleado8:ha lanzado una excepción y no ha eliminado al empleado");
			}
			return false;
		}
		if (log.isInfoEnabled()){
			log.info("EliminarEmpleado9:se ha eliminado con exito");
		}
		return true;
	}
}
