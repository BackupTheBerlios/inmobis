package com.inmobis.bbdd;

import com.inmobis.bbdd.cliente.*;
import com.inmobis.bbdd.inmueble.*;
import com.inmobis.bbdd.empleado.*;
import com.inmobis.bbdd.mensajes.*;

public final class CreadorGestores {
	public static BDObject crearGestor(String tipo, Object bean){
		if (tipo.toLowerCase().equals("cliente"))
			return (BDObject)new ClienteBD((ClienteBean)bean);
		if (tipo.toLowerCase().equals("empleado"))
			return (BDObject)new EmpleadoBD((EmpleadoBean)bean);
		if (tipo.toLowerCase().equals("inmueble"))
			return (BDObject)new InmuebleBD((InmuebleBean)bean);
		if(tipo.toLowerCase().equals("mensajes"))
			return (BDObject)new MensajesBD((MensajesBean)bean);
		if(tipo.toLowerCase().equals("agente"))
			return (BDObject)new AgenteBD((AgenteBean)bean);
		if(tipo.toLowerCase().equals("contable"))
			return (BDObject)new VentasBD((VentasBean)bean);
		return null;
	}
}
