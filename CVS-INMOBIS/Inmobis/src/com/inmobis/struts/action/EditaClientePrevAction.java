package com.inmobis.struts.action;

import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;

import com.inmobis.bbdd.cliente.ClienteBean;
import com.inmobis.bbdd.direccion.InfoDirBean;
import com.inmobis.bbdd.email.InfoMailBean;
import com.inmobis.bbdd.login.UsuarioLoginBean;
import com.inmobis.bbdd.telefono.InfoTelfBean;
import com.inmobis.consultas.Consultar;
import com.inmobis.consultas.ConsultarCliente;
import com.inmobis.consultas.CreadorConsultar;
import com.inmobis.modificaciones.CreadorModificar;
import com.inmobis.modificaciones.Modificar;
import com.inmobis.struts.form.EditaClienteForm;
import com.inmobis.struts.form.EditaClientePrevForm;

public class EditaClientePrevAction extends Action{

	private static final Logger i_log = Logger.getLogger(EditaClientePrevAction.class);
	
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) {
			
		//TODO Coger los datos de la lista que le llega al form y pasarselos al jsp de editarEmpleado
		if (i_log.isInfoEnabled()){
			i_log.info("Voy a coger los datos del usuario: "+((EditaClientePrevForm)form).getNombre());
		}
		//Accedo a los datos del usuario
		//En teoria el vector debería tener 1 elemento
		//En el caso del mail(opcional) tambien puede estar vacio
		
		ClienteBean cliente=new ClienteBean();
		cliente.setNombre(((EditaClientePrevForm)form).getNombre());
		cliente.setApellido1(((EditaClientePrevForm)form).getApellido1());
		cliente.setApellido2(((EditaClientePrevForm)form).getApellido2());
		cliente.setDni(((EditaClientePrevForm)form).getDni());
		cliente.setFechNacimiento(((EditaClientePrevForm)form).getFechaNacimiento());
		cliente.setIdCliente(((EditaClientePrevForm)form).getIdUsuario());
		
		Consultar consult=CreadorConsultar.CreaConsultar("telefono");
		Vector telefonos=consult.listar(form);
		
		//TODO ver de donde se coge la direccion
		consult=CreadorConsultar.CreaConsultar("cliente");
		//direccion=((ConsultarCliente)consult).obtenerDir(cliente);
		
		consult=CreadorConsultar.CreaConsultar("mail");
		Vector mails=consult.listar(form);
		
		consult=CreadorConsultar.CreaConsultar("login");
		Vector logins=consult.listar(form);
		
		if(telefonos.size()<1 && mails.size()<1 && logins.size()<1){
			//saveErrors(request, errors);
			if (i_log.isInfoEnabled()){
				i_log.info("No he encontrado datos extra");
			}
			return (mapping.findForward("error"));
		}
		if (i_log.isInfoEnabled()){
			i_log.info("Hay datos extras");
		}
		
		//Poner los datos en una variable de sesion
		
		HttpSession session = request.getSession(true);
		
		session.setAttribute("cliente",cliente);
		InfoDirBean direccion=((InfoDirBean)direcciones.elementAt(0));
		session.setAttribute("direccion",direccion);
		InfoTelfBean telefono=((InfoTelfBean)telefonos.elementAt(0));
		session.setAttribute("telefono",telefono);
		UsuarioLoginBean login=((UsuarioLoginBean)logins.elementAt(0));
		session.setAttribute("login",login);
		if (mails.size()!=0){
			InfoMailBean mail=((InfoMailBean)mails.elementAt(0));
			session.setAttribute("mail",mail);
		}
		String fecha= cliente.getFechNacimiento();
		String[] componentes=fecha.split("-");
		if (i_log.isInfoEnabled()){
			i_log.info("Dia:"+componentes[2].toString()+" Mes:"+componentes[1].toString()+" Año:"+componentes[0].toString());
		}
		session.setAttribute("dia",componentes[2].toString());
		session.setAttribute("mes",componentes[1].toString());
		session.setAttribute("anio",componentes[0].toString());
		return (mapping.findForward("exito"));
		}

}
