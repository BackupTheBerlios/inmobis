package com.inmobis.bbdd.empleado;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import org.apache.log4j.Logger;

import com.inmobis.bbdd.ConnectionManager;
import com.inmobis.bbdd.MysqlUtils;
import com.inmobis.bbdd.RowExistsException;
import com.inmobis.bbdd.RowNotFoundException;
import com.inmobis.bbdd.inmueble.VentasBean;

public class ContableBD implements GestorContableBD{
	private static final Logger milog = Logger.getLogger(ContableBD.class);
	
	private Connection conn;
	
	//lista todos los reg de TVentas
	public Vector listadoVentas()throws RowNotFoundException
	{
		Vector listaVentas=new Vector();
		
		try{
			Connection conn = ConnectionManager.getConection();
		    Statement stmt = conn.createStatement();
		    ResultSet rs = null;
		    
		    rs = stmt.executeQuery("SELECT * FROM TVentas");
		    
		    while(rs.next()){
		    	VentasBean ventas=new VentasBean();
		    	ventas.setIdAgente(rs.getString("idAgente"));
		    	ventas.setIdInmueble(rs.getString("idInmueble"));
		    	ventas.setFechVenta(rs.getString("fechVenta"));
		    	ventas.setPrecioInicial(rs.getString("precioInicial"));
		    	ventas.setPrecioFinal(rs.getString("ganancia"));
		    	listaVentas.add(ventas);
		    }
		    
		}catch (Exception ex){
			throw new RowNotFoundException();
	     }
	     finally{
	    	 if (conn != null) 
	    		 try{conn.close();}catch(SQLException e){}
	    } //Liberamos la conexion pase lo que pase
	     return listaVentas;
	}
	
	public Vector BusquedaDetallada(VentasBean venta)
	{
		Vector ventashechas=new Vector();
		
		try{
			Connection conn = ConnectionManager.getConection();
		    Statement stmt = conn.createStatement();
		    ResultSet rs = null;
		    Hashtable consulta = new Hashtable();
		    
		    if (venta.getIdAgente()!=null)
			       consulta.put("idAgente",venta.getIdAgente());
		    if (venta.getIdInmueble()!=null)
			       consulta.put("idInmueble",venta.getIdInmueble());
		    if (venta.getFechVenta()!=null)
		       consulta.put("fechVenta",venta.getFechVenta());
		    if (venta.getPrecioInicial()!=null)
		       consulta.put("precioInicial",venta.getPrecioInicial());
		    if (venta.getPrecioFinal()!=null)
		       consulta.put("precioFinal",venta.getPrecioFinal());
		    if (venta.getGanancia()!=null)
			       consulta.put("precioFinal",venta.getGanancia());
		    
		    StringBuffer sqlString = new StringBuffer("SELECT * from TVentas WHERE ");
		    Iterator it=consulta.keySet().iterator();
		    
		    while(it.hasNext()){
		    	String key=(String) it.next();
		        sqlString.append(key +"="+
		                      MysqlUtils.toMysqlString((String) consulta.get(key)));
		        if (milog.isInfoEnabled()){
		 			milog.info(consulta.get(key));
		 		}  
		        if (it.hasNext())
		            sqlString.append(" AND ");
		    }
		    rs=stmt.executeQuery(sqlString.toString());
		    
		    while (rs.next()) {
		    	VentasBean ventas=new VentasBean();
		    	ventas.setIdAgente(rs.getString("idAgente"));
		    	ventas.setIdInmueble(rs.getString("idInmueble"));
		    	ventas.setFechVenta(rs.getString("fechVenta"));
		    	ventas.setPrecioInicial(rs.getString("precioInicial"));
		    	ventas.setPrecioFinal(rs.getString("ganancia"));
		    	
		    	ventashechas.add(ventas);
		    }
		}catch (Exception ex){
	     }
	     finally{
	    	 if (conn != null) 
	    		 try{conn.close();}catch(SQLException e){}
	    } //Liberamos la conexion pase lo que pase
		return ventashechas;
	}
}
