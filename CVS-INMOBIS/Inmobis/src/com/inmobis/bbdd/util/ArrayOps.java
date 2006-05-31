package com.inmobis.bbdd.util;

import java.util.*;

import org.apache.log4j.Logger;

import com.inmobis.bbdd.empleado.ContableBD;


public class ArrayOps {
	private static final Logger milog = Logger.getLogger(ArrayOps.class);
	/**
	 *  Método que convierte un array de caracteres a Vector de Character
	 *
	 *@param  array  char[] array
	 *@return        Vector de Character
	 */
	public static Vector toVector(char[] array) {
		Vector resultado = new Vector();
		for (int i = 0; i < array.length; i++) {
			resultado.add(new Character(array[i]));
		}
		return resultado;
	}

        /**
         *  Método que convierte un array de Object a Vector de Object
         *
         *@param  array  Object[] array
         *@return        Vector de Object
          */
	public static Vector toVector(Object[] array) {
		Vector resultado = new Vector();
		for (int i = 0; i < array.length; i++) {
			resultado.add(array[i]);
		}
		return resultado;
	}


	/**
	 *  Método que imprime un vector
	 *
	 *@param  v  Vector
	 */
	public static void print(Vector v) {
		for (int i = 0; i < v.size(); i++) {
	    	  if (milog.isInfoEnabled()){
	    			milog.info(v.elementAt(i).toString());
	    		}
		}
	}


	/**
	 *   Método que imprime un array de String
	 *
	 *@param  v  Description of Parameter
	 */
	public static void print(String v[]) {
		for (int i = 0; i < v.length; i++) {
			if (milog.isInfoEnabled()){
    			milog.info(v[i]);
    		}
		}
	}


	/**
	 *  Método que convierte una Collection a array de String
	 *
	 *@param  c  Collection, ha de tener objetos con el método toString()
         *          correctamente definido
	 *@return    String[]
	 */
	public static String[] toStringArray(Collection c) {
		String array[] = new String[c.size()];
		int i = 0;
		Iterator it = c.iterator();
		while (it.hasNext()) {
			array[i] = it.next().toString();
			i++;
		}
		return array;
	}


        /**
         *  Método que convierte un Iterator a array de String
         *
         *@param  c  Iterator, ha de tener objetos con el método toString()
         *          correctamente definido
         *@return    String[]
         */

	public static String[] toStringArray(Iterator it) {
		Vector v = new Vector();
		while (it.hasNext()) {
			v.add(it.next().toString());
		}
		return toStringArray(v);
	}


}
