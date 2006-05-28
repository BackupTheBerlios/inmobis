package com.inmobis.bbdd.empleado;

public class EmpleadoBean {
  protected String idEmpleado;
  protected String dni;
  protected String nombre;
  protected String apellido1;
  protected String apellido2;
  protected String fechNacimiento;

  public String getIdEmpleado() {
   return idEmpleado;
  }
  
  public String getDni() {
	   return dni;
	  }

  public String getNombre() {
    return nombre;
  }

  public String getApellido1() {
    return apellido1;
  }

  public String getApellido2() {
    return apellido2;
  }

  public String getFechNacimiento() {
    return fechNacimiento;
  }

  public void setIdEmpleado(String _idEmpleado) {
     this.idEmpleado = _idEmpleado;
  }

  public void setNombre(String _nombre) {
    this.nombre = _nombre;
  }

  public void setApellido1(String _apellido1) {
    this.apellido1 = _apellido1;
  }

  public void setApellido2(String _apellido2) {
    this.apellido2 = _apellido2;
  }

  public void setFechNacimiento(String _fechNacimiento) {
    this.fechNacimiento = _fechNacimiento;
  }

  public void setDni(String dni) {
  	this.dni = dni;
  }

}
