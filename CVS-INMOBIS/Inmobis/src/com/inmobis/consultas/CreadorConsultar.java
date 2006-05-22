package com.inmobis.consultas;

//import com.inmobis.consultas.*;


public class CreadorConsultar {
	public static Consultar CreaConsultar(String Usuario)	{
		if (Usuario.equals("empleado")) return new ConsultarEmpleado();
		if (Usuario.equals("agente")) return new ConsultarAgente();
		if (Usuario.equals("cliente")) return new ConsultarCliente();
		if (Usuario.equals("inmueble")) return new ConsultarInmueble();
		if (Usuario.equals("inmuebleCondicion")) return new ConsultarInmuebleCondicion();
		if (Usuario.equals("mensaje")) return new ConsultarMensaje();
		return null;
	}

}
