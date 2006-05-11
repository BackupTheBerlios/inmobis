package com.inmobis.altas;

public final class CreadorIntroducir {
	public static Introducir createIntroducir(String tipo){
		if (tipo.equals("piso"))
			return new IntroducirInmueble();
		if (tipo.equals("empleado"))
			return new IntroducirEmpleado();
		if (tipo.equals("cliente"))
			return new IntroducirCliente();
		return null;
	}
}
