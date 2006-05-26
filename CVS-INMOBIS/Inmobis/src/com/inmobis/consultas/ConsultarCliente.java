package com.inmobis.consultas;

import java.util.Vector;

import org.apache.struts.action.ActionForm;
import com.inmobis.bbdd.CreadorGestores;
import com.inmobis.bbdd.RowNotFoundException;

import com.inmobis.bbdd.cliente.*;
import com.inmobis.bbdd.direccion.InfoDirBean;
import com.inmobis.bbdd.email.InfoMailBean;
import com.inmobis.bbdd.login.UsuarioLoginBean;
import com.inmobis.bbdd.telefono.InfoTelfBean;
import com.inmobis.struts.form.EditaClientePrevForm;
//import com.inmobis.struts.form.*;
//import com.inmobis.struts.action.*;
import org.apache.log4j.Logger;
//import com.inmobis.bbdd.RowNotFoundException;
//import com.inmobis.bbdd.direccion.InfoDirBean;
//import com.inmobis.bbdd.email.InfoMailBean;
//import com.inmobis.bbdd.login.UsuarioLoginBean;
//import com.inmobis.bbdd.telefono.InfoTelfBean;


public class ConsultarCliente extends Consultar{
	
	private static final Logger log = Logger.getLogger(ConsultarCliente.class);
	
	public UsuarioLoginBean getLogin(ActionForm datosCliente){
		ClienteBean cliente=new ClienteBean();
		cliente.setIdCliente(((EditaClientePrevForm)datosCliente).getIdUsuario());
		CreadorGestores creador = new CreadorGestores();
		GestorClienteBD gestorCliente= (GestorClienteBD)creador.crearGestor("cliente",cliente);
		UsuarioLoginBean login=new UsuarioLoginBean();
		try {
			gestorCliente.consultaLoginPorId(((EditaClientePrevForm)datosCliente).getIdUsuario());
			login=gestorCliente.getLoginBean();
		} catch (RowNotFoundException e) {
			if(log.isInfoEnabled())
				log.info("Error" );
		}
		if(log.isInfoEnabled())
			log.info("login "+login.getNombreUsuario() );
		return login;
	}
	
	public InfoDirBean getDir(ActionForm datosCliente){
		ClienteBean cliente=new ClienteBean();
		cliente.setIdCliente(((EditaClientePrevForm)datosCliente).getIdUsuario());
		CreadorGestores creador = new CreadorGestores();
		GestorClienteBD gestorCliente= (GestorClienteBD)creador.crearGestor("cliente",cliente);
		InfoDirBean direccion=new InfoDirBean();
		try {
			gestorCliente.consultaDirPorId(((EditaClientePrevForm)datosCliente).getIdUsuario());
			direccion=gestorCliente.getDireccionBean();
		} catch (RowNotFoundException e) {
			if(log.isInfoEnabled())
				log.info("Error" );
		}
		if(log.isInfoEnabled())
			log.info("direccion "+direccion.getCalle() );
		return direccion;
	}
	
	public InfoTelfBean getTelf(ActionForm datosCliente){
		ClienteBean cliente=new ClienteBean();
		cliente.setIdCliente(((EditaClientePrevForm)datosCliente).getIdUsuario());
		CreadorGestores creador = new CreadorGestores();
		GestorClienteBD gestorCliente= (GestorClienteBD)creador.crearGestor("cliente",cliente);
		InfoTelfBean telf=new InfoTelfBean();
		try {
			gestorCliente.consultaTelfPorId(((EditaClientePrevForm)datosCliente).getIdUsuario());
			telf=gestorCliente.getTelefonoBean();
		} catch (RowNotFoundException e) {
			if(log.isInfoEnabled())
				log.info("Error" );
		}
		if(log.isInfoEnabled())
			log.info("telefono "+telf.getTelefono());
		return telf;
	}
	
	public InfoMailBean getMail(ActionForm datosCliente){
		ClienteBean cliente=new ClienteBean();
		cliente.setIdCliente(((EditaClientePrevForm)datosCliente).getIdUsuario());
		CreadorGestores creador = new CreadorGestores();
		GestorClienteBD gestorCliente= (GestorClienteBD)creador.crearGestor("cliente",cliente);
		InfoMailBean mail=new InfoMailBean();
		try {
			gestorCliente.consultaMailPorId(((EditaClientePrevForm)datosCliente).getIdUsuario());
			mail=gestorCliente.getMailBean();
		} catch (RowNotFoundException e) {
			if(log.isInfoEnabled())
				log.info("Error" );
		}
		if(log.isInfoEnabled())
			log.info("mail "+mail.getDirMail() );
		return mail;
	}

	
	public Vector listar(ActionForm datosBusqueda){
		//Vector para guardar la lista que me devuelve la base de datos
		Vector datos = new Vector();
		//se crea un vector para devolver en cado de error
		//Vector error = new Vector();
		//error.add(new Integer(1));
		//se crea el cliente bean
		
		/*c.setNombre(((FiltrarClienteForm)datosBusqueda).getNombreCliente());
		c.setApellido1(((FiltrarClienteForm)datosBusqueda).getApellido1());
		c.setApellido2(((FiltrarClienteForm)datosBusqueda).getApellido2());
		c.setFechNacimiento(((FiltrarClienteForm)datosBusqueda).getFechaNacimiento());
		c.setIdCliente(((FiltrarClienteForm)datosBusqueda).getIdCliente());
		c.setDni(((FiltrarClienteForm)datosBusqueda).getDniCliente());*/		
		try{
			//if (datosBusqueda ==null)
			//{
			//if ((datosBusqueda.getClass()).equals("VerClientesPrevForm"))
			//{
			/*if ((((FiltrarClienteForm)datosBusqueda).getNombreCliente()).equals("") &&
					(((FiltrarClienteForm)datosBusqueda).getApellido1()).equals("") &&
					(((FiltrarClienteForm)datosBusqueda).getApellido2()).equals("") &&
					(((FiltrarClienteForm)datosBusqueda).getFechaNacimiento()).equals("") &&
					(((FiltrarClienteForm)datosBusqueda).getIdCliente()).equals("") &&
					(((FiltrarClienteForm)datosBusqueda).getDniCliente()).equals("")datosBusqueda.equals(null)){*/
				
					
				//if (((VerClientesPrevForm)datosBusqueda)==null)
				//{
				
					if(log.isInfoEnabled()){
						log.info("ConsultarCliente 3: entro en consultar cliente para listarlos " );
					}
					
					ClienteBean c = new ClienteBean();
					//c.setNombre("");
					//c.setApellido1("");
					//c.setApellido2("");
					//c.setFechNacimiento("");
					//c.setIdCliente("");
					//c.setDni("");
				
					//					LLamada al gestor de la base de datos
					GestorClienteBD gestorCliente= (GestorClienteBD)CreadorGestores.crearGestor("cliente",c);
					datos = gestorCliente.listarClientes();
					
					
				//}
			//}
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
		  //}
		}catch (Exception E){
			if(log.isInfoEnabled()){
				log.info("ConsultarCliente 3: Fallo en la busqueda en la base de datos " );
			}
			return datos;//si hay un error en la base de datos devuelve un vector con un elemento que indica error
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
