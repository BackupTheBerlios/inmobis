package com.inmobis.bbdd.inmueble;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.inmobis.bbdd.ConnectionManager;
import com.inmobis.bbdd.MysqlUtils;
import com.inmobis.bbdd.RowExistsException;
import com.inmobis.bbdd.RowNotFoundException;


/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class RelClientesInmueblesBD {
  private RelClientesInmueblesBean clienteInmueble;
  private Connection conn;

  public Object getBean() {
    return clienteInmueble;
  }
  public RelClientesInmueblesBD( RelClientesInmueblesBean _clienteInmueble) {
    clienteInmueble=_clienteInmueble;

  }
  
  public void select () throws RowNotFoundException {

	  try {

	    conn = ConnectionManager.getConection();
	    Statement stmt = conn.createStatement();
	    ResultSet rs = null;

	    rs = stmt.executeQuery("SELECT * FROM TClientesInmuebles WHERE idCliente=" +
	                           MysqlUtils.toMysqlString(clienteInmueble.getIdCliente()));
	    if (rs.next()) {
	    	
	    	clienteInmueble.setIdCliente(rs.getString("idCliente"));
	    	clienteInmueble.setIdInmueble(rs.getString("idInmueble"));


	    }
	    else {
	      throw new RowNotFoundException();
	    }


	  }
	  catch(Exception ex)
	    {
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
	  ResultSet rs = null;

	  StringBuffer sqlString = new StringBuffer("INSERT INTO TClientesInmuebles ");
	  sqlString.append("VALUES (" + MysqlUtils.toMysqlString(clienteInmueble.getIdCliente()) + ", ");
	  sqlString.append(MysqlUtils.toMysqlString(clienteInmueble.getIdInmueble())+")");



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
	  ResultSet rs = null;

	  StringBuffer sqlString = new StringBuffer("UPDATE TClientesInmuebles ");
	  sqlString.append("set idCliente=" +
	                   MysqlUtils.toMysqlString(clienteInmueble.getIdCliente()));
	  sqlString.append("idInmueble=" +
	                   MysqlUtils.toMysqlString(clienteInmueble.getIdInmueble()));


	  sqlString.append("WHERE IdCliente=" +
	                   MysqlUtils.toMysqlString(clienteInmueble.getIdCliente()));
	  stmt.execute(sqlString.toString());


	     }
	catch (Exception ex) {
	 throw new  RowNotFoundException();
	}
	finally{
		 if (conn != null) 
			 try{conn.close();}catch(SQLException e){}
	} //Liberamos la conexion pase lo que pase

	}

	public void delete () throws RowNotFoundException  {

	try {
	  conn = ConnectionManager.getConection();
	  Statement stmt = conn.createStatement();
	  ResultSet rs = null;

	  StringBuffer sqlString = new StringBuffer("DELETE FROM TClientesInmuebles ");
	  sqlString.append("WHERE idCliente=" +
	                  MysqlUtils.toMysqlString(clienteInmueble.getIdCliente()));
	 stmt.execute(sqlString.toString());



	}
	catch (Exception ex) {
	 throw new  RowNotFoundException();
	}
	finally{
		 if (conn != null) 
			 try{conn.close();}catch(SQLException e){}
	} //Liberamos la conexion pase lo que pase

	}

}