package com.inmobis.modificaciones;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.inmobis.altas.IntroducirCliente;
import com.inmobis.bbdd.CreadorGestores;
import com.inmobis.bbdd.RowExistsException;
import com.inmobis.bbdd.RowNotFoundException;
import com.inmobis.bbdd.cliente.ClienteBean;
import com.inmobis.bbdd.cliente.GestorClienteBD;
import com.inmobis.bbdd.direccion.InfoDirBean;
import com.inmobis.bbdd.email.InfoMailBean;
import com.inmobis.bbdd.login.UsuarioLoginBean;
import com.inmobis.bbdd.telefono.InfoTelfBean;
import com.inmobis.struts.form.EditaClienteForm;
import com.inmobis.struts.form.RegistraClienteForm;

public class ModificarCliente extends Modificar{
	
	private static final Logger i_log = Logger.getLogger(IntroducirCliente.class);
	
	public ActionMessages modifica(ActionForm datosCliente){
		ActionMessages errors=new ActionMessages();
		
		ClienteBean cliente=new ClienteBean();
		cliente.setApellido1(((EditaClienteForm)datosCliente).getApellido1());
		cliente.setApellido2(((EditaClienteForm)datosCliente).getApellido2());
		cliente.setNombre(((EditaClienteForm)datosCliente).getNombre());
		cliente.setDni(((EditaClienteForm)datosCliente).getDni());
		String dia =(((EditaClienteForm)datosCliente).getDiaNacimiento());
		String mes =(((EditaClienteForm)datosCliente).getMesNacimiento());
		String anio =(((EditaClienteForm)datosCliente).getAnioNacimiento());
		String fecha=anio+"-"+mes+"-"+dia;
		if(i_log.isInfoEnabled())
			i_log.info("Fecha: " + fecha);
		cliente.setFechNacimiento(fecha);
		//TODO cambiar cuando tenga acceso al id
		//cliente.setIdCliente(((EditaClienteForm)datosCliente).getIdUsuario());
		cliente.setIdCliente("C101");
		
		CreadorGestores creador = new CreadorGestores();
		GestorClienteBD gestorCliente= (GestorClienteBD)creador.crearGestor("cliente",cliente);
		
		//Creamos un Bean de Direccion asociada al inmueble ya creado
		InfoDirBean direccion=gestorCliente.newInfoDirClientes("casa");
		//Rellenamos el bean 
		direccion.setCalle(((EditaClienteForm)datosCliente).getCalle());
		direccion.setNum(((EditaClienteForm)datosCliente).getNum());
		direccion.setPiso(((EditaClienteForm)datosCliente).getPiso());
		direccion.setCodPostal(((EditaClienteForm)datosCliente).getCodPostal());
		direccion.setPoblacion(((EditaClienteForm)datosCliente).getPoblacion());
		direccion.setProvincia(((EditaClienteForm)datosCliente).getProvincia());
		direccion.setPais(((EditaClienteForm)datosCliente).getPais());
		
		//Creamos un Bean de Telefono asociada al cliente ya creado
		InfoTelfBean telefono=gestorCliente.newInfoTelfClientes("casa");
		//Rellenamos el bean
		telefono.setTelefono(((EditaClienteForm)datosCliente).getTelefono1());
		telefono.setTelefono2(((EditaClienteForm)datosCliente).getTelefono2());
		
		//Creamos un Bean de Mail asociada al cliente ya creado
		InfoMailBean mail = gestorCliente.newInfoMailClientes("personal");
		//Rellenamos el bean
		mail.setDirMail(((EditaClienteForm)datosCliente).getEmail());
		
		//TODO se puede modificar la info de login?
		//Creamos un Bean de Login asociado al cliente ya creado
		UsuarioLoginBean login=gestorCliente.newInfoLoginClientes(cliente.getIdCliente());
		//Rellenamos el bean
		login.setNombreUsuario(((EditaClienteForm)datosCliente).getNombreUsuario());
		login.setPassword(((EditaClienteForm)datosCliente).getPassword());
		login.setTipoUsuario("cliente");
		
		try{
			gestorCliente.updateLogin(login);
			try{
				gestorCliente.update();
				gestorCliente.updateDir(direccion);
				gestorCliente.updateMail(mail);
				gestorCliente.updateTelf(telefono);
			}
			catch(Exception e){
				errors.add("editaCliente", new ActionMessage(e.toString()));
				if(i_log.isInfoEnabled())
					i_log.info("Fallo en BBDD al actualizar cliente:" + e.toString());
			}
		}
//		catch (RowExistsException e){
//			errors.add("nombreUsuario", new ActionMessage("errors.nombreUsuario.duplicated"));
//			if(i_log.isInfoEnabled())
//				i_log.info(login.getNombreUsuario()+" ya existe : " + e.toString());
//		}
		catch (RowNotFoundException e){
			errors.add("nombreUsuario", new ActionMessage("errors.nombreUsuario.duplicated"));
			if(i_log.isInfoEnabled())
				i_log.info(login.getNombreUsuario()+" ya existe : " + e.toString());
		}
		//TODO Asignar el agente si este se ha modificado
		return errors;
	}
}
