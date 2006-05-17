package com.inmobis.bbdd.telefono;
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

public class InfoTelfBD implements BDObject {

  private InfoTelfBean telefono;
  private String nombreTabla;
  private Connection conn;
  private static final Logger milog = Logger.getLogger(InfoTelfBD.class);

 public InfoTelfBD (InfoTelfBean _telefono, String _nombreTabla) {
   telefono = _telefono;
   nombreTabla=_nombreTabla;
 }

  public Object getBean() {
     return telefono;
   }

   public void select () throws RowNotFoundException {

      try {

        conn = ConnectionManager.getConection();
        Statement stmt = conn.createStatement();
        ResultSet rs = null;

        rs = stmt.executeQuery("SELECT * FROM " + nombreTabla + " WHERE idGeneral =" +
                               MysqlUtils.toMysqlString(telefono.getIdGeneral())+"AND descTelefono ="+
                                MysqlUtils.toMysqlString(telefono.getDescTelefono()));
        if (rs.next()) {
          telefono.setIdGeneral(rs.getString("idGeneral"));
          telefono.setDescTelefono(rs.getString("descTelefono"));
          telefono.setTelefono(rs.getString("telefono"));
          telefono.setTelefono2(rs.getString("telefono2"));

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
			milog.info("Telefono de: "+ telefono.idGeneral);
		}
    try {
      conn = ConnectionManager.getConection();
      Statement stmt = conn.createStatement();
      ResultSet rs = null;

      StringBuffer sqlString = new StringBuffer("INSERT INTO " + nombreTabla );
      sqlString.append(" VALUES (" +  MysqlUtils.toMysqlString (telefono.getIdGeneral()) + ", ");
      sqlString.append(MysqlUtils.toMysqlString(telefono.getDescTelefono()) +", ");
      sqlString.append(MysqlUtils.toMysqlString(telefono.getTelefono()) + ", ");
      sqlString.append(MysqlUtils.toMysqlString(telefono.getTelefono2()) + ")");
      
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
                       MysqlUtils.toMysqlString(telefono.getIdGeneral()) + ", ");
      sqlString.append("descTelefono=" +
                       MysqlUtils.toMysqlString(telefono.getDescTelefono()) +
                       ", ");
      sqlString.append("telefono=" +
                       MysqlUtils.toMysqlString(telefono.getTelefono()) + ", ");

      sqlString.append("telefono2=" +
                       MysqlUtils.toMysqlString(telefono.getTelefono2()));
      sqlString.append(" WHERE IdGeneral=" +
                       MysqlUtils.toMysqlString(telefono.getIdGeneral())+" AND descTelefono="+
                                MysqlUtils.toMysqlString(telefono.getDescTelefono()));
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

      StringBuffer sqlString = new StringBuffer("DELETE FROM " +nombreTabla );
      sqlString.append(" WHERE idGeneral=" +
                       MysqlUtils.toMysqlString(telefono.getIdGeneral())+"AND descTelefono="+
                                MysqlUtils.toMysqlString(telefono.getDescTelefono()));
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
