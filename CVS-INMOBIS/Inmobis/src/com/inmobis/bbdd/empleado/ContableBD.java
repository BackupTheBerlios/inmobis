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
import com.inmobis.bbdd.BDObject;

public class ContableBD implements BDObject,GestorContableBD{
	private VentasBean  venta;
	private static final Logger milog = Logger.getLogger(ContableBD.class);
	
	private Connection conn;
	
	public Object getBean() {
		return venta;
	}
	
	public void select () throws RowNotFoundException {}
	
	public void delete () throws RowNotFoundException {}
	
	public void insert () throws RowExistsException  {}
	
	public void update () throws RowNotFoundException {}
	
	//lista todos los reg de TVentas
	public Vector listadoVentas()throws RowNotFoundException
	{		
		Vector listaVentas=new Vector();
		
		try{			
			conn = ConnectionManager.getConection();
		    Statement stmt = conn.createStatement();
		    ResultSet rs = null;		    
		    rs = stmt.executeQuery("SELECT TInmueble.*,TVentas.idAgente," +
		    		"TVentas.fechVenta,TVentas.precioInicial,TVentas.precioFinal," +
		    		" TVentas.ganancia FROM TInmueble,TVentas " +
		    		"WHERE TInmueble.idInmueble=TVentas.idInmueble");   
		    
		    while(rs.next()){
		    	VentasBean ventas=new VentasBean();
		    	
		    	ventas.setIdAgente(rs.getString("idAgente"));
		    	ventas.setIdInmueble(rs.getString("idInmueble"));
		    	ventas.setFechVenta(rs.getString("fechVenta"));
		    	ventas.setPrecioInicial(rs.getString("precioInicial"));
		    	ventas.setPrecioFinal(rs.getString("precioFinal"));		    	
		    	ventas.setGanancia(rs.getString("ganancia"));		    	
		    	//campos correspondientes a TInmueble
		    	ventas.setNumHab(rs.getString("numHab"));
		    	ventas.setMetros(rs.getString("metros"));
		    	ventas.setRegimen(rs.getString("regimen"));
		    	ventas.setTipo(rs.getString("tipo"));
		    	ventas.setZona(rs.getString("zona"));
		    	ventas.setPrecio(rs.getString("precio"));
		    	ventas.setDatosDeInteres(rs.getString("datosdeinteres"));
		    	
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
	
	//consultas a medida, por cualquier campo
	public Vector BusquedaDetallada(VentasBean venta)
	{
		Vector ventashechas=new Vector();
		boolean fecha=false;//se pone a true si se hace una consulta
		//por rango de fechas, es decir si fechaDesde y FechaHasta estan rellenas.
		
		try{
			conn = ConnectionManager.getConection();
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
			       consulta.put("ganancia",venta.getGanancia());
		    //if(venta.getFechaDesde()!=null)
		    	//consulta.put("fechaDesde",venta.getFechaDesde());
		    if((venta.getFechaHasta()!=null)&& (venta.getFechaDesde()!=null))
		    	//consulta.put("fechaHasta",venta.getFechaHasta());
		    	fecha=true;
		    	//estas no las metemos en la hastable		    
		    
		    StringBuffer sqlString = new StringBuffer("SELECT TInmueble.*,TVentas.idAgente," +
    		"TVentas.fechVenta,TVentas.precioInicial,TVentas.precioFinal," +
    		" TVentas.ganancia FROM TInmueble,TVentas " +
    		"WHERE TInmueble.idInmueble=TVentas.idInmueble");
		    		    
		    if(fecha){//hay que hacer un rango entre fechadesde y fechahasta
		    	sqlString.append(" AND fechVenta BETWEEN "+MysqlUtils.toMysqlString(venta.getFechaDesde())+
		    			" AND " +MysqlUtils.toMysqlString(venta.getFechaHasta()));
		    }
		    
		    Iterator it=consulta.keySet().iterator();
		    
		    while(it.hasNext()){
		    	sqlString.append(" AND ");
		    	String key=(String) it.next();
		        sqlString.append(key +"="+
		                      MysqlUtils.toMysqlString((String) consulta.get(key)));
		        if (milog.isInfoEnabled()){
		 			milog.info(consulta.get(key));
		 		}  
		        /*if (it.hasNext())
		            sqlString.append(" AND ");*/
		    }
		    rs=stmt.executeQuery(sqlString.toString());
		    
		    while (rs.next()) {
		    	VentasBean ventas=new VentasBean();
		    	
		    	ventas.setIdAgente(rs.getString("idAgente"));
		    	ventas.setIdInmueble(rs.getString("idInmueble"));
		    	ventas.setFechVenta(rs.getString("fechVenta"));
		    	ventas.setPrecioInicial(rs.getString("precioInicial"));
		    	ventas.setPrecioFinal(rs.getString("precioFinal"));
		    	ventas.setGanancia(rs.getString("ganancia"));
               //campos correspondientes a TInmueble
		    	ventas.setNumHab(rs.getString("numHab"));
		    	ventas.setMetros(rs.getString("metros"));
		    	ventas.setRegimen(rs.getString("regimen"));
		    	ventas.setTipo(rs.getString("tipo"));
		    	ventas.setZona(rs.getString("zona"));
		    	ventas.setPrecio(rs.getString("precio"));
		    	ventas.setDatosDeInteres(rs.getString("datosdeinteres"));
		    		    	
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
