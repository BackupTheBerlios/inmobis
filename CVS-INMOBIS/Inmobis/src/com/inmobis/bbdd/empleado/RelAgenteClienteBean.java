package com.inmobis.bbdd.empleado;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class RelAgenteClienteBean {
  protected String idAgente;
  protected String idCliente;
  public String getIdAgente() {
     return idAgente;
     }
  public String getIdCliente() {
      return idCliente;
     }
  public void setIdAgente ( String _idAgente){
    this.idAgente=_idAgente;
      }
  public void setIdCliente ( String _idCliente){
     this.idCliente=_idCliente;
    }

}