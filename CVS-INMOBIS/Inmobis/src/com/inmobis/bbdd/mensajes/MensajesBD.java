package com.inmobis.bbdd.mensajes;

import org.apache.log4j.Logger;

import com.inmobis.bbdd.BDObject;
import com.inmobis.bbdd.ConnectionManager;
import com.inmobis.bbdd.MysqlUtils;
import com.inmobis.bbdd.RowExistsException;
import com.inmobis.bbdd.RowNotFoundException;
import java.sql.*;

import com.inmobis.bbdd.empleado.EmpleadoBD;
import com.inmobis.bbdd.util.*;

public class MensajesBD implements BDObject, GestorMensajesBD{
	
	private MensajesBean mensaje;
	private Connection conn;
	//-----------mas variables
	private static final Logger milog = Logger.getLogger(MensajesBD.class);
	
	
	//el constructor de la clase
	public MensajesBD(MensajesBean _mensaje){
		this.mensaje=_mensaje;
	}
	
	//implementar los metodos abstractos de BDObject
	public Object getBean() {
		return this.mensaje;
	}
	
	public void select()throws RowNotFoundException {
		try {
		      conn = ConnectionManager.getConection();
		      Statement stmt = conn.createStatement();
		      ResultSet rs = null;
		      
		      //obtenemos un ResultSet con los datos producidos por la consulta
		      rs = stmt.executeQuery("SELECT * FROM TMensajes WHERE idMensaje=" +
                      MysqlUtils.toMysqlString(mensaje.getIdMensaje()));
		      if (rs.next()){//situarse en la siguiente fila
		    	  mensaje.setAsunto(rs.getString("asunto"));
		    	  mensaje.setIdMensaje(rs.getString("idMensaje"));
		    	  mensaje.setTexto(rs.getString("texto"));
		      }
		      else{
		    	  throw new RowNotFoundException();
		      }
		
		}catch(Exception e){
			if (milog.isInfoEnabled()){
	 			milog.info("error: "+ e.toString());
			}
			 throw new RowNotFoundException();
		}
	     finally{
	    	 if (conn != null) 
	    		 try{conn.close();}catch(SQLException e){}
	    } //Liberamos la conexion pase lo que pase
	}
	
	public void insert() throws RowExistsException{
		if (milog.isInfoEnabled()){
			milog.info("Voy a insertar: "+mensaje.getIdMensaje());
		}
		try{
			conn = ConnectionManager.getConection();
		    Statement stmt = conn.createStatement();
				    
		    StringBuffer sb= new StringBuffer("INSERT INTO TMensajes ");
		    sb.append("VALUES (" + MysqlUtils.toMysqlString(mensaje.getIdMensaje()) + ",");
		    sb.append(MysqlUtils.toMysqlString(mensaje.getAsunto()) + ",");
		    sb.append(MysqlUtils.toMysqlString(mensaje.getTexto()) + ")");
		    
		    if (milog.isInfoEnabled()){
				milog.info("comando sql: "+sb);
		    }
		    //ejecuta la sentencia sql que acabamos de construir
		    stmt.execute(sb.toString());
		}catch (Exception e){
			if (milog.isInfoEnabled()){
				milog.info("error: "+ e.toString());
			}
			throw new RowExistsException();
		}
	     finally{
	    	 if (conn != null) 
	    		 try{conn.close();}catch(SQLException e){}
	    } //Liberamos la conexion pase lo que pase
	}
	
	public void update() throws RowNotFoundException{
		try{
			conn = ConnectionManager.getConection();
		    Statement stmt = conn.createStatement();
		    
		    StringBuffer sb= new StringBuffer("UPDATE TMensajes ");
		    sb.append("set IdMensaje=" +
		    		MysqlUtils.toMysqlString(mensaje.getIdMensaje()) + ",");
		    sb.append("asunto=" +
		    		MysqlUtils.toMysqlString(mensaje.getAsunto()) + ",");
		    sb.append("texto=" +
		    		MysqlUtils.toMysqlString(mensaje.getTexto()));
		    sb.append("WHERE IdMensaje=" +
		    		MysqlUtils.toMysqlString(mensaje.getIdMensaje()));
		    
		    stmt.execute(sb.toString());
		    
		} catch (Exception e){
			throw new RowNotFoundException();
		}
	     finally{
	    	 if (conn != null) 
	    		 try{conn.close();}catch(SQLException e){}
	    } //Liberamos la conexion pase lo que pase
	}
	
	public void delete () throws RowNotFoundException{
		try{
			conn = ConnectionManager.getConection();
		    Statement stmt = conn.createStatement();
		    
		    StringBuffer sb= new StringBuffer("DELETE FROM TMensajes ");
		    sb.append("WHERE idMensaje=" +
		    		MysqlUtils.toMysqlString(mensaje.getIdMensaje()));
		    
		    stmt.execute(sb.toString());
		    
		} catch(Exception e){
			throw new RowNotFoundException();
		}
	     finally{
	    	 if (conn != null) 
	    		 try{conn.close();}catch(SQLException e){}
	    } //Liberamos la conexion pase lo que pase
	}
	
	//otros métodos necesarios.
	
}
