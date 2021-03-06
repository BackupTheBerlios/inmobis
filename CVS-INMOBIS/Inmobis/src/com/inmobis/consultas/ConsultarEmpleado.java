package com.inmobis.consultas;

import java.util.Vector;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import com.inmobis.bbdd.login.UsuarioLoginBD;
import com.inmobis.bbdd.login.UsuarioLoginBean;
import com.inmobis.bbdd.CreadorGestores;
import com.inmobis.bbdd.RowNotFoundException;
import com.inmobis.bbdd.direccion.InfoDirBean;
import com.inmobis.bbdd.email.InfoMailBean;
import com.inmobis.bbdd.empleado.AgenteBean;
import com.inmobis.bbdd.empleado.EmpleadoBean;
import com.inmobis.bbdd.empleado.GestorAgenteBD;
import com.inmobis.bbdd.empleado.GestorEmpleadoBD;
import com.inmobis.bbdd.login.UsuarioLoginBean;
import com.inmobis.bbdd.telefono.InfoTelfBean;
import com.inmobis.struts.form.EditaEmpleadoForm;
import com.inmobis.struts.form.EditaEmpleadoPrevForm;
import com.inmobis.struts.form.FiltrarEmpleadoForm;
import com.inmobis.struts.form.BorraEmpleadoForm;

public class ConsultarEmpleado extends Consultar{
	
	private static final Logger log = Logger.getLogger(ConsultarEmpleado.class);
	
	public ActionForm dameDatos (String id){
		//form que va a tener los datos y se va a devolver
		EditaEmpleadoForm form=new EditaEmpleadoForm();
		
		//se crea un empleado bean
		EmpleadoBean empleado=new EmpleadoBean();
		empleado.setIdEmpleado(id);

		GestorEmpleadoBD gestorEmpleado= (GestorEmpleadoBD)CreadorGestores.crearGestor("empleado",empleado);
		
		InfoDirBean direccion=new InfoDirBean();
		InfoMailBean email=new InfoMailBean();
		InfoTelfBean telf=new InfoTelfBean();
		UsuarioLoginBean login=new UsuarioLoginBean();
		//Miro la direccion
		try {
			gestorEmpleado.consultaDirPorId(id);
			direccion=gestorEmpleado.getDireccionBean();
		} catch (RowNotFoundException e) {
			if(log.isInfoEnabled())
				log.info("Error Dir: "+e );
		}
		//Miro el login
		try {
			gestorEmpleado.consultaLoginPorId(id);
		} catch (RowNotFoundException e) {
			if(log.isInfoEnabled())
				log.info("Error Login: "+e );
		}
		login= gestorEmpleado.getLoginBean();
		//Miro el telefono
		try {
			gestorEmpleado.consultaTelfPorId(id);
		} catch (RowNotFoundException e) {
			if(log.isInfoEnabled())
				log.info("Error Telf: "+e );
		}
		telf=gestorEmpleado.getTelefonoBean();
		//Miro el email
		try {
			gestorEmpleado.consultaMailPorId(id);
		} catch (RowNotFoundException e) {
			if(log.isInfoEnabled())
				log.info("Error Mail: "+e );
		}
		email=gestorEmpleado.getMailBean();
		try {
			gestorEmpleado.select();
		} catch (RowNotFoundException e) {
			if(log.isInfoEnabled())
				log.info("Error Empleado: "+e );
		}
		
		empleado=(EmpleadoBean)gestorEmpleado.getBean();
		
		if(log.isInfoEnabled())
			log.info("direccion "+direccion.getCalle() );
		if(log.isInfoEnabled())
			log.info("nombre "+empleado.getNombre() );
		if(log.isInfoEnabled())
			log.info("telf "+telf.getTelefono() );
		if(log.isInfoEnabled())
			log.info("login "+login.getNombreUsuario() );
		if(log.isInfoEnabled())
			log.info("dni "+empleado.getDni() );
		
		form.setCalle(direccion.getCalle());
		form.setCodPostal(direccion.getCodPostal());
		form.setNum(direccion.getNum());
		form.setPais(direccion.getPais());
		form.setPiso(direccion.getPiso());
		form.setPoblacion(direccion.getPoblacion());
		form.setProvincia(direccion.getProvincia());
		form.setCodPostal(direccion.getCodPostal());
		form.setApellido1(empleado.getApellido1());
		form.setApellido2(empleado.getApellido2());
		form.setNif(empleado.getDni());
		form.setIdUsuario(empleado.getIdEmpleado());
		form.setNombre(empleado.getNombre());
		String fecha=empleado.getFechNacimiento();
		String[] fechaSplit=fecha.split("-");
		form.setAnioNacimiento(fechaSplit[0]);
		form.setMesNacimiento((new Integer(fechaSplit[1])).toString());
		form.setDiaNacimiento((new Integer(fechaSplit[2])).toString());		
		form.setTelefono1(telf.getTelefono());
		form.setTelefono2(telf.getTelefono2());
		form.setEmail(email.getDirMail());
		form.setPassword(login.getPassword());
		form.setTipoEmpleado(login.getTipoUsuario());
		String porcentaje="";
		if(login.getTipoUsuario().toLowerCase().equals("agente")){
			if(log.isInfoEnabled())
				log.info("Es agente, cojo el porcentaje" );
			//Miro el porcentaje
			AgenteBean agente=new AgenteBean();
			agente.setIdAgente(empleado.getIdEmpleado());
			
			GestorAgenteBD gestorAgente=(GestorAgenteBD)CreadorGestores.crearGestor("agente",agente);
			try {
				gestorAgente.select();
				porcentaje=((AgenteBean)gestorAgente.getBean()).getComision();
				if(log.isInfoEnabled())
					log.info("porcentaje: "+porcentaje );
				form.setPorcentaje(porcentaje);
			} catch (RowNotFoundException e) {
				if(log.isInfoEnabled())
					log.info("Error Porcentaje: "+e );
			}
		}
		if(log.isInfoEnabled())
			log.info("Porcentaje: "+porcentaje );
		return form;
	}
	
	public Vector listar(ActionForm datosBusqueda){
		//Vector para guardar la lista que me devuelve la base de datos
		Vector datos = new Vector();
				
		//se crea el empleado bean		
		EmpleadoBean e = new EmpleadoBean();
		
		//se crea el empleado dase de datos		
		GestorEmpleadoBD gestorEmpleado = (GestorEmpleadoBD) CreadorGestores.crearGestor("empleado",e);
		
		if(log.isInfoEnabled()){
			log.info("ConsultarEmpleado 1: Antes de entrar en la base de datos " );
		}
		
		try{
			datos=gestorEmpleado.listarEmpleados();
		}catch (Exception E){
			if(log.isInfoEnabled()){
				log.info("ConsultarEmpleado 2: Fallo en la busqueda en la base de datos " );
			}
			return datos;
		}
		if(log.isInfoEnabled()){
			log.info("ConsultarEmpleado 3: Exito " );
		}
		return datos;
	}
	
	public Vector filtrarEmpleados (ActionForm datosBusqueda){
		//Vector para guardar el resultado de la b�squeda
		Vector datos= new Vector();
		//crear el bean
		EmpleadoBean e = new EmpleadoBean();
		
		//se rellean el bean con los datos que se han recogido del formulario
		if (!(((FiltrarEmpleadoForm)datosBusqueda).getApellido1().equals(null)) &&
				!(((FiltrarEmpleadoForm)datosBusqueda).getApellido1().equals("")))
			e.setApellido1(((FiltrarEmpleadoForm)datosBusqueda).getApellido1());
		if (!(((FiltrarEmpleadoForm)datosBusqueda).getApellido2().equals(null)) &&
				!(((FiltrarEmpleadoForm)datosBusqueda).getApellido2().equals("")))
			e.setApellido2(((FiltrarEmpleadoForm)datosBusqueda).getApellido2());
		if (!(((FiltrarEmpleadoForm)datosBusqueda).getDniEmpleado().equals(null)) &&
				!(((FiltrarEmpleadoForm)datosBusqueda).getDniEmpleado().equals("")))
			e.setDni(((FiltrarEmpleadoForm)datosBusqueda).getDniEmpleado());
		if (!(((FiltrarEmpleadoForm)datosBusqueda).getFechaNacimiento().equals(null)) &&
				!(((FiltrarEmpleadoForm)datosBusqueda).getFechaNacimiento().equals("")))
			e.setFechNacimiento(((FiltrarEmpleadoForm)datosBusqueda).getFechaNacimiento());
		if (!(((FiltrarEmpleadoForm)datosBusqueda).getNombreEmpleado().equals(null)) &&
				!(((FiltrarEmpleadoForm)datosBusqueda).getNombreEmpleado().equals("")))
			e.setNombre(((FiltrarEmpleadoForm)datosBusqueda).getNombreEmpleado());
		
		//se crea el empleado dase de datos		
		GestorEmpleadoBD gestorEmpleado = (GestorEmpleadoBD) CreadorGestores.crearGestor("empleado",e);
		
		try{
			datos=gestorEmpleado.BusquedaDetallada();
		}catch (Exception E){
			if(log.isInfoEnabled()){
				log.info("ConsultarEmpleado 2: Fallo en la busqueda en la base de datos " );
			}
			return datos;
		}
		if(log.isInfoEnabled()){
			log.info("ConsultarEmpleado 2: Exito " );
		}
		return datos;
		
	}
	
	public String dameTipoUsuario(String id){
		String tipoUsuario="error";
		UsuarioLoginBean u = new UsuarioLoginBean();
		u.setIdUsuario(id);
		UsuarioLoginBD g = new UsuarioLoginBD(u);
		try{
			g.selectAll();
		}catch(Exception e){
			if(log.isInfoEnabled()){
				log.info("ConsultarEmpleado 3: Fallo  " );
			}
			return tipoUsuario;
		}
		tipoUsuario= ((UsuarioLoginBean)g.getBean()).getTipoUsuario();
		return tipoUsuario;
	}

}
