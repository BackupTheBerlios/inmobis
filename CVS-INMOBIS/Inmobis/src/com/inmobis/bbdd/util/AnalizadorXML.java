package com.inmobis.bbdd.util;

import java.io.*;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import java.util.*;



public class AnalizadorXML extends DefaultHandler {
	private Stack pila;
	private String texto;
	private ElementoXML raiz, actual;


	/**
	 *  Constructor for the AnalizadorXML object
	 */
	public AnalizadorXML() {

	}


	/**
	 *  Metodo que genera un Elemento XML a partir de un fichero xml
	 *
	 *@param  archivo  Ruta del fichero xml
	 *@return          ElementoXML resultado del parseo del fichero xml
	 */
	public ElementoXML generaArbolXML(String archivo) {
		//inicialización de la pila
		actual = null;
		pila = new Stack();
		texto = null;
		raiz = new ElementoXML("documentoXML", new Hashtable());
		raiz.sub = new Vector();
		pila.push(raiz);
		DefaultHandler handler = this;
		SAXParserFactory fact = SAXParserFactory.newInstance();
		try {
			SAXParser parser = fact.newSAXParser();
			parser.parse(new File(archivo).getAbsolutePath(), handler);
		}
		catch (Throwable t) {
			t.printStackTrace();
		}
		return ((ElementoXML) raiz.sub.firstElement());
	}


	/**
	 *  Implementación del método abstracto de DefaultHandler
	 *
	 */
	public void startElement(String uri, String nombre, String cualificado, Attributes atr) throws SAXException {
		ElementoXML padre = (ElementoXML) pila.peek();
		ElementoXML hijo = new ElementoXML(cualificado, atr);
		//vacío
		actual = hijo;
		texto = new String();
		//
		padre.sub.add(hijo);
		//apilamos el hijo
		pila.push(hijo);
	}


        /**
         *  Implementación del método abstracto de DefaultHandler
         *
         */

	public void endElement(String uri, String nombre, String cualificado) throws
			SAXException {
		pila.pop();
		if (actual != null && texto != null) {
			actual.ponValor(texto.trim());
		}
		actual = null;
	}



        /**
         *  Implementación del método abstracto de DefaultHandler
         * Hace referencia a la secuencia de caracteres del contenido (#PCDATA) de un elemento
         *
         */

	public void characters(char[] buf, int ini, int lon) throws SAXException {
		if (actual != null && texto != null) {
			String valor = new String(buf, ini, lon);
			texto += valor;
		}
	}

}
