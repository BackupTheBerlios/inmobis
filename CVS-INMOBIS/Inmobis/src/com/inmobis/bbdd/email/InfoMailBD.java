package com.inmobis.bbdd.email;
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

public class InfoMailBD implements BDObject {
  private InfoMailBean mail;
  private String nombreTabla;
  private Connection conn;
  private static final Logger milog = Logger.getLogger(InfoMailBD.class);
  
public InfoMailBD (InfoMailBean _mail, String _nombreTabla) {
  mail = _mail;
  nombreTabla=_nombreTabla;
}

 public Object getBean() {
    return mail;
  }

  public void select () throws RowNotFoundException {

     try {

       conn = ConnectionManager.getConection();
       Statement stmt = conn.createStatement();
       ResultSet rs = null;

       rs = stmt.executeQuery("SELECT * FROM "+ nombreTabla + " WHERE idGeneral=" +
                              MysqlUtils.toMysqlString(mail.getIdGeneral())+"AND descMail= "+
                               MysqlUtils.toMysqlString(mail.getDescMail()));
       if (rs.next()) {
         mail.setIdGeneral(rs.getString("idGeneral"));
         mail.setDirMail(rs.getString("dirMail"));
         mail.setDescMail(rs.getString("descMail"));


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
		milog.info("Mail de: "+ mail.idGeneral);
	}
	try {
		conn = ConnectionManager.getConection();
		Statement stmt = conn.createStatement();
		ResultSet rs = null;
			
		StringBuffer sqlString = new StringBuffer("INSERT INTO " + nombreTabla );
		sqlString.append(" VALUES (" + MysqlUtils.toMysqlString (mail.getIdGeneral()) + ", ");
		sqlString.append(MysqlUtils.toMysqlString(mail.getDirMail()) +", ");
		sqlString.append(MysqlUtils.toMysqlString(mail.getDescMail()) + ")");
		
		if (milog.isInfoEnabled()){
			milog.info("comando sql: "+ sqlString);
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

     StringBuffer sqlString = new StringBuffer("UPDATE " + nombreTabla );
     sqlString.append(" set IdGeneral=" +
                      MysqlUtils.toMysqlString(mail.getIdGeneral()) + ", ");
     sqlString.append("dirMail=" +
                      MysqlUtils.toMysqlString(mail.getDirMail()) +
                      ", ");

     sqlString.append("descMail=" +
                      MysqlUtils.toMysqlString(mail.getDescMail()));
     sqlString.append(" WHERE IdGeneral=" +
                      MysqlUtils.toMysqlString(mail.getIdGeneral())+" AND descMail="+
                               MysqlUtils.toMysqlString(mail.getDescMail()));
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

 public void delete () throws RowNotFoundException{

   try {
     conn = ConnectionManager.getConection();
     Statement stmt = conn.createStatement();
     ResultSet rs = null;

     StringBuffer sqlString = new StringBuffer("DELETE FROM " + nombreTabla );
     sqlString.append(" WHERE idGeneral=" +
                      MysqlUtils.toMysqlString(mail.getIdGeneral())+"AND descMail= "+
                               MysqlUtils.toMysqlString(mail.getDescMail()));
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
