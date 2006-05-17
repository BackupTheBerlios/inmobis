package com.inmobis.bbdd.inmueble;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class RelClientesInmueblesBean {

  protected String idCliente;
  protected String idInmueble;

  public String getIdCliente (){
    return idCliente;
  }

  public String getIdInmueble (){
    return idInmueble;
  }

  public void setIdCliente (String _idCliente){
    this.idCliente=_idCliente;
  }

  public void setIdInmueble (String _idInmueble){
  this.idInmueble=_idInmueble;
  }



}