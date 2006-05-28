package com.inmobis.altas;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionForm;

import com.inmobis.bbdd.CreadorGestores;
import com.inmobis.bbdd.GeneradorDeCodigos;
import com.inmobis.bbdd.direccion.InfoDirBean;
import com.inmobis.bbdd.email.InfoMailBean;
import com.inmobis.bbdd.empleado.AgenteBD;
import com.inmobis.bbdd.empleado.AgenteBean;
import com.inmobis.bbdd.empleado.EmpleadoBean;
import com.inmobis.bbdd.empleado.GestorEmpleadoBD;
import com.inmobis.bbdd.login.UsuarioLoginBean;
import com.inmobis.bbdd.telefono.InfoTelfBean;
import com.inmobis.struts.form.RegistraEmpleadoForm;

public class IntroducirEmpleado extends Introducir{
	private static final Logger i_log = Logger.getLogger(IntroducirEmpleado.class);
	
	public ActionMessages introduce(ActionForm datosEmpleado){
		
		GeneradorDeCodigos gc=GeneradorDeCodigos.getGeneradorDeCodigos();
		ActionMessages errors=new ActionMessages();
		
		//Creamos y rellenamos el objeto Bean para el Empleado
		EmpleadoBean empleado=new EmpleadoBean();
		empleado.setNombre(((RegistraEmpleadoForm)datosEmpleado).getNombre());
		empleado.setApellido1(((RegistraEmpleadoForm)datosEmpleado).getApellido1());
		empleado.setApellido2(((RegistraEmpleadoForm)datosEmpleado).getApellido2());
		String dia =(((RegistraEmpleadoForm)datosEmpleado).getDiaNacimiento());
		String mes =(((RegistraEmpleadoForm)datosEmpleado).getMesNacimiento());
		String anio =(((RegistraEmpleadoForm)datosEmpleado).getAnioNacimiento());
		String fecha=anio+"-"+mes+"-"+dia;
		if(i_log.isInfoEnabled())
			i_log.info("Fecha: " + fecha);
		empleado.setFechNacimiento(fecha);
		empleado.setDni(((RegistraEmpleadoForm)datosEmpleado).getNif());
		//generar el idEmpleado para la BBDD con la funcion de Esther
		empleado.setIdEmpleado(gc.asignaCodigoEmpleado());

		GestorEmpleadoBD gestorEmpleado=(GestorEmpleadoBD)CreadorGestores.crearGestor("empleado",empleado);
		
		//Creamos un Bean de Direccion asociada al empleado ya creado
		InfoDirBean direccion=gestorEmpleado.newInfoDirEmpleados("casa");
		//Rellenamos el bean
		direccion.setCalle(((RegistraEmpleadoForm)datosEmpleado).getCalle());
		direccion.setNum(((RegistraEmpleadoForm)datosEmpleado).getNum());
		direccion.setPiso(((RegistraEmpleadoForm)datosEmpleado).getPiso());
		direccion.setCodPostal(((RegistraEmpleadoForm)datosEmpleado).getCodPostal());
		direccion.setPoblacion(((RegistraEmpleadoForm)datosEmpleado).getPoblacion());
		direccion.setProvincia(((RegistraEmpleadoForm)datosEmpleado).getProvincia());
		direccion.setPais(((RegistraEmpleadoForm)datosEmpleado).getPais());
		
		//Creamos un Bean de Telefono asociada al empleado ya creado
		InfoTelfBean telefono=gestorEmpleado.newInfoTelfEmpleados("casa");
		//Rellenamos el bean
		telefono.setTelefono(((RegistraEmpleadoForm)datosEmpleado).getTelefono1());
		telefono.setTelefono2(((RegistraEmpleadoForm)datosEmpleado).getTelefono2());
		
		//Creamos un Bean de Mail asociada al cliente ya creado
		InfoMailBean mail = gestorEmpleado.newInfoMailEmpleados("casa");
		//Rellenamos el bean
		mail.setDirMail(((RegistraEmpleadoForm)datosEmpleado).getEmail());
		
		//Creamos un Bean de Login asociado al empleado ya creado
		UsuarioLoginBean login=gestorEmpleado.newInfoLoginEmpleados(empleado.getIdEmpleado());
		//Rellenamos el bean
		login.setNombreUsuario(((RegistraEmpleadoForm)datosEmpleado).getNif());
		login.setPassword("inmobis");
		login.setTipoUsuario(((RegistraEmpleadoForm)datosEmpleado).getTipoEmpleado());

		//TODO hacer con interfaces
		//Segun el tipo de usuario que sea, le inserto en una tabla u otra
		
		//El nombre de usuario del empleado será el DNI, que es unico
		try{
			gestorEmpleado.insertaLogin(login);
			try{
				gestorEmpleado.insert();
				gestorEmpleado.insertaDir(direccion);
				gestorEmpleado.insertaMail(mail);
				gestorEmpleado.insertaTelf(telefono);
			}
			catch(Exception e){
				errors.add("registraEmpleado", new ActionMessage(e.toString()));
				if(i_log.isInfoEnabled())
					i_log.info("Fallo en BBDD :" + e.toString());
			}
			if(((RegistraEmpleadoForm)datosEmpleado).getTipoEmpleado().toLowerCase().equals("agente")){
				AgenteBean agente =new AgenteBean();
				agente.setIdAgente(empleado.getIdEmpleado());
				agente.setComision(((RegistraEmpleadoForm)datosEmpleado).getPorcentaje());
				AgenteBD agenteBD =new AgenteBD(agente);
				agenteBD.insert();
			}
			if(((RegistraEmpleadoForm)datosEmpleado).getTipoEmpleado().toLowerCase().equals("gerente")){
//				Todavia nada
			}
			if(((RegistraEmpleadoForm)datosEmpleado).getTipoEmpleado().toLowerCase().equals("administrador")){
//				Todavia nada
			}
			if(((RegistraEmpleadoForm)datosEmpleado).getTipoEmpleado().toLowerCase().equals("contable")){
//				Todavia nada
			}
		}
		catch (Exception e){
			errors.add("nif", new ActionMessage("errors.empleado.duplicated"));
			if(i_log.isInfoEnabled())
				i_log.info(login.getNombreUsuario()+" ya existe : " + e.toString());
		}
		
		return errors;
	}
}
