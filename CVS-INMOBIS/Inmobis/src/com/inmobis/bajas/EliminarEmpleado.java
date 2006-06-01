package com.inmobis.bajas;

import org.apache.struts.action.ActionForm;
import com.inmobis.struts.form.BorraEmpleadoPrevForm;
import com.inmobis.struts.form.BorraEmpleadoForm;
import org.apache.log4j.Logger;
import com.inmobis.bbdd.CreadorGestores;
import com.inmobis.bbdd.empleado.GestorEmpleadoBD;
import com.inmobis.bbdd.empleado.EmpleadoBean;
import com.inmobis.struts.action.BorraClienteAction;


public class EliminarEmpleado extends Eliminar{
	
	private static final Logger log = Logger.getLogger(BorraClienteAction.class);
	
	public boolean validarRegistrado(ActionForm id){	
		//se crea un Bean para el empleado 
		EmpleadoBean empleado = new EmpleadoBean();
		empleado.setIdEmpleado(((BorraEmpleadoPrevForm)id).getIdEmpleado());
		//se crea un empleado de la base de datos
		GestorEmpleadoBD gestorEmpleado = (GestorEmpleadoBD)CreadorGestores.crearGestor("empleado",empleado);
		//mensajes para ver los errores
		if (log.isInfoEnabled()){
			log.info("EliminarEmpleado1: Antes de la BDD tengo idEmpleado: "+ ((EmpleadoBean)gestorEmpleado.getBean()).getIdEmpleado());
			log.info("EliminarEmpleado2: Voy a entrar en la base de datos, para validar");
		}
		//miro a ver si el empleado está en la BBDD
		try {
			gestorEmpleado.select();
		} catch (Exception E) {
			if (log.isInfoEnabled()){
				log.info("EliminarEmpleado3: no ha visto al empleado en la base de datos");
			}
			return false;
		}
		
		if (log.isInfoEnabled()){
			log.info("EliminarEmpleado4:Nombre del empleado:  "+ ((EmpleadoBean)gestorEmpleado.getBean()).getNombre()+
				"Apellido1: " + ((EmpleadoBean)gestorEmpleado.getBean()).getApellido1()+ 
				"Apellido2: " + ((EmpleadoBean)gestorEmpleado.getBean()).getApellido2()+
				"Fecha de Nacimiento: " + ((EmpleadoBean)gestorEmpleado.getBean()).getFechNacimiento() + 
				"Identificador del empleado" + ((EmpleadoBean)gestorEmpleado.getBean()).getIdEmpleado());
			log.info("NombreBean5: "+((EmpleadoBean)gestorEmpleado.getBean()).getNombre());
		}
		return true;
	}
	
	public boolean eliminarDesdeED(ActionForm id){	
		//se crea un Bean empleado
		EmpleadoBean empleado = new EmpleadoBean();
		empleado.setIdEmpleado(((BorraEmpleadoForm)id).getIdEmpleado());
		//se crea empleado de la base de datos
		GestorEmpleadoBD gestorEmpleado = (GestorEmpleadoBD)CreadorGestores.crearGestor("empleado",empleado);
		//mensajes de error del log
		if (log.isInfoEnabled()){
			log.info("EliminarEmpleado 6:Antes de la BDD tengo idEmpleado: "+ empleado.getIdEmpleado());
			log.info("EliminarEmpleado 7:voy a entrar en la base de datos para borrar al empleado");
		}
		//se borra el empleado
		try {
			gestorEmpleado.delete();
		} catch (Exception E) {
			if (log.isInfoEnabled()){
				log.info("EliminarEmpleado 8:ha lanzado una excepción y no ha eliminado al empleado");
			}
			return false;
		}
		if (log.isInfoEnabled()){
			log.info("EliminarEmpleado 9:se ha eliminado con exito");
		}
		return true;
	}
}
