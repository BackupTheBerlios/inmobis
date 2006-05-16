package com.inmobis.modificaciones;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.inmobis.bbdd.CreadorGestores;
import com.inmobis.bbdd.RowExistsException;
import com.inmobis.bbdd.RowNotFoundException;
import com.inmobis.bbdd.direccion.InfoDirBean;
import com.inmobis.bbdd.email.InfoMailBean;
import com.inmobis.bbdd.empleado.AgenteBD;
import com.inmobis.bbdd.empleado.AgenteBean;
import com.inmobis.bbdd.empleado.EmpleadoBean;
import com.inmobis.bbdd.empleado.GestorEmpleadoBD;
import com.inmobis.bbdd.empleado.RelAgenteClienteBD;
import com.inmobis.bbdd.empleado.RelAgenteClienteBean;
import com.inmobis.bbdd.login.UsuarioLoginBean;
import com.inmobis.bbdd.telefono.InfoTelfBean;
import com.inmobis.struts.form.EditaEmpleadoForm;
import com.inmobis.struts.form.RegistraEmpleadoForm;

public class ModificarEmpleado extends Modificar{
//TODO EN LOS UML'S NO EXISTE!!!
	private static final Logger i_log = Logger.getLogger(ModificarEmpleado.class);
	
	public ActionMessages modifica(ActionForm datosEmpleado){
		
		ActionMessages errors=new ActionMessages();
		
		//Creamos y rellenamos el objeto Bean para el Empleado
		EmpleadoBean empleado=new EmpleadoBean();
		empleado.setNombre(((EditaEmpleadoForm)datosEmpleado).getNombre());
		empleado.setApellido1(((EditaEmpleadoForm)datosEmpleado).getApellido1());
		empleado.setApellido2(((EditaEmpleadoForm)datosEmpleado).getApellido2());
		String dia =(((EditaEmpleadoForm)datosEmpleado).getDiaNacimiento());
		String mes =(((EditaEmpleadoForm)datosEmpleado).getMesNacimiento());
		String anio =(((EditaEmpleadoForm)datosEmpleado).getAnioNacimiento());
		String fecha=anio+"-"+mes+"-"+dia;
		if(i_log.isInfoEnabled())
			i_log.info("Fecha: " + fecha);
		empleado.setFechNacimiento(fecha);
		empleado.setIdDni(((EditaEmpleadoForm)datosEmpleado).getNif());
		//generar el idEmpleado para la BBDD con la funcion de Esther
		empleado.setIdEmpleado(((EditaEmpleadoForm)datosEmpleado).getIdUsuario());
		
		CreadorGestores creador =new CreadorGestores();
		GestorEmpleadoBD gestorEmpleado=(GestorEmpleadoBD)creador.crearGestor("empleado",empleado);
		
//		Creamos un Bean de Direccion asociada al empleado ya creado
		InfoDirBean direccion=gestorEmpleado.newInfoDirEmpleados("casa");
		//Rellenamos el bean
		direccion.setCalle(((EditaEmpleadoForm)datosEmpleado).getCalle());
		direccion.setNum(((EditaEmpleadoForm)datosEmpleado).getNum());
		direccion.setPiso(((EditaEmpleadoForm)datosEmpleado).getPiso());
		direccion.setCodPostal(((EditaEmpleadoForm)datosEmpleado).getCodPostal());
		direccion.setPoblacion(((EditaEmpleadoForm)datosEmpleado).getPoblacion());
		direccion.setProvincia(((EditaEmpleadoForm)datosEmpleado).getProvincia());
		direccion.setPais(((EditaEmpleadoForm)datosEmpleado).getPais());
		
		//Creamos un Bean de Telefono asociada al empleado ya creado
		InfoTelfBean telefono=gestorEmpleado.newInfoTelfEmpleados("casa");
		//Rellenamos el bean
		telefono.setTelefono(((EditaEmpleadoForm)datosEmpleado).getTelefono1());
		telefono.setTelefono2(((EditaEmpleadoForm)datosEmpleado).getTelefono2());
		
		//Creamos un Bean de Mail asociada al cliente ya creado
		InfoMailBean mail = gestorEmpleado.newInfoMailEmpleados("casa");
		//Rellenamos el bean
		mail.setDirMail(((EditaEmpleadoForm)datosEmpleado).getEmail());
		
		//Creamos un Bean de Login asociado al empleado ya creado
		UsuarioLoginBean login=gestorEmpleado.newInfoLoginEmpleados(empleado.getIdEmpleado());
		//Rellenamos el bean
		login.setNombreUsuario(((EditaEmpleadoForm)datosEmpleado).getNif());
		login.setPassword(((EditaEmpleadoForm)datosEmpleado).getPassword());
		login.setTipoUsuario(((EditaEmpleadoForm)datosEmpleado).getTipoEmpleado());
		
		//TODO hacer con interfaces
		//Segun el tipo de usuario que sea, actualizo una u otra tabla
		
		//El nombre de usuario del empleado será el DNI, que es unico
		//TODO con update.
		try{
			gestorEmpleado.insertaLogin(login);
			try{
				gestorEmpleado.update();
				gestorEmpleado.insertaDir(direccion);
				gestorEmpleado.insertaMail(mail);
				gestorEmpleado.insertaTelf(telefono);
			}
			catch(Exception e){
				errors.add("editaEmpleado", new ActionMessage(e.toString()));
				if(i_log.isInfoEnabled())
					i_log.info("Fallo en BBDD :" + e.toString());
			}
			
			//Al actualizar un agente, miro si ya existia. 
			//Si no existia tendre que crear una nueva entrada en tagente.			
			if(((EditaEmpleadoForm)datosEmpleado).getTipoEmpleado().toLowerCase().equals("agente")){
				AgenteBean agente =new AgenteBean();
				agente.setIdAgente(empleado.getIdEmpleado());
				agente.setComision(((EditaEmpleadoForm)datosEmpleado).getPorcentaje());
				AgenteBD agenteBD =new AgenteBD(agente);
				AgenteBD agenteBDAux=new AgenteBD(agente);
				try {
					agenteBDAux.select();
					agenteBD.update();
					if(i_log.isInfoEnabled())
						i_log.info(empleado.getDni()+" era un agente ->Actualizo");
				} catch (RowNotFoundException e) {
					if(i_log.isInfoEnabled())
						i_log.info(empleado.getDni()+" no era agente ->Introducirle");
					agenteBD.insert();
				}
			}
			//Para los demas, tendre que ver si antes eran agentes.
			//Si lo eran, tendre que borrar su entrada en tagente, comprobando que no tenian clientes asociados
			else{
				AgenteBean agente =new AgenteBean();
				agente.setIdAgente(empleado.getIdEmpleado());
				AgenteBD agenteBD=new AgenteBD(agente);
				RelAgenteClienteBean rel=new RelAgenteClienteBean();
				rel.setIdAgente(empleado.getIdEmpleado());
				RelAgenteClienteBD relBD=new RelAgenteClienteBD(rel);
				boolean esAgente=false;
				try {
					agenteBD.select();
					if(i_log.isInfoEnabled())
						i_log.info(empleado.getDni()+" era un agente ->Tengo que ver si no tenia clientes");
					esAgente=true;
				} catch (RowNotFoundException e) {
					if(i_log.isInfoEnabled())
						i_log.info(empleado.getDni()+" no era agente ->No hay que hacer nada.");
				}
				//Si era agente, miro sus clientes
				if(esAgente){
					try{
						relBD.select();
						if(i_log.isInfoEnabled())
							i_log.info(empleado.getDni()+" tenia clientes ->No le puedo borrar");
						errors.add("editaEmpleado", new ActionMessage("errors.listaClientes.notEmpty"));
					}
					catch(RowNotFoundException e){
						if(i_log.isInfoEnabled())
							i_log.info(empleado.getDni()+" no tenia clientes ->Le borro");
						try {
							agenteBD.delete();
							if(i_log.isInfoEnabled())
								i_log.info(empleado.getDni()+" Borrado");
						} catch (RowNotFoundException e1) {
							if(i_log.isInfoEnabled())
								i_log.info(empleado.getDni()+" No se ha podido borrar "+e1);
						}
					}
				}
			}
		}
		catch (RowExistsException e){
			errors.add("nif", new ActionMessage("errors.empleado.duplicated"));
			if(i_log.isInfoEnabled())
				i_log.info(login.getNombreUsuario()+" ya existe : " + e.toString());
		}
		return errors;
	}
}
