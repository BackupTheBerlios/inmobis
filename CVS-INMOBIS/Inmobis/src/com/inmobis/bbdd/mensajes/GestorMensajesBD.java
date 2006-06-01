package com.inmobis.bbdd.mensajes;

import java.util.Vector;

import com.inmobis.bbdd.BDObject;


public interface GestorMensajesBD extends BDObject {
	Vector BusquedaDetallada(); //Un cliente pincha en verMensajes
	Vector BusquedaDetalladaAgente(); //Un agente pincha en verMensajes
	Vector GetDestinosMensajeCliente();
	Vector GetDestinosMensajeAgente();
}
