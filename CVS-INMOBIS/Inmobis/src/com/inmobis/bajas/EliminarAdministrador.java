package com.inmobis.bajas;

import com.inmobis.struts.action.BorraEmpleadoAction;
import com.inmobis.struts.form.*;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import com.inmobis.bbdd.empleado.EmpleadoBD;
import com.inmobis.bbdd.empleado.EmpleadoBean;



public class EliminarAdministrador extends EliminarEmpleado{
	
	private static final Logger log = Logger.getLogger(BorraEmpleadoAction.class);
	
	public boolean unico(String id) {
		EmpleadoBean empleado = new EmpleadoBean();
		empleado.setIdEmpleado(id);
		EmpleadoBD emple = new EmpleadoBD (empleado);
		
		int numAdmin;
		try{
			numAdmin = emple.getNumAdmin();
			if (log.isInfoEnabled()){
				log.info("EliminarAdministrador1: Número de administradores en la bd: "+ numAdmin);
			}
		}catch(Exception E){
			if (log.isInfoEnabled()){
				log.info("EliminarAdministrador2: Ha habido un error mirando el número de administradores");
			}
			return true;
		}
		if (numAdmin == 1){
			if (log.isInfoEnabled()){
				log.info("EliminarAdministrador3: Hay un solo administrador en la bd");
			}
			return true;
		}
		else{
			if (numAdmin == 0){
				if (log.isInfoEnabled()){
					log.info("EliminarAdministrador4: No hay administradores en la base de datos");
				}
				return false;
			}
			else{
				if (log.isInfoEnabled()){
					log.info("EliminarAdministrador5: hay más de un administrador en la bd");
				}
				return false;
			}	
		}
	}
	public boolean eliminarDesdeED(ActionForm id){
		//se crea el empleado Bean
		EmpleadoBean empleado = new EmpleadoBean();
		empleado.setIdEmpleado(((BorraEmpleadoForm)id).getIdEmpleado());
		//se crea el empleado base de datos
		EmpleadoBD emple = new EmpleadoBD (empleado);
		//información para errores
		if (log.isInfoEnabled()){
			log.info("EliminarAdministrador6: antes de comprobar si es unico");
		}
		//se comprueba si el administrador es unico
		if (!unico(((EmpleadoBean)emple.getBean()).getIdEmpleado())){
			try {
				emple.delete();
				if (log.isInfoEnabled()){
					log.info("EliminarAdministrador7: se ha eliminado el administrador de la bd");
				}
			} catch (Exception E) {
				if (log.isInfoEnabled()){
					log.info("EliminarAdministrador8: No ha sido posible eliminar al administrador (error en la bd)");
				}
				return false;
			}
			return true;
		}
		else{
			if (log.isInfoEnabled()){
				log.info("EliminarAdministrador9: Hay un solo administrador y no se ha eliminado");
			}
			return false;	
		}
	}
}
