package com.inmobis.bbdd.direccion;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;

import org.apache.log4j.Logger;

import com.inmobis.bbdd.BDObject;
import com.inmobis.bbdd.ConnectionManager;
import com.inmobis.bbdd.MysqlUtils;
import com.inmobis.bbdd.RowExistsException;
import com.inmobis.bbdd.RowNotFoundException;

public class InfoDirBD implements BDObject {
  protected InfoDirBean direccion;
  private String nombreTabla;
  private Connection conn;
  private static final Logger milog = Logger.getLogger(InfoDirBD.class);

 public InfoDirBD (InfoDirBean _direccion, String _nombreTabla) {
   direccion = _direccion;
   nombreTabla=_nombreTabla;
 }


 public Object getBean() {
    return direccion;
  }

  public void select () throws RowNotFoundException {

     try {

       conn = ConnectionManager.getConection();
       Statement stmt = conn.createStatement();
       ResultSet rs = null;

       rs = stmt.executeQuery("SELECT * FROM "+nombreTabla+" WHERE idGeneral=" +
                              MysqlUtils.toMysqlString(direccion.getIdGeneral())+"AND descDir="+
                               MysqlUtils.toMysqlString(direccion.getDescDir()));
       if (rs.next()) {
         direccion.setIdGeneral(rs.getString("idGeneral"));
         direccion.setDescDir(rs.getString("descDir"));
         direccion.setCalle(rs.getString("calle"));
         direccion.setNum(rs.getString("num"));
         direccion.setPiso(rs.getString("piso"));
         direccion.setCodPostal(rs.getString("codPostal"));
         direccion.setPoblacion(rs.getString("poblacion"));
         direccion.setProvincia(rs.getString("provincia"));
         direccion.setPais(rs.getString("pais"));

       }
       else {
    	   throw new RowNotFoundException();
       }


     }
     catch(Exception ex)
       {
        System.out.println(ex);
       }
     finally{
    	 if (conn != null) 
    		 try{conn.close();}catch(SQLException e){}
    } //Liberamos la conexion pase lo que pase


  }

  public void insert() throws RowExistsException {
	  
	  if (milog.isInfoEnabled()){
			milog.info("Direccion de: "+ direccion.idGeneral);
		}  
   try {
     conn = ConnectionManager.getConection();
     Statement stmt = conn.createStatement();
     ResultSet rs = null;

     StringBuffer sqlString = new StringBuffer("INSERT INTO "+nombreTabla);
     sqlString.append(" VALUES (" + MysqlUtils.toMysqlString (direccion.getIdGeneral()) + ", ");
     sqlString.append(MysqlUtils.toMysqlString(direccion.getDescDir()) +", ");
     sqlString.append(MysqlUtils.toMysqlString(direccion.getCalle()) + ", ");
     sqlString.append(MysqlUtils.toMysqlString(direccion.getNum()) + ", ");
     sqlString.append(MysqlUtils.toMysqlString(direccion.getPiso()) + ", ");
     sqlString.append(MysqlUtils.toMysqlString(direccion.getCodPostal()) + ", ");
     sqlString.append(MysqlUtils.toMysqlString(direccion.getPoblacion()) + ", ");
     sqlString.append(MysqlUtils.toMysqlString(direccion.getProvincia()) + ", ");
     sqlString.append(MysqlUtils.toMysqlString(direccion.getPais()) + ")");
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
   finally{
  	 if (conn != null) 
  		 try{conn.close();}catch(SQLException e){}
  } //Liberamos la conexion pase lo que pase
 }

 public void update() throws RowNotFoundException {

   try {
     conn = ConnectionManager.getConection();
     Statement stmt = conn.createStatement();
     ResultSet rs = null;

     StringBuffer sqlString = new StringBuffer("UPDATE" + nombreTabla );
     sqlString.append("set IdGeneral=" +
                      MysqlUtils.toMysqlString(direccion.getIdGeneral()) + ", ");
     sqlString.append("descDir=" +
                      MysqlUtils.toMysqlString(direccion.getDescDir()) +
                      ", ");
     sqlString.append("calle=" +
                      MysqlUtils.toMysqlString(direccion.getCalle()) + ", ");
     sqlString.append("num=" +
                      MysqlUtils.toMysqlString(direccion.getNum()) + ", ");
     sqlString.append("piso=" +
                      MysqlUtils.toMysqlString(direccion.getPiso()));
     sqlString.append("codPostal=" +
                      MysqlUtils.toMysqlString(direccion.getCodPostal()));
     sqlString.append("poblacion=" +
                      MysqlUtils.toMysqlString(direccion.getPoblacion()));
     sqlString.append("provincia=" +
                      MysqlUtils.toMysqlString(direccion.getProvincia()));
     sqlString.append("pais=" +
                      MysqlUtils.toMysqlString(direccion.getPais()));
     sqlString.append("WHERE IdGeneral=" +
                      MysqlUtils.toMysqlString(direccion.getIdGeneral())+"AND descDir="+
                               MysqlUtils.toMysqlString(direccion.getDescDir()));
     stmt.execute(sqlString.toString());


        }
   catch (Exception ex) {
     throw new RowNotFoundException();
   }
   finally{
  	 if (conn != null) 
  		 try{conn.close();}catch(SQLException e){}
  } //Liberamos la conexion pase lo que pase

 }

 public void delete () throws RowNotFoundException {

   try {
     conn = ConnectionManager.getConection();
     Statement stmt = conn.createStatement();
     ResultSet rs = null;
     
	 StringBuffer sqlString = new StringBuffer("DELETE FROM "+ nombreTabla );
     sqlString.append(" WHERE idGeneral=" +
                      MysqlUtils.toMysqlString(direccion.getIdGeneral())+"AND descDir="+
                               MysqlUtils.toMysqlString(direccion.getDescDir()));
    stmt.execute(sqlString.toString());



   }
   catch (Exception ex) {
    throw new RowNotFoundException();
   }
   finally{
  	 if (conn != null) 
  		 try{conn.close();}catch(SQLException e){}
  } //Liberamos la conexion pase lo que pase
 }

}
