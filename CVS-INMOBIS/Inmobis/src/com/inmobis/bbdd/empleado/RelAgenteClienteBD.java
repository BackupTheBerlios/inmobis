package com.inmobis.bbdd.empleado;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;

import org.apache.log4j.Logger;

import com.inmobis.bbdd.ConnectionManager;
import com.inmobis.bbdd.MysqlUtils;
import com.inmobis.bbdd.RowExistsException;
import com.inmobis.bbdd.RowNotFoundException;
import com.inmobis.bbdd.cliente.ClienteBD;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class RelAgenteClienteBD {
  private RelAgenteClienteBean agenteCliente;
  private Connection conn;
  private static final Logger milog = Logger.getLogger(RelAgenteClienteBD.class);

  public Object getBean() {
    return agenteCliente;
  }
  public RelAgenteClienteBD(RelAgenteClienteBean _agenteCliente) {
    agenteCliente=_agenteCliente;

  }

public void select () throws RowNotFoundException {

  try {

    conn = ConnectionManager.getConection();
    Statement stmt = conn.createStatement();
    ResultSet rs = null;

    rs = stmt.executeQuery("SELECT * FROM TAgentesClientes WHERE idCliente=" +
                           MysqlUtils.toMysqlString(agenteCliente.idCliente));
    if (rs.next()) {
      agenteCliente.setIdAgente(rs.getString("idAgente"));
      agenteCliente.setIdCliente(rs.getString("idCliente"));


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

public void selectPorIdAgente () throws RowNotFoundException {

	  try {

	    conn = ConnectionManager.getConection();
	    Statement stmt = conn.createStatement();
	    ResultSet rs = null;

	    if (milog.isInfoEnabled()){
			milog.info("idAgente: "+agenteCliente.getIdAgente());
	    }
	    rs = stmt.executeQuery("SELECT * FROM TAgentesClientes WHERE idAgente= " +
	                           MysqlUtils.toMysqlString(agenteCliente.getIdAgente()));
	    if (rs.next()) {
	      agenteCliente.setIdAgente(rs.getString("idAgente"));
	      agenteCliente.setIdCliente(rs.getString("idCliente"));


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

  StringBuffer sqlString = new StringBuffer("INSERT INTO TAgentesClientes ");
  sqlString.append("VALUES (" + MysqlUtils.toMysqlString(agenteCliente.getIdAgente()) + ", ");
  sqlString.append(MysqlUtils.toMysqlString(agenteCliente.getIdCliente())+")");


  if (milog.isInfoEnabled()){
		milog.info("comando sql: "+sqlString);
    }
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

  StringBuffer sqlString = new StringBuffer("UPDATE TAgentesClientes ");
  sqlString.append("set idAgente=" +
                   MysqlUtils.toMysqlString(agenteCliente.getIdAgente()));
  sqlString.append("idCliente=" +
                   MysqlUtils.toMysqlString(agenteCliente.getIdCliente()));


  sqlString.append("WHERE IdCliente=" +
                   MysqlUtils.toMysqlString(agenteCliente.getIdCliente()));
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

  StringBuffer sqlString = new StringBuffer("DELETE FROM TAgentesClientes ");
  sqlString.append("WHERE idCliente=" +
                  MysqlUtils.toMysqlString(agenteCliente.getIdCliente()));
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
