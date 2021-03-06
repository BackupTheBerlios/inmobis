package com.inmobis.bbdd.login;

import org.apache.log4j.Logger;

import com.inmobis.bbdd.BDObject;
import com.inmobis.bbdd.ConnectionManager;
import com.inmobis.bbdd.MysqlUtils;
import com.inmobis.bbdd.RowExistsException;
import com.inmobis.bbdd.RowNotFoundException;

import java.sql.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class UsuarioLoginBD implements BDObject {
  private UsuarioLoginBean login;
  private static final Logger milog = Logger.getLogger(UsuarioLoginBD.class);
  private Connection conn;
 public UsuarioLoginBD (UsuarioLoginBean _login) {
   login = _login;
 }


 public Object getBean() {
    return login;
  }

 public void selectAll () throws RowNotFoundException {

     try {

    	if (milog.isInfoEnabled()){
 			milog.info("idUsuario: "+login.idUsuario);
 		}

       conn = ConnectionManager.getConection();
       Statement stmt = conn.createStatement();
       ResultSet rs = null;


       rs = stmt.executeQuery("SELECT * FROM TLogin WHERE idUsuario=" +
                              MysqlUtils.toMysqlString(login.getIdUsuario()));
       if (rs.next()) {
         login.setIdUsuario(rs.getString("idUsuario"));
         login.setNombreUsuario(rs.getString("nombreUsuario"));
         login.setPassword(rs.getString("password"));
         login.setTipoUsuario(rs.getString("tipoUsuario"));
       }
       else {
    	   throw new RowNotFoundException();
       }
       if (milog.isInfoEnabled()){
			milog.info("Despues de la selectAll Usuario tengo Usuario: "+login.getNombreUsuario()+" pass: "+login.getPassword());
		}       
     }
     catch(Exception ex)
       {
    	 if (milog.isInfoEnabled()){
 			milog.info(ex);
 		}  
       }
     finally{
    	 if (conn != null) 
    		 try{conn.close();}catch(SQLException e){}
    } //Liberamos la conexion pase lo que pase
  }
 
 
 
 public void select () throws RowNotFoundException {

     try {

    	if (milog.isInfoEnabled()){
 			milog.info("Antes de la Select Usuario tengo Usuario: "+login.getNombreUsuario()+" pass: "+login.getPassword());
 		}

       conn = ConnectionManager.getConection();
       Statement stmt = conn.createStatement();
       ResultSet rs = null;


       rs = stmt.executeQuery("SELECT * FROM TLogin WHERE nombreUsuario=" +
                              MysqlUtils.toMysqlString(login.getNombreUsuario()));
       if (rs.next()) {
         login.setIdUsuario(rs.getString("idUsuario"));
         login.setNombreUsuario(rs.getString("nombreUsuario"));
         login.setPassword(rs.getString("password"));
         login.setTipoUsuario(rs.getString("tipoUsuario"));
       }
       else {
    	   throw new RowNotFoundException();
       }
       if (milog.isInfoEnabled()){
			milog.info("Despues de la select Usuario tengo Usuario: "+login.getNombreUsuario()+" pass: "+login.getPassword());
		}       
     }
     catch(Exception ex)
       {
    	 if (milog.isInfoEnabled()){
 			milog.info(ex);
 		}  
       }
     finally{
    	 if (conn != null) 
    		 try{conn.close();}catch(SQLException e){}
    } //Liberamos la conexion pase lo que pase
  }

  public void insert() throws RowExistsException {

   try {
     conn = ConnectionManager.getConection();
     Statement stmt = conn.createStatement();
    // ResultSet rs = null;

     StringBuffer sqlString = new StringBuffer("INSERT INTO TLogin ");
     sqlString.append("VALUES (" +MysqlUtils.toMysqlString(login.getIdUsuario()) + ", ");
     sqlString.append(MysqlUtils.toMysqlString(login.getNombreUsuario()) +
                      ", ");
     sqlString.append(MysqlUtils.toMysqlString(login.getPassword()) +
                      ", ");
     sqlString.append(MysqlUtils.toMysqlString(login.getTipoUsuario()) +
                      ")");

      stmt.execute(sqlString.toString());
   }
   catch (Exception ex) {
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
   //  ResultSet rs = null;

     StringBuffer sqlString = new StringBuffer("UPDATE TLogin ");
     sqlString.append("set idUsuario=" +
                      MysqlUtils.toMysqlString(login.getIdUsuario()) + ", ");
     sqlString.append("nombreUsuario=" +
                 MysqlUtils.toMysqlString(login.getNombreUsuario()) +
                 ", ");

     sqlString.append("password=" +
                      MysqlUtils.toMysqlString(login.getPassword()) +
                      ", ");
     sqlString.append("tipoUsuario=" +
                      MysqlUtils.toMysqlString(login.getTipoUsuario()));
     sqlString.append(" WHERE idUsuario=" +
                      MysqlUtils.toMysqlString(login.getIdUsuario()));
     if (milog.isInfoEnabled()){
			milog.info("Comando sql: "+sqlString);
		}  
     stmt.execute(sqlString.toString());


        }
   catch (Exception ex) {
	if (milog.isInfoEnabled()){
			milog.info("Error en update");
	} 
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
  //   ResultSet rs = null;

     StringBuffer sqlString = new StringBuffer("DELETE FROM TLogin ");
     sqlString.append("WHERE nombreUsuario=" +
                     MysqlUtils.toMysqlString(login.getNombreUsuario()));
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

