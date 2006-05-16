package com.inmobis.bbdd.empleado;

import java.util.Vector;

import com.inmobis.bbdd.BDObject;
import com.inmobis.bbdd.RowExistsException;
import com.inmobis.bbdd.RowNotFoundException;
import com.inmobis.bbdd.direccion.InfoDirBean;
import com.inmobis.bbdd.email.InfoMailBean;
import com.inmobis.bbdd.login.UsuarioLoginBean;
import com.inmobis.bbdd.telefono.InfoTelfBean;

public interface GestorEmpleadoBD extends BDObject {
 // Object getBean() ;
  InfoDirBean getDireccionBean ();
  InfoTelfBean getTelefonoBean ();
  InfoMailBean getMailBean ();
  UsuarioLoginBean getLoginBean ();
  /*void select() ;
  void insert() ;
  void update() ;
  void delete() ;*/
  String [] getIdDirecciones();
  InfoDirBean newInfoDirEmpleados(String descDir);
  String [] getIdTelefonos();
  InfoTelfBean newInfoTelfEmpleados(String desctelf);
  String [] getIdMails();
  InfoMailBean newInfoMailEmpleados(String descMail);
  UsuarioLoginBean newInfoLoginEmpleados(String nombreUsuario);
  void consultaDir (String descDir) throws RowNotFoundException;
  void consultaLogin (String nombreUsuario) throws RowNotFoundException;
  void consultaTelf (String descTelf) throws RowNotFoundException;
  void consultaMail (String descMail) throws RowNotFoundException;
  void deleteLogin (String nombreUsuario) throws RowNotFoundException;
  void deleteDir (String descDir) throws RowNotFoundException;
  void deleteTelf (String descTel) throws RowNotFoundException;
  void deleteMail (String descMail) throws RowNotFoundException;
  void insertaLogin (UsuarioLoginBean miLogin) throws RowExistsException;
  void insertaDir (InfoDirBean miDireccion) throws RowExistsException;
  void insertaTelf (InfoTelfBean miTelefono) throws RowExistsException;
  void insertaMail (InfoMailBean miMail) throws RowExistsException;
  void updateLogin (UsuarioLoginBean miLogin) throws RowNotFoundException;
  void updateDir (InfoDirBean miDireccion) throws RowNotFoundException;
  void updateTelf (InfoTelfBean miTelefono) throws RowNotFoundException;
  void updateMail (InfoMailBean miMail) throws RowNotFoundException;
  
  Vector listarInmueblesAgentes() throws RowNotFoundException;
  int getNumAdmin() throws RowNotFoundException;
  Vector BusquedaDetallada ();
  Vector  listarEmpleados() throws RowNotFoundException;
  
  
}