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
    protected String metros;
    protected String regimen;
    protected String precio;
    protected String datosDeInteres;

    public String getIdInmueble() {
    return idInmueble;
    }
    public String getMetros() {
    return metros;
    }
    public String getRegimen() {
    return regimen;
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
    public void setMetros( String _metros) {
      this.metros=_metros;
    }

    public void setRegimen ( String _regimen){
      this.regimen=_regimen;
    }
    public void setPrecio ( String _precio){
       this.precio=_precio;
    }

    public void setDatosDeInteres ( String _datosDeInteres){
      this.datosDeInteres=_datosDeInteres;
    }

  }
