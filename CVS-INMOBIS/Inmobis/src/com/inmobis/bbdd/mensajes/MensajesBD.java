package com.inmobis.bbdd.mensajes;

import org.apache.log4j.Logger;

import com.inmobis.bbdd.BDObject;
import com.inmobis.bbdd.ConnectionManager;
import com.inmobis.bbdd.MysqlUtils;
import com.inmobis.bbdd.RowExistsException;
import com.inmobis.bbdd.RowNotFoundException;
import java.sql.*;
import java.util.Vector;

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
		      ResultSet rs,rs1,rs2,rs3 = null;
		      
		      //obtenemos un ResultSet con los datos producidos por la consulta
		      rs = stmt.executeQuery("SELECT TMensajes.idMensaje,asunto,texto,origen,destino,Fecha,leido" +
		      		" FROM TMensajes, TRelMensaje" +
		      		" WHERE TMensajes.idMensaje=TRelMensaje.idMensaje " +
		      		"AND idMensaje= " +
                      MysqlUtils.toMysqlString(mensaje.getIdMensaje())+
                    "AND origen= " +
                      MysqlUtils.toMysqlString(mensaje.getOrigen())+
                    "AND destino= " +
                      MysqlUtils.toMysqlString(mensaje.getOrigen())+
                    "AND Fecha= " +
                      MysqlUtils.toMysqlString(mensaje.getFecha()));
		      
		      if (rs.next()){//situarse en la siguiente fila
		    	  mensaje.setAsunto(rs.getString("asunto"));
		    	  mensaje.setIdMensaje(rs.getString("idMensaje"));
		    	  mensaje.setTexto(rs.getString("texto"));
		    	  mensaje.setOrigen(rs.getString("origen"));
		    	  mensaje.setDestino(rs.getString("destino"));
		    	  mensaje.setFecha(rs.getString("Fecha"));
		    	  mensaje.setLeido(rs.getString("leido").charAt(0));
		    	  
		    	  
		    	  //Para el origen y el destino devolvemos su nombre,no su id.
		    	  //Se busca en TClientes y/o TEmpleados para obtener su nombre 
		    	  //y apellidos y devolverlos concatenados en nombreOrigen 
		    	  //y nombreDestino
		    	  rs1=stmt.executeQuery("SELECT nombre,apellido1, apellido2" +
		    			  "FROM TEmpleados WHERE IdEmpleado= " +
		    			  MysqlUtils.toMysqlString(mensaje.getOrigen()));
		    	  if(rs1.next()){ //el origen es empleado, por tanto el destino es cliente
		    		  nom=rs1.getString("nombre");
		    		  ap1=rs1.getString("apellido1");
		    		  ap2=rs1.getString("apellido2");
		    		  mensaje.setNombreOrigen("nom " + "ap1 " + "ap2 ");
		    		  //Destino=Cliente
		    		  rs2=stmt.executeQuery("SELECT nombre,apellido1, apellido2" +
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
		    		  rs2=stmt.executeQuery("SELECT nombre,apellido1, apellido2" +
			    			  "FROM TCliente WHERE IdCliente= " +
			    			  MysqlUtils.toMysqlString(mensaje.getOrigen()));
			    		  if(rs2.next()){ 
			    			  nom=rs2.getString("nombre");
				    		  ap1=rs2.getString("apellido1");
				    		  ap2=rs2.getString("apellido2");
				    		  mensaje.setNombreOrigen("nom " + "ap1 " + "ap2 ");
			    		  }
			    		  //Destino=Empleado
			    		  rs3=stmt.executeQuery("SELECT nombre,apellido1, apellido2" +
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
		/* Se insertan datos en las dos tablas. En el caso de los mensajes genéricos
		 * tambien, siendo el destino=todos.Si pasa esto habra que hacer en TRelMesajes
		 * tantos insert como clientes dados de alta*/
				
		if (milog.isInfoEnabled()){
			milog.info("Voy a insertar: "+mensaje.getIdMensaje());
		}
		try{
			conn = ConnectionManager.getConection();
		    Statement stmt = conn.createStatement();
	//	    Statement stmt1 = conn.createStatement();
		    ResultSet rs = null;
		    //transaccion
		    
		    //TMensaje
		    StringBuffer sb= new StringBuffer("INSERT INTO TMensajes ");
		    sb.append("VALUES ( " + 
		    		MysqlUtils.toMysqlString(mensaje.getIdMensaje()) + ",");
		    sb.append(MysqlUtils.toMysqlString(mensaje.getAsunto()) + ",");
		    sb.append(MysqlUtils.toMysqlString(mensaje.getTexto()) + ")");
		  	//ejecuta la sentencia sql que acabamos de construir
		    //stmt.execute(sb.toString());
		    stmt.addBatch(sb.toString());
		    //TRelMensaje
/*
		    if(mensaje.getDestino()=="todos"){
		    	StringBuffer sqlString = new StringBuffer("SELECT IdCliente " +
		    			"FROM TCliente");
		    	rs=stmt.executeQuery(sqlString.toString());
		    	while(rs.next()){//hacemos un insert para cada cliente
		    		StringBuffer sb1= new StringBuffer("INSERT INTO TRelMensaje ");
				    sb1.append("VALUES ( " + 
				    		MysqlUtils.toMysqlString(mensaje.getOrigen()) + ",");
				    sb1.append(MysqlUtils.toMysqlString(mensaje.getDestino()) + ",");
				    sb1.append(MysqlUtils.toMysqlString(rs.getString(1)) + ",");//el idCliente obtenido de TCliente
				    sb1.append(MysqlUtils.toMysqlString(mensaje.getFecha()) + ",");
				    sb1.append(MysqlUtils.toMysqlString(mensaje.getLeido().toString()) + ")");
                    // ejecuta la sentencia sql que acabamos de construir
				    stmt1.execute(sb1.toString());
		    	}
		    	
		    }else{//insertar solo un reg en TRelMensajes
	*/	    	StringBuffer sb1= new StringBuffer("INSERT INTO TRelMensaje ");
			    sb1.append("VALUES ( " + 
			    		MysqlUtils.toMysqlString(mensaje.getOrigen()) + ",");
			    sb1.append(MysqlUtils.toMysqlString(mensaje.getDestino()) + ",");
			    sb1.append(MysqlUtils.toMysqlString(mensaje.getIdMensaje()) + ",");
			    sb1.append(MysqlUtils.toMysqlString(mensaje.getFecha()) + ",");
			    sb1.append(MysqlUtils.toMysqlString(mensaje.getLeido().toString()) + ")");
			    //ejecuta la sentencia sql que acabamos de construir
			    //stmt1.execute(sb1.toString());
				if (milog.isInfoEnabled()){
					milog.info("Voy a insertar: "+sb1.toString());
				}
			    stmt.addBatch(sb1.toString());
			    stmt.executeBatch();
		   // }
		    //fin transaccion
		    
		}catch (SQLException ex){
						
		}catch(Exception e){
			throw new RowExistsException();
		}
	     finally{
	    	 if (conn != null) 
	    		 try{conn.close();
	         }catch(SQLException e){}	    		 
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
		    sb.append("set leido = " +
		    		MysqlUtils.toMysqlString(mensaje.getLeido().toString()));
		    sb.append(" WHERE IdMensaje= " +
		    		MysqlUtils.toMysqlString(mensaje.getIdMensaje()) +
		    	   "AND origen= " +
                     MysqlUtils.toMysqlString(mensaje.getOrigen())+
                   "AND destino= " +
                     MysqlUtils.toMysqlString(mensaje.getOrigen())+
                   "AND Fecha= " +
                     MysqlUtils.toMysqlString(mensaje.getFecha()));
		    
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
		//solo se borra de TMensajes si solo existe en TRelMensaje el
		//registro que se pide en los datos, si no , borramos solo de 
		//TRelMensajes.
		
		int n;
		try{
			conn = ConnectionManager.getConection();
		    Statement stmt = conn.createStatement();
		    Statement stmt1 = conn.createStatement();
		    ResultSet rs;
		    
		    //contamos cuantos reg hay en RelM con el id pasado.
		    //en rs devolvera una columna con una fila
		    rs=stmt1.executeQuery("SELECT COUNT(IdMensaje)" +
		    		"FROM TRelMensajes WHERE IdMensaje= " +
		    		MysqlUtils.toMysqlString(mensaje.getIdMensaje()));
		    
		    n=rs.getInt(1); 
		    if (n>1){ //borramos solo de TRelMensajes
		    	StringBuffer sb= new StringBuffer("DELETE FROM TRelMensaje ");
			    sb.append("WHERE idMensaje=" +
			    		MysqlUtils.toMysqlString(mensaje.getIdMensaje())+
			    	   "AND origen= " +
	                     MysqlUtils.toMysqlString(mensaje.getOrigen())+
	                   "AND destino= " +
	                     MysqlUtils.toMysqlString(mensaje.getOrigen())+
	                   "AND Fecha= " +
	                     MysqlUtils.toMysqlString(mensaje.getFecha()));
			    
			    stmt.execute(sb.toString());
		    }else if (n==1){
		    	StringBuffer sb= new StringBuffer("DELETE FROM TMensajes,TRelMensaje ");
			    sb.append("WHERE TMensajes.idMensaje=TRelMensajes.idMensaje " +
			    		"AND TMensajes.idMensaje = " +
			    		MysqlUtils.toMysqlString(mensaje.getIdMensaje())+
			    	   "AND origen= " +
	                     MysqlUtils.toMysqlString(mensaje.getOrigen())+
	                   "AND destino= " +
	                     MysqlUtils.toMysqlString(mensaje.getOrigen())+
	                   "AND Fecha= " +
	                     MysqlUtils.toMysqlString(mensaje.getFecha()));
			    
			    stmt.execute(sb.toString());
		    }else{
		    	 throw new RowNotFoundException();
		    }	  
		    
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
		String nom,ap1,ap2;
		try{ // 
		   conn = ConnectionManager.getConection();
	       Statement stmt = conn.createStatement();
	       ResultSet rs = null;

	       StringBuffer sqlString = new StringBuffer("SELECT * " +
		       		" FROM TMensajes,TRelMensaje, TEmpleados WHERE TMensajes.idMensaje=TRelMensaje.idMensaje " +
		       		"AND TEmpleados.idEmpleado = TRelMensaje.Origen "+
		       		"AND destino = " + MysqlUtils.toMysqlString((String) mensaje.getDestino()));
    	  if (milog.isInfoEnabled()){
	    			milog.info("Busqueda Detallada: "+ sqlString.toString());
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
			   nuevomensaje.setNombreOrigen(rs.getString("nombre")+" "+rs.getString("apellido1")+" "+rs.getString("apellido2"));	
			   //añadir los datos de cada mensaje encontrado a un vector 
			   //para devolverlos.
			   mensajesEncontrados.add(nuevomensaje);
			   
		   }//Fin del while
		} //Fin del try
	     catch (Exception ex){

	     }
	     finally{
	    	 if (conn != null) 
	    		 try{conn.close();}catch(SQLException e){}
	    } //Liberamos la conexion pase lo que pase
	     return mensajesEncontrados;
	}

	public Vector BusquedaDetalladaAgente() {
		Vector mensajesEncontrados= new Vector();
		ResultSet rs = null;
		try{ // 
		   conn = ConnectionManager.getConection();
	       Statement stmt = conn.createStatement();

	       StringBuffer sqlString = new StringBuffer("SELECT * " +
		       		" FROM TMensajes,TRelMensaje, TCliente WHERE TMensajes.idMensaje=TRelMensaje.idMensaje " +
		       		"AND TCliente.idCliente = TRelMensaje.Origen "+
		       		"AND destino = " + MysqlUtils.toMysqlString((String) mensaje.getDestino()));
    	  if (milog.isInfoEnabled()){
	    			milog.info(sqlString.toString());
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
			   nuevomensaje.setNombreOrigen(rs.getString("nombre")+" "+rs.getString("apellido1")+" "+rs.getString("apellido2"));	
			   //añadir los datos de cada mensaje encontrado a un vector 
			   //para devolverlos.
			   mensajesEncontrados.add(nuevomensaje);
			   
		   }//Fin del while
		} //Fin del try
	     catch (Exception ex){

	     }
	     finally{
	    	 if (conn != null) 
	    		 try{conn.close();}catch(SQLException e){}
	    } //Liberamos la conexion pase lo que pase
	     return mensajesEncontrados;
	}	

	public Vector GetDestinosMensajeAgente(){
		Vector listaDestinos = new Vector();

		try{
			   conn = ConnectionManager.getConection();
		       Statement stmt = conn.createStatement();
		       ResultSet rs = null;      
		
		      StringBuffer sqlString = new StringBuffer("SELECT TAgentesClientes.idCliente, nombre, apellido1, apellido2" +
		       		" FROM TCliente, TAgentesClientes WHERE TAgentesClientes.idCliente=TCliente.idCliente" +
		   			" AND TAgentesClientes.idAgente = ");
		       sqlString.append(MysqlUtils.toMysqlString((String) mensaje.origen));
			      if (milog.isInfoEnabled()){
		    			milog.info("GetDestinosMensajeAgente : "+sqlString.toString());
		    	  }				   
			   rs=stmt.executeQuery(sqlString.toString());
			   while (rs.next()){
				   MensajesBean destBean = new MensajesBean();
				   destBean.setDestino(rs.getString("idCliente"));
				   destBean.setNombreDestino(rs.getString("nombre")+" "+rs.getString("apellido1")+" "+rs.getString("apellido2"));
				   //nombres de origen y destino:
				   listaDestinos.add(destBean);
			   }
		}
		catch (Exception ex){
		      if (milog.isInfoEnabled()){
	    			milog.info("MensajesBD: GetDestinosMensajeAgente : "+ex.toString());
	    	  	}	
	   }
	    finally{
		    	 if (conn != null) 
		    		 try{conn.close();}catch(SQLException e){}
	    } //Liberamos la conexion pase lo que pase
			     return listaDestinos;
		
	}
	public Vector GetDestinosMensajeCliente() {
		Vector listaDestinos = new Vector();
		try{
		   conn = ConnectionManager.getConection();
	       Statement stmt = conn.createStatement();
	       ResultSet rs = null;
	       
	       //probamos si el que lo envia es un cliente
	       StringBuffer sqlString = new StringBuffer("SELECT TAgentesClientes.idAgente, nombre, apellido1, apellido2" +
	       		" FROM TEmpleados, TAgentesClientes WHERE TAgentesClientes.idAgente=TEmpleados.idEmpleado" +
	   			" AND TAgentesClientes.idCliente = ");
	       sqlString.append(MysqlUtils.toMysqlString((String) mensaje.origen));
	      if (milog.isInfoEnabled()){
	    			milog.info("GetDestinosMensajeCliente : "+sqlString.toString());
	    	  }			   
		   rs=stmt.executeQuery(sqlString.toString());

		   if (rs.next()){
			   MensajesBean destBean = new MensajesBean();
			   destBean.setDestino(rs.getString("idAgente"));
			   destBean.setNombreDestino(rs.getString("nombre")+" "+rs.getString("apellido1")+" "+rs.getString("apellido2"));
			   //nombres de origen y destino:
			   listaDestinos.add(destBean);
			   }
		}
	     catch (Exception ex){
		      if (milog.isInfoEnabled()){
	    			milog.info("MensajesBD: GetDestinosMensajeCliente : "+ex.toString());
	    	  }	
	     }
	     finally{
	    	 if (conn != null) 
	    		 try{conn.close();}catch(SQLException e){}
	    } //Liberamos la conexion pase lo que pase
	     return listaDestinos;
	}

}
