package com.inmobis.bbdd.mensajes;

import org.apache.log4j.Logger;

import com.inmobis.bbdd.BDObject;
import com.inmobis.bbdd.ConnectionManager;
import com.inmobis.bbdd.MysqlUtils;
import com.inmobis.bbdd.RowExistsException;
import com.inmobis.bbdd.RowNotFoundException;
import java.sql.*;

import com.inmobis.bbdd.util.*;

public class RelMensajesBD implements BDObject, GestorMensajesBD{

	private RelMensajesBean relmensajes;
	private Connection conn;
	//-----------mas variables
	private static final Logger milog = Logger.getLogger(MensajesBD.class);
	
//	el constructor de la clase
	public RelMensajesBD(RelMensajesBean _relmensaje){
		this.relmensajes= _relmensaje;
	}
	
//	implementar los metodos abstractos de BDObject
	public Object getBean() {
		return this.relmensajes;
	}
	
	public void select()throws RowNotFoundException {
		try {
		      conn = ConnectionManager.getConection();
		      Statement stmt = conn.createStatement();
		      ResultSet rs = null;
		      
              // obtenemos un ResultSet con los datos producidos por la consulta
		      rs = stmt.executeQuery("SELECT * FROM TRelMensaje WHERE origen=" +
		    		  MysqlUtils.toMysqlString(relmensajes.getOrigen())+
		    		  "AND destino=" + MysqlUtils.toMysqlString(relmensajes.getDestino())
		    		  + "AND idMensaje=" + MysqlUtils.toMysqlString(relmensajes.getIdMensaje())
		    		  + "AND Fecha=" + MysqlUtils.toMysqlString(relmensajes.getFecha()));
		      
		      if (rs.next()) {
		    	  relmensajes.setOrigen(rs.getString("origen"));
		    	  relmensajes.setDestino(rs.getString("destino"));
		    	  relmensajes.setIdMensaje(rs.getString("idMensaje"));
		    	  relmensajes.setFecha(rs.getString("Fecha"));
		    	  relmensajes.setLeido(rs.getString("leido").charAt(0));
		      }else{
		    	  throw new RowNotFoundException();
		      }
		      
		} catch (Exception e){
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
		try{
			conn = ConnectionManager.getConection();
		    Statement stmt = conn.createStatement();
				    
		    StringBuffer sb= new StringBuffer("INSERT INTO TRelMensaje ");
		    sb.append("VALUES (" + MysqlUtils.toMysqlString(relmensajes.getOrigen()) + ",");
		    sb.append(MysqlUtils.toMysqlString(relmensajes.getDestino()) + ",");
		    sb.append(MysqlUtils.toMysqlString(relmensajes.getIdMensaje()) + ",");
		    sb.append(MysqlUtils.toMysqlString(relmensajes.getFecha()) + ",");		    
		    sb.append(MysqlUtils.toMysqlString(relmensajes.getLeido().toString()) + ")");
		    
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
		    
		    StringBuffer sb= new StringBuffer("UPDATE TRelMensajes ");
		    sb.append("set origen=" +
		    		MysqlUtils.toMysqlString(relmensajes.getOrigen()) + ",");
		    sb.append("destino=" +
		    		MysqlUtils.toMysqlString(relmensajes.getDestino()) + ",");
		    sb.append("idMensaje=" +
		    		MysqlUtils.toMysqlString(relmensajes.getIdMensaje()) + ",");
		    sb.append("Fecha=" +
		    		MysqlUtils.toMysqlString(relmensajes.getFecha()) + ",");
		    sb.append("leido=" +
		    		MysqlUtils.toMysqlString(relmensajes.getLeido().toString()));
		    sb.append("WHERE origen=" + 
		    		MysqlUtils.toMysqlString(relmensajes.getOrigen()) +
		    		"AND destino=" +
		    		MysqlUtils.toMysqlString(relmensajes.getDestino()) +
		    		"AND idMensaje=" + 
		    		MysqlUtils.toMysqlString(relmensajes.getIdMensaje()) +
		    		"AND Fecha=" +
		    		MysqlUtils.toMysqlString(relmensajes.getFecha()));
		    
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
		    
		    StringBuffer sb= new StringBuffer("DELETE FROM TRelMensajes ");
		    sb.append("WHERE origen=" +
		    		MysqlUtils.toMysqlString(relmensajes.getOrigen())+ 
		    		"AND destino=" + MysqlUtils.toMysqlString(relmensajes.getDestino()) +
		    		"AND idMensaje=" + MysqlUtils.toMysqlString(relmensajes.getIdMensaje()) +
		    		"AND Fecha=" + MysqlUtils.toMysqlString(relmensajes.getFecha()));
		    
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
