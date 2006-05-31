package com.inmobis.bbdd.mensajes;

import java.util.Vector;

import com.inmobis.bbdd.BDObject;


public interface GestorMensajesBD extends BDObject {
	Vector BusquedaDetallada ();
	Vector GetDestinosMensaje ();
}
