package com.inmobis.bbdd;



public class MysqlUtils {
	public static String toMysqlString (String str){

		  if (str==null){
		    return "null";
		  }
		  else return "'"+str+"'";
		}

		public static String toMysqlInt (String sint){

		  if (sint==null){
		    return "null";
		  }
		  else return ""+sint+"";
		}

		public static String toMysqlInt (Integer n){

		  if (n==null){
		    return "null";
		  }
		  else return ""+n.intValue()+"";
		}



		public static String toMysqlInt (int n){

		  if (n==-1){
		    return "null";
		  }
		  else return ""+n+"";
		}




}
