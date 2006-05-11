package com.inmobis.bajas;


import org.apache.log4j.Logger;
import com.inmobis.struts.form.*;
import com.inmobis.bbdd.cliente.*;
import com.inmobis.struts.action.BorraClienteAction;
import org.apache.struts.action.ActionForm;


public class EliminarCliente extends Eliminar{
	
	private static final Logger log = Logger.getLogger(BorraClienteAction.class);
	
	public boolean validarRegistrado(ActionForm id){		
		//se crea un cliente Bean
		ClienteBean cliente = new ClienteBean();
		cliente.setIdCliente(((BorraClienteForm) id).getIDUsuario());
		//se crea el cliente de la base de datos
		ClienteBD clientebd = new ClienteBD(cliente);
		//para ver los errores
		if (log.isInfoEnabled()){
			log.info("EliminarCliente1: Antes de la BDD tengo idCliente: "+ cliente.getIdCliente());
			log.info("EliminarCliente2: Voy a entrar en la base de datos, para validar");
		}
		//se mira a ver si está el cliente en la BBDD
		try {
			clientebd.select();
		} catch (Exception e) {
			if (log.isInfoEnabled()){
				log.info("EliminarCliente3: no ha visto al cliente en la base de datos");
			}
			return false;
		}
		if (log.isInfoEnabled()){
			log.info("EliminarCliente4:Nombre del cliente:  "+ ((ClienteBean)clientebd.getBean()).getNombreCliente()+
				"Apellido1: " + ((ClienteBean)clientebd.getBean()).getApellido1()+ 
				"Apellido2: " + ((ClienteBean)clientebd.getBean()).getApellido2()+
				"Fecha de Nacimiento: " + ((ClienteBean)clientebd.getBean()).getFechNacimiento() + 
				"Identificador del cliente" + ((ClienteBean)clientebd.getBean()).getIdCliente());
			log.info("NombreBean5: "+((ClienteBean)clientebd.getBean()).getNombreCliente());
		}
		return true;
	}
	
	public boolean eliminarDesdeED(ActionForm id){	
		//se crea un cliente Bean
		ClienteBean cliente = new ClienteBean();
		cliente.setIdCliente(((BorraClienteForm)id).getIDUsuario());
		//se crea un cliente de la BBDD
		ClienteBD client = new ClienteBD (cliente);
		//Para ver los errores
		if (log.isInfoEnabled()){
			log.info("EliminarCliente6:Antes de la BDD tengo idCliente: "+ cliente.getIdCliente());
			log.info("EliminarCliente7:voy a entrar en la base de datos para borrar al cliente");
		}
		//se borra el cliente
		try {
			client.delete();
		} catch (Exception e) {
			if (log.isInfoEnabled()){
				log.info("EliminarCliente8:ha lanzado una excepción y no ha eliminado al cliente");
			}
			return false;
		}
		if (log.isInfoEnabled()){
			log.info("EliminarEmpleado9: se ha eliminado con exito");
		}
		return true;
	}

}
