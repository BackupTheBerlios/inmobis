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
		String nOrigen;
		String nDestino;
		String nom,ap1,ap2;
		try {
		      conn = ConnectionManager.getConection();
		      Statement stmt = conn.createStatement();
		      Statement stmt1 = conn.createStatement();
		      Statement stmt2 = conn.createStatement();
		      Statement stmt3 = conn.createStatement();
		      ResultSet rs,rs1,rs2,rs3 = null;
		      
		      //obtenemos un ResultSet con los datos producidos por la consulta
		      rs = stmt.executeQuery("SELECT TMensajes.idMensaje,asunto,texto,origen,destino,Fecha,leido" +
		      		" FROM TMensajes, TRelMensaje" +
		      		" WHERE TMensajes.idMensaje=TRelMensaje.idMensaje " +
		      		"AND idMensaje= " +
                      MysqlUtils.toMysqlString(mensaje.getIdMensaje()));
		      if (rs.next()){//situarse en la siguiente fila
		    	  mensaje.setAsunto(rs.getString("asunto"));
		    	  mensaje.setIdMensaje(rs.getString("idMensaje"));
		    	  mensaje.setTexto(rs.getString("texto"));
		    	  mensaje.setFecha(rs.getString("Fecha"));
		    	  mensaje.setLeido(rs.getString("leido").charAt(0));
		    	  
		    	  //Para el origen y el destino devolvemos su nombre,no su id.
		    	  //Se busca en TClientes y/o TEmpleados para obtener su nombre 
		    	  //y apellidos y devolverlos concatenados en nombreOrigen 
		    	  //y nombreDestino
		    	  rs1=stmt1.executeQuery("SELECT nombre,apellido1, apellido2" +
		    			  "FROM TEmpleados WHERE IdEmpleado= " +
		    			  MysqlUtils.toMysqlString(mensaje.getOrigen()));
		    	  if(rs1.next()){ //el origen es empleado, por tanto el destino es cliente
		    		  nom=rs1.getString("nombre");
		    		  ap1=rs1.getString("apellido1");
		    		  ap2=rs1.getString("apellido2");
		    		  mensaje.setNombreOrigen("nom " + "ap1 " + "ap2 ");
		    		  //Destino=Cliente
		    		  rs2=stmt2.executeQuery("SELECT nombre,apellido1, apellido2" +
		    			  "FROM TCliente WHERE IdCliente= " +
		    			  MysqlUtils.toMysqlString(mensaje.getDestino()));
		    		  if(rs2.next()){
		    			  nom=rs2.getString("nombre");
			    		  ap1=rs2.getString("apellido1");
			    		  ap2=rs2.getString("apellido2");
			    		  mensaje.setNombreDestino("nom " + "ap1 " + "ap2 ");
		    		  }
		    	  }else{//origen es cliente y destino es empleado
		    		  //Origen=Cliente
		    		  rs2=stmt2.executeQuery("SELECT nombre,apellido1, apellido2" +
			    			  "FROM TCliente WHERE IdCliente= " +
			    			  MysqlUtils.toMysqlString(mensaje.getOrigen()));
			    		  if(rs2.next()){ 
			    			  nom=rs2.getString("nombre");
				    		  ap1=rs2.getString("apellido1");
				    		  ap2=rs2.getString("apellido2");
				    		  mensaje.setNombreOrigen("nom " + "ap1 " + "ap2 ");
			    		  }
			    		  //Destino=Empleado
			    		  rs3=stmt3.executeQuery("SELECT nombre,apellido1, apellido2" +
				    			  "FROM TEmpleados WHERE IdEmpleado= " +
				    			  MysqlUtils.toMysqlString(mensaje.getDestino()));
				    	  if(rs3.next()){ 
				    		  nom=rs3.getString("nombre");
				    		  ap1=rs3.getString("apellido1");
				    		  ap2=rs3.getString("apellido2");
				    		  mensaje.setNombreDestino("nom " + "ap1 " + "ap2 ");
				    	  }
		    	  }
		    }else {
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
		/* Se insertan datos en las dos tablas. En el caso de los mensajes gen�ricos
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
		    sb.append("set leido =" +
		    		MysqlUtils.toMysqlString(mensaje.getLeido().toString()));
		    sb.append(" WHERE IdMensaje=" +
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
	
	//otros m�todos necesarios.
	
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
	       		" from TMensajes,TRelMensajes WHERE TMensajes.idMensaje=TRelMensaje.idMensaje" +
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
