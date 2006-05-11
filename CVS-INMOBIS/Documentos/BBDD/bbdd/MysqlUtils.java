package com.inmobis.bbdd;

public class MysqlUtils {
public static String toMysqlString (String str){

  if (str==null){
    return "null";
  }
  else return "'"+str+"'";
}

}
