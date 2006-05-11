package com.inmobis.login;

public final class CreadorLogin {
	public static Login CreateLogin(String TipoUsu)
	{
		if (TipoUsu == "empleado") return new LoginEmpleado();
		else return new LoginCliente(); 
	}
}
