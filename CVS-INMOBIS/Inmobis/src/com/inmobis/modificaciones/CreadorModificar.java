package com.inmobis.modificaciones;

public class CreadorModificar {
	public static Modificar createModificar(String tipo){
		if (tipo.equals("piso"))
			return new ModificarInmueble();
		if (tipo.equals("empleado"))
			return new ModificarEmpleado();
		if (tipo.equals("cliente"))
			return new ModificarCliente();
		return null;
	}
}
