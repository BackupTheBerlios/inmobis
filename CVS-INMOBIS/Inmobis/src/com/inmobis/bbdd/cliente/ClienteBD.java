package com.inmobis.bbdd.cliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

import org.apache.log4j.Logger;

import com.inmobis.bbdd.BDObject;
import com.inmobis.bbdd.ConnectionManager;
import com.inmobis.bbdd.MysqlUtils;
import com.inmobis.bbdd.RowExistsException;
import com.inmobis.bbdd.RowNotFoundException;
import com.inmobis.bbdd.direccion.InfoDirBean;
import com.inmobis.bbdd.direccion.InfoDirClientesBD;
import com.inmobis.bbdd.email.InfoMailBean;
import com.inmobis.bbdd.email.InfoMailClientesBD;
import com.inmobis.bbdd.empleado.EmpleadoBean;
import com.inmobis.bbdd.login.UsuarioLoginBD;
import com.inmobis.bbdd.login.UsuarioLoginBean;
import com.inmobis.bbdd.telefono.InfoTelfBean;
import com.inmobis.bbdd.telefono.InfoTelfClientesBD;
import com.inmobis.bbdd.util.ArrayOps;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class ClienteBD implements BDObject,GestorClienteBD{
  private ClienteBean cliente;
  private InfoDirBean dirCliente;
  private UsuarioLoginBean loginCliente;
  private InfoDirClientesBD direccion;
  private InfoTelfBean telfCliente;
  private InfoTelfClientesBD telefono;
  private InfoMailBean mailCliente;
  private InfoMailClientesBD mail;
  private Connection conn;
  private static final Logger milog = Logger.getLogger(ClienteBD.class);

  public ClienteBD(ClienteBean _cliente)  {
    cliente = _cliente;

  }

  public Object getBean() {
    return cliente;
  }

  public InfoDirBean getDireccionBean (){

     return dirCliente;
   }

   public InfoTelfBean getTelefonoBean (){

    return telfCliente;
   }

   public InfoMailBean getMailBean (){

    return mailCliente;
   }
   
   public UsuarioLoginBean getLoginBean (){

       return loginCliente;
      }
  public void select() throws RowNotFoundException{

    try {
      conn = ConnectionManager.getConection();
      Statement stmt = conn.createStatement();
      ResultSet rs = null;

      rs = stmt.executeQuery("SELECT * FROM TCliente WHERE idCliente=" +
                             MysqlUtils.toMysqlString(cliente.getIdCliente()));

      if (rs.next()) {
        cliente.setIdCliente(rs.getString("idCliente"));
        cliente.setIdCliente(rs.getString("dni"));
        cliente.setNombre(rs.getString("nombre"));
        cliente.setApellido1(rs.getString("apellido1"));
        cliente.setApellido2(rs.getString("apellido2"));
        cliente.setFechNacimiento(rs.getString("fechNacimiento"));
      }
      else {
    	  throw new RowNotFoundException();
      }

    }
    catch (Exception ex) {
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

  public void insert()throws RowExistsException {
	  if (milog.isInfoEnabled()){
			milog.info("Voy a insertar: "+cliente.idCliente +" nombre: "+cliente.nombre+" apelidos: "+cliente.apellido1+" "+cliente.apellido2);
		}
      try {
		  conn = ConnectionManager.getConection();
		  Statement stmt = conn.createStatement();
		  ResultSet rs = null;

		  StringBuffer sqlString = new StringBuffer("INSERT INTO TCliente ");
		  sqlString.append("VALUES (" + MysqlUtils.toMysqlString(cliente.getIdCliente()) + ", ");
		  sqlString.append(MysqlUtils.toMysqlString(cliente.getDni()) + ", ");
		  sqlString.append(MysqlUtils.toMysqlString(cliente.getNombreCliente()) +
		                   ", ");
		  sqlString.append(MysqlUtils.toMysqlString(cliente.getApellido1()) + ", ");
		  sqlString.append(MysqlUtils.toMysqlString(cliente.getApellido2()) + ", ");
		  sqlString.append(MysqlUtils.toMysqlString(cliente.getFechNacimiento()) +
		                   ")");
		  if (milog.isInfoEnabled()){
	 			milog.info("comando sql: "+sqlString);
		  }
		  stmt.execute(sqlString.toString());
	} catch (Exception ex) {
		
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

  public void update()throws RowNotFoundException {

    try {
      conn = ConnectionManager.getConection();
      Statement stmt = conn.createStatement();
      ResultSet rs = null;

      StringBuffer sqlString = new StringBuffer("UPDATE TCliente ");
      sqlString.append("set idCliente=" +
                       MysqlUtils.toMysqlString(cliente.getIdCliente()) + ", ");
      sqlString.append("dni=" +
              MysqlUtils.toMysqlString(cliente.getDni()) +  ", ");
      sqlString.append("nombre=" +
                       MysqlUtils.toMysqlString(cliente.getNombreCliente()) +
                       ", ");
      sqlString.append("apellido1=" +
                       MysqlUtils.toMysqlString(cliente.getApellido1()) + ", ");
      sqlString.append("apellido2=" +
                       MysqlUtils.toMysqlString(cliente.getApellido2()) + ", ");
      sqlString.append("fechNacimiento=" +
                       MysqlUtils.toMysqlString(cliente.getFechNacimiento()));
      sqlString.append("WHERE idCliente=" +
                       MysqlUtils.toMysqlString(cliente.getIdCliente()));
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

  public void delete()throws RowNotFoundException {

    try {
      conn = ConnectionManager.getConection();
      Statement stmt = conn.createStatement();
      ResultSet rs = null;

      StringBuffer sqlString = new StringBuffer("DELETE FROM TCliente ");
      sqlString.append("WHERE idCliente=" +
                       MysqlUtils.toMysqlString(cliente.getIdCliente()));
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
  
  public  Vector  listarClientes() throws RowNotFoundException {
	    Vector listaClientes = new Vector();

	    try {
	      conn = ConnectionManager.getConection();
	      Statement stmt = conn.createStatement();
	      ResultSet rs = null;
	      
	      rs = stmt.executeQuery("select * from TCliente");
	     
	      while (rs.next()) {
	        ClienteBean cliente=new ClienteBean();
	        cliente.setIdCliente(rs.getString("idCliente"));
	        cliente.setIdCliente(rs.getString("dni"));
	        cliente.setNombre(rs.getString("nombre"));
	        cliente.setApellido1(rs.getString("apellido1"));
	        cliente.setApellido2(rs.getString("apellido2"));
	        cliente.setFechNacimiento(rs.getString("fechNacimiento"));
	        listaClientes.add(cliente);

	      }

	    }
	    catch (Exception ex) {
	      throw new RowNotFoundException();
	    }
	     finally{
	    	 if (conn != null) 
	    		 try{conn.close();}catch(SQLException e){}
	    } //Liberamos la conexion pase lo que pase
	    return listaClientes;
	  }

  public Vector BusquedaDetallada () {
	   Vector clientesEncontrados = new Vector();
	     try {
	       conn = ConnectionManager.getConection();
	       Statement stmt = conn.createStatement();
	       ResultSet rs = null;
	       Hashtable consulta = new Hashtable();

	      if (cliente.getIdCliente()!=null)
	       consulta.put("idCliente",cliente.getIdCliente());
	      
	      if (cliente.getDni()!=null)
		       consulta.put("dni",cliente.getDni());

	      if (cliente.getNombreCliente()!=null)
	        consulta.put("nombre",cliente.getNombreCliente());

	      if (cliente.getApellido1()!=null)
	        consulta.put("apellido1",cliente.getApellido1());

	      if (cliente.getApellido2()!=null)
	        consulta.put("apellido2",cliente.getApellido2());
	      
	      if (cliente.getFechNacimiento()!=null)
		        consulta.put("fechNacimiento",cliente.getFechNacimiento());

	      StringBuffer sqlString = new StringBuffer("SELECT * from TCliente WHERE ");
	      Iterator it=consulta.keySet().iterator();


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
	           ClienteBean clienteNuevo=new ClienteBean();
	           
	           clienteNuevo.setIdCliente(rs.getString("idCliente"));
	           clienteNuevo.setIdCliente(rs.getString("dni"));
	           clienteNuevo.setNombre(rs.getString("nombre"));
	           clienteNuevo.setApellido1(rs.getString("apellido1"));
	           clienteNuevo.setApellido2(rs.getString("apellido2"));
	           clienteNuevo.setFechNacimiento(rs.getString("fechNacimiento"));
	           clientesEncontrados.add(clienteNuevo);
	         }

	    
	     }
	     catch (Exception ex){

	     }
	     finally{
	    	 if (conn != null) 
	    		 try{conn.close();}catch(SQLException e){}
	    } //Liberamos la conexion pase lo que pase

	     return clientesEncontrados;
	     }
  
  public String [] getIdDirecciones(){
     Vector direcciones=new Vector();
     StringBuffer query=new StringBuffer();
     query.append("SELECT idGeneral FROM TDirCliente WHERE idGeneral=");
     query.append(MysqlUtils.toMysqlString(cliente.getIdCliente()));

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

  public InfoDirBean newInfoDirClientes(String descDir){
  InfoDirBean idb=new  InfoDirBean();
  idb.setIdGeneral(cliente.getIdCliente());
  idb.setDescDir(descDir);
  return idb;
  }
  public String [] getIdTelefonos(){
    Vector direcciones=new Vector();
    StringBuffer query=new StringBuffer();
    query.append("SELECT idGeneral FROM TTelfCliente WHERE idGeneral=");
    query.append(MysqlUtils.toMysqlString(cliente.getIdCliente()));

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

 public InfoTelfBean newInfoTelfClientes(String desctelf){
 InfoTelfBean idb=new  InfoTelfBean();
 idb.setIdGeneral(cliente.getIdCliente());
 idb.setDescTelefono(desctelf);
 return idb;
 }

 public String [] getIdMails(){
    Vector direcciones=new Vector();
    StringBuffer query=new StringBuffer();
    query.append("SELECT idGeneral FROM TMailCliente WHERE idGeneral=");
    query.append(MysqlUtils.toMysqlString(cliente.getIdCliente()));

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

 public InfoMailBean newInfoMailClientes(String descMail){
 InfoMailBean idb=new  InfoMailBean();
 idb.setIdGeneral(cliente.getIdCliente());
 idb.setDescMail(descMail);
 return idb;
 }
 public UsuarioLoginBean newInfoLoginClientes(String nombreUsuario){
	 UsuarioLoginBean login=new  UsuarioLoginBean();
	 login.setIdUsuario(cliente.getIdCliente());
	 //preguntar si se prefiere que se coja el dato del dni???
	 login.setNombreUsuario(nombreUsuario);
	 
	 return login;
	 }
 
 public void consultaLogin (String nombreUsuario)throws RowNotFoundException {
	   loginCliente=newInfoLoginClientes(nombreUsuario);
	   UsuarioLoginBD login = new UsuarioLoginBD(loginCliente);
	   login.select();

	 }
 
 public void consultaDir (String descDir)throws RowNotFoundException {
   dirCliente=newInfoDirClientes(descDir);//Bean de las direcciones
   InfoDirClientesBD direccion = new InfoDirClientesBD(dirCliente);
   direccion.select();

 }

 public void consultaTelf (String descTelf) throws RowNotFoundException {
  telfCliente=newInfoTelfClientes(descTelf);//Bean de las direcciones
  InfoTelfClientesBD telefono = new InfoTelfClientesBD(telfCliente);
  telefono.select();
 }

 public void consultaMail (String descMail) throws RowNotFoundException {
 mailCliente=newInfoMailClientes(descMail);//Bean de las direcciones
 InfoMailClientesBD mail = new InfoMailClientesBD(mailCliente);
 mail.select();
 }


 public void deleteLogin (String nombreUsuario) throws RowNotFoundException {
  loginCliente=newInfoLoginClientes(nombreUsuario);
  UsuarioLoginBD login = new UsuarioLoginBD(loginCliente);
  login.delete();
	 }
 
 public void deleteDir (String descDir) throws RowNotFoundException {
   String [] direcciones = getIdDirecciones();

   dirCliente=newInfoDirClientes(descDir);//Bean de las direcciones
   InfoDirClientesBD direccion = new InfoDirClientesBD(dirCliente);
   direccion.delete();
 }

 public void deleteTelf (String descTel) throws RowNotFoundException {
  String [] direcciones = getIdTelefonos();

  telfCliente=newInfoTelfClientes(descTel);//Bean de las direcciones
  InfoTelfClientesBD telefono = new InfoTelfClientesBD(telfCliente);
  telefono.delete();
 }

 public void deleteMail (String descMail) throws RowNotFoundException {
 String [] mails = getIdMails();
 mailCliente=newInfoMailClientes(descMail);//Bean de las direcciones
 InfoMailClientesBD mail = new InfoMailClientesBD (mailCliente);
 mail.delete();
 }

 public void insertaLogin (UsuarioLoginBean miLogin) throws RowExistsException {

	   UsuarioLoginBD login = new UsuarioLoginBD(miLogin);
	   loginCliente=miLogin;
	   login.insert();

	 }
 
 public void insertaDir (InfoDirBean miDireccion) throws RowExistsException {

   InfoDirClientesBD direccion = new InfoDirClientesBD(miDireccion);
   dirCliente=miDireccion;
   direccion.insert();

 }

 public void insertaTelf (InfoTelfBean miTelefono)throws RowExistsException{

  InfoTelfClientesBD telefono=new InfoTelfClientesBD (miTelefono);
  telfCliente=miTelefono;//Bean de las direcciones
  telefono.insert();

 }

 public void insertaMail (InfoMailBean miMail) throws RowExistsException{

 InfoMailClientesBD mail=new InfoMailClientesBD (miMail);
 mailCliente=miMail;
 mail.insert();
 }
 
 public void updateLogin (UsuarioLoginBean miLogin) throws RowNotFoundException {

	   UsuarioLoginBD login = new UsuarioLoginBD(miLogin);
	   loginCliente=miLogin;
	   login.update();

	 }

public void updateDir (InfoDirBean miDireccion) throws RowNotFoundException {

 InfoDirClientesBD direccion = new InfoDirClientesBD(miDireccion);
 dirCliente=miDireccion;
 direccion.update();

}

public void updateTelf (InfoTelfBean miTelefono)throws RowNotFoundException {

InfoTelfClientesBD telefono=new InfoTelfClientesBD (miTelefono);
telfCliente=miTelefono;//Bean de las direcciones
telefono.update();

}

public void updateMail (InfoMailBean miMail) throws RowNotFoundException {

InfoMailClientesBD mail=new InfoMailClientesBD (miMail);
mailCliente=miMail;
mail.update();
}

  /*public static void main(String[] args) {
    ClienteBean cliente=new ClienteBean();
    cliente.setIdCliente("C107");
    cliente.setNombre("Diana");
    cliente.setApellido1("Galvez");
    cliente.setApellido2("Yagüez");
    cliente.setFechNacimiento("2003-10-10");

    ClienteBD user = new ClienteBD(cliente);
    user.insert();

    System.out.println(cliente.getNombreCliente());


  }*/
}
