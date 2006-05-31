package com.inmobis.bbdd.inmueble;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import java.sql.Connection;

import com.inmobis.bbdd.ConnectionManager;
import com.inmobis.bbdd.MysqlUtils;
import com.inmobis.bbdd.RowExistsException;
import com.inmobis.bbdd.RowNotFoundException;

public class ImagenesBD {
 private ImagenesBean  imagen;
 private Connection conn;
 public ImagenesBD(ImagenesBean _imagen) {
   imagen = _imagen;
 }

 public Object getBean() {
   return imagen;
 }
 public void select () throws RowNotFoundException {

   try {

     conn = ConnectionManager.getConection();
     Statement stmt = conn.createStatement();
     ResultSet rs = null;

     rs = stmt.executeQuery("SELECT * FROM TImagenes WHERE idInmueble=" +
                            MysqlUtils.toMysqlString(imagen.getIdInmueble()));
     if (rs.next()) {
       imagen.setIdInmueble(rs.getString("idInmueble"));
       imagen.setNombre(rs.getString("nombre"));

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
	 }



}

public void insert() throws RowExistsException {

 try {
    conn = ConnectionManager.getConection();
   Statement stmt = conn.createStatement();
   ResultSet rs = null;

   StringBuffer sqlString = new StringBuffer("INSERT INTO TImagenes ");
   sqlString.append("VALUES (" + MysqlUtils.toMysqlString(imagen.getIdInmueble())+ ", ");
   sqlString.append(MysqlUtils.toMysqlString(imagen.getNombre())  + ")");


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
    conn = ConnectionManager.getConection();
   Statement stmt = conn.createStatement();
   ResultSet rs = null;

   StringBuffer sqlString = new StringBuffer("UPDATE TImagenes ");
   sqlString.append("set IdInmueble=" +
                    MysqlUtils.toMysqlString(imagen.getIdInmueble()));

   sqlString.append("WHERE IdAgente=" +
                    MysqlUtils.toMysqlString(imagen.getNombre()));
   stmt.execute(sqlString.toString());


      }
 catch (Exception ex) {
  throw new  RowNotFoundException();
 }
 finally{
 	 if (conn != null) 
 		 try{conn.close();}catch(SQLException e){}
 }

}

public void delete () throws RowNotFoundException  {

 try {
    conn = ConnectionManager.getConection();
   Statement stmt = conn.createStatement();
   ResultSet rs = null;

   StringBuffer sqlString = new StringBuffer("DELETE FROM TImagenes ");
   sqlString.append("WHERE idInmueble=" +
                   MysqlUtils.toMysqlString(imagen.getIdInmueble()));
  stmt.execute(sqlString.toString());



 }
 catch (Exception ex) {
  throw new  RowNotFoundException();
 }
 finally{
 	 if (conn != null) 
 		 try{conn.close();}catch(SQLException e){}
 }

}



public  Vector listarFotosInmueble() throws RowNotFoundException {
  Vector listaNombres = new Vector();

  try {
     conn = ConnectionManager.getConection();
    Statement stmt = conn.createStatement();
    ResultSet rs = null;
    ResultSetMetaData rsmd = null;
    rs = stmt.executeQuery("select * from TImagenes where idInmueble=" +
                            MysqlUtils.toMysqlString(imagen.getIdInmueble()));
    rsmd = rs.getMetaData();
    while (rs.next()) {
      ImagenesBean imagen = new ImagenesBean();
      imagen.setIdInmueble(rs.getString("idInmueble"));
      imagen.setNombre(rs.getString("nombre"));
      listaNombres.add(imagen);

    }

  }
  catch (Exception ex) {
    throw new RowNotFoundException();
  }
  finally{
	 	 if (conn != null) 
	 		 try{conn.close();}catch(SQLException e){}
	 }
  return listaNombres;

}


}
