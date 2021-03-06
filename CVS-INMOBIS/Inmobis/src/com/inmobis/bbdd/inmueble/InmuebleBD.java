package com.inmobis.bbdd.inmueble;

import java.util.*;

import org.apache.log4j.Logger;

import java.sql.*;

import com.inmobis.bbdd.BDObject;
import com.inmobis.bbdd.ConnectionManager;
import com.inmobis.bbdd.MysqlUtils;
import com.inmobis.bbdd.RowExistsException;
import com.inmobis.bbdd.RowNotFoundException;
import com.inmobis.bbdd.cliente.ClienteBean;
import com.inmobis.bbdd.direccion.InfoDirBean;
import com.inmobis.bbdd.direccion.InfoDirClientesBD;
import com.inmobis.bbdd.direccion.InfoDirInmueblesBD;
import com.inmobis.bbdd.util.*;


/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class InmuebleBD implements BDObject,GestorInmuebleBD{

 private InmuebleBean inmueble;
 private InfoDirBean dirInmueble;
 private InfoDirInmueblesBD direccion;
 private Connection conn;
 private static final Logger milog = Logger.getLogger(InmuebleBD.class);

 public InmuebleBD (InmuebleBean _inmueble) {
   inmueble = _inmueble;
 }


 public Object getBean() {
    return inmueble;
  }

 public InfoDirBean getDireccionBean (){
    return dirInmueble;
     }

//solo muestra si es no vendido
  public void select () throws RowNotFoundException {

     try {

       conn = ConnectionManager.getConection();
       Statement stmt = conn.createStatement();
       ResultSet rs = null;

       rs = stmt.executeQuery("SELECT * FROM TInmueble WHERE idInmueble " +
       		"not in (select idInmueble from TVentas) AND idInmueble= " +
                              MysqlUtils.toMysqlString(inmueble.getIdInmueble()));
       if (rs.next()) {
         inmueble.setIdInmueble(rs.getString("idInmueble"));
         inmueble.setNumHab(rs.getString("numHab"));
         inmueble.setMetros(rs.getString("metros"));
         inmueble.setRegimen(rs.getString("regimen"));
         inmueble.setTipo(rs.getString("tipo"));
         inmueble.setZona(rs.getString("zona"));
         inmueble.setPrecio(rs.getString("precio"));
         inmueble.setDatosDeInteres(rs.getString("datosdeinteres"));
         inmueble.setFoto1(rs.getString("foto1"));
         inmueble.setFoto2(rs.getString("foto2"));

       }
       else {
    	   throw new RowNotFoundException();
       }
     }
     catch(Exception ex)
       {
    	 if (milog.isInfoEnabled()){
 			milog.info("error: "+ ex.toString());
 		}
    	 throw new RowNotFoundException();
       }
     finally{
    	 if (conn != null) 
    		 try{conn.close();}catch(SQLException e){}
    } //Liberamos la conexion pase lo que pase
  }

  public void insert() throws RowExistsException {
	  if (milog.isInfoEnabled()){
			milog.info("Voy a insertar: "+inmueble.idInmueble +" metros: "+inmueble.metros);
		}  
   try {
     conn = ConnectionManager.getConection();
     Statement stmt = conn.createStatement();

     StringBuffer sqlString = new StringBuffer("INSERT INTO TInmueble ");
     sqlString.append("VALUES (" + MysqlUtils.toMysqlString(inmueble.getIdInmueble()) + ", ");
     sqlString.append(MysqlUtils.toMysqlString(inmueble.getNumHab()) +
     ", ");
     sqlString.append(MysqlUtils.toMysqlString(inmueble.getMetros()) +
                      ", ");
     sqlString.append(MysqlUtils.toMysqlString(inmueble.getRegimen()) + ", ");
     sqlString.append(MysqlUtils.toMysqlString(inmueble.getTipo()) + ", ");
     sqlString.append(MysqlUtils.toMysqlString(inmueble.getZona()) + ", ");
     sqlString.append(MysqlUtils.toMysqlString(inmueble.getPrecio()) + ", ");
     sqlString.append(MysqlUtils.toMysqlString(inmueble.getdatosDeInteres())+", ");
	 sqlString.append(MysqlUtils.toMysqlString(inmueble.getFoto1())+", ");
     sqlString.append(MysqlUtils.toMysqlString(inmueble.getFoto2()) +
                      ")");
     if (milog.isInfoEnabled()){
			milog.info("comando sql: "+sqlString);
	  }
     stmt.execute(sqlString.toString());
   }
   catch (Exception ex) {
	   if (milog.isInfoEnabled()){
			milog.info("error: "+ ex.toString());
		}
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
     
     StringBuffer sqlString = new StringBuffer("UPDATE TInmueble ");
     sqlString.append("set IdInmueble=" +
                      MysqlUtils.toMysqlString(inmueble.getIdInmueble()) + ", ");
     sqlString.append("numHab=" +
             MysqlUtils.toMysqlString(inmueble.getNumHab()) +
             ", ");
     sqlString.append("metros=" +
                      MysqlUtils.toMysqlString(inmueble.getMetros()) +
                      ", ");
     sqlString.append("regimen=" +
                      MysqlUtils.toMysqlString(inmueble.getRegimen()) + ", ");
     
     sqlString.append("tipo=" +
             MysqlUtils.toMysqlString(inmueble.getTipo()) + ", ");
     sqlString.append("zona=" +
             MysqlUtils.toMysqlString(inmueble.getZona()) + ", ");
     
     sqlString.append("precio=" +
                      MysqlUtils.toMysqlString(inmueble.getPrecio()) + ", ");
     sqlString.append("datosdeinteres=" +
                      MysqlUtils.toMysqlString(inmueble.getdatosDeInteres()));
     sqlString.append(" WHERE IdInmueble=" +
                      MysqlUtils.toMysqlString(inmueble.getIdInmueble()));
     
     if(milog.isInfoEnabled())
			milog.info(sqlString.toString());
     
     stmt.execute(sqlString.toString());
        }
   catch (Exception ex) {
    throw new RowNotFoundException();
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
    
     StringBuffer sqlString = new StringBuffer("DELETE FROM TInmueble ");
     sqlString.append("WHERE idInmueble=" +
                     MysqlUtils.toMysqlString(inmueble.getIdInmueble()));
     stmt.execute(sqlString.toString());
   }
   catch (Exception ex) {
     throw new RowNotFoundException();
   }
   finally{
  	 if (conn != null) 
  		 try{conn.close();}catch(SQLException e){}
  } //Liberamos la conexion pase lo que pase
   
   //borrar de TClientesInmuebles el registro correspondiente
   try{
	   conn=ConnectionManager.getConection();
	   Statement stmt=conn.createStatement();
	   
	   StringBuffer sb= new StringBuffer("DELETE FROM TClientesInmuebles " +
	   		"WHERE idInmueble= " + MysqlUtils.toMysqlString(inmueble.getIdInmueble()));
	   stmt.execute(sb.toString());
	   
   }catch(Exception ex){
	   throw new RowNotFoundException();
   }finally{
	   if (conn != null) 
	  		 try{conn.close();}catch(SQLException e){}
	  } //Liberamos la conexion pase lo que pase
   }

 
 //Solo se listan los inmuebles no vendidos
 public  Vector  listarInmuebles() throws RowNotFoundException {
	    Vector listaInmuebles = new Vector();
	    if (milog.isInfoEnabled()){
	 			milog.info("InmuebleBD 1: estoy dentro de listarinmuebles");
	 	}
	    try {
	      conn = ConnectionManager.getConection();
	      Statement stmt = conn.createStatement();
	      ResultSet rs = null;
	      ResultSetMetaData rsmd=null;
	      rs = stmt.executeQuery("select * from TInmueble WHERE idInmueble " +
       		"not in (select idInmueble from TVentas) ");
	      rsmd=rs.getMetaData();
	      while (rs.next()) {
	        InmuebleBean inmueble=new InmuebleBean();
	        inmueble.setIdInmueble(rs.getString("idInmueble"));
	        inmueble.setNumHab(rs.getString("numHab"));
	        inmueble.setMetros(rs.getString("metros"));
	        inmueble.setRegimen(rs.getString("regimen"));
	        inmueble.setTipo(rs.getString("tipo"));
	        inmueble.setZona(rs.getString("zona"));
	        inmueble.setPrecio(rs.getString("precio"));
	        inmueble.setDatosDeInteres(rs.getString("datosdeinteres"));
	        listaInmuebles.add(inmueble);

	      }
	      
	    }
	    catch (Exception ex) {
	    	if (milog.isInfoEnabled()){
	 			milog.info("InmuebleBD 2:ha habido error");
	    	}	
	      throw new RowNotFoundException();
	    }
	     finally{
	    	 if (conn != null) 
	    		 try{conn.close();}catch(SQLException e){}
	    } //Liberamos la conexion pase lo que pase
	    if (milog.isInfoEnabled()){
 			milog.info("InmuebleBD 3:estoy al final de listarinmuebles");
	    }
	    return listaInmuebles;
	    
	  }

 public String [] getIdDirecciones(){
      Vector direcciones=new Vector();
      StringBuffer query=new StringBuffer();
      query.append("SELECT idGeneral FROM TDirInmueble WHERE idGeneral=");
      query.append(MysqlUtils.toMysqlString(inmueble.getIdInmueble()));

           try {
             conn = ConnectionManager.getConection();
             Statement stmt = conn.createStatement();
             ResultSet rs=stmt.executeQuery(query.toString());
               while (rs.next()){
                direcciones.add(rs.getString("idGeneral"));
               }
             }
         catch (Exception e) {
          e.printStackTrace();
       }
	     finally{
	    	 if (conn != null) 
	    		 try{conn.close();}catch(SQLException e){}
	    } //Liberamos la conexion pase lo que pase
      return ArrayOps.toStringArray(direcciones);
   }

   public InfoDirBean newInfoDirInmuebles(String descDir){
   InfoDirBean idb=new  InfoDirBean();
   idb.setIdGeneral(inmueble.getIdInmueble());
   idb.setDescDir(descDir);
   return idb;
   }
   //solo busca/muestra inmuebles no vendidos
   public Vector BusquedaDetallada () {
	   Vector inmueblesEncontrados = new Vector();
	   if (milog.isInfoEnabled()){
			milog.info("InmuebleBD 4:estoy al principio de busquedaDetallada");
	    }
	     try {
	       conn = ConnectionManager.getConection();
	       Statement stmt = conn.createStatement();
	       ResultSet rs = null;
	       Hashtable consulta = new Hashtable();

	      if (inmueble.getIdInmueble()!=null)
	       consulta.put("idInmueble",inmueble.getIdInmueble());
	      
	      if (inmueble.getNumHab()!=null)
		       consulta.put("numHab",inmueble.getNumHab());

	      if (inmueble.getMetros()!=null)
	        consulta.put("metros",inmueble.getMetros());

	      if (inmueble.getRegimen()!=null)
	        consulta.put("regimen",inmueble.getRegimen());
	      
	      if (inmueble.getTipo()!=null)
		        consulta.put("tipo",inmueble.getTipo());
	      
	      if (inmueble.getZona()!=null)
		        consulta.put("zona",inmueble.getZona());


	      if (inmueble.getPrecio()!=null)
	        consulta.put("precio",inmueble.getPrecio());


	      StringBuffer sqlString = new StringBuffer("SELECT * from TInmueble " +
	      		"WHERE idInmueble not in (select idInmueble from TVentas) ");
	      Iterator it=consulta.keySet().iterator();


	  	while(it.hasNext())
	  	{
	  	String key=(String) it.next();
	  	      sqlString.append(" AND ");
	          sqlString.append(key +"="+
	                        MysqlUtils.toMysqlString((String) consulta.get(key)));
		        if (milog.isInfoEnabled()){
		 			milog.info(consulta.get(key));
		 		}  
	         // if (it.hasNext())
	           //   sqlString.append(" AND ");
	  	}


	     rs=stmt.executeQuery(sqlString.toString());

	       while (rs.next()) {
	           InmuebleBean inmuebleNuevo=new InmuebleBean();
	           
	           inmuebleNuevo.setIdInmueble(rs.getString("idInmueble"));
	           inmuebleNuevo.setNumHab(rs.getString("numHab"));
	           inmuebleNuevo.setMetros(rs.getString("metros"));
	           inmuebleNuevo.setRegimen(rs.getString("regimen"));
	           inmuebleNuevo.setTipo(rs.getString("tipo"));
	           inmuebleNuevo.setZona(rs.getString("zona"));
	           inmuebleNuevo.setPrecio(rs.getString("precio"));
	           inmuebleNuevo.setDatosDeInteres(rs.getString("datosdeinteres"));
	           inmueblesEncontrados.add(inmuebleNuevo);
	         }

	   
	     }
	     catch (Exception ex){

	     }
	     finally{
	    	 if (conn != null) 
	    		 try{conn.close();}catch(SQLException e){}
	    } //Liberamos la conexion pase lo que pase
	     if (milog.isInfoEnabled()){
				milog.info("InmuebleBD 5:estoy al final de busquedaDetallada");
		    }
	     return inmueblesEncontrados;
  }
   public Vector BusquedaDetalladaConPrecio (String precioMin,String precioMax) {
	   Vector inmueblesEncontrados = new Vector();

	     try {
	       Connection conn = ConnectionManager.getConection();
	       Statement stmt = conn.createStatement();
	       ResultSet rs = null;
	       Hashtable consulta = new Hashtable();

	      if (inmueble.getIdInmueble()!=null)
	       consulta.put("idInmueble",inmueble.getIdInmueble());

	     if (inmueble.getNumHab()!=null)
	       consulta.put("numHab",inmueble.getNumHab());

	      if (inmueble.getMetros()!=null)
	        consulta.put("metros",inmueble.getMetros());

	      if (inmueble.getRegimen()!=null)
	        consulta.put("regimen",inmueble.getRegimen());
	      if (inmueble.getTipo()!=null)
	        consulta.put("tipo",inmueble.getTipo());
	      if (inmueble.getZona()!=null)
	        consulta.put("zona",inmueble.getZona());

	      StringBuffer sqlString = new StringBuffer("SELECT * from TInmueble " +
	      		"WHERE idInmueble not in (select idInmueble from TVentas) ");
	      Iterator it=consulta.keySet().iterator();


	          while(it.hasNext())
	          {
	          String key=(String) it.next();

	          sqlString.append(" AND ");
	          sqlString.append(key +"="+
	                        MysqlUtils.toMysqlString((String) consulta.get(key)));
		        if (milog.isInfoEnabled()){
		 			milog.info(consulta.get(key));
		 		}  
	          //if (it.hasNext())
	            //  sqlString.append(" AND ");
	          }
	          if(consulta.size()>0){
	            sqlString.append(" AND ");
	          }
	          sqlString.append(" precio BETWEEN "+MysqlUtils.toMysqlString(precioMin)+" AND "
	                           +MysqlUtils.toMysqlString(precioMax));
	          if (milog.isInfoEnabled()){
		 			milog.info(sqlString);
		 		}  
	          

	     rs=stmt.executeQuery(sqlString.toString());

	       while (rs.next()) {
	           InmuebleBean inmuebleNuevo=new InmuebleBean();
	           inmuebleNuevo.setIdInmueble(rs.getString("idInmueble"));
	           inmuebleNuevo.setNumHab(rs.getString("numHab"));
	           inmuebleNuevo.setMetros(rs.getString("metros"));
	           inmuebleNuevo.setRegimen(rs.getString("regimen"));
	           inmuebleNuevo.setTipo(rs.getString("tipo"));
	           inmuebleNuevo.setZona(rs.getString("zona"));
	           inmuebleNuevo.setPrecio(rs.getString("precio"));
	           inmuebleNuevo.setDatosDeInteres(rs.getString("datosdeinteres"));
	           inmueblesEncontrados.add(inmuebleNuevo);
	         }

	       if (milog.isInfoEnabled()){
	 			milog.info(sqlString);
	 		}  
	     }
	     catch (Exception ex){

	     }
	     finally{
	    	 if (conn != null) 
	    		 try{conn.close();}catch(SQLException e){}
	    }
	     return inmueblesEncontrados;
	   }

	   public Vector BusquedaDetalladaConMetros (String metrosMin,String metrosMax) {
	   Vector inmueblesEncontrados = new Vector();

	     try {
	       Connection conn = ConnectionManager.getConection();
	       Statement stmt = conn.createStatement();
	       ResultSet rs = null;
	       Hashtable consulta = new Hashtable();

	      if (inmueble.getIdInmueble()!=null)
	       consulta.put("idInmueble",inmueble.getIdInmueble());

	     if (inmueble.getNumHab()!=null)
	       consulta.put("numHab",inmueble.getNumHab());
	      if (inmueble.getRegimen()!=null)
	        consulta.put("regimen",inmueble.getRegimen());
	      if (inmueble.getTipo()!=null)
	        consulta.put("tipo",inmueble.getTipo());
	      if (inmueble.getZona()!=null)
	        consulta.put("zona",inmueble.getZona());
	      if (inmueble.getPrecio()!=null)
	        consulta.put("precio",inmueble.getPrecio());

	      StringBuffer sqlString = new StringBuffer("SELECT * from TInmueble " +
	      		"WHERE idInmueble not in (select idInmueble from TVentas) ");
	      Iterator it=consulta.keySet().iterator();


	          while(it.hasNext())
	          {
	          String key=(String) it.next();

	          sqlString.append(" AND ");
	          sqlString.append(key +"="+
	                        MysqlUtils.toMysqlString((String) consulta.get(key)));
		        if (milog.isInfoEnabled()){
		 			milog.info(consulta.get(key));
		 		}  
	          //if (it.hasNext())
	              //sqlString.append(" AND ");
	          }
	          if(consulta.size()>0){
	            sqlString.append(" AND ");
	          }
	         /* sqlString.append(" metros BETWEEN "+MysqlUtils.toMysqlString(metrosMin)+" AND "
	                           +MysqlUtils.toMysqlString(metrosMax));*/
	          sqlString.append(" metros BETWEEN "+metrosMin+" AND "+metrosMax);

	          if (milog.isInfoEnabled()){
		 			milog.info(sqlString);
		 		}  

	     rs=stmt.executeQuery(sqlString.toString());

	       while (rs.next()) {
	           InmuebleBean inmuebleNuevo=new InmuebleBean();
	           inmuebleNuevo.setIdInmueble(rs.getString("idInmueble"));
	           inmuebleNuevo.setNumHab(rs.getString("numHab"));
	           inmuebleNuevo.setMetros(rs.getString("metros"));
	           inmuebleNuevo.setRegimen(rs.getString("regimen"));
	           inmuebleNuevo.setTipo(rs.getString("tipo"));
	           inmuebleNuevo.setZona(rs.getString("zona"));
	           inmuebleNuevo.setPrecio(rs.getString("precio"));
	           inmuebleNuevo.setDatosDeInteres(rs.getString("datosdeinteres"));
	           inmueblesEncontrados.add(inmuebleNuevo);
	         }

	       if (milog.isInfoEnabled()){
	 			milog.info(sqlString);
	 		}
	     }
	     catch (Exception ex){

	     }
	     finally{
	    	 if (conn != null) 
	    		 try{conn.close();}catch(SQLException e){}
	    }
	     return inmueblesEncontrados;
	   }

	   public Vector BusquedaDetalladaMetrosPrecio (String metrosMin,String metrosMax,String precioMin,String precioMax) {
	     Vector inmueblesEncontrados = new Vector();

	       try {
	         Connection conn = ConnectionManager.getConection();
	         Statement stmt = conn.createStatement();
	         ResultSet rs = null;
	         Hashtable consulta = new Hashtable();

	        if (inmueble.getIdInmueble()!=null)
	         consulta.put("idInmueble",inmueble.getIdInmueble());

	       if (inmueble.getNumHab()!=null)
	         consulta.put("numHab",inmueble.getNumHab());
	        if (inmueble.getRegimen()!=null)
	          consulta.put("regimen",inmueble.getRegimen());
	        if (inmueble.getTipo()!=null)
	          consulta.put("tipo",inmueble.getTipo());
	        if (inmueble.getZona()!=null)
	          consulta.put("zona",inmueble.getZona());

	        StringBuffer sqlString = new StringBuffer("SELECT * from TInmueble " +
	        		"WHERE idInmueble not in (select idInmueble from TVentas) ");
	        Iterator it=consulta.keySet().iterator();


	            while(it.hasNext())
	            {
	            String key=(String) it.next();

	            sqlString.append(" AND ");
	            sqlString.append(key +"="+
	                          MysqlUtils.toMysqlString((String) consulta.get(key)));
		        if (milog.isInfoEnabled()){
		 			milog.info(consulta.get(key));
		 		}  
	            //if (it.hasNext())
	              //  sqlString.append(" AND ");
	            }
	            if(consulta.size()>0){
	              sqlString.append(" AND ");
	            }
	            sqlString.append(" precio BETWEEN "+MysqlUtils.toMysqlString(precioMin)+" AND "
	                             +MysqlUtils.toMysqlString(precioMax));
	          /*  sqlString.append(" AND metros BETWEEN "+MysqlUtils.toMysqlString(metrosMin)+" AND "
	                             +MysqlUtils.toMysqlString(metrosMax));*/
	              sqlString.append(" AND metros BETWEEN "+metrosMin+" AND "+metrosMax);
	              if (milog.isInfoEnabled()){
	  	 			milog.info(sqlString);
	  	 		}  

	       rs=stmt.executeQuery(sqlString.toString());

	         while (rs.next()) {
	             InmuebleBean inmuebleNuevo=new InmuebleBean();
	             inmuebleNuevo.setIdInmueble(rs.getString("idInmueble"));
	             inmuebleNuevo.setNumHab(rs.getString("numHab"));
	             inmuebleNuevo.setMetros(rs.getString("metros"));
	             inmuebleNuevo.setRegimen(rs.getString("regimen"));
	             inmuebleNuevo.setTipo(rs.getString("tipo"));
	             inmuebleNuevo.setZona(rs.getString("zona"));
	             inmuebleNuevo.setPrecio(rs.getString("precio"));
	             inmuebleNuevo.setDatosDeInteres(rs.getString("datosdeinteres"));
	             inmueblesEncontrados.add(inmuebleNuevo);
	           }

	         if (milog.isInfoEnabled()){
		 			milog.info(sqlString);
		 		}
	       }
	       catch (Exception ex){

	       }
	       finally{
		    	 if (conn != null) 
		    		 try{conn.close();}catch(SQLException e){}
		    }
	       return inmueblesEncontrados;
	     }



   public void consultaDirPorId (String idGeneral)throws RowNotFoundException {
	   this.dirInmueble=new InfoDirBean();//Bean de las direcciones
	   this.dirInmueble.setIdGeneral(idGeneral);
	   InfoDirInmueblesBD direccion = new InfoDirInmueblesBD(this.dirInmueble);
	   direccion.selectAll();

	 }
   /*public void consultaDir (String descDir) throws RowNotFoundException {
    dirInmueble=newInfoDirInmuebles(descDir);
    InfoDirInmueblesBD direccion = new InfoDirInmueblesBD(dirInmueble);
    direccion.select();

  }*/
  public void deleteDir (String descDir) throws RowNotFoundException{
     String [] direcciones = getIdDirecciones();

     dirInmueble=newInfoDirInmuebles(descDir);
     InfoDirInmueblesBD direccion = new InfoDirInmueblesBD(dirInmueble);
     direccion.delete();
   }

   public void insertaDir (InfoDirBean miDireccion) throws RowExistsException {

      InfoDirInmueblesBD direccion = new InfoDirInmueblesBD(miDireccion);
      dirInmueble=miDireccion;
      direccion.insert();

    }
   
   public void updateDir (InfoDirBean miDireccion) throws RowNotFoundException {

	      InfoDirInmueblesBD direccion = new InfoDirInmueblesBD(miDireccion);
	      dirInmueble=miDireccion;
	      direccion.update();

	    }
   
   public  void asociarClienteInmueble (String idCliente,String idInmueble) throws
   RowExistsException {
   String id=null;
   RelClientesInmueblesBean clienteInmuebleBean= new RelClientesInmueblesBean();
  
   clienteInmuebleBean.setIdCliente(idCliente);
   clienteInmuebleBean.setIdInmueble(idInmueble);
   RelClientesInmueblesBD clienteInmuebleBD=new RelClientesInmueblesBD(clienteInmuebleBean);
   clienteInmuebleBD.insert();

}


}
