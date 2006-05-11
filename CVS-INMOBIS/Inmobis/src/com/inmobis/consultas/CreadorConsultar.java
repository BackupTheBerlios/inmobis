package com.inmobis.consultas;

import com.inmobis.consultas.Consultar;
import com.inmobis.consultas.ConsultarAgente;
import com.inmobis.consultas.ConsultarCliente;
import com.inmobis.consultas.ConsultarEmpleado;
import com.inmobis.consultas.ConsultarInmueble;
import com.inmobis.consultas.ConsultarInmuebleCondicion;


public class CreadorConsultar {
	public static Consultar CreaConsultar(String Usuario)	{
		if (Usuario.equals("empleado")) return new ConsultarEmpleado();
		if (Usuario.equals("agente")) return new ConsultarAgente();
		if (Usuario.equals("cliente")) return new ConsultarCliente();
		if (Usuario.equals("inmueble")) return new ConsultarInmueble();
		if (Usuario.equals("inmuebleCondicion")) return new ConsultarInmuebleCondicion();
		return null;
	}

}
