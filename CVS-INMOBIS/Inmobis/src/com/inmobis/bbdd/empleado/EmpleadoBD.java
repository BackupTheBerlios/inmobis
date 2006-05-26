package com.inmobis.bbdd.empleado;

import java.util.*;

import org.apache.log4j.Logger;

import com.inmobis.bbdd.BDObject;
import com.inmobis.bbdd.ConnectionManager;
import com.inmobis.bbdd.MysqlUtils;
import com.inmobis.bbdd.RowExistsException;
import com.inmobis.bbdd.RowNotFoundException;
import com.inmobis.bbdd.direccion.InfoDirBean;
import com.inmobis.bbdd.direccion.InfoDirClientesBD;
import com.inmobis.bbdd.direccion.InfoDirEmpleadosBD;
import com.inmobis.bbdd.email.InfoMailBean;
import com.inmobis.bbdd.email.InfoMailClientesBD;
import com.inmobis.bbdd.email.InfoMailEmpleadosBD;
import com.inmobis.bbdd.inmueble.InmuebleBean;
import com.inmobis.bbdd.login.UsuarioLoginBD;
import com.inmobis.bbdd.login.UsuarioLoginBean;
import com.inmobis.bbdd.telefono.InfoTelfBean;
import com.inmobis.bbdd.telefono.InfoTelfClientesBD;
import com.inmobis.bbdd.telefono.InfoTelfEmpleadosBD;

import java.sql.*;

import com.inmobis.bbdd.util.*;


public class EmpleadoBD implements BDObject,GestorEmpleadoBD {
  private EmpleadoBean empleado;
  private InfoDirBean dirEmpleado;
  private UsuarioLoginBean loginEmpleado;
  private InfoDirEmpleadosBD direccion;
  private InfoTelfBean telfEmpleado;
  private InfoTelfEmpleadosBD telefono;
  private InfoMailBean mailEmpleado;
  private InfoMailEmpleadosBD mail;
  private Connection conn;
  private static final Logger milog = Logger.getLogger(EmpleadoBD.class);

  public EmpleadoBD(EmpleadoBean _empleado) {
    empleado = _empleado;
  }

  public Object getBean() {
    return empleado;
  }

  public InfoDirBean getDireccionBean (){

      return dirEmpleado;
    }

    public InfoTelfBean getTelefonoBean (){

     return telfEmpleado;
    }

    public InfoMailBean getMailBean (){

     return mailEmpleado;
    }
    
    public UsuarioLoginBean getLoginBean (){

        return loginEmpleado;
       }

  public void select()throws RowNotFoundException {

    try {
      conn = ConnectionManager.getConection();
      Statement stmt = conn.createStatement();
      ResultSet rs = null;

      rs = stmt.executeQuery("SELECT * FROM TEmpleados WHERE idEmpleado=" +
                             MysqlUtils.toMysqlString(empleado.getIdEmpleado()));

      if (rs.next()) {  //situarse en la siguiene fila

        empleado.setIdEmpleado(rs.getString("idEmpleado"));
        empleado.setIdEmpleado(rs.getString("dni"));
        empleado.setNombre(rs.getString("nombre"));
        empleado.setApellido1(rs.getString("apellido1"));
        empleado.setApellido2(rs.getString("apellido2"));
        empleado.setFechNacimiento(rs.getString("fechNacimiento"));

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

  public void insert() throws RowExistsException{
	if (milog.isInfoEnabled()){
		milog.info("Voy a insertar: "+empleado.idEmpleado +" nombre: "+empleado.nombre+" apelidos: "+empleado.apellido1+" "+empleado.apellido2);
	}
    try {
      conn = ConnectionManager.getConection();
      Statement stmt = conn.createStatement();
      ResultSet rs = null;

      StringBuffer sqlString = new StringBuffer("INSERT INTO TEmpleados ");
      sqlString.append("VALUES (" + MysqlUtils.toMysqlString(empleado.getIdEmpleado()) + ", ");
      sqlString.append(MysqlUtils.toMysqlString(empleado.getDni()) +  ", ");
      sqlString.append(MysqlUtils.toMysqlString(empleado.getNombreEmpleado()) +
                       ", ");
      sqlString.append(MysqlUtils.toMysqlString(empleado.getApellido1()) + ", ");
      sqlString.append(MysqlUtils.toMysqlString(empleado.getApellido2()) + ", ");
      sqlString.append(MysqlUtils.toMysqlString(empleado.getFechNacimiento()) +
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

  public void update() throws RowNotFoundException{

    try {
      conn = ConnectionManager.getConection();
      Statement stmt = conn.createStatement();
      ResultSet rs = null;

      StringBuffer sqlString = new StringBuffer("UPDATE TEmpleados ");
      sqlString.append("set idEmpleado=" +
                       MysqlUtils.toMysqlString(empleado.getIdEmpleado()) + ", ");
      sqlString.append("dni=" +
              MysqlUtils.toMysqlString(empleado.getDni()) +  ", ");
      sqlString.append("nombre=" +
                       MysqlUtils.toMysqlString(empleado.getNombreEmpleado()) +
                       ", ");
      sqlString.append("apellido1=" +
                       MysqlUtils.toMysqlString(empleado.getApellido1()) + ", ");
      sqlString.append("apellido2=" +
                       MysqlUtils.toMysqlString(empleado.getApellido2()) + ", ");
      sqlString.append("fechNacimiento=" +
                       MysqlUtils.toMysqlString(empleado.getFechNacimiento()));
      sqlString.append("WHERE idEmpleado=" +
                       MysqlUtils.toMysqlString(empleado.getIdEmpleado()));
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

  public void delete () throws RowNotFoundException{

    try {
      conn = ConnectionManager.getConection();
      Statement stmt = conn.createStatement();
      ResultSet rs = null;

      StringBuffer sqlString = new StringBuffer("DELETE FROM TEmpleados ");
      sqlString.append("WHERE idEmpleado=" +
                      MysqlUtils.toMysqlString(empleado.getIdEmpleado()));
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
  
  public  Vector listarEmpleados() throws RowNotFoundException {
	    Vector listaEmpleados = new Vector();

	    try {
	      conn = ConnectionManager.getConection();
	      Statement stmt = conn.createStatement();
	      ResultSet rs = null;
	      rs = stmt.executeQuery("select * from TEmpleados");
	     
	      while (rs.next()) {
	        EmpleadoBean empleado=new EmpleadoBean();
	        empleado.setIdEmpleado(rs.getString("idEmpleado"));
	        empleado.setIdEmpleado(rs.getString("dni"));
	        empleado.setNombre(rs.getString("nombre"));
	        empleado.setApellido1(rs.getString("apellido1"));
	        empleado.setApellido2(rs.getString("apellido2"));
	        empleado.setFechNacimiento(rs.getString("fechNacimiento"));
	        listaEmpleados.add(empleado);

	      }

	    }
	    catch (Exception ex) {
	      throw new RowNotFoundException();
	    }
	     finally{
	    	 if (conn != null) 
	    		 try{conn.close();}catch(SQLException e){}
	    } //Liberamos la conexion pase lo que pase
	    return listaEmpleados;

	  }
  
  public Vector BusquedaDetallada () {
	   Vector empleadosEncontrados = new Vector();
	     try {
	       conn = ConnectionManager.getConection();
	       Statement stmt = conn.createStatement();
	       ResultSet rs = null;
	       Hashtable consulta = new Hashtable();

	      if (empleado.getIdEmpleado()!=null)
	       consulta.put("idEmpleado",empleado.getIdEmpleado());
	      
	      if (empleado.getDni()!=null)
		       consulta.put("dni",empleado.getDni());

	      if (empleado.getNombreEmpleado()!=null)
	        consulta.put("nombre",empleado.getNombreEmpleado());

	      if (empleado.getApellido1()!=null)
	        consulta.put("apellido1",empleado.getApellido1());

	      if (empleado.getApellido2()!=null)
	        consulta.put("apellido2",empleado.getApellido2());
	      
	      if (empleado.getFechNacimiento()!=null)
		        consulta.put("fechNacimiento",empleado.getFechNacimiento());

	      StringBuffer sqlString = new StringBuffer("SELECT * from TEmpleados WHERE ");
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
	           EmpleadoBean empleadoNuevo=new EmpleadoBean();
	           
	           empleadoNuevo.setIdEmpleado(rs.getString("idEmpleado"));
	           empleadoNuevo.setNombre(rs.getString("dni"));
	           empleadoNuevo.setNombre(rs.getString("nombre"));
	           empleadoNuevo.setApellido1(rs.getString("apellido1"));
	           empleadoNuevo.setApellido2(rs.getString("apellido2"));
	           empleadoNuevo.setFechNacimiento(rs.getString("fechNacimiento"));
	           empleadosEncontrados.add(empleadoNuevo);
	         }

	     System.out.println(sqlString);
	     }
	     catch (Exception ex){

	     }
	     finally{
	    	 if (conn != null) 
	    		 try{conn.close();}catch(SQLException e){}
	    } //Liberamos la conexion pase lo que pase
	     return empleadosEncontrados;
	     }


  public  int getNumAdmin() throws RowNotFoundException {
	    int num=0;
	    try {
	      conn = ConnectionManager.getConection();
	      Statement stmt = conn.createStatement();
	      ResultSet rs = null;
	    
	      rs=stmt.executeQuery("SELECT COUNT(*) FROM TLogin WHERE tipoUsuario= " +
	                             MysqlUtils.toMysqlString("administrador")+" GROUP BY tipoUsuario");

	      if (rs.next()) {
	        num=rs.getInt(1);
	      }
	      else {
	        throw new RowNotFoundException();
	      }
	    }
	    catch (Exception ex) {

	    }
	     finally{
	    	 if (conn != null) 
	    		 try{conn.close();}catch(SQLException e){}
	    } //Liberamos la conexion pase lo que pase
	    return num;
	  }
  
  public String [] getIdDirecciones(){
      Vector direcciones=new Vector();
      StringBuffer query=new StringBuffer();
      query.append("SELECT idGeneral FROM TDirEmpleado WHERE idGeneral=");
      query.append(MysqlUtils.toMysqlString(empleado.getIdEmpleado()));

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

   public InfoDirBean newInfoDirEmpleados(String descDir){
   InfoDirBean idb=new  InfoDirBean();
   idb.setIdGeneral(empleado.getIdEmpleado());
   idb.setDescDir(descDir);
   return idb;
   }
   public String [] getIdTelefonos(){
     Vector direcciones=new Vector();
     StringBuffer query=new StringBuffer();
     query.append("SELECT idGeneral FROM TTelfEmpleado WHERE idGeneral=");
     query.append(MysqlUtils.toMysqlString(empleado.getIdEmpleado()));

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

   public UsuarioLoginBean newInfoLoginEmpleados(String nombreUsuario){
		 UsuarioLoginBean login=new  UsuarioLoginBean();
		 login.setIdUsuario(empleado.getIdEmpleado());
		 //preguntar si se prefiere que se coja el dato del dni???
		 login.setNombreUsuario(nombreUsuario);
		 
		 return login;
		 }
   
   
   public void consultaLogin (String nombreUsuario)throws RowNotFoundException {
	   loginEmpleado=newInfoLoginEmpleados(nombreUsuario);
	   UsuarioLoginBD login = new UsuarioLoginBD(loginEmpleado);
	   login.select();

	 }
   
  public InfoTelfBean newInfoTelfEmpleados(String desctelf){
  InfoTelfBean idb=new  InfoTelfBean();
  idb.setIdGeneral(empleado.getIdEmpleado());
  idb.setDescTelefono(desctelf);
  return idb;
  }

  public String [] getIdMails(){
     Vector direcciones=new Vector();
     StringBuffer query=new StringBuffer();
     query.append("SELECT idGeneral FROM TMailEmpleado WHERE idGeneral=");
     query.append(MysqlUtils.toMysqlString(empleado.getIdEmpleado()));

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

  public InfoMailBean newInfoMailEmpleados(String descMail){
  InfoMailBean idb=new  InfoMailBean();
  idb.setIdGeneral(empleado.getIdEmpleado());
  idb.setDescMail(descMail);
  return idb;
  }
  public void consultaLoginPorNombreUsuario (String nombreUsuario)throws RowNotFoundException {
	  this.loginEmpleado=newInfoLoginEmpleados(nombreUsuario);
	  UsuarioLoginBD login = new UsuarioLoginBD(this.loginEmpleado);
	  login.select();

	 }

	  
	  public void consultaLoginPorId (String idUsuario)throws RowNotFoundException {
	 	   this.loginEmpleado=new UsuarioLoginBean();
	 	   this.loginEmpleado.setIdUsuario(idUsuario);
	 	   UsuarioLoginBD login = new UsuarioLoginBD(this.loginEmpleado);
	 	   login.selectAll();

	 	 }
	  
	  public void consultaDirPorId (String idGeneral)throws RowNotFoundException {
	    this.dirEmpleado=new InfoDirBean();//Bean de las direcciones
	    this.dirEmpleado.setIdGeneral(idGeneral);
	    InfoDirEmpleadosBD direccion = new InfoDirEmpleadosBD(this.dirEmpleado);
	    direccion.selectAll();

	  }

	  public void consultaTelfPorId (String idGeneral) throws RowNotFoundException {
	   this.telfEmpleado=new InfoTelfBean();//Bean de las direcciones
	   this.telfEmpleado.setIdGeneral(idGeneral);
	   InfoTelfEmpleadosBD telefono = new InfoTelfEmpleadosBD(this.telfEmpleado);
	   telefono.selectAll();
	  }

	  public void consultaMailPorId (String idGeneral) throws RowNotFoundException {
	  this.mailEmpleado=new InfoMailBean();//Bean de las direcciones
	  this.mailEmpleado.setIdGeneral(idGeneral);
	  InfoMailEmpleadosBD mail = new InfoMailEmpleadosBD(this.mailEmpleado);
	  mail.selectAll();
	  }
//  public void consultaDir (String descDir) throws RowNotFoundException{
//    dirEmpleado=newInfoDirEmpleados(descDir);
//    InfoDirEmpleadosBD direccion = new InfoDirEmpleadosBD(dirEmpleado);
//    direccion.select();
//
//  }
//
//  public void consultaTelf (String descTelf) throws RowNotFoundException {
//   telfEmpleado=newInfoTelfEmpleados(descTelf);
//   InfoTelfEmpleadosBD telefono = new InfoTelfEmpleadosBD(telfEmpleado);
//   telefono.select();
//  }
//
//  public void consultaMail (String descMail) throws RowNotFoundException {
//  mailEmpleado=newInfoMailEmpleados(descMail);
//  InfoMailEmpleadosBD mail = new InfoMailEmpleadosBD(mailEmpleado);
//  mail.select();
//  }

  public void deleteLogin (String nombreUsuario) throws RowNotFoundException {
	  loginEmpleado=newInfoLoginEmpleados(nombreUsuario);
	  UsuarioLoginBD login = new UsuarioLoginBD(loginEmpleado);
	  login.delete();
		 }
  
  public void deleteDir (String descDir) throws RowNotFoundException {
    String [] direcciones = getIdDirecciones();

    dirEmpleado=newInfoDirEmpleados(descDir);
    InfoDirEmpleadosBD direccion = new InfoDirEmpleadosBD(dirEmpleado);
    direccion.delete();
  }

  public void deleteTelf (String descTel) throws RowNotFoundException {
   String [] direcciones = getIdTelefonos();

   telfEmpleado=newInfoTelfEmpleados(descTel);
   InfoTelfEmpleadosBD telefono = new InfoTelfEmpleadosBD(telfEmpleado);
   telefono.delete();
  }

  public void deleteMail (String descMail) throws RowNotFoundException {
  String [] mails = getIdMails();
  mailEmpleado=newInfoMailEmpleados(descMail);
  InfoMailEmpleadosBD mail = new InfoMailEmpleadosBD (mailEmpleado);
  mail.delete();
  }

  public void insertaLogin (UsuarioLoginBean miLogin) throws RowExistsException {

	   UsuarioLoginBD login = new UsuarioLoginBD(miLogin);
	   loginEmpleado=miLogin;
	   login.insert();

	 }
  
  public void insertaDir (InfoDirBean miDireccion) throws RowExistsException {

    InfoDirEmpleadosBD direccion = new InfoDirEmpleadosBD(miDireccion);
    dirEmpleado=miDireccion;
    direccion.insert();

  }

  public void insertaTelf (InfoTelfBean miTelefono) throws RowExistsException {

   InfoTelfEmpleadosBD telefono=new InfoTelfEmpleadosBD (miTelefono);
   telfEmpleado=miTelefono;
   telefono.insert();

  }

  public void insertaMail (InfoMailBean miMail) throws RowExistsException {

  InfoMailEmpleadosBD mail=new InfoMailEmpleadosBD (miMail);
  mailEmpleado=miMail;
  mail.insert();
  }
  
  
  public void updateLogin (UsuarioLoginBean miLogin) throws RowNotFoundException {

	   UsuarioLoginBD login = new UsuarioLoginBD(miLogin);
	   loginEmpleado=miLogin;
	   login.update();

	 }
 
 public void updateDir (InfoDirBean miDireccion) throws RowNotFoundException {

   InfoDirEmpleadosBD direccion = new InfoDirEmpleadosBD(miDireccion);
   dirEmpleado=miDireccion;
   direccion.update();

 }

 public void updateTelf (InfoTelfBean miTelefono) throws RowNotFoundException {

  InfoTelfEmpleadosBD telefono=new InfoTelfEmpleadosBD (miTelefono);
  telfEmpleado=miTelefono;
  telefono.update();

 }

 public void updateMail (InfoMailBean miMail) throws RowNotFoundException {

 InfoMailEmpleadosBD mail=new InfoMailEmpleadosBD (miMail);
 mailEmpleado=miMail;
 mail.update();
 }

  public static void main(String[] args) {
   /* EmpleadoBD user = new EmpleadoBD();
    EmpleadoBean emp;
    // user.eliminaEmpleado("G543");
    emp = user.dameUsuario("Cristina");
    emp.setApellido1("Rivero");
    user.modificaUsuario(emp);
    System.out.println(emp.getIdEmpleado());
    System.out.println(emp.getNombreEmpleado());
    System.out.println(emp.getApellido1());
    System.out.println(emp.getApellido2());*/
  }

public Vector listarInmueblesAgentes() throws RowNotFoundException {
	// TODO Auto-generated method stub
	return null;
}

}
