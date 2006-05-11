package com.inmobis.bbdd;

import java.sql.*;
/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class GeneradorDeCodigos {
int cntEmpleados;
int cntClientes;
private static GeneradorDeCodigos gc;
private GeneradorDeCodigos (){
  leeContadorBD();
  leeContadorClientesBD();
}

public static GeneradorDeCodigos getGeneradorDeCodigos(){
  if (gc==null){
    gc=new GeneradorDeCodigos();
  }
 return gc;
}


private void actualizaContadorBD (){
  try{
     Connection conn = ConnectionManager.getConection();
     Statement stmt = conn.createStatement();
     ResultSet rs = null;
     String codigo=null;
     stmt.execute("update TCodigos set cntEmpleados="+cntEmpleados);

    }
      catch (Exception ex) {
      System.out.println(ex);
    }

}
private void actualizaContadorClienteBD (){
  try{
     Connection conn = ConnectionManager.getConection();
     Statement stmt = conn.createStatement();
     ResultSet rs = null;
     String codigo=null;
     stmt.execute("update TCodigos set cntClientes="+cntClientes);

    }
      catch (Exception ex) {
      System.out.println(ex);
    }

}



private void leeContadorBD (){
 cntEmpleados=0;
   try{
     Connection conn = ConnectionManager.getConection();
     Statement stmt = conn.createStatement();
     ResultSet rs = null;
     String codigo=null;
     rs = stmt.executeQuery("select cntEmpleados from TCodigos");
   if (rs.next()){
     String idEmpleado=rs.getString(1);
      cntEmpleados=new Integer(idEmpleado).intValue();
   }
    }
      catch (Exception ex) {
      System.out.println(ex);
    }

}
private void leeContadorClientesBD (){
 cntClientes=0;
   try{
     Connection conn = ConnectionManager.getConection();
     Statement stmt = conn.createStatement();
     ResultSet rs = null;
     String codigo=null;
     rs = stmt.executeQuery("select cntClientes from TCodigos");
   if (rs.next()){
     String idCliente=rs.getString(1);
      cntClientes=new Integer(idCliente).intValue();
   }
    }
      catch (Exception ex) {
      System.out.println(ex);
    }

}
  public synchronized String asignaCodigoEmpleado () {
    String nuevoCodigo="E"+cntEmpleados;
    cntEmpleados++;
    actualizaContadorBD();
    return nuevoCodigo;
  }
  public synchronized String asignaCodigoCliente() {
    String nuevoCodigo="C"+cntClientes;
    cntClientes++;
    actualizaContadorClienteBD();
    return nuevoCodigo;
  }

}
