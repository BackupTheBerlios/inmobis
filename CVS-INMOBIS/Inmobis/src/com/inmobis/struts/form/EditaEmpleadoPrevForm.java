//Created by MyEclipse Struts
// XSL source (default): platform:/plugin/com.genuitec.eclipse.cross.easystruts.eclipse_4.0.0/xslt/JavaClass.xsl

package com.inmobis.struts.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;


//TODO hay que ver que campos del empleado puede editar el administrador
//, y cuales no tiene sentido editar (fechaNacimiento, nombre, DNI?)
public class EditaEmpleadoPrevForm extends ActionForm {

	private static final Logger i_log = Logger.getLogger(RegistraEmpleadoForm.class);
	//datos personales
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String fechaNacimiento;
	private String nif;
	private String tipoEmpleado;
	private String porcentaje;
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
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {

		this.nombre="";
		this.apellido1="";
		this.apellido2="";
		this.fechaNacimiento="";
		this.nif="";
		this.tipoEmpleado="";
		this.porcentaje="";
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
	}
	
	public ActionErrors validate(ActionMapping mapping,
								HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();

		if (i_log.isInfoEnabled()){
			i_log.info("Antes de comprobar los errores. Nº errores: "+errors.size());
		}
		
		if(nombre.equals("") &&	apellido1.equals("") && apellido2.equals("") && fechaNacimiento.equals("") &&
				telefono1.equals("") && telefono2.equals("") && email.equals("") && calle.equals("") &&
				num.equals("") && piso.equals("") && codPostal.equals("") &&poblacion.equals("")&&
				provincia.equals("") && pais.equals(""))
			errors.add("editaCliente", new ActionMessage("error.editaCliente.invalid"));
		
		//TODO FechaNacimiento (lo mismo que en cliente)
		//TODO Puede el superusuario cambiar el tipo de empleado?
		
		//Si he seleccionado agente, tengo que rellenar porcentaje
		if (tipoEmpleado.equals("agente") && porcentaje.equals(""))
			errors.add("tipoEmpleado", new ActionMessage("errors.porcentaje.required"));
		
		//El telefono tiene que tener 9 cifras
		if (!telefono1.equals(""))
			if(telefono1.length()==9){
				try{
					new Integer(telefono1).intValue();
				}catch(Exception e){
					errors.add("telefono1", new ActionMessage("errors.telefono1.notValid"));
				}
			}
			else
				errors.add("telefono1", new ActionMessage("errors.telefono1.notValid"));
		
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
		if(!email.equals("")){
			String[] tokens = email.split("@");
			//Solo puede haber una arroba y no puede haber espacios
			if(tokens.length==2){
				String dominio=tokens[1];
				String[] tokens2 = dominio.split("\\.");
				//Pero puede haber muchos puntos (@domain.co.uk)
				if(tokens2.length>1){
					boolean tokens2valid=true;
					//El primer campo tiene que tener 2 o mas caracteres
					if (tokens2[0].length()<2){
						tokens2valid=false;
					}
					//El resto tienen que tener 2 o 3
					for(int i=1; i<tokens2.length;i++)
						if (tokens2[i].length()<2 ||tokens2[i].length()>3)
							tokens2valid=false;
					if(tokens[0].trim().length()<=0 || !tokens2valid)
						errors.add("email" , new ActionMessage("errors.email.notValid"));					
				}
				else
					errors.add("email" , new ActionMessage("errors.email.notFalid"));
			}
			else
				errors.add("email" , new ActionMessage("errors.email.notValid"));
		}
	   
		//El numero solo puede contener digitos
		if(!num.equals("")){
			try{
				new Integer(num).intValue();
			}catch(Exception e){
				errors.add("num", new ActionMessage("errors.num.notValid"));
			}
		}
		//El codigo postal debe tenr 5 digitos
		if(!codPostal.equals("")){
			if(codPostal.length()!=5)
				errors.add("codPostal", new ActionMessage("errors.direccion.CPnotValid"));
			else{
				try{
					new Integer(codPostal).intValue();
				}catch(Exception e){
					errors.add("codPostal", new ActionMessage("errors.direccion.CPnotValid"));
				}
			}
		}
		
		if (i_log.isInfoEnabled()){
			i_log.info("Despues de comprobar los errores. Nº errores: "+errors.size());
		}
		
		return errors;
	}
	
//	Getters
	public String getNombre(){
		return this.nombre;
	}
	public String getApellido1(){
		return this.apellido1;
	}
	public String getApellido2(){
		return this.apellido2;
	}
	public String getTelefono1(){
		return this.telefono1;
	}
	public String getTelefono2(){
		return this.telefono2;
	}
	public String getNif(){
		return this.nif;
	}
	public String getTipoEmpleado(){
		return this.tipoEmpleado;
	}
	public String getPorcentaje(){
		return this.porcentaje;
	}
	public String getEmail(){
		return this.email;
	}
	public String getFechaNacimiento(){
		return this.fechaNacimiento;
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
	
	//Setters
	
	public void setNombre(String nombre){
		this.nombre=nombre.trim();
	}
	public void setApellido1(String ap1){
		this.apellido1=ap1.trim();
	}
	public void setApellido2(String ap2){
		this.apellido2=ap2.trim();
	}
	public void setTelefono1(String tlf1){
		this.telefono1=tlf1.trim();
	}
	public void setTelefono2(String tlf2){
		this.telefono2=tlf2.trim();
	}
	public void setNif(String nif){
		this.nif=nif.trim();
	}
	public void setTipoEmpleado(String tEmp){
		this.tipoEmpleado=tEmp.trim();
	}
	public void setPorcentaje(String p){
		this.porcentaje=p.trim();
	}
	public void setEmail(String email){
		this.email=email.trim();
	}
	public void setFechaNacimiento(String fecha){
		this.fechaNacimiento=fecha.trim();
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
	

}

