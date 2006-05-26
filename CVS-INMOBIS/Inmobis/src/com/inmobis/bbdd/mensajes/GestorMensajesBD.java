package com.inmobis.bbdd.mensajes;

import java.util.Vector;

import com.inmobis.bbdd.BDObject;
import com.inmobis.bbdd.RowExistsException;
import com.inmobis.bbdd.RowNotFoundException;


public interface GestorMensajesBD extends BDObject {
	Vector BusquedaDetallada ();
}
