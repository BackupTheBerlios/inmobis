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

import com.inmobis.bbdd.empleado.AgenteBean;
import com.inmobis.bbdd.empleado.AgenteBD;

import com.inmobis.struts.form.*;
//import com.inmobis.struts.action.*;
import org.apache.log4j.Logger;
//import com.inmobis.bbdd.RowNotFoundException;
//import com.inmobis.bbdd.direccion.InfoDirBean;
//import com.inmobis.bbdd.email.InfoMailBean;
//import com.inmobis.bbdd.login.UsuarioLoginBean;
//import com.inmobis.bbdd.telefono.InfoTelfBean;


public class ConsultarCliente extends Consultar{
	
	private static final Logger log = Logger.getLogger(ConsultarCliente.class);
	
	public ActionForm dameDatos (String id){
		
		//form que va a tener los datos y se va a devolver
		EditaClienteForm form=new EditaClienteForm();
		
		//se crea un cliente bean
		ClienteBean cliente=new ClienteBean();
		cliente.setIdCliente(id);
		
		CreadorGestores creador = new CreadorGestores();
		GestorClienteBD gestorCliente= (GestorClienteBD)creador.crearGestor("cliente",cliente);
		
		InfoDirBean direccion=new InfoDirBean();
		InfoMailBean email=new InfoMailBean();
		InfoTelfBean telf=new InfoTelfBean();
		UsuarioLoginBean login=new UsuarioLoginBean();
		//Miro la direccion
		try {
			gestorCliente.consultaDirPorId(id);
			direccion=gestorCliente.getDireccionBean();
		} catch (RowNotFoundException e) {
			if(log.isInfoEnabled())
				log.info("Error Dir: "+e );
		}
		//Miro el login
		try {
			gestorCliente.consultaLoginPorId(id);
		} catch (RowNotFoundException e) {
			if(log.isInfoEnabled())
				log.info("Error Login: "+e );
		}
		login= gestorCliente.getLoginBean();
		//Miro el telefono
		try {
			gestorCliente.consultaTelfPorId(id);
		} catch (RowNotFoundException e) {
			if(log.isInfoEnabled())
				log.info("Error Telf: "+e );
		}
		telf=gestorCliente.getTelefonoBean();
		//Miro el email
		try {
			gestorCliente.consultaMailPorId(id);
		} catch (RowNotFoundException e) {
			if(log.isInfoEnabled())
				log.info("Error Mail: "+e );
		}
		email=gestorCliente.getMailBean();
		try {
			gestorCliente.select();
		} catch (RowNotFoundException e) {
			if(log.isInfoEnabled())
				log.info("Error Cliente: "+e );
		}
		
		cliente=(ClienteBean)gestorCliente.getBean();
		
		if(log.isInfoEnabled())
			log.info("direccion "+direccion.getCalle() );
		if(log.isInfoEnabled())
			log.info("nombre "+cliente.getNombreCliente() );
		if(log.isInfoEnabled())
			log.info("telf "+telf.getTelefono() );
		if(log.isInfoEnabled())
			log.info("login "+login.getNombreUsuario() );
		
		form.setCalle(direccion.getCalle());
		form.setCodPostal(direccion.getCodPostal());
		form.setNum(direccion.getNum());
		form.setPais(direccion.getPais());
		form.setPiso(direccion.getPiso());
		form.setPoblacion(direccion.getPoblacion());
		form.setProvincia(direccion.getProvincia());
		form.setCodPostal(direccion.getCodPostal());
		form.setApellido1(cliente.getApellido1());
		form.setApellido2(cliente.getApellido2());
		form.setDni(cliente.getDni());
		form.setIdUsuario(cliente.getIdCliente());
		form.setNombre(cliente.getNombreCliente());
		String fecha=cliente.getFechNacimiento();
		String[] fechaSplit=fecha.split("-");
		form.setAnioNacimiento(fechaSplit[0]);
		form.setMesNacimiento(fechaSplit[1]);
		form.setDiaNacimiento(fechaSplit[2]);		
		form.setTelefono1(telf.getTelefono());
		form.setTelefono2(telf.getTelefono2());
		form.setEmail(email.getDirMail());
		form.setNombreUsuario(login.getNombreUsuario());
		form.setPassword(login.getPassword());
		return form;
	}
	
	public Vector listar(ActionForm datosBusqueda){
		//Vector para guardar la lista que me devuelve la base de datos
		Vector datos = new Vector();
			
		try{		
			if(log.isInfoEnabled()){
				log.info("ConsultarCliente 3: Entro en consultar cliente para listarlos. " );
			}
			
			ClienteBean c = new ClienteBean();
			
			//LLamada al gestor de la base de datos
			GestorClienteBD gestorCliente= (GestorClienteBD)CreadorGestores.crearGestor("cliente",c);
			datos = gestorCliente.listarClientes();
			
		}catch (Exception E){
			if(log.isInfoEnabled()){
				log.info("ConsultarCliente 3: Fallo en la busqueda en la base de datos " );
			}
			return datos;//si hay un error en la base de datos devuelve un vector con un elemento que indica error
		}
		return datos;
	}
	
	public Vector listarClientesAgente(ActionForm datosBusqueda){
		//Vector para guardar la lista que me devuelve la base de datos
		Vector datos = new Vector();
			
		try{		
			if(log.isInfoEnabled()){
				log.info("ConsultarCliente 3: Entro en consultar cliente para listarlos. " );
			}
			
			AgenteBean a = new AgenteBean();
			a.setIdAgente(((VerClientesAgentePrevForm)datosBusqueda).getIdAgente());
			
			//LLamada al gestor de la base de datos
			AgenteBD gestorAgente = new AgenteBD(a);
			//GestorEmpleadoBD gestorAgente= (GestorEmpleadoBD)CreadorGestores.crearGestor("empleado",a);			
			datos = gestorAgente.listarClientesAsociados();
			
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
