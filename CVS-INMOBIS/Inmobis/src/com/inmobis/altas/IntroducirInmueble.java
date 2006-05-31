package com.inmobis.altas;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionForm;

import com.inmobis.bbdd.CreadorGestores;
import com.inmobis.bbdd.GeneradorDeCodigos;
import com.inmobis.bbdd.RowExistsException;
import com.inmobis.bbdd.RowNotFoundException;
import com.inmobis.bbdd.cliente.ClienteBean;
import com.inmobis.bbdd.cliente.GestorClienteBD;
import com.inmobis.bbdd.direccion.InfoDirBean;
import com.inmobis.bbdd.inmueble.GestorInmuebleBD;
import com.inmobis.bbdd.inmueble.InmuebleBean;
import com.inmobis.struts.form.RegistraPisoForm;

public class IntroducirInmueble extends Introducir{
	private static final Logger i_log = Logger.getLogger(IntroducirInmueble.class);
	
	public ActionMessages introduce(ActionForm datosInmueble){
		GeneradorDeCodigos gc=GeneradorDeCodigos.getGeneradorDeCodigos();
		ActionMessages errors= new ActionMessages();
		
		//Creamos y rellenamos el objeto Bean para el inmueble
		InmuebleBean inmueble=new InmuebleBean();
		inmueble.setMetros(((RegistraPisoForm)datosInmueble).getMetros());
		inmueble.setPrecio(((RegistraPisoForm)datosInmueble).getPrecio());
		inmueble.setRegimen(((RegistraPisoForm)datosInmueble).getRegimen());
		inmueble.setNumHab(((RegistraPisoForm)datosInmueble).getNumHab());
		inmueble.setTipo(((RegistraPisoForm)datosInmueble).getTipo());
		inmueble.setZona(((RegistraPisoForm)datosInmueble).getZona());
		inmueble.setDatosDeInteres(((RegistraPisoForm)datosInmueble).getDatosInteres());
		inmueble.setIdInmueble(gc.asignaCodigoInmueble());
		if(i_log.isInfoEnabled())
			i_log.info("Codigo Inmueble:" + inmueble.getIdInmueble());

		GestorInmuebleBD gestorInmueble= (GestorInmuebleBD)CreadorGestores.crearGestor("inmueble",inmueble);
		
		//Creamos un Bean de Direccion asociada al inmueble ya creado
		InfoDirBean direccion=gestorInmueble.newInfoDirInmuebles("casa");
		//Rellenamos el bean 
		direccion.setCalle(((RegistraPisoForm)datosInmueble).getCalle());
		direccion.setNum(((RegistraPisoForm)datosInmueble).getNum());
		direccion.setPiso(((RegistraPisoForm)datosInmueble).getPiso());
		direccion.setCodPostal(((RegistraPisoForm)datosInmueble).getCodPostal());
		direccion.setPoblacion(((RegistraPisoForm)datosInmueble).getPoblacion());
		direccion.setProvincia(((RegistraPisoForm)datosInmueble).getProvincia());
		direccion.setPais(((RegistraPisoForm)datosInmueble).getPais());
		
		ClienteBean cliente=new ClienteBean();
		GestorClienteBD gestorCliente=(GestorClienteBD)CreadorGestores.crearGestor("cliente",cliente);
		try {
			gestorCliente.consultaLoginPorNombreUsuario(((RegistraPisoForm)datosInmueble).getNombreUsuario());
			if(i_log.isInfoEnabled())
				i_log.info("id de:"+((RegistraPisoForm)datosInmueble).getNombreUsuario()+" o "+
						gestorCliente.getLoginBean().getNombreUsuario()+" es "+gestorCliente.getLoginBean().getIdUsuario());
			if (gestorCliente.getLoginBean().getIdUsuario()!=null)	{
				try {
					gestorInmueble.asociarClienteInmueble(gestorCliente.getLoginBean().getIdUsuario(),inmueble.getIdInmueble());
					gestorInmueble.insert();
					gestorInmueble.insertaDir(direccion);
				} catch (RowExistsException e) {
					errors.add("registraPiso", new ActionMessage("errors.bbdd.clave"));
					if(i_log.isInfoEnabled())
						i_log.info("Fallo en identificadores de tabla de BBDD :" + e.toString());
				}
			}
			else{
				errors.add("registraPiso", new ActionMessage("error.username.noexiste"));
				if(i_log.isInfoEnabled())
					i_log.info("No se ha encontrado el cliente indicado");
			}
		} catch (RowNotFoundException e1) {
			//TODO mensaje de error
			errors.add("registraPiso", new ActionMessage("errors.username.noexiste"));
			if(i_log.isInfoEnabled())
				i_log.info("No se ha encontrado el cliente indicado");
		}
		
		return errors;
	}
}
