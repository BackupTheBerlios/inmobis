package com.inmobis.bajas;


import org.apache.log4j.Logger;
import com.inmobis.struts.form.*;
import com.inmobis.bbdd.CreadorGestores;
import com.inmobis.bbdd.cliente.*;
import com.inmobis.struts.action.BorraClienteAction;
import org.apache.struts.action.ActionForm;


public class EliminarCliente extends Eliminar{
	
	private static final Logger log = Logger.getLogger(BorraClienteAction.class);
	
	public boolean validarRegistrado(ActionForm id){		
		//se crea un cliente Bean
		ClienteBean cliente = new ClienteBean();
		cliente.setIdCliente(((BorraClienteForm) id).getIdCliente());
		//se crea el cliente de la base de datos
		GestorClienteBD gestorCliente= (GestorClienteBD)CreadorGestores.crearGestor("cliente",cliente);
		//para ver los errores
		if (log.isInfoEnabled()){
			log.info("EliminarCliente1: Antes de la BDD tengo idCliente: "+ cliente.getIdCliente());
			log.info("EliminarCliente2: Voy a entrar en la base de datos, para validar");
		}
		//se mira a ver si está el cliente en la BBDD
		try {
			gestorCliente.select();
		} catch (Exception e) {
			if (log.isInfoEnabled()){
				log.info("EliminarCliente3: no ha visto al cliente en la base de datos");
			}
			return false;
		}
		if (log.isInfoEnabled()){
			log.info("EliminarCliente4: el cliente está en la base de datos");
		}
		return true;
	}
	
	public boolean eliminarDesdeED(ActionForm id){	
		//se crea un cliente Bean
		ClienteBean cliente = new ClienteBean();
		cliente.setIdCliente(((BorraClienteForm)id).getIdCliente());
		//se crea un cliente de la BBDD
		GestorClienteBD gestorCliente= (GestorClienteBD)CreadorGestores.crearGestor("cliente",cliente);
		//Para ver los errores
		if (log.isInfoEnabled()){
			log.info("EliminarCliente 6:Antes de la BDD tengo idCliente: "+ cliente.getIdCliente());
			log.info("EliminarCliente 7:voy a entrar en la base de datos para borrar al cliente");
		}
		//se borra el cliente
		try {
			gestorCliente.delete();
		} catch (Exception e) {
			if (log.isInfoEnabled()){
				log.info("EliminarCliente 8:ha lanzado una excepción y no ha eliminado al cliente");
			}
			return false;
		}
		if (log.isInfoEnabled()){
			log.info("EliminarEmpleado 9: se ha eliminado con exito");
		}
		return true;
	}
}
