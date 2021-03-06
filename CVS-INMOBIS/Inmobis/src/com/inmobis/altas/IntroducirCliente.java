package com.inmobis.altas;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMessage;

import com.inmobis.bbdd.CreadorGestores;
import com.inmobis.bbdd.GeneradorDeCodigos;
import com.inmobis.bbdd.RowExistsException;

import com.inmobis.bbdd.cliente.ClienteBean;
import com.inmobis.bbdd.cliente.GestorClienteBD;

import com.inmobis.bbdd.direccion.InfoDirBean;

import com.inmobis.bbdd.email.InfoMailBean;
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

			try {
				gestorCliente.insertaLogin(login);
				try {
					gestorCliente.insert();
					gestorCliente.insertaDir(direccion);
					gestorCliente.insertaMail(mail);
					gestorCliente.insertaTelf(telefono);
					cInsertado=true;
				} catch (RowExistsException e) {
					if(((RegistraClienteForm)datosCliente).getEsAgente())
						errors.add("registraClienteAgente", new ActionMessage(e.toString()));
					else
						errors.add("registraClienteCliente", new ActionMessage(e.toString()));
					if(i_log.isInfoEnabled())
						i_log.info("Fallo en BBDD al registrar nuevo cliente:" + e.toString());
				}	
			} catch (RowExistsException e) {
				errors.add("nombreUsuario", new ActionMessage("errors.nombreUsuario.duplicated"));
							if(i_log.isInfoEnabled())
								i_log.info(login.getNombreUsuario()+" ya existe : " + e.toString());
			}
		if(i_log.isInfoEnabled())
			i_log.info("El cliente se ha introducido correctamente");	
		if(i_log.isInfoEnabled())
			i_log.info("Le registra un agente?: "+((RegistraClienteForm)datosCliente).getEsAgente());
		//Si le ha dado de alta un agente, se lo asociamos
		if (((RegistraClienteForm)datosCliente).getEsAgente() && cInsertado){
			try {
				gestorCliente.asociarAgenteACliente(cliente.getIdCliente(),((RegistraClienteForm)datosCliente).getIdAgente());
			} catch (RowExistsException e) {
				errors.add("registraClienteAgente", new ActionMessage(e.toString()));
				if(i_log.isInfoEnabled())
					i_log.info("No se ha podido asociar: "+cliente.getIdCliente()+" a "+((RegistraClienteForm)datosCliente).getIdAgente() );
			}
		}
		//Sino, le asociamos el que menos clientes tenga asociado
		else{
			try {
				gestorCliente.darAgente(cliente.getIdCliente());
			} catch (RowExistsException e) {
				errors.add("registraClienteAgente", new ActionMessage(e.toString()));
				if(i_log.isInfoEnabled())
					i_log.info("No se ha encontrado un agente para: "+cliente.getIdCliente());
			}
		}
		return errors;
	}
}
