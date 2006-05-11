package com.inmobis.bbdd.util;

import org.xml.sax.*;
import java.util.*;





public class ElementoXML {
	/**
	 *  Description of the Field
	 */
	private String nombre;
	/**
	 *  Description of the Field
	 */
	private String valor = null;
	/**
	 *  Description of the Field
	 */
	private Map atributos;
	/**
	 *  Vector de subelementos de un elemento XML
	 */
	protected Vector sub = new Vector();
	//arrray vacio


	/**
	 *  Constructor for the ElementoXML object
	 *
	 */
	public ElementoXML(String nombre, Attributes atr) {
		this.nombre = nombre;
		atributos = new Hashtable();
		for (int i = 0; i < atr.getLength(); i++) {
			atributos.put(atr.getQName(i), atr.getValue(i));
		}
	}


	/**
	 *  Constructor for the ElementoXML object
	 *
	 */
	public ElementoXML(String nombre, Map atr) {
		this.nombre = nombre;
		atributos = atr;
	}


	/**
	 *  Constructor for the ElementoXML object
	 *
	 *@param  nombre  Description of Parameter
	 */
	public ElementoXML(String nombre) {
		this.nombre = nombre;
		atributos = new Hashtable();

	}


	/**
	 *  Gets the Empty attribute of the ElementoXML object
	 *
	 *@return    The Empty value
	 */
	public boolean isEmpty() {
		return ((valor == null || valor.compareTo("") == 0) && sub.isEmpty());
	}


	/**
	 *  Description of the Method
	 *
	 *@param  valor  Description of Parameter
	 */
	public void ponValor(String valor) {
		this.valor = valor;
	}


	/**
	 *  Description of the Method
	 *
	 *@return    Description of the Returned Value
	 */
	public String dameNombre() {
		return nombre;
	}


	/**
	 *  Description of the Method
	 *
	 *@return    Description of the Returned Value
	 */
	public String dameValor() {
		return valor;
	}


	/**
	 *  Description of the Method
	 *
	 *@return    Description of the Returned Value
	 */
	public Map dameAtributos() {
		return atributos;
	}



	/**
	 * genera XML recursivamente
	 *
	 *@return    Description of the Returned Value
	 */
	public String toXMLString() {
		StringBuffer sb = new StringBuffer();
		if (this.isEmpty()) {
			return printEmpty();
		}
		sb.append("<" + nombre);
		Object[] keys = atributos.keySet().toArray();
		for (int j = 0; j < keys.length; j++) {
			String clavej = (String) keys[j];
			sb.append(" " + clavej + "=" + "\"" + (String) atributos.get(clavej) + "\"");
		}
		sb.append(">");
		//array vacio
		if (valor != null) {
			sb.append(valor);
		}
		else {
			sb.append("\n");
		}
		for (int i = 0; i < sub.size(); i++) {
			sb.append(((ElementoXML) sub.elementAt(i)).toXMLString());
		}

		sb.append("</" + nombre + ">\n");
		return sb.toString();
	}


	/**
	 *  Description of the Method
	 *
	 *@return    Description of the Returned Value
	 */
	public Vector dameSubelementos() {
		return sub;
	}


	/**
	 *  Description of the Method
	 *
	 *@return    Description of the Returned Value
	 */
	private String printEmpty() {
		StringBuffer sb = new StringBuffer();
		sb.append("<" + nombre);
		Object[] keys = atributos.keySet().toArray();
		for (int j = 0; j < keys.length; j++) {
			String clavej = (String) keys[j];
			sb.append(" " + clavej + "=" + "\"" + (String) atributos.get(clavej) + "\"");
		}
		sb.append("/>\n");
		return sb.toString();
	}

}
