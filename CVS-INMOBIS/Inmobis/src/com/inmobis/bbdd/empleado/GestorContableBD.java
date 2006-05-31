package com.inmobis.bbdd.empleado;

import java.util.Vector;
import com.inmobis.bbdd.inmueble.VentasBean;

import com.inmobis.bbdd.RowNotFoundException;

public interface GestorContableBD {
	public Vector listadoVentas()throws RowNotFoundException;
	public Vector BusquedaDetallada(VentasBean venta);
}
