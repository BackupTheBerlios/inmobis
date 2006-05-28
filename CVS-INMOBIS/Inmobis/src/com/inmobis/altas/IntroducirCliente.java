package com.inmobis.altas;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMessage;

import com.inmobis.bbdd.CreadorGestores;
import com.inmobis.bbdd.GeneradorDeCodigos;
import com.inmobis.bbdd.RowExistsException;
import com.inmobis.bbdd.RowNotFoundException;

import com.inmobis.bbdd.cliente.ClienteBean;
import com.inmobis.bbdd.cliente.GestorClienteBD;

import com.inmobis.bbdd.direccion.InfoDirBean;

import com.inmobis.bbdd.email.InfoMailBean;
import com.inmobis.bbdd.empleado.AgenteBD;
import com.inmobis.bbdd.empleado.AgenteBean;
import com.inmobis.bbdd.empleado.RelAgenteClienteBD;
import com.inmobis.bbdd.empleado.RelAgenteClienteBean;

import com.inmobis.bbdd.login.UsuarioLoginBD;
import com.inmobis.bbdd.login.UsuarioLoginBean;

import com.inmobis.bbdd.telefono.InfoTelfBean;

import com.inmobis.struts.form.RegistraClienteForm;

public class IntroducirCliente extends Introducir{
	private static final Logger i_log = Logger.getLogger(IntroducirCliente.class);
	
	public ActionMessages introduce(ActionForm datosCliente){
		
		ActionMessages errors=new ActionMessages();
		GeneradorDeCodigos gc =GeneradorDeCodigos.getGeneradorDeCodigos();
		
		//Creamos y rellenamos el objeto Bean para el inmueble
		ClienteBean cliente=new ClienteBean();
		cliente.setApellido1(((RegistraClienteForm)datosCliente).getApellido1());
		cliente.setApellido2(((RegistraClienteForm)datosCliente).getApellido2());
		cliente.setNombre(((RegistraClienteForm)datosCliente).getNombre());
		cliente.setDni(((RegistraClienteForm)datosCliente).getDni());
		String dia =(((RegistraClienteForm)datosCliente).getDiaNacimiento());
		String mes =(((RegistraClienteForm)datosCliente).getMesNacimiento());
		String anio =(((RegistraClienteForm)datosCliente).getAnioNacimiento());
		String fecha=anio+"-"+mes+"-"+dia;
		if(i_log.isInfoEnabled())
			i_log.info("Fecha: " + fecha);
		cliente.setFechNacimiento(fecha);
		//generar el idCliente para la BBDD con la funcion de Esther
		cliente.setIdCliente(gc.asignaCodigoCliente());

		GestorClienteBD gestorCliente= (GestorClienteBD)CreadorGestores.crearGestor("cliente",cliente);

		//Creamos un Bean de Direccion asociada al inmueble ya creado
		InfoDirBean direccion=gestorCliente.newInfoDirClientes("casa");
		//Rellenamos el bean 
		direccion.setCalle(((RegistraClienteForm)datosCliente).getCalle());
		direccion.setNum(((RegistraClienteForm)datosCliente).getNum());
		direccion.setPiso(((RegistraClienteForm)datosCliente).getPiso());
		direccion.setCodPostal(((RegistraClienteForm)datosCliente).getCodPostal());
		direccion.setPoblacion(((RegistraClienteForm)datosCliente).getPoblacion());
		direccion.setProvincia(((RegistraClienteForm)datosCliente).getProvincia());
		direccion.setPais(((RegistraClienteForm)datosCliente).getPais());
		
		//Creamos un Bean de Telefono asociada al cliente ya creado
		InfoTelfBean telefono=gestorCliente.newInfoTelfClientes("casa");
		//Rellenamos el bean
		telefono.setTelefono(((RegistraClienteForm)datosCliente).getTelefono1());
		telefono.setTelefono2(((RegistraClienteForm)datosCliente).getTelefono2());
		
		//Creamos un Bean de Mail asociada al cliente ya creado
		InfoMailBean mail = gestorCliente.newInfoMailClientes("personal");
		//Rellenamos el bean
		mail.setDirMail(((RegistraClienteForm)datosCliente).getEmail());
		
		//Creamos un Bean de Login asociado al cliente ya creado
		UsuarioLoginBean login=gestorCliente.newInfoLoginClientes(cliente.getIdCliente());
		//Rellenamos el bean
		login.setNombreUsuario(((RegistraClienteForm)datosCliente).getNombreUsuario());
		login.setPassword(((RegistraClienteForm)datosCliente).getPassword());
		login.setTipoUsuario("cliente");		
		boolean cInsertado=false;
		//Compruebo que el nombre de usuario no esta repetido
		try{
			gestorCliente.insertaLogin(login);
			try{
				gestorCliente.insert();
				gestorCliente.insertaDir(direccion);
				gestorCliente.insertaMail(mail);
				gestorCliente.insertaTelf(telefono);
				cInsertado=true;
			}
			catch(Exception e){
				if(((RegistraClienteForm)datosCliente).getEsAgente())
					errors.add("registraClienteAgente", new ActionMessage(e.toString()));
				else
					errors.add("registraClienteCliente", new ActionMessage(e.toString()));
				if(i_log.isInfoEnabled())
					i_log.info("Fallo en BBDD al registrar nuevo cliente:" + e.toString());
			}
		}
		catch (Exception e){
			errors.add("nombreUsuario", new ActionMessage("errors.nombreUsuario.duplicated"));
			if(i_log.isInfoEnabled())
				i_log.info(login.getNombreUsuario()+" ya existe : " + e.toString());
		}
		//TODO USAR INTERFACES
		//Variable para decidir si hay que borrar al cliente previamente introducido por no encontrar al agente.
		if(i_log.isInfoEnabled())
			i_log.info("Le registra un agente?: "+((RegistraClienteForm)datosCliente).getEsAgente());
		//Si le ha dado de alta un agente, se lo asociamos
		
		if (((RegistraClienteForm)datosCliente).getEsAgente() && cInsertado){
			AgenteBean agente=new AgenteBean();
			agente.setIdAgente(((RegistraClienteForm)datosCliente).getIdAgente());
			AgenteBD agenteBD= new AgenteBD(agente);
			try {
				if(i_log.isInfoEnabled())
					i_log.info("idCliente: "+cliente.getIdCliente()+"idAgente: "+((RegistraClienteForm)datosCliente).getIdAgente());
				agenteBD.asociarCliente(cliente.getIdCliente(),((RegistraClienteForm)datosCliente).getIdAgente());
				//No se debería llegar a esto, porque acabo de registrar al cliente
			} catch (RowExistsException e) {
				if(i_log.isInfoEnabled())
					i_log.info("Ese cliente ya estaba registrado con usted");
				errors.add("registraClienteAgente", new ActionMessage("Ese cliente ya está registrado con usted"));
				try {
					gestorCliente.delete();
				} catch (RowNotFoundException e1) {
					if(i_log.isInfoEnabled())
						i_log.info("Borrando a un cliente que no existe: "+e1);
				}
			}
		}
		else{
			AgenteBean agente=new AgenteBean();
			agente.setIdAgente(((RegistraClienteForm)datosCliente).getIdAgente());
			AgenteBD agenteBD= new AgenteBD(agente);
			try {
				agenteBD.agregarCliente(cliente.getIdCliente());
			} catch (RowExistsException e) {
				//No se debería llegar a esto, porque acabo de registrar al cliente
				if(i_log.isInfoEnabled())
					i_log.info("El cliente que se está registrando ya tiene un agente asociado");
				errors.add("registraClienteCliente", new ActionMessage("Ya tiene un agente asociado"));
				try {
					gestorCliente.delete();
				} catch (RowNotFoundException e1) {
					if(i_log.isInfoEnabled())
						i_log.info("Borrando a un cliente que no existe: "+e1);
				}
			}
		}
			
		
//		if (((RegistraClienteForm)datosCliente).getEsAgente() && cInsertado){
//			UsuarioLoginBean loginAgente=new UsuarioLoginBean();
//			loginAgente.setNombreUsuario(((RegistraClienteForm)datosCliente).getIdAgente());
//			UsuarioLoginBD loginAgenteBD=new UsuarioLoginBD(loginAgente);
//			try {
//				//para ver si existe un empleado con ese dni
//				loginAgenteBD.select();
//				//Si existe, miro que sea agente
//				if (loginAgente.getTipoUsuario().trim().equals("agente")){
//					RelAgenteClienteBean relacion= new RelAgenteClienteBean();
//					relacion.setIdAgente(loginAgente.getIdUsuario());
//					relacion.setIdCliente(cliente.getIdCliente());
//					RelAgenteClienteBD relacionBD= new RelAgenteClienteBD(relacion);
//					try {
//						relacionBD.insert();
//					} catch (RowExistsException e) {
//						borrar=true;
//						errors.add("registraClientAgente", new ActionMessage(e.toString()));
//						//Si no consigo asociar un cliente, borro lo que ya habia introducido
//						
//						if(i_log.isInfoEnabled())
//							i_log.info("Error en BBDD al asociar al agente "+((RegistraClienteForm)datosCliente).getIdAgente() +". "+e);
//					}
//				}
//				else{
//					borrar=true;
//					errors.add("registraClienteAgente", new ActionMessage("errors.idAgente.unknown"));
//					if(i_log.isInfoEnabled())
//						i_log.info("El empleado de dni " + ((RegistraClienteForm)datosCliente).getIdAgente()+ " no es un agente, es "+loginAgente.getTipoUsuario());
//				}
//			} catch (RowNotFoundException e) {
//				errors.add("registraClienteAgente", new ActionMessage("errors.idAgente.unknown"));
//				//Si no consigo asociar un cliente, borro lo que ya habia introducido
//				borrar=true;
//				if(i_log.isInfoEnabled())
//					i_log.info("no se encontro ningun usuario con nombre de usuario :" + ((RegistraClienteForm)datosCliente).getIdAgente());
//			}
//			if(borrar){
//				try {
//					gestorCliente.delete();
//					gestorCliente.deleteDir("casa");
//					gestorCliente.deleteLogin(((RegistraClienteForm)datosCliente).getNombreUsuario());
//					gestorCliente.deleteMail("personal");
//					gestorCliente.deleteTelf("casa");
//				} catch (RowNotFoundException e) {
//					if(i_log.isInfoEnabled())
//						i_log.info("Error al borrar lo ya metido "+e);
//				}
//			}
//			
//		}
//		else{
//		}
		return errors;
	}
}
