package com.inmobis.bbdd.cliente;

import com.inmobis.bbdd.BDObject;
import com.inmobis.bbdd.RowExistsException;
import com.inmobis.bbdd.RowNotFoundException;
import com.inmobis.bbdd.direccion.InfoDirBean;
import com.inmobis.bbdd.email.InfoMailBean;
import com.inmobis.bbdd.telefono.InfoTelfBean;


public interface GestorClienteBD extends BDObject{
 // Object getBean() ;
  InfoDirBean getDireccionBean ();
  InfoTelfBean getTelefonoBean ();
  InfoMailBean getMailBean ();
  /*void select() ;
  void insert() ;
  void update() ;
  void delete() ;*/
  String [] getIdDirecciones();
  InfoDirBean newInfoDirClientes(String descDir);
  String [] getIdTelefonos();
  InfoTelfBean newInfoTelfClientes(String desctelf);
  String [] getIdMails();
  InfoMailBean newInfoMailClientes(String descMail);
  void consultaDir (String descDir) throws RowNotFoundException;
  void consultaTelf (String descTelf) throws RowNotFoundException;
  void consultaMail (String descMail) throws RowNotFoundException;
  void deleteDir (String descDir) throws RowNotFoundException;
  void deleteTelf (String descTel) throws RowNotFoundException;
  void deleteMail (String descMail) throws RowNotFoundException;
  void insertaDir (InfoDirBean miDireccion)throws RowExistsException;
  void insertaTelf (InfoTelfBean miTelefono)throws RowExistsException;
  void insertaMail (InfoMailBean miMail)throws RowExistsException;

}