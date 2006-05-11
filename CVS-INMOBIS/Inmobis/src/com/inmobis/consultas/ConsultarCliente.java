package com.inmobis.consultas;

import java.util.Vector;

import org.apache.struts.action.ActionForm;
import com.inmobis.bbdd.CreadorGestores;
import com.inmobis.bbdd.BDObject;
import com.inmobis.bbdd.cliente.ClienteBD;
import com.inmobis.bbdd.cliente.ClienteBean;
import com.inmobis.bbdd.cliente.GestorClienteBD;
import com.inmobis.struts.form.*;
import com.inmobis.struts.action.*;
import org.apache.log4j.Logger;


public class ConsultarCliente extends Consultar{
	
	private static final Logger log = Logger.getLogger(FiltrarClienteAction.class);
	
	public Vector listar(ActionForm datosBusqueda){
		//Vector para guardar la lista que me devuelve la base de datos
		Vector datos = new Vector();
		//se crea un vector para devolver en cado de error
		Vector error = new Vector();
		error.addElement(new Integer(1));
		//se crea el cliente bean
		ClienteBean c = new ClienteBean();
		c.setNombre(((FiltrarClienteForm)datosBusqueda).getNombreCliente());
		c.setApellido1(((FiltrarClienteForm)datosBusqueda).getApellido1());
		c.setApellido2(((FiltrarClienteForm)datosBusqueda).getApellido2());
		c.setFechNacimiento(((FiltrarClienteForm)datosBusqueda).getFechaNacimiento());
		c.setIdCliente(((FiltrarClienteForm)datosBusqueda).getIdCliente());
		c.setDni(((FiltrarClienteForm)datosBusqueda).getDniCliente());
		
		//LLamada al gestor de la base de datos 
		//CreadorGestores creador = new CreadorGestores();
		GestorClienteBD gestorCliente= (GestorClienteBD)CreadorGestores.crearGestor("cliente",c);

		
		if(log.isInfoEnabled()){
			log.info("ConsultarCliente 1: Antes de entrar en la base de datos " );
			log.info("ConsultarCliente 2:  " +
					"Nombre: "+ ((ClienteBean)((ClienteBD)gestorCliente.getBean()).getBean()).getNombreCliente()+
					 "Apellido1: " + ((ClienteBean)((ClienteBD)gestorCliente.getBean()).getBean()).getApellido1() + 
					 "Apellido2: " + ((ClienteBean)((ClienteBD)gestorCliente.getBean()).getBean()).getApellido2()+ 
					 "Fecha de Nacimiento: " + ((ClienteBean)((ClienteBD)gestorCliente.getBean()).getBean()).getFechNacimiento() + 
					 "identificador: " + ((ClienteBean)((ClienteBD)gestorCliente.getBean()).getBean()).getIdCliente());
		}
		
		try{
			if (datosBusqueda.equals(null))
				datos = ((ClienteBD)gestorCliente.getBean()).listarClientes();
			else datos = ((ClienteBD)gestorCliente.getBean()).BusquedaDetallada();
		}catch (Exception E){
			if(log.isInfoEnabled()){
				log.info("ConsultarCliente 3: Fallo en la busqueda en la base de datos " );
			}
			return error;//si hay un error en la base de datos devuelve un vector con un elemento que indica error
		}
		return datos;
	}	
}
