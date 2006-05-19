package com.inmobis.consultas;

import java.util.Vector;

import org.apache.struts.action.ActionForm;
import com.inmobis.bbdd.CreadorGestores;
import com.inmobis.bbdd.BDObject;
import com.inmobis.bbdd.empleado.*;
import com.inmobis.bbdd.cliente.*;
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
		error.add(new Integer(1));
		//se crea el cliente bean
		
		/*c.setNombre(((FiltrarClienteForm)datosBusqueda).getNombreCliente());
		c.setApellido1(((FiltrarClienteForm)datosBusqueda).getApellido1());
		c.setApellido2(((FiltrarClienteForm)datosBusqueda).getApellido2());
		c.setFechNacimiento(((FiltrarClienteForm)datosBusqueda).getFechaNacimiento());
		c.setIdCliente(((FiltrarClienteForm)datosBusqueda).getIdCliente());
		c.setDni(((FiltrarClienteForm)datosBusqueda).getDniCliente());*/
		
		 
		
		

		
		
		
		
		try{
			
			if (datosBusqueda.getClass().equals("VerClientesPrevForm"))
			{
			/*if ((((FiltrarClienteForm)datosBusqueda).getNombreCliente()).equals("") &&
					(((FiltrarClienteForm)datosBusqueda).getApellido1()).equals("") &&
					(((FiltrarClienteForm)datosBusqueda).getApellido2()).equals("") &&
					(((FiltrarClienteForm)datosBusqueda).getFechaNacimiento()).equals("") &&
					(((FiltrarClienteForm)datosBusqueda).getIdCliente()).equals("") &&
					(((FiltrarClienteForm)datosBusqueda).getDniCliente()).equals("")datosBusqueda.equals(null)){*/
		
				if (((VerClientesPrevForm)datosBusqueda).isEsBusqueda()==false)
				{
				
					ClienteBean c = new ClienteBean();
					c.setNombre("");
					c.setApellido1("");
					c.setApellido2("");
					c.setFechNacimiento("");
					c.setIdCliente("");
					c.setDni("");
				
					//					LLamada al gestor de la base de datos
					GestorClienteBD gestorCliente= (GestorClienteBD)CreadorGestores.crearGestor("cliente",c);
				
				
					datos = gestorCliente.listarClientes();				
				}
			}
			/*else {
			   if (datosBusqueda.getClass().equals("VerClientesAgentePrevForm"))
				//AgenteBean a = new AgenteBean();
			   {
				   EmpleadoBean a = new EmpleadoBean();				
				
				
				   a.setNombre(((FiltrarClienteForm)datosBusqueda).getNombreCliente());
				   a.setApellido1(((FiltrarClienteForm)datosBusqueda).getApellido1());
				   a.setApellido2(((FiltrarClienteForm)datosBusqueda).getApellido2());
				   a.setFechNacimiento(((FiltrarClienteForm)datosBusqueda).getFechaNacimiento());
				   a.setIdEmpleado(((FiltrarClienteForm)datosBusqueda).getIdCliente());
				   a.setIdDni(((FiltrarClienteForm)datosBusqueda).getDniCliente());
				
				   GestorEmpleadoBD gestorAgente = (GestorEmpleadoBD)CreadorGestores.crearGestor("agente",a);				
				
				   datos = gestorAgente.BusquedaDetallada();
			   }
		    }*/
		}catch (Exception E){
			if(log.isInfoEnabled()){
				log.info("ConsultarCliente 3: Fallo en la busqueda en la base de datos " );
			}
			return error;//si hay un error en la base de datos devuelve un vector con un elemento que indica error
		}
		return datos;
	}
	
	public static void main(String [] args){
		Consultar  c= new ConsultarCliente();
		ActionForm f =null;
		Vector r = c.listar(f);
		
		int i=0;
		while(i<r.size()){
			System.out.println("Nombre: "+ ((ClienteBean)((ClienteBD)((ClienteBD)r.get(i)).getBean()).getBean()).getNombreCliente()+
					 "Apellido1: " + ((ClienteBean)((ClienteBD)((ClienteBD)r.get(i)).getBean()).getBean()).getApellido1() + 
					 "Apellido2: " + ((ClienteBean)((ClienteBD)((ClienteBD)r.get(i)).getBean()).getBean()).getApellido2()+ 
					 "Fecha de Nacimiento: " + ((ClienteBean)((ClienteBD)((ClienteBD)r.get(i)).getBean()).getBean()).getFechNacimiento() + 
					 "identificador: " + ((ClienteBean)((ClienteBD)((ClienteBD)r.get(i)).getBean()).getBean()).getIdCliente());
		}
		
	}
}
