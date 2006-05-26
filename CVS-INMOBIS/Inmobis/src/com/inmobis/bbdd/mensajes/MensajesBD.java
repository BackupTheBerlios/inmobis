package com.inmobis.bbdd.mensajes;

import org.apache.log4j.Logger;

import com.inmobis.bbdd.BDObject;
import com.inmobis.bbdd.ConnectionManager;
import com.inmobis.bbdd.MysqlUtils;
import com.inmobis.bbdd.RowExistsException;
import com.inmobis.bbdd.RowNotFoundException;
import java.sql.*;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

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
		      rs = stmt.executeQuery("SELECT TMensajes.idMensaje,asunto,texto,origen,destino,Fecha,leido" +
		      		" FROM TMensajes, TRelMensaje" +
		      		" WHERE TMensajes.idMensaje=TRelMensaje.idMensaje " +
		      		"AND idMensaje=" +
                      MysqlUtils.toMysqlString(mensaje.getIdMensaje()));
		      if (rs.next()){//situarse en la siguiente fila
		    	  mensaje.setAsunto(rs.getString("asunto"));
		    	  mensaje.setIdMensaje(rs.getString("idMensaje"));
		    	  mensaje.setTexto(rs.getString("texto"));
		    	  mensaje.setDestino(rs.getString("destino"));
		    	  mensaje.setOrigen(rs.getString("origen"));
		    	  mensaje.setFecha(rs.getString("Fecha"));
		    	  mensaje.setLeido(rs.getString("leido").charAt(0));
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
		/* Se insertan datos en las dos tablas. En el caso de los mensajes genéricos
		 * tambien, siendo el destino=todos.Si pasa esto habra que hacer en TRelMesajes
		 * tantos insert como clientes dados de alta*/
		/*Podemos hacerlo por codigo o por un trigger---->mirarlo*/
		
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
		
		//solo se produce update para marcar un mensaje como leido,
		//pasandole el id. En el resto de casos no se contempla el 
		// update para los mensajes.!!!!!!!!!!!!!!!!!!!!
		try{
			conn = ConnectionManager.getConection();
		    Statement stmt = conn.createStatement();
		    
		    StringBuffer sb= new StringBuffer("UPDATE TRelMensajes ");
		    sb.append("setLeido =" +
		    		MysqlUtils.toMysqlString(mensaje.getLeido().toString()));
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
	
	public Vector BusquedaDetallada () {
		Vector mensajesEncontrados= new Vector();
		try{
		   conn = ConnectionManager.getConection();
	       Statement stmt = conn.createStatement();
	       ResultSet rs = null;
	       Hashtable consulta = new Hashtable();
	       
	       if(mensaje.getIdMensaje()!=null)
	    	   consulta.put("idMensaje",mensaje.getIdMensaje());
	       if(mensaje.getAsunto()!=null)
	    	   consulta.put("asunto", mensaje.getAsunto());
	       if(mensaje.getTexto()!=null)
	    	   consulta.put("texto",mensaje.getTexto());
	       if(mensaje.getOrigen()!=null)
	    	   consulta.put("origen",mensaje.getOrigen());
	       if(mensaje.getDestino()!=null)
	    	   consulta.put("destino",mensaje.getDestino());
	       if(mensaje.getFecha()!=null)
	    	   consulta.put("Fecha",mensaje.getFecha());
	       if(mensaje.getLeido()!=null)
	    	   consulta.put("leido",mensaje.getLeido());
	       
	       StringBuffer sqlString = new StringBuffer("SELECT TMensajes.idMensaje,asunto,texto,origen,destino,Fecha" +
	       		" from TMensajes,TRelMensajes WHERE TMensajes.idMesaje=TRelMensaje.idMesanje" +
	       		"AND ");
		   Iterator it=consulta.keySet().iterator();
		   
		   //componer la consulta con los campos rellenados
		   while(it.hasNext())
		  	{
		  	String key=(String) it.next();
		          sqlString.append(key +"="+
		                        MysqlUtils.toMysqlString((String) consulta.get(key)));
		          System.out.println(consulta.get(key));
		          if (it.hasNext())
		              sqlString.append(" AND ");
		  	}
		   
		   rs=stmt.executeQuery(sqlString.toString());
		   
		   while (rs.next()) {
			   MensajesBean nuevomensaje = new MensajesBean();
			   
			   nuevomensaje.setIdMensaje(rs.getString("idMensaje"));
			   nuevomensaje.setAsunto(rs.getString("asunto"));
			   nuevomensaje.setTexto(rs.getString("texto"));
			   nuevomensaje.setOrigen(rs.getString("origen"));
			   nuevomensaje.setDestino(rs.getString("destino"));
			   nuevomensaje.setFecha(rs.getString("Fecha"));
			   nuevomensaje.setLeido(rs.getString("leido").charAt(0));			   
			   
		   }
		}
	     catch (Exception ex){

	     }
	     finally{
	    	 if (conn != null) 
	    		 try{conn.close();}catch(SQLException e){}
	    } //Liberamos la conexion pase lo que pase
	     return mensajesEncontrados;
	}
		
}
