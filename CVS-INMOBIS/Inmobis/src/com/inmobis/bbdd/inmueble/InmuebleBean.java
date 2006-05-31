package com.inmobis.bbdd.inmueble;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

public class InmuebleBean {
    protected String idInmueble;
    protected String numHab;
    protected String metros;
    protected String regimen;
    protected String tipo;
    protected String zona;
    protected String precio;
    protected String datosDeInteres;
    protected String foto1;
    protected String foto2;

    public String getFoto1() {
		return foto1;
	}

	public void setFoto1(String foto1) {
		this.foto1 = foto1;
	}

	public String getFoto2() {
		return foto2;
	}

	public void setFoto2(String foto2) {
		this.foto2 = foto2;
	}
    
    public String getIdInmueble() {
    return idInmueble;
    }
    
    public String getNumHab(){
    	return numHab;
    }
    public String getMetros() {
    return metros;
    }
    public String getRegimen() {
    return regimen;
    }
    public String getTipo (){
    	return tipo;
    }
    
    public String getZona (){
    	return zona;
    }
    public String getPrecio() {
    return precio;
    }
    public String getdatosDeInteres() {
    return datosDeInteres;
    }
    public void setIdInmueble( String _idInmueble) {
      this.idInmueble=_idInmueble;
    }
    public void setNumHab (String _numHab){
    	this.numHab=_numHab;
    }
    public void setMetros( String _metros) {
      this.metros=_metros;
    }

    public void setRegimen ( String _regimen){
      this.regimen=_regimen;
          }
    public void setTipo( String _tipo) {
        this.tipo=_tipo;
      }
    public void setZona( String _zona) {
        this.zona=_zona;
      }
    public void setPrecio ( String _precio){
       this.precio=_precio;
    }

    public void setDatosDeInteres ( String _datosDeInteres){
      this.datosDeInteres=_datosDeInteres;
    }

  }
