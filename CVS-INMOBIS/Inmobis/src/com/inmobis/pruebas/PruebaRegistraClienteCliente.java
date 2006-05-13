package com.inmobis.pruebas;

import servletunit.struts.MockStrutsTestCase; 
import java.io.File;
import com.inmobis.struts.form.RegistraClienteForm;

public class PruebaRegistraClienteCliente extends MockStrutsTestCase {
	
	public void setUp() throws Exception {
		super.setUp();
		// fijo el directorio de contexto a WebRoot
		setContextDirectory(new File("WebRoot"));
		// creo una instancia del Form correspondiente al action
		// que quiero probar, e introduzco los datos
		/*RegistraClienteForm formulario = new RegistraClienteForm();
		formulario.setAnioNacimiento("1979");
		formulario.setApellido1("Gonzalez");
		formulario.setApellido2("Perez");
		formulario.setCalle("Calle Alta");
		formulario.setCodPostal("28000");
		formulario.setDiaNacimiento("11/11/06");
		formulario.setDni("47023423");
		formulario.setEmail("pepeito@hotmail.com");
		formulario.setEsAgente(false);
		formulario.setIdAgente("1");
		formulario.setMesNacimiento("Marzo");
		formulario.setNombre("Pepe");
		formulario.setNombreUsuario("josua");
		formulario.setNum("9999");
		formulario.setPais("Spain");
		formulario.setPassword("whatsup");
		formulario.setPasswordAgain("whatsup");
		formulario.setPiso("10");
		formulario.setPoblacion("Madrid");
		formulario.setProvincia("madrid");
		formulario.setTelefono1("91555555533");
		formulario.setTelefono2("665456789323232");*/
	}
	
	public PruebaRegistraClienteCliente(String testname) { 
		super(testname);	
	}

	
	public void testRegistraClienteCliente(){
		setConfigFile("/WEB-INF/struts-config.xml");
	    //setRequestPathInfo("/AgentePiso","/EditaPiso");
		setRequestPathInfo("/registraClienteCliente");
		addRequestParameter("nombreUsuario","pepe");
		actionPerform();
		verifyForward("exito");
		verifyNoActionErrors();
	}
}
