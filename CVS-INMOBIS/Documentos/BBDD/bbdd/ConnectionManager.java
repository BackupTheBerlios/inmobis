package com.inmobis.bbdd;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.log4j.Logger;


/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public final class ConnectionManager{
	private static final Logger milog = Logger.getLogger(ConnectionManager.class);

  private static Connection conn;
 
  private static void initConnection(){
    try {
    	Context init = new InitialContext();
    	DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/inmobis");
    	conn = ds.getConnection();
        conn.setAutoCommit(true);

      }
      catch (Exception ex) {
  		if (milog.isInfoEnabled()){
			milog.info("Error en InitConnection: "+ ex.getMessage());
		}
    }
  }

  public static Connection getConection() {
    if (conn == null){
     initConnection();
    }
    return conn;
  }

  public static void finishConnection(){
	  if (conn != null){
		  try {
			  conn.close();
		  }
	  	  catch (SQLException sqle) {
	    		if (milog.isInfoEnabled()){
	    			milog.info("Error en finishConnection: "+ sqle.getMessage());
	    		}
	  	  }
	  	  conn = null;
	  }	  
 }



}
