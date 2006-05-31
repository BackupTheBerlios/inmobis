package com.inmobis.bbdd.empleado;

import java.util.*;

import com.inmobis.bbdd.BDObject;
import com.inmobis.bbdd.RowExistsException;
import com.inmobis.bbdd.RowNotFoundException;
import com.inmobis.bbdd.inmueble.VentasBean;


public interface GestorAgenteBD extends BDObject{

	public String agregarCliente (String idCliente) throws RowExistsException;
	public  void asociarCliente (String idCliente,String idAgente) throws RowExistsException;
	public  Vector listarAgentes() throws RowNotFoundException;
	public  Vector listarClientesAsociados() throws RowNotFoundException ;
	public  Vector listarInmueblesAgentes() throws RowNotFoundException ;
	public void insertarVenta(VentasBean venta) throws RowExistsException;
}
