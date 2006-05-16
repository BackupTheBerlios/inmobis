package com.inmobis.bbdd.inmueble;

import java.util.Vector;

import com.inmobis.bbdd.BDObject;
import com.inmobis.bbdd.RowExistsException;
import com.inmobis.bbdd.RowNotFoundException;
import com.inmobis.bbdd.direccion.InfoDirBean;


public interface GestorInmuebleBD extends BDObject{
 //Object getBean();
 InfoDirBean getDireccionBean ();
 /*void select () ;
 void insert() ;
 void update() ;
 void delete () ;*/
 String [] getIdDirecciones();
 InfoDirBean newInfoDirInmuebles(String descDir);
 void consultaDir (String descDir) throws RowNotFoundException;
 void deleteDir (String descDir)throws RowNotFoundException;
 void insertaDir (InfoDirBean miDireccion)throws RowExistsException;
 void updateDir (InfoDirBean miDireccion)throws RowNotFoundException;
 Vector BusquedaDetallada ();
 Vector  listarInmuebles() throws RowNotFoundException;
 }

