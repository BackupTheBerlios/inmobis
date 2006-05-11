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

 public UsuarioLoginBD (UsuarioLoginBean _login) {
   login = _login;
 }


 public Object getBean() {
    return login;
  }

 public void select () throws RowNotFoundException {

     try {

    	if (milog.isInfoEnabled()){
 			milog.info("Antes de la Select Usuario tengo Usuario: "+login.getNombreUsuario()+" pass: "+login.getPassword());
 		}

       Connection conn = ConnectionManager.getConection();
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
        System.out.println(ex);
       }
  }

  public void insert() throws RowExistsException {

   try {
     Connection conn = ConnectionManager.getConection();
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
 }

 public void update() throws RowNotFoundException {

   try {
     Connection conn = ConnectionManager.getConection();
     Statement stmt = conn.createStatement();
   //  ResultSet rs = null;

     StringBuffer sqlString = new StringBuffer("UPDATE TLogin ");
     sqlString.append("set idUsuario=" +
                      MysqlUtils.toMysqlString(login.getIdUsuario()) + ", ");
     sqlString.append("nombreUsuario=" +
                 MysqlUtils.toMysqlString(login.getPassword()) +
                 ", ");

     sqlString.append("password=" +
                      MysqlUtils.toMysqlString(login.getPassword()) +
                      ", ");
     sqlString.append("tipoUsuario=" +
                      MysqlUtils.toMysqlString(login.getTipoUsuario()));
     sqlString.append("WHERE nombreUsuario=" +
                      MysqlUtils.toMysqlString(login.getNombreUsuario()));
     stmt.execute(sqlString.toString());


        }
   catch (Exception ex) {
    throw new RowNotFoundException();
   }

 }

 public void delete () throws RowNotFoundException {

   try {
     Connection conn = ConnectionManager.getConection();
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

 }


}

