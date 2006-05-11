package com.inmobis.bbdd.direccion;

public class InfoDirBean {
  protected String idGeneral;
  protected String descDir;
  protected String calle;
  protected String num;
  protected String piso;
  protected String codPostal;
  protected String poblacion;
  protected String provincia;
  protected String pais;

  public String getIdGeneral() {
    return idGeneral;
  }

  public String getDescDir() {
    return descDir;
  }

  public String getCalle() {
    return calle;
  }

  public String getNum() {
    return num;
  }

  public String getPiso() {
    return piso;
  }

  public String getCodPostal() {
    return codPostal;
  }

  public String getPoblacion() {
    return poblacion;
  }

  public String getProvincia() {
    return provincia;
  }

  public String getPais() {
    return pais;
  }

  public void setIdGeneral(String _idgeneral) {
  this.idGeneral=_idgeneral;
 }

 public void setDescDir(String _descDir) {
  this.descDir=_descDir;
 }

 public void setCalle(String _calle) {
  this.calle=_calle;
 }

 public void setNum(String _num) {
  this.num=_num;
 }

 public void setPiso(String _piso) {
   this.piso=_piso;
 }

 public void setCodPostal(String _codPostal) {
  this.codPostal=_codPostal;
 }

 public void setPoblacion(String _poblacion) {
   this.poblacion=_poblacion;
 }

 public void setProvincia(String _provincia) {
  this.provincia=_provincia;
 }

 public void setPais(String _pais) {
   this.pais=_pais;
 }


}
