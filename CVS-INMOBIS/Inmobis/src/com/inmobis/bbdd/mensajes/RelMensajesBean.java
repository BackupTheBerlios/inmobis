package com.inmobis.bbdd.mensajes;

public class RelMensajesBean {
	protected String idMensaje;
	protected String origen;
	protected String destino;
	protected Character leido;  //vale s/n
	protected String fecha;
	
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public String getIdMensaje() {
		return idMensaje;
	}
	public void setIdMensaje(String idMensaje) {
		this.idMensaje = idMensaje;
	}
	public Character getLeido() {//con tipo char habia algun problema de conversiones
		return leido;
	}
	public void setLeido(Character leido) {
		this.leido = leido;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getFecha(){
		return fecha;
	}
	public void setFecha(String fecha){
		this.fecha = fecha;
	}
	

}
