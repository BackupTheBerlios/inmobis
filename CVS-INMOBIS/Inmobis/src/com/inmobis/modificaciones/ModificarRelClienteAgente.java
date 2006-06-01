package com.inmobis.modificaciones;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.inmobis.bbdd.CreadorGestores;
import com.inmobis.bbdd.RowNotFoundException;
import com.inmobis.bbdd.empleado.AgenteBean;
import com.inmobis.bbdd.empleado.GestorAgenteBD;
import com.inmobis.bbdd.empleado.RelAgenteClienteBean;
import com.inmobis.struts.form.TraspasarClientesForm;

public class ModificarRelClienteAgente extends Modificar{
	private static final Logger i_log = Logger.getLogger(ModificarRelClienteAgente.class);
	
	public ActionMessages modifica(ActionForm datos){
		
		ActionMessages errors=new ActionMessages();
		
		RelAgenteClienteBean rel=new RelAgenteClienteBean();
		rel.setIdCliente(((TraspasarClientesForm)datos).getIdCliente());
		
		AgenteBean agente =new AgenteBean();
		GestorAgenteBD gestorAgente=((GestorAgenteBD)CreadorGestores.crearGestor("agente",agente));
		try {
			gestorAgente.updateRelAgenteCliente(((TraspasarClientesForm)datos).getIdEmpleado(),((TraspasarClientesForm)datos).getIdCliente());
		} catch (RowNotFoundException e) {
			errors.add("MenuGerente",new ActionMessage("errors.traspasar.ClienteNotFound"));
		}
		
		
		return errors;
	}
}
