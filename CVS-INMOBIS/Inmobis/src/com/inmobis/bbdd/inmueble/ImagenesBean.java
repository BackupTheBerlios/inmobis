package com.inmobis.bbdd.inmueble;

public class ImagenesBean {
  protected String idInmueble;
  protected String nombre;

  public String getIdInmueble (){
    return idInmueble;
  }
 public String getNombre (){
  return nombre;
}
  public void setIdInmueble (String _idInmueble){
    this.idInmueble=_idInmueble;
  }
  public void setNombre ( String _nombre){
    this.nombre=_nombre;
}

  }
