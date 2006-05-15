package com.inmobis.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class EditaClienteForm extends ActionForm {
	private static final Logger i_log = Logger.getLogger(EditaClienteForm.class);
	private String idUsuario;
	//datos de login
	private String nombreUsuario;
	private String password;
	private String passwordAgain;
	//datos personales
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String diaNacimiento;
	private String mesNacimiento;
	private String anioNacimiento;
	private String dni;
	//telefono
	private String telefono1;
	private String telefono2;
	//email
	private String email;
	//direccion
	private String calle;
	private String num;
	private String piso;
	private String codPostal;
	private String poblacion;
	private String provincia;
	private String pais;
	//Identificador del agente que lo registra
	private String idAgente;
	

	public void reset(ActionMapping mapping, HttpServletRequest request)
	{
		this.idUsuario="";	
		this.nombreUsuario="";
		this.password="";
		this.passwordAgain="";
		this.nombre="";
		this.apellido1="";
		this.apellido2="";
		this.dni="";
		this.diaNacimiento="";
		this.mesNacimiento="";
		this.anioNacimiento="";
		this.telefono1="";
		this.telefono2="";
		this.email="";
		this.calle="";
		this.num="";
		this.piso="";
		this.codPostal="";
		this.poblacion="";
		this.provincia="";
		this.pais="";
		this.idAgente="";
	}
	
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request)
	{
		ActionErrors errors = new ActionErrors();

		if (i_log.isInfoEnabled()){
			i_log.info("Antes de comprobar los errores. Nº errores: "+errors.size());
		}
		
//		El nombre de usuario tiene que tener al menos 2 caractereres
		if(nombreUsuario.equals("") || nombreUsuario.length() < 2){
			errors.add("nombreUsuario", new ActionMessage("errors.nombreUsuario.required"));	
		}
		
		//La contraseña tiene que tener al menos 4 caracteres
		if(password.equals("") || password.length() < 4)
			errors.add("password", new ActionMessage("errors.registro.password.required"));
		
		//Los campos contraseña y repitaContraseña tienen que ser iguales
		if(!(password.equals(passwordAgain)))
			errors.add("passwordAgain", new ActionMessage("errors.passwordAgain.notEqual"));
		
		//Tiene que haber rellenado al menos el nombre y un apellido
		if (nombre.equals("") || apellido1.equals("")|| !esNombre(nombre) || !esNombre(apellido1))
			errors.add("nombre", new ActionMessage("errors.realName.incomplete"));
		if (!apellido2.equals("") && !esNombre(apellido2))
			errors.add("nombre", new ActionMessage("errors.realName.incomplete"));
		if (diaNacimiento.equals("") || mesNacimiento.equals("") || anioNacimiento.equals("")){
			errors.add("registraClienteCliente", new ActionMessage("errors.fecha.notValid"));
		}
		//El nif tiene que tener longitud 8
		if (dni==null || dni.equals("") || dni.length()!=8)
			errors.add("nif", new ActionMessage("errors.nif.notValid"));
		
		//Tiene que haber al menos 1 telefono de 9 cifras
		if (telefono1.equals("")|| telefono1.length()!=9 )
			errors.add("telefono1", new ActionMessage("errors.telefono1.notValid"));
		else{
			try{
				new Integer(telefono1).intValue();
			}catch(Exception e){
				errors.add("telefono1", new ActionMessage("errors.telefono1.notValid"));
			}
		}
		//Si se pone un segundo telefono, tambien ha de tener 9 cifras
		if (!telefono2.equals(""))
			if(telefono2.length()==9){
				try{
					new Integer(telefono2).intValue();
				}catch(Exception e){
					errors.add("telefono2", new ActionMessage("errors.telefono2.notValid"));
				}
			}
			else
				errors.add("telefono2", new ActionMessage("errors.telefono2.notValid"));
		//La direcion de correo debe ser valida 
		//if(email.equals(""))
		//	errors.add("email" , new ActionMessage("errors.email.notValid"));
		//else{
		if(!email.equals("")){
			String[] tokens = email.split("@");
			//Solo puede haber una arroba y no puede haber espacios
			if(tokens.length==2){
				String[] tokens2 = tokens[1].split("\\.");
				//Pero puede haber muchos puntos (@domain.co.uk)
				if(tokens2.length>1){
					boolean tokens2valid=true;
					//El primer campo tiene que tener 2 o mas caracteres
					if (tokens2[0].length()<2 || tokens2[0].contains(" ")){
						tokens2valid=false; 
					}
					//El resto tienen que tener 2 o 3
					for(int i=1; i<tokens2.length;i++)
						if (tokens2[i].length()<2 ||tokens2[i].length()>3 || tokens[i].contains(" "))
							tokens2valid=false;
					if(tokens[0].trim().length()<=0 || !tokens2valid || tokens[0].contains(" "))
						errors.add("email" , new ActionMessage("errors.email.notValid"));					
				}
				else
					errors.add("email" , new ActionMessage("errors.email.notValid"));
			}
			else
				errors.add("email" , new ActionMessage("errors.email.notValid"));
		}
		//Hay que rellenar obligatoriamente todo menos el piso
		if(calle.equals("") || num.equals("") || codPostal.equals("") || 
				poblacion.equals("") || provincia.equals("") || pais.equals("")){
			errors.add("calle", new ActionMessage("errors.direccion.incomplete"));
		}
		if(!esNombre(poblacion))
			errors.add("poblacion", new ActionMessage("errors.poblacion.notValid"));
		if(!esNombre(provincia))
			errors.add("provincia", new ActionMessage("errors.provincia.notValid"));
		if(!esNombre(pais))
			errors.add("pais", new ActionMessage("errors.pais.notValid"));
		//El numero solo puede contener digitos
		if(!num.equals("")){
			try{
				new Integer(num).intValue();
			}catch(Exception e){
				errors.add("num", new ActionMessage("errors.num.notValid"));
			}
		}
		//El codigo postal debe tenr 5 digitos
		if(codPostal.length()!=5)
			errors.add("codPostal", new ActionMessage("errors.direccion.CPnotValid"));
		else{
			try{
				new Integer(codPostal).intValue();
			}catch(Exception e){
				errors.add("codPostal", new ActionMessage("errors.direccion.CPnotValid"));
			}
		}
		
//		if(nombreUsuario.equals("") && password.equals("") && nombre.equals("") &&
//				apellido1.equals("") && apellido2.equals("") && diaNacimiento.equals("") &&
//				mesNacimiento.equals("") && anioNacimiento.equals("") && dni.equals("") &&
//				telefono1.equals("") && telefono2.equals("") && email.equals("") && calle.equals("") &&
//				num.equals("") && piso.equals("") && codPostal.equals("") &&poblacion.equals("")&&
//				provincia.equals("") && pais.equals(""))
//			errors.add("editaCliente", new ActionMessage("error.editaCliente.invalid"));
//		
//		//El nombre de usuario tiene que tener al menos 2 caractereres
//		if(!nombreUsuario.equals("") && nombreUsuario.length() < 2){
//			errors.add("nombreUsuario", new ActionMessage("errors.nombreUsuario.required"));	
//		}
//		
//		//La contraseña tiene que tener al menos 4 caracteres
//		if(!password.equals("") && password.length() < 4)
//			errors.add("password", new ActionMessage("errors.registro.password.required"));
//		
//		//Los campos contraseña y repitaContraseña tienen que ser iguales
//		if(!(password.equals(passwordAgain)))
//			errors.add("passwordAgain", new ActionMessage("errors.passwordAgain.notEqual"));
//		
//		//Los nombres y apellidos deben ser letras
//		if (!nombre.equals("") || !esNombre(nombre))
//			errors.add("nombre", new ActionMessage("errors.realName.incomplete"));
//
//		if (!apellido1.equals("") || !esNombre(apellido1))
//			errors.add("apellido1", new ActionMessage("errors.realName.incomplete"));
//		
//		if (!apellido2.equals("") && !esNombre(apellido2))
//			errors.add("apellido2", new ActionMessage("errors.realName.incomplete"));
//		
//		//La fecha se comprueba en el jsp
//		
//		//El nif tiene que tener longitud 8
//		if (!dni.equals(""))
//			if (dni.length()!=8)
//				errors.add("nif", new ActionMessage("errors.nif.notValid"));
//			else{
//				try{
//					new Integer(dni).intValue();
//				}
//				catch(Exception e){
//					errors.add("nif", new ActionMessage("errors.nif.notValid"));
//				}
//			}
//		//eL telefono tiene que tener 9 cifras
//		if (!telefono1.equals(""))
//			if(telefono1.length()==9){
//				try{
//					new Integer(telefono1).intValue();
//				}catch(Exception e){
//					errors.add("telefono1", new ActionMessage("errors.telefono1.notValid"));
//				}
//			}
//			else
//				errors.add("telefono1", new ActionMessage("errors.telefono1.notValid"));
//		
//		//Si se pone un segundo telefono, tambien ha de tener 9 cifras
//		if (!telefono2.equals(""))
//			if(telefono2.length()==9){
//				try{
//					new Integer(telefono2).intValue();
//				}catch(Exception e){
//					errors.add("telefono2", new ActionMessage("errors.telefono2.notValid"));
//				}
//			}
//			else
//				errors.add("telefono2", new ActionMessage("errors.telefono2.notValid"));
//		//La direcion de correo debe ser valida 
//		if(!email.equals("")){
//			String[] tokens = email.split("@");
//			//Solo puede haber una arroba y no puede haber espacios
//			if(tokens.length==2){
//				String[] tokens2 = tokens[1].split("\\.");
//				//Pero puede haber muchos puntos (@domain.co.uk)
//				if(tokens2.length>1){
//					boolean tokens2valid=true;
//					//El primer campo tiene que tener 2 o mas caracteres
//					if (tokens2[0].length()<2){
//						tokens2valid=false;
//					}
//					//El resto tienen que tener 2 o 3
//					for(int i=1; i<tokens2.length;i++)
//						if (tokens2[i].length()<2 ||tokens2[i].length()>3)
//							tokens2valid=false;
//					if(tokens[0].trim().length()<=0 || !tokens2valid)
//						errors.add("email" , new ActionMessage("errors.email.notValid"));					
//				}
//				else
//					errors.add("email" , new ActionMessage("errors.email.notFalid"));
//			}
//			else
//				errors.add("email" , new ActionMessage("errors.email.notValid"));
//		}
//		
//		//Los nombres de calle, poblacion, provincia y pais solo pueden tener letras
//		if(!poblacion.equals("") &&!esNombre(poblacion))
//			errors.add("poblacion", new ActionMessage("errors.poblacion.notValid"));
//		if(!provincia.equals("") &&!esNombre(provincia))
//			errors.add("provincia", new ActionMessage("errors.provincia.notValid"));
//		if(!pais.equals("") &&!esNombre(pais))
//			errors.add("pais", new ActionMessage("errors.pais.notValid"));
//		//El numero solo puede contener digitos
//		if(!num.equals("")){
//			try{
//				new Integer(num).intValue();
//			}catch(Exception e){
//				errors.add("num", new ActionMessage("errors.num.notValid"));
//			}
//		}
//		//El codigo postal debe tenr 5 digitos
//		if(!codPostal.equals("")){
//			if(codPostal.length()!=5)
//				errors.add("codPostal", new ActionMessage("errors.direccion.CPnotValid"));
//			else{
//				try{
//					new Integer(codPostal).intValue();
//				}catch(Exception e){
//					errors.add("codPostal", new ActionMessage("errors.direccion.CPnotValid"));
//				}
//			}
//		}
		if (i_log.isInfoEnabled()){
			i_log.info("Despues de comprobar los errores. Nº errores: "+errors.size());
		}	
		return errors;
			
	}

	//Metodo para saber si una cadena solo tiene letras y espacios
	boolean esNombre(String cadena){
		boolean valido=true;
		char[] chars = cadena.toCharArray();
		int i=0;
		while(i<chars.length && valido){
			if (!Character.isLetter(chars[i]) && !Character.isSpace(chars[i]))
				valido=false;	
			i++;
		}
		return valido;
	}
	
	public String getIdUsuario(){
		return this.idUsuario;
	}
	public String getNombreUsuario(){
		return this.nombreUsuario;
	}
	public String getPassword(){
		return this.password;
	}
	public String getPasswordAgain(){
		return this.passwordAgain;
	}
	public String getNombre(){
		return this.nombre;
	}
	public String getApellido1(){
		return this.apellido1;
	}
	public String getApellido2(){
		return this.apellido2;
	}
	public String getDni(){
		return this.dni;
	}
	public String getTelefono1(){
		return this.telefono1;
	}
	public String getTelefono2(){
		return this.telefono2;
	}
	public String getEmail(){
		return this.email;
	}
	public String getDiaNacimiento(){
		return this.diaNacimiento;
	}
	public String getMesNacimiento(){
		return this.mesNacimiento;
	}
	public String getAnioNacimiento(){
		return this.anioNacimiento;
	}
	public String getCalle(){
		return this.calle;
	}
	public String getNum(){
		return this.num;
	}
	public String getPiso(){
		return this.piso;
	}
	public String getCodPostal(){
		return this.codPostal;
	}
	public String getPoblacion(){
		return this.poblacion;
	}
	public String getProvincia(){
		return this.provincia;
	}
	public String getPais(){
		return this.pais;
	}
	public String getIdAgente(){
		return this.idAgente;
	}
	//Setters
	
	public void setIdUsuario(String id){
		this.idUsuario=id;
	}
	public void setNombreUsuario(String nUsuario){
		this.nombreUsuario=nUsuario.trim();
	}
	public void setPassword(String pass){
		this.password=pass.trim();
	}
	public void setPasswordAgain(String pass){
		this.passwordAgain=pass.trim();
	}
	public void setNombre(String nombre){
		this.nombre=nombre.trim();
	}
	public void setApellido1(String ap1){
		this.apellido1=ap1.trim();
	}
	public void setApellido2(String ap2){
		this.apellido2=ap2.trim();
	}
	public void setDni(String dni){
		this.dni=dni.trim();
	}
	public void setTelefono1(String tlf1){
		this.telefono1=tlf1.trim();
	}
	public void setTelefono2(String tlf2){
		this.telefono2=tlf2.trim();
	}
	public void setEmail(String email){
		this.email=email.trim();
	}
	public void setDiaNacimiento(String fecha){
		this.diaNacimiento=fecha.trim();
	}
	public void setMesNacimiento(String fecha){
		this.mesNacimiento=fecha.trim();
	}
	public void setAnioNacimiento(String fecha){
		this.anioNacimiento=fecha.trim();
	}
	public void setCalle(String calle){
		this.calle=calle.trim();
	}
	public void setNum(String num){
		this.num=num.trim();
	}
	public void setPiso(String piso){
		this.piso=piso.trim();
	}
	public void setCodPostal(String cp){
		this.codPostal=cp.trim();
	}
	public void setPoblacion(String pob){
		this.poblacion=pob.trim();
	}
	public void setProvincia(String prov){
		this.provincia=prov.trim();
	}
	public void setPais(String pais){
		this.pais=pais.trim();
	}
	public void setIdAgente(String idA){
		this.idAgente=idA.trim();
	}

}
