package com.inmobis.bajas;

public final class CreadorEliminar {

	public static Eliminar CreaEliminar(String Usuario)	{
		if (Usuario.equals("empleado")) return new EliminarEmpleado();
		if (Usuario.equals("administrador")) return new EliminarAdministrador();
		if (Usuario.equals("cliente")) return new EliminarCliente();
		if (Usuario.equals("inmueble")) return new EliminarInmueble();
		if (Usuario.equals("mensaje")) return new EliminarMensaje();
		return null;
	}
}
