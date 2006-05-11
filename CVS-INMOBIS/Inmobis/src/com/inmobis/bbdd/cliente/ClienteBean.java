package com.inmobis.bbdd.cliente;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class ClienteBean {

    protected String idCliente;
    protected String dni;
    protected String nombre;
    protected String apellido1;
    protected String apellido2;
    protected String fechNacimiento;

    public String getIdCliente() {
     return idCliente;
    }
    
    public String getDni() {
        return dni;
       }

    public String getNombreCliente() {
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

    public void setIdCliente(String _idCliente) {
       this.idCliente = _idCliente;
    }
    
    public void setDni(String _dni) {
        this.dni = _dni;
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

}
