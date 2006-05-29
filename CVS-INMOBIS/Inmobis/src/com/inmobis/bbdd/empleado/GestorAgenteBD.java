package com.inmobis.bbdd.empleado;

import java.util.*;

import com.inmobis.bbdd.BDObject;
import com.inmobis.bbdd.RowExistsException;
import com.inmobis.bbdd.RowNotFoundException;


public interface GestorAgenteBD extends BDObject{

	public String agregarCliente (String idCliente) throws RowExistsException;
	public  void asociarCliente (String idCliente,String idAgente) throws RowExistsException;
	public  Vector listarAgentes() throws RowNotFoundException;
	public  Vector listarClientesAsociados() throws RowNotFoundException ;
	public  Vector listarInmueblesAgentes() throws RowNotFoundException ;
}
