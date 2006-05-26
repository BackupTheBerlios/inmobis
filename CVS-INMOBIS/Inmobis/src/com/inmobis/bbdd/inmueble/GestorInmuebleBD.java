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
 void consultaDirPorId (String idGeneral) throws RowNotFoundException;
 void deleteDir (String descDir)throws RowNotFoundException;
 void insertaDir (InfoDirBean miDireccion)throws RowExistsException;
 void updateDir (InfoDirBean miDireccion)throws RowNotFoundException;
 void asociarClienteInmueble (String idCliente,String idInmueble) throws RowExistsException;
 Vector BusquedaDetalladaMetrosPrecio (String metrosMin,String metrosMax,String precioMin,String precioMax);
 Vector BusquedaDetalladaConMetros (String metrosMin,String metrosMax);
 Vector BusquedaDetalladaConPrecio (String precioMin,String precioMax);
 Vector BusquedaDetallada ();
 Vector  listarInmuebles() throws RowNotFoundException;
 }

