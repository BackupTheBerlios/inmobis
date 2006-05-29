package com.inmobis.modificaciones;

import java.util.Vector;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.inmobis.bbdd.CreadorGestores;
import com.inmobis.bbdd.RowExistsException;
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

public class ModificarEmpleado extends Modificar{
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
		empleado.setDni(((EditaEmpleadoForm)datosEmpleado).getNif());
		//generar el idEmpleado para la BBDD con la funcion de Esther
		empleado.setIdEmpleado(((EditaEmpleadoForm)datosEmpleado).getIdUsuario());

		GestorEmpleadoBD gestorEmpleado=(GestorEmpleadoBD)CreadorGestores.crearGestor("empleado",empleado);
		
		//Creamos un Bean de Direccion asociada al empleado ya creado
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
		
		//Aquí guardo de que tipo era antes
		try {
			gestorEmpleado.consultaLoginPorId(((EditaEmpleadoForm)datosEmpleado).getIdUsuario());
		} catch (RowNotFoundException e) {
			if(i_log.isInfoEnabled())
				i_log.info("Fallo en BBDD :" + e.toString());
		}
		String tipoViejo=((UsuarioLoginBean)gestorEmpleado.getLoginBean()).getTipoUsuario().toLowerCase();
		//Creamos un Bean de Login asociado al empleado ya creado
		UsuarioLoginBean login=gestorEmpleado.newInfoLoginEmpleados(empleado.getIdEmpleado());
		//Rellenamos el bean
		login.setNombreUsuario(((EditaEmpleadoForm)datosEmpleado).getNif());
		login.setPassword(((EditaEmpleadoForm)datosEmpleado).getPassword());
		login.setTipoUsuario(((EditaEmpleadoForm)datosEmpleado).getTipoEmpleado());
		//Segun el tipo de usuario que sea, actualizo una u otra tabla
		
		//El nombre de usuario del empleado será el DNI, que es unico
		try{
			gestorEmpleado.updateLogin(login);
			try{
				gestorEmpleado.update();
				gestorEmpleado.updateDir(direccion);
				gestorEmpleado.updateMail(mail);
				gestorEmpleado.updateTelf(telefono);
			}
			catch(Exception e){
				errors.add("editaEmpleado", new ActionMessage(e.toString()));
				if(i_log.isInfoEnabled())
					i_log.info("Fallo en BBDD :" + e.toString());
			}
			
			//Al actualizar a agente, miro si ya era agente. 
			//Si no existia tendre que crear una nueva entrada en tagente.			
			if(((EditaEmpleadoForm)datosEmpleado).getTipoEmpleado().toLowerCase().equals("agente")){
				AgenteBean agente =new AgenteBean();
				agente.setIdAgente(empleado.getIdEmpleado());
				agente.setComision(((EditaEmpleadoForm)datosEmpleado).getPorcentaje());
				GestorAgenteBD gestorAgente = (GestorAgenteBD)CreadorGestores.crearGestor("agente",agente);
				//Si no era agente le introduzco
				if(!tipoViejo.equals("agente")){
					if(i_log.isInfoEnabled())
						i_log.info(empleado.getDni()+" no era agente ->Introducirle");
					gestorAgente.insert();
				}
				//Si era agente le actualizo
				else{
					if(i_log.isInfoEnabled())
						i_log.info(empleado.getDni()+" era un agente ->Actualizo");
					gestorAgente.update();
				}
			}
			//Para los demas, tendre que ver si antes eran agentes.
			//Si lo eran, tendre que borrar su entrada en tagente, comprobando que no tenian clientes asociados
			else{
				if(tipoViejo.equals("agente")){
					if(i_log.isInfoEnabled())
						i_log.info(empleado.getDni()+" era un agente ->Tengo que ver si no tenia clientes");
					AgenteBean agente =new AgenteBean();
					agente.setIdAgente(empleado.getIdEmpleado());
					GestorAgenteBD gestorAgente = (GestorAgenteBD)CreadorGestores.crearGestor("agente",agente);
					Vector v=gestorAgente.listarClientesAsociados();
					if(v.size()==0){
						if(i_log.isInfoEnabled())
							i_log.info(empleado.getDni()+" no tenia clientes ->Le borro");
						try {
							gestorAgente.delete();
							if(i_log.isInfoEnabled())
								i_log.info(empleado.getDni()+" Borrado");
						} catch (RowNotFoundException e1) {
							if(i_log.isInfoEnabled())
								i_log.info(empleado.getDni()+" No se ha podido borrar "+e1);
						}
					}
					else{
						if(i_log.isInfoEnabled())
							i_log.info(empleado.getDni()+" tenia clientes ->No le puedo borrar");
						errors.add("editaEmpleado", new ActionMessage("errors.listaClientes.notEmpty"));
					}
				} 
				else
					if(i_log.isInfoEnabled())
						i_log.info(empleado.getDni()+" no era agente ->No hay que hacer nada.");
			}
		}
		catch (RowExistsException e){
			errors.add("nif", new ActionMessage("errors.empleado.duplicated"));
			if(i_log.isInfoEnabled())
				i_log.info(login.getNombreUsuario()+" ya existe : " + e.toString());
		}
		catch (RowNotFoundException e){
			errors.add("editaEmpleado", new ActionMessage("errors.bbdd.clave"));
			if(i_log.isInfoEnabled())
				i_log.info("Error fatal en BBDD, no se ha encontrado la clave");
		}
		return errors;
	}
}
