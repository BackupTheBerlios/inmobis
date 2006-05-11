package com.inmobis.bbdd.email;

public class InfoMailBean {
  protected String idGeneral;
  protected String dirMail;
  protected String descMail;

  public String getIdGeneral (){
    return idGeneral;
  }
  public String getDirMail () {
    return dirMail;
  }
  public String getDescMail () {
    return descMail;
  }

  public void setIdGeneral (String _idGeneral){
   idGeneral=_idGeneral;
 }
  public void setDirMail (String _dirMail) {
   dirMail=_dirMail;
 }
  public void setDescMail (String _descMail) {
   descMail=_descMail;
 }


}