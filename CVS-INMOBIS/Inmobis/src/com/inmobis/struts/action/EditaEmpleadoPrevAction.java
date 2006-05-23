package com.inmobis.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.inmobis.bbdd.direccion.InfoDirBean;
import com.inmobis.bbdd.email.InfoMailBean;
import com.inmobis.bbdd.empleado.EmpleadoBean;
import com.inmobis.bbdd.login.UsuarioLoginBean;
import com.inmobis.bbdd.telefono.InfoTelfBean;
import com.inmobis.consultas.Consultar;
import com.inmobis.consultas.CreadorConsultar;
import com.inmobis.struts.form.EditaEmpleadoPrevForm;

public class EditaEmpleadoPrevAction extends Action {

	private static final Logger i_log = Logger.getLogger(EditaEmpleadoPrevAction.class);
	
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response) {
		//Coger los datos de la lista que le llega al form, obtener los
		//datos que faltan de la BBDD y pasarselos al jsp de editaEmpleado
		if (i_log.isInfoEnabled()){
			i_log.info("Voy a coger los datos del usuario: "+((EditaEmpleadoPrevForm)form).getIdUsuario());
		}
		EmpleadoBean empleado=new EmpleadoBean();
		empleado.setNombre(((EditaEmpleadoPrevForm)form).getNombre());
		empleado.setApellido1(((EditaEmpleadoPrevForm)form).getApellido1());
		empleado.setApellido2(((EditaEmpleadoPrevForm)form).getApellido2());
		empleado.setIdDni(((EditaEmpleadoPrevForm)form).getDni());
		empleado.setFechNacimiento(((EditaEmpleadoPrevForm)form).getFechaNacimiento());
		empleado.setIdEmpleado(((EditaEmpleadoPrevForm)form).getIdUsuario());
		
		Consultar consult=CreadorConsultar.CreaConsultar("empleado");
		InfoDirBean dir=consult.getDir(form);
		InfoTelfBean telf=consult.getTelf(form);
		UsuarioLoginBean login=consult.getLogin(form);
		InfoMailBean mail=consult.getMail(form);
		
		if(login.getTipoUsuario().equals("agente"));
		consult=CreadorConsultar.CreaConsultar("agente");
		//TODO Acceder a los datos del agente (porcentaje)
		//AgenteBean agente=consult.
		
		if (i_log.isInfoEnabled()){
			i_log.info("Direccion "+dir.getCalle());
			i_log.info("telefono "+telf.getTelefono());
			i_log.info("Login "+login.getNombreUsuario());
			//Ojo con este que no siempre hay email
			i_log.info("mail "+mail.getDirMail());
		}
		//Poner los datos en una variable de sesion
		HttpSession session = request.getSession(true);
		session.setAttribute("empleado",empleado);
		session.setAttribute("direccion",dir);
		session.setAttribute("login",login);
		session.setAttribute("telefono",telf);
		session.setAttribute("mail",mail);
		String fecha=((EditaEmpleadoPrevForm)form).getFechaNacimiento();
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

