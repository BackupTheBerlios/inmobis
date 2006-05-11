package com.inmobis.bbdd.login;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class UsuarioLoginBean {

  protected String idUsuario = new String("");
  protected String nombreUsuario = new String("");
  protected String password = new String("");
  protected String tipoUsuario = new String("");

  public String getIdUsuario (){
    return idUsuario;
  }

  public String getNombreUsuario(){
    return nombreUsuario;
  }
  public String getPassword(){
    return password;
  }
  public String getTipoUsuario(){
    return tipoUsuario;
  }

  public void setIdUsuario (String _idUsuario){
    this.idUsuario=_idUsuario;
  }

  public void setPassword(String _password){
    this.password=_password;
  }
  public void setNombreUsuario(String _nombreUsuario) {
    this.nombreUsuario=_nombreUsuario;
  }
  public void setTipoUsuario(String _tipoUsuario){
    this.tipoUsuario=_tipoUsuario;
  }

}

