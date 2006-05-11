package com.inmobis.bbdd.cliente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
import com.inmobis.bbdd.telefono.InfoTelfBean;
import com.inmobis.bbdd.telefono.InfoTelfClienteBD;
import com.inmobis.bbdd.telefono.InfoTelfClientesBD;
import com.inmobis.bbdd.util.ArrayOps;
import com.inmobis.bbdd.

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
  private InfoDirClientesBD direccion;
  private InfoTelfBean telfCliente;
  private InfoTelfClienteBD telefono;
  private InfoMailBean mailCliente;
  private InfoMailClientesBD mail;
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

  public void select() throws RowNotFoundException{

    try {
      Connection conn = ConnectionManager.getConection();
      Statement stmt = conn.createStatement();
      ResultSet rs = null;

      rs = stmt.executeQuery("SELECT * FROM TCliente WHERE idCliente=" +
                             MysqlUtils.toMysqlString(cliente.getIdCliente()));

      if (rs.next()) {
        cliente.setIdCliente(rs.getString("idCliente"));
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
      System.out.println(ex);
    }

  }

  public void insert()throws RowExistsException {
	  if (milog.isInfoEnabled()){
			milog.info("Voy a insertar: "+cliente.idCliente +" nombre: "+cliente.nombre+" apelidos: "+cliente.apellido1+" "+cliente.apellido2);
		}
      try {
		Connection conn = ConnectionManager.getConection();
		  Statement stmt = conn.createStatement();
		  ResultSet rs = null;

		  StringBuffer sqlString = new StringBuffer("INSERT INTO TCliente ");
		  sqlString.append("VALUES (" + MysqlUtils.toMysqlString(cliente.getIdCliente()) + ", ");
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
    
  }

  public void update()throws RowNotFoundException {

    try {
      Connection conn = ConnectionManager.getConection();
      Statement stmt = conn.createStatement();
      ResultSet rs = null;

      StringBuffer sqlString = new StringBuffer("UPDATE TCliente ");
      sqlString.append("set idCliente=" +
                       MysqlUtils.toMysqlString(cliente.getIdCliente()) + ", ");
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

  }

  public void delete()throws RowNotFoundException {

    try {
      Connection conn = ConnectionManager.getConection();
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

  }

  public String [] getIdDirecciones(){
     Vector direcciones=new Vector();
     StringBuffer query=new StringBuffer();
     query.append("SELECT idGeneral FROM TDirCliente WHERE idGeneral=");
     query.append(MysqlUtils.toMysqlString(cliente.getIdCliente()));

          try {
            Connection conn = ConnectionManager.getConection();
            Statement stmt = conn.createStatement();
            ResultSet rs=stmt.executeQuery(query.toString());
              while (rs.next()){
               direcciones.add(rs.getString("idGeneral"));
              }
            }
        catch (Exception e) {
         e.printStackTrace();
      }
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
           Connection conn = ConnectionManager.getConection();
           Statement stmt = conn.createStatement();
           ResultSet rs=stmt.executeQuery(query.toString());
             while (rs.next()){
              direcciones.add(rs.getString("idGeneral"));
             }
           }
       catch (Exception e) {
        e.printStackTrace();
     }
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
           Connection conn = ConnectionManager.getConection();
           Statement stmt = conn.createStatement();
           ResultSet rs=stmt.executeQuery(query.toString());
             while (rs.next()){
              direcciones.add(rs.getString("idGeneral"));
             }
           }
       catch (Exception e) {
        e.printStackTrace();
     }
    return ArrayOps.toStringArray(direcciones);
 }

 public InfoMailBean newInfoMailClientes(String descMail){
 InfoMailBean idb=new  InfoMailBean();
 idb.setIdGeneral(cliente.getIdCliente());
 idb.setDescMail(descMail);
 return idb;
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
