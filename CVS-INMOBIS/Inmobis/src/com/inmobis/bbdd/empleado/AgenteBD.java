package com.inmobis.bbdd.empleado;

import java.util.*;
import java.sql.*;

import org.apache.log4j.Logger;

import com.inmobis.bbdd.BDObject;
import com.inmobis.bbdd.ConnectionManager;
import com.inmobis.bbdd.MysqlUtils;
import com.inmobis.bbdd.RowExistsException;
import com.inmobis.bbdd.RowNotFoundException;
import com.inmobis.bbdd.cliente.ClienteBD;
import com.inmobis.bbdd.cliente.ClienteBean;
import com.inmobis.bbdd.inmueble.InmuebleBean;
import com.inmobis.bbdd.inmueble.VentasBean;


public class AgenteBD implements BDObject,GestorAgenteBD{
	  private AgenteBean agente;
	  private Connection conn;
	  private static final Logger milog = Logger.getLogger(AgenteBD.class);
	  public AgenteBD(AgenteBean _agente) {
	    agente = _agente;
	  }

	  public Object getBean() {
	    return agente;
	  }
	  public void select () throws RowNotFoundException {

	    try {

	      conn = ConnectionManager.getConection();
	      Statement stmt = conn.createStatement();
	      ResultSet rs = null;

	      rs = stmt.executeQuery("SELECT * FROM TAgente WHERE idAgente=" +
	                             MysqlUtils.toMysqlString(agente.getIdAgente()));
	      if (rs.next()) {
	        agente.setIdAgente(rs.getString("idAgente"));
	        agente.setComision(rs.getString("comision"));
	      }
	      else {
	    	  if (milog.isInfoEnabled()){
	    			milog.info("Error al seleccionar");
	            }
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

	    StringBuffer sqlString = new StringBuffer("INSERT INTO TAgente ");
	    sqlString.append("VALUES (" + MysqlUtils.toMysqlString(agente.getIdAgente()) + ", ");
	    sqlString.append(MysqlUtils.toMysqlString(agente.getComision())+")");


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

	    StringBuffer sqlString = new StringBuffer("UPDATE TAgente ");
	    sqlString.append("set idAgente=" +
	                     MysqlUtils.toMysqlString(agente.getIdAgente()));
	    sqlString.append(", comision=" +
	                     MysqlUtils.toMysqlString(agente.getComision()));


	    sqlString.append(" WHERE IdAgente=" +
	                     MysqlUtils.toMysqlString(agente.getIdAgente()));
	    
	    if (milog.isInfoEnabled()){
  			milog.info("comando sql: "+sqlString);
          }
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

	    StringBuffer sqlString = new StringBuffer("DELETE FROM TAgente ");
	    sqlString.append("WHERE idAgente=" +
	                    MysqlUtils.toMysqlString(agente.getIdAgente()));
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
	
	/*Para que se asocie un agente automaticamente cuando un cliente se registra via Web*/
	public String agregarCliente (String idCliente) throws RowExistsException 
	{
	  Vector listaAgentes=new Vector();
	   StringBuffer query=new StringBuffer();
	   String id=null;
	  query.append( "(select idAgente, 0  from TAgente where idAgente not in (SELECT idAgente FROM TAgentesClientes ) )"
	 + "UNION (SELECT idAgente, count(idCliente) AS 'nom' FROM TAgentesClientes  GROUP BY idAgente  ORDER BY 'nom' )" );

	   try {
	          conn = ConnectionManager.getConection();
	          Statement stmt = conn.createStatement();
	          if (milog.isInfoEnabled()){
	  			milog.info("comando sql: "+query);
	          }
	          ResultSet rs=stmt.executeQuery(query.toString());
	         while (rs.next()){
	            id=(rs.getString("idAgente"));
	            }

	          RelAgenteClienteBean agenteClienteBean= new RelAgenteClienteBean();
	          agenteClienteBean.setIdAgente(id);
	          agenteClienteBean.setIdCliente(idCliente);
	          RelAgenteClienteBD agenteClienteBD=new RelAgenteClienteBD(agenteClienteBean);
	          agenteClienteBD.insert();
	          }
	      catch (Exception e) {
	        throw new RowExistsException();
	    }
		     finally{
		    	 if (conn != null) 
		    		 try{conn.close();}catch(SQLException e){}
		    } //Liberamos la conexion pase lo que pase

	  return id;
	}
/*Cuando sea el agente quien registra a un cliente, se usa este metodo
 * que se encarga de almacenar la tupla de valores pasados (idCliente,idAgente)
 * en la base de datos
 */
	public  void asociarCliente (String idCliente,String idAgente) throws
	   RowExistsException {
	   RelAgenteClienteBean agenteClienteBean= new RelAgenteClienteBean();
	   agenteClienteBean.setIdAgente(idAgente);
	   agenteClienteBean.setIdCliente(idCliente);
	   RelAgenteClienteBD agenteClienteBD=new RelAgenteClienteBD(agenteClienteBean);
	   agenteClienteBD.insert();
	}


/*
 * Método para listar a los empleados que son agentes
 */
	public  Vector listarAgentes() throws RowNotFoundException {
	   Vector listaAgentes = new Vector();

	   try {
	     conn = ConnectionManager.getConection();
	     Statement stmt = conn.createStatement();
	     ResultSet rs = null;
	     ResultSetMetaData rsmd = null;
	     rs = stmt.executeQuery("select * from TEmpleados where idEmpleado in (select idAgente from TAgente)");
	     rsmd = rs.getMetaData();
	     while (rs.next()) {
	       EmpleadoBean empleado = new EmpleadoBean();
	       empleado.setIdEmpleado(rs.getString("idEmpleado"));
	       empleado.setNombre(rs.getString("nombre"));
	       empleado.setApellido1(rs.getString("apellido1"));
	       empleado.setApellido2(rs.getString("apellido2"));
	       empleado.setFechNacimiento(rs.getString("fechNacimiento"));
	       listaAgentes.add(empleado);

	     }

	   }
	   catch (Exception ex) {
	     throw new RowNotFoundException();
	   }
	     finally{
	    	 if (conn != null) 
	    		 try{conn.close();}catch(SQLException e){}
	    } //Liberamos la conexion pase lo que pase

	   return listaAgentes;

	 }


/*
 * Lista de clientes asociados a un agente
 */
	 public  Vector listarClientesAsociados() throws RowNotFoundException {
	    Vector listaClientesAgentes = new Vector();

	    try {
	      conn = ConnectionManager.getConection();
	      Statement stmt = conn.createStatement();
	      ResultSet rs = null;
	      ResultSetMetaData rsmd = null;



	      rs = stmt.executeQuery("select * from TCliente where idCliente in (select idCliente from TAgentesClientes"+
	                            " WHERE idAgente=" + MysqlUtils.toMysqlString(agente.getIdAgente())+")");


	 	      while (rs.next()) {
	        ClienteBean cliente = new ClienteBean();
	        cliente.setIdCliente(rs.getString("idCliente"));
	        cliente.setDni(rs.getString("dni"));
	        cliente.setNombre(rs.getString("nombre"));
	        cliente.setApellido1(rs.getString("apellido1"));
	        cliente.setApellido2(rs.getString("apellido2"));
	        cliente.setFechNacimiento(rs.getString("fechNacimiento"));
	        listaClientesAgentes.add(cliente);

	      }

	    }
	    catch (Exception ex) {
	     throw new RowNotFoundException();
	    }
	     finally{
	    	 if (conn != null) 
	    		 try{conn.close();}catch(SQLException e){}
	    } //Liberamos la conexion pase lo que pase

	    return listaClientesAgentes;

	  }
	 
	 public  Vector listarInmueblesAgentes() throws RowNotFoundException {
		   Vector listaInmueblesAgentes = new Vector();

		   try {
		     Connection conn = ConnectionManager.getConection();
		     Statement stmt = conn.createStatement();
		     ResultSet rs = null;
		  
		     
		     rs = stmt.executeQuery("select * from TInmueble where idInmueble in (select idInmueble from TClientesInmuebles where idCliente in(select idCliente from TAgentesClientes where idAgente="
		                            +MysqlUtils.toMysqlString(agente.getIdAgente())+"))");

		    
		     while (rs.next()) {
		       InmuebleBean inmueble = new InmuebleBean();
		       inmueble.setIdInmueble(rs.getString("idInmueble"));
		       inmueble.setNumHab(rs.getString("numHab"));
		       inmueble.setMetros(rs.getString("metros"));
		       inmueble.setRegimen(rs.getString("regimen"));
		       inmueble.setTipo(rs.getString("tipo"));
		       inmueble.setZona(rs.getString("zona"));
		       inmueble.setPrecio(rs.getString("precio"));
		       inmueble.setDatosDeInteres(rs.getString("datosdeinteres"));
		       listaInmueblesAgentes.add(inmueble);

		     }

		   }
		   catch (Exception ex) {
		     throw new RowNotFoundException();
		   }finally{
		    	 if (conn != null) 
		    		 try{conn.close();
		    	 }catch(SQLException e){}
		    } //Liberamos la conexion pase lo que pase
		   return listaInmueblesAgentes;

		 }
	 
	 //añadir una venta en la tabla TVentas:
	 public void insertarVenta(VentasBean venta) throws RowExistsException
	 {
		 try {
			    conn = ConnectionManager.getConection();
			    Statement stmt = conn.createStatement();

			    StringBuffer sqlString = new StringBuffer("INSERT INTO TVentas ");
			    sqlString.append("VALUES (" + MysqlUtils.toMysqlString(venta.getIdAgente()) + ", ");
			    sqlString.append(MysqlUtils.toMysqlString(venta.getIdInmueble()) + ", ");
			    sqlString.append(MysqlUtils.toMysqlString(venta.getFechVenta()) + ", ");
			    sqlString.append(MysqlUtils.toMysqlString(venta.getPrecioInicial()) + ", ");
			    sqlString.append(MysqlUtils.toMysqlString(venta.getPrecioFinal()) + ", ");
			    sqlString.append(MysqlUtils.toMysqlString(venta.getGanancia())+ ")");
			    
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
			    		 try{conn.close();
			    	 }catch(SQLException e){}
			    } //Liberamos la conexion pase lo que pase
	 }
}