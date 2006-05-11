package com.inmobis.consultas;

import java.util.*;
import org.apache.struts.action.ActionForm;

public abstract class Consultar {
	public abstract Vector listar(ActionForm datosBusqueda);	
}
