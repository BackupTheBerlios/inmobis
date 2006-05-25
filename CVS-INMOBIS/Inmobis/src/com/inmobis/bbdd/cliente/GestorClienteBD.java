package com.inmobis.bbdd.cliente;

import java.util.Vector;

import com.inmobis.bbdd.BDObject;
import com.inmobis.bbdd.RowExistsException;
import com.inmobis.bbdd.RowNotFoundException;
import com.inmobis.bbdd.direccion.InfoDirBean;
import com.inmobis.bbdd.email.InfoMailBean;
import com.inmobis.bbdd.login.UsuarioLoginBean;
import com.inmobis.bbdd.telefono.InfoTelfBean;


public interface GestorClienteBD extends BDObject{
 // Object getBean() ;
  InfoDirBean getDireccionBean ();
  InfoTelfBean getTelefonoBean ();
  InfoMailBean getMailBean ();
  UsuarioLoginBean getLoginBean ();
  /*void select() ;
  void insert() ;
  void update() ;
  void delete() ;*/
  UsuarioLoginBean newInfoLoginClientes(String nombreUsuario);
  String [] getIdDirecciones();
  InfoDirBean newInfoDirClientes(String descDir);
  String [] getIdTelefonos();
  InfoTelfBean newInfoTelfClientes(String desctelf);
  String [] getIdMails();
  InfoMailBean newInfoMailClientes(String descMail);
  void consultaLogin (String idUsuario) throws RowNotFoundException;
  void consultaDir (String idUsuario) throws RowNotFoundException;
  void consultaTelf (String idUsuario) throws RowNotFoundException;
  void consultaMail (String idUsuario) throws RowNotFoundException;
  void deleteLogin (String nombreUsuario) throws RowNotFoundException;
  void deleteDir (String descDir) throws RowNotFoundException;
  void deleteTelf (String descTel) throws RowNotFoundException;
  void deleteMail (String descMail) throws RowNotFoundException;
  void insertaLogin (UsuarioLoginBean milogin)throws RowExistsException;
  void insertaDir (InfoDirBean miDireccion)throws RowExistsException;
  void insertaTelf (InfoTelfBean miTelefono)throws RowExistsException;
  void insertaMail (InfoMailBean miMail)throws RowExistsException;
  void updateLogin (UsuarioLoginBean milogin)throws RowNotFoundException;
  void updateDir (InfoDirBean miDireccion)throws RowNotFoundException;
  void updateTelf (InfoTelfBean miTelefono)throws RowNotFoundException;
  void updateMail (InfoMailBean miMail)throws RowNotFoundException;

  Vector BusquedaDetallada ();
  Vector  listarClientes() throws RowNotFoundException;
}