package com.inmobis.bbdd.inmueble;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class VentasBean {

  protected String idAgente;
  protected String idInmueble;
  protected String fechVenta;
  protected String precioInicial;
  protected String precioFinal;
  protected String ganancia;


  public String getIdAgente (){
    return idAgente;
  }

  public String getIdInmueble (){
  return idAgente;
  }

  public String getFechVenta (){
  return fechVenta;
  }

  public String getPrecioInicial (){
  return precioInicial;
  }

  public String getPrecioFinal (){
  return precioFinal;
  }

  public String getGanancia (){
  return ganancia;
  }

  public void setIdAgente (String _idAgente){
  this.idAgente=_idAgente;
}

public void setIdInmueble (String _idInmueble){
this.idInmueble=_idInmueble;
}

public void setFechVenta (String _fechVenta){
this.fechVenta=_fechVenta;
}

public void setPrecioInicial (String _precioInicial){
  this.precioInicial=_precioInicial;
}

public void setPrecioFinal (String _precioFinal){
this.precioFinal=_precioFinal;
}

public void setGanancia (String _ganancia){
this.ganancia=_ganancia;
}

}