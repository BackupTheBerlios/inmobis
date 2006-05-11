package com.inmobis.bbdd.telefono;

public class InfoTelfBean {
  protected String idGeneral;
  protected String descTelefono;
  protected String telefono;
  protected String telefono2;

  public String getIdGeneral (){
    return idGeneral;
  }
  public String getDescTelefono (){
    return descTelefono;
  }
  public String getTelefono () {
    return telefono;
  }
  public String getTelefono2 () {
    return telefono2;
  }

  public void setIdGeneral (String _idGeneral){
    idGeneral=_idGeneral;
  }
  public void setDescTelefono (String _descTelefono){
    descTelefono=_descTelefono;
  }
  public void setTelefono (String _telefono) {
    telefono=_telefono;
  }
  public void setTelefono2 (String _telefono2) {
    telefono2=_telefono2;
  }


}