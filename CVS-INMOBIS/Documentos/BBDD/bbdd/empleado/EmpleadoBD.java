package com.inmobis.bbdd.empleado;

import java.util.*;

import org.apache.log4j.Logger;

import com.inmobis.bbdd.BDObject;
import com.inmobis.bbdd.ConnectionManager;
import com.inmobis.bbdd.MysqlUtils;
import com.inmobis.bbdd.RowExistsException;
import com.inmobis.bbdd.RowNotFoundException;
import com.inmobis.bbdd.direccion.InfoDirBean;
import com.inmobis.bbdd.direccion.InfoDirEmpleadosBD;
import com.inmobis.bbdd.email.InfoMailBean;
import com.inmobis.bbdd.email.InfoMailEmpleadosBD;
import com.inmobis.bbdd.telefono.InfoTelfBean;
import com.inmobis.bbdd.telefono.InfoTelfEmpleadosBD;

import java.sql.*;
import com.inmobis.bbdd.util.*;


public class EmpleadoBD implements BDObject,GestorEmpleadoBD {
  private EmpleadoBean empleado;
  private InfoDirBean dirEmpleado;
  private InfoDirEmpleadosBD direccion;
  private InfoTelfBean telfEmpleado;
  private InfoTelfEmpleadosBD telefono;
  private InfoMailBean mailEmpleado;
  private InfoMailEmpleadosBD mail;
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

  public void select()throws RowNotFoundException {

    try {
      Connection conn = ConnectionManager.getConection();
      Statement stmt = conn.createStatement();
      ResultSet rs = null;

      rs = stmt.executeQuery("SELECT * FROM TEmpleado WHERE idEmpleado=" +
                             MysqlUtils.toMysqlString(empleado.getIdEmpleado()));

      if (rs.next()) {

        empleado.setIdEmpleado(rs.getString("idEmpleado"));
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
      System.out.println(ex);
    }

  }

  public void insert() throws RowExistsException{
	if (milog.isInfoEnabled()){
		milog.info("Voy a insertar: "+empleado.idEmpleado +" nombre: "+empleado.nombre+" apelidos: "+empleado.apellido1+" "+empleado.apellido2);
	}
    try {
      Connection conn = ConnectionManager.getConection();
      Statement stmt = conn.createStatement();
      ResultSet rs = null;

      StringBuffer sqlString = new StringBuffer("INSERT INTO TEmpleados ");
      sqlString.append("VALUES (" + MysqlUtils.toMysqlString(empleado.getIdEmpleado()) + ", ");
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
  }

  public void update() throws RowNotFoundException{

    try {
      Connection conn = ConnectionManager.getConection();
      Statement stmt = conn.createStatement();
      ResultSet rs = null;

      StringBuffer sqlString = new StringBuffer("UPDATE TEmpleados ");
      sqlString.append("set idEmpleado=" +
                       MysqlUtils.toMysqlString(empleado.getIdEmpleado()) + ", ");
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

  }

  public void delete () throws RowNotFoundException{

    try {
      Connection conn = ConnectionManager.getConection();
      Statement stmt = conn.createStatement();
      ResultSet rs = null;

      StringBuffer sqlString = new StringBuffer("DELETE FROM TEmpleados ");
      sqlString.append("WHERE idCliente=" +
                      MysqlUtils.toMysqlString(empleado.getIdEmpleado()));
      stmt.execute(sqlString.toString());



    }
    catch (Exception ex) {
      throw new RowNotFoundException();
    }

  }

  public String [] getIdDirecciones(){
      Vector direcciones=new Vector();
      StringBuffer query=new StringBuffer();
      query.append("SELECT idGeneral FROM TDirEmpleado WHERE idGeneral=");
      query.append(MysqlUtils.toMysqlString(empleado.getIdEmpleado()));

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

  public InfoMailBean newInfoMailEmpleados(String descMail){
  InfoMailBean idb=new  InfoMailBean();
  idb.setIdGeneral(empleado.getIdEmpleado());
  idb.setDescMail(descMail);
  return idb;
  }
  public void consultaDir (String descDir) throws RowNotFoundException{
    dirEmpleado=newInfoDirEmpleados(descDir);
    InfoDirEmpleadosBD direccion = new InfoDirEmpleadosBD(dirEmpleado);
    direccion.select();

  }

  public void consultaTelf (String descTelf) throws RowNotFoundException {
   telfEmpleado=newInfoTelfEmpleados(descTelf);
   InfoTelfEmpleadosBD telefono = new InfoTelfEmpleadosBD(telfEmpleado);
   telefono.select();
  }

  public void consultaMail (String descMail) throws RowNotFoundException {
  mailEmpleado=newInfoMailEmpleados(descMail);
  InfoMailEmpleadosBD mail = new InfoMailEmpleadosBD(mailEmpleado);
  mail.select();
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

}
