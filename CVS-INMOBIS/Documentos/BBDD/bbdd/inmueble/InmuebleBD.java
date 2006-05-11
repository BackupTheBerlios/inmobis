package com.inmobis.bbdd.inmueble;

import java.util.*;

import org.apache.log4j.Logger;

import java.sql.*;

import com.inmobis.bbdd.BDObject;
import com.inmobis.bbdd.ConnectionManager;
import com.inmobis.bbdd.MysqlUtils;
import com.inmobis.bbdd.RowExistsException;
import com.inmobis.bbdd.RowNotFoundException;
import com.inmobis.bbdd.direccion.InfoDirBean;
import com.inmobis.bbdd.direccion.InfoDirInmueblesBD;
import com.inmobis.bbdd.util.*;


/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class InmuebleBD implements BDObject,GestorInmuebleBD{

 private InmuebleBean inmueble;
 private InfoDirBean dirInmueble;
 private InfoDirInmueblesBD direccion;
 private static final Logger milog = Logger.getLogger(InmuebleBD.class);

 public InmuebleBD (InmuebleBean _inmueble) {
   inmueble = _inmueble;
 }


 public Object getBean() {
    return inmueble;
  }

 public InfoDirBean getDireccionBean (){
    return dirInmueble;
     }


  public void select () throws RowNotFoundException {

     try {

       Connection conn = ConnectionManager.getConection();
       Statement stmt = conn.createStatement();
       ResultSet rs = null;

       rs = stmt.executeQuery("SELECT * FROM TInmueble WHERE idInmueble=" +
                              MysqlUtils.toMysqlString(inmueble.getIdInmueble()));
       if (rs.next()) {
         inmueble.setIdInmueble(rs.getString("idInmueble"));
         inmueble.setMetros(rs.getString("metros"));
         inmueble.setRegimen(rs.getString("regimen"));
         inmueble.setPrecio(rs.getString("precio"));
         inmueble.setDatosDeInteres(rs.getString("datosdeinteres"));


       }
       else {
    	   throw new RowNotFoundException();
       }


     }
     catch(Exception ex)
       {
        System.out.println(ex);
       }


  }

  public void insert() throws RowExistsException {
	  if (milog.isInfoEnabled()){
			milog.info("Voy a insertar: "+inmueble.idInmueble +" metros: "+inmueble.metros);
		}  
   try {
     Connection conn = ConnectionManager.getConection();
     Statement stmt = conn.createStatement();
     ResultSet rs = null;

     StringBuffer sqlString = new StringBuffer("INSERT INTO TInmueble ");
     sqlString.append("VALUES (" + MysqlUtils.toMysqlString(inmueble.getIdInmueble()) + ", ");
     sqlString.append(MysqlUtils.toMysqlString(inmueble.getMetros()) +
                      ", ");
     sqlString.append(MysqlUtils.toMysqlString(inmueble.getRegimen()) + ", ");
     sqlString.append(MysqlUtils.toMysqlString(inmueble.getPrecio()) + ", ");
     sqlString.append(MysqlUtils.toMysqlString(inmueble.getdatosDeInteres()) +
                      ")");
     if (milog.isInfoEnabled()){
			milog.info("comando sql: "+sqlString);
	  }
     stmt.execute(sqlString.toString());
   }
   catch (Exception ex) {
	   if (milog.isInfoEnabled()){
			milog.info("error: "+ ex.toString());
		}
	   throw new RowExistsException();
   }
 }

 public void update() throws RowNotFoundException {

   try {
     Connection conn = ConnectionManager.getConection();
     Statement stmt = conn.createStatement();
     ResultSet rs = null;

     StringBuffer sqlString = new StringBuffer("UPDATE TInmueble ");
     sqlString.append("set IdInmueble=" +
                      MysqlUtils.toMysqlString(inmueble.getIdInmueble()) + ", ");
     sqlString.append("nombre=" +
                      MysqlUtils.toMysqlString(inmueble.getMetros()) +
                      ", ");
     sqlString.append("apellido1=" +
                      MysqlUtils.toMysqlString(inmueble.getRegimen()) + ", ");
     sqlString.append("apellido2=" +
                      MysqlUtils.toMysqlString(inmueble.getPrecio()) + ", ");
     sqlString.append("fechNacimiento=" +
                      MysqlUtils.toMysqlString(inmueble.getdatosDeInteres()));
     sqlString.append("WHERE IdInmueble=" +
                      MysqlUtils.toMysqlString(inmueble.getIdInmueble()));
     stmt.execute(sqlString.toString());


        }
   catch (Exception ex) {
    throw new RowNotFoundException();
   }

 }

 public void delete () throws RowNotFoundException  {

   try {
     Connection conn = ConnectionManager.getConection();
     Statement stmt = conn.createStatement();
     ResultSet rs = null;

     StringBuffer sqlString = new StringBuffer("DELETE FROM TInmueble ");
     sqlString.append("WHERE idInmueble=" +
                     MysqlUtils.toMysqlString(inmueble.getIdInmueble()));
    stmt.execute(sqlString.toString());



   }
   catch (Exception ex) {
     throw new RowNotFoundException();
   }

 }

 public String [] getIdDirecciones(){
      Vector direcciones=new Vector();
      StringBuffer query=new StringBuffer();
      query.append("SELECT idGeneral FROM TDirInmueble WHERE idGeneral=");
      query.append(MysqlUtils.toMysqlString(inmueble.getIdInmueble()));

           try {
             Connection conn = ConnectionManager.getConection();
             Statement stmt = conn.createStatement();
             ResultSet rs=stmt.executeQuery(query.toString());
               while (rs.next()){
                direcciones.add(rs.getString("idGeneral"));
               }
             }
         catch (Exception e) {
          e.printStackTrace();
       }
      return ArrayOps.toStringArray(direcciones);
   }

   public InfoDirBean newInfoDirInmuebles(String descDir){
   InfoDirBean idb=new  InfoDirBean();
   idb.setIdGeneral(inmueble.getIdInmueble());
   idb.setDescDir(descDir);
   return idb;
   }

   public void consultaDir (String descDir) throws RowNotFoundException {
    dirInmueble=newInfoDirInmuebles(descDir);
    InfoDirInmueblesBD direccion = new InfoDirInmueblesBD(dirInmueble);
    direccion.select();

  }
  public void deleteDir (String descDir) throws RowNotFoundException{
     String [] direcciones = getIdDirecciones();

     dirInmueble=newInfoDirInmuebles(descDir);
     InfoDirInmueblesBD direccion = new InfoDirInmueblesBD(dirInmueble);
     direccion.delete();
   }

   public void insertaDir (InfoDirBean miDireccion) throws RowExistsException {

      InfoDirInmueblesBD direccion = new InfoDirInmueblesBD(miDireccion);
      dirInmueble=miDireccion;
      direccion.insert();

    }


}
