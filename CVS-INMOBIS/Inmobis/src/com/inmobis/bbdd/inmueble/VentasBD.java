package com.inmobis.bbdd.inmueble;


import java.util.*;
import java.sql.*;
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

public class VentasBD {
private VentasBean ventas;
private Connection conn;

  public VentasBD(VentasBean _ventas) {
      ventas = _ventas;

  }

  /*Select tomando el identificador del agente cambiar si es necesario para
   *que la consulta sea con el id del inmueble
  */
  public void select() throws RowNotFoundException{

    try {
      Connection conn = ConnectionManager.getConection();
      Statement stmt = conn.createStatement();
      ResultSet rs = null;
     
      rs = stmt.executeQuery("SELECT * FROM TVentas WHERE idAgente=" +
                             MysqlUtils.toMysqlString(ventas.getIdAgente()));

      if (rs.next()) {
        ventas.setIdAgente(rs.getString("idAgente"));
        ventas.setIdInmueble(rs.getString("idInmueble"));
        ventas.setFechVenta(rs.getString("fechVenta"));
        ventas.setPrecioInicial(rs.getString("precioInicial"));
        ventas.setPrecioFinal(rs.getString("precioFinal"));
        ventas.setGanancia(rs.getString("ganancia"));
      }
      else {
        throw new RowNotFoundException();
      }

    }
    catch (Exception ex) {

    }
    finally{
	 	 if (conn != null) 
	 		 try{conn.close();}catch(SQLException e){}
	 }

  }

  public void insert() throws RowExistsException{

    try {
      Connection conn = ConnectionManager.getConection();
      Statement stmt = conn.createStatement();
      ResultSet rs = null;

      StringBuffer sqlString = new StringBuffer("INSERT INTO TVentas ");
      sqlString.append("VALUES (" + MysqlUtils.toMysqlString(ventas.getIdAgente()) + ", ");


      sqlString.append(MysqlUtils.toMysqlString(ventas.getIdInmueble()) +  ", ");
      sqlString.append(MysqlUtils.toMysqlString(ventas.getFechVenta()) +
                       ", ");
      sqlString.append(MysqlUtils.toMysqlString(ventas.getPrecioInicial()) + ", ");
      sqlString.append(MysqlUtils.toMysqlString(ventas.getPrecioFinal()) + ", ");
      sqlString.append(MysqlUtils.toMysqlString(ventas.getGanancia()) +
                       ")");
      System.out.println(sqlString);
      stmt.execute(sqlString.toString());
    }
    catch (Exception ex) {
     throw new RowExistsException();
    }
    finally{
	 	 if (conn != null) 
	 		 try{conn.close();}catch(SQLException e){}
	 }
  }

  public void update() throws RowNotFoundException {

    try {
      Connection conn = ConnectionManager.getConection();
      Statement stmt = conn.createStatement();
      ResultSet rs = null;

      StringBuffer sqlString = new StringBuffer("UPDATE TVentas ");
      sqlString.append("set idAgente=" +
                       MysqlUtils.toMysqlString(ventas.getIdAgente()) + ", ");
      sqlString.append("idInmueble=" +
                     MysqlUtils.toMysqlString(ventas.getIdInmueble()) +
                     ", ");

      sqlString.append("fechVenta=" +
                       MysqlUtils.toMysqlString(ventas.getFechVenta()) +
                       ", ");
      sqlString.append("precioInicial=" +
                       MysqlUtils.toMysqlString(ventas.getPrecioInicial()) + ", ");
      sqlString.append("precioFinal=" +
                       MysqlUtils.toMysqlString(ventas.getPrecioFinal()) + ", ");
      sqlString.append("ganancia=" +
                       MysqlUtils.toMysqlString(ventas.getGanancia()));
      sqlString.append("WHERE idAgente=" +
                       MysqlUtils.toMysqlString(ventas.getIdAgente()));
      stmt.execute(sqlString.toString());

    }
    catch (Exception ex) {
       throw new RowNotFoundException();
    }
    finally{
	 	 if (conn != null) 
	 		 try{conn.close();}catch(SQLException e){}
	 }

  }

  public void delete()throws RowNotFoundException{

    try {
      Connection conn = ConnectionManager.getConection();
      Statement stmt = conn.createStatement();
      ResultSet rs = null;

      StringBuffer sqlString = new StringBuffer("DELETE FROM TVentas ");
      sqlString.append("WHERE idAgente=" +
                       MysqlUtils.toMysqlString(ventas.getIdAgente()));
      stmt.execute(sqlString.toString());

    }
    catch (Exception ex) {
       throw new RowNotFoundException();
    }
    finally{
	 	 if (conn != null) 
	 		 try{conn.close();}catch(SQLException e){}
	 }

  }
}