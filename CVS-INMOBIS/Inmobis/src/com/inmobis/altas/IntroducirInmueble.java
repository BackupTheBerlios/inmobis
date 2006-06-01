package com.inmobis.altas;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

import com.inmobis.INMOCTES;
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
import com.inmobis.bbdd.inmueble.VentasBean;
import com.inmobis.struts.form.VenderPisoForm;
import com.inmobis.bbdd.empleado.AgenteBean;
import com.inmobis.bbdd.empleado.GestorAgenteBD;

public class IntroducirInmueble extends Introducir{
	private static final Logger i_log = Logger.getLogger(IntroducirInmueble.class);
	
	public ActionMessages introduce(ActionForm datosInmueble){
		GeneradorDeCodigos gc=GeneradorDeCodigos.getGeneradorDeCodigos();
		ActionMessages errors= new ActionMessages();
		RegistraPisoForm datosInmo = (RegistraPisoForm) datosInmueble;
		
		//Creamos y rellenamos el objeto Bean para el inmueble
		InmuebleBean inmueble=new InmuebleBean();
		inmueble.setMetros(datosInmo.getMetros());
		inmueble.setPrecio(datosInmo.getPrecio());
		inmueble.setRegimen(datosInmo.getRegimen());
		inmueble.setNumHab(datosInmo.getNumHab());
		inmueble.setTipo(datosInmo.getTipo());
		inmueble.setZona(datosInmo.getZona());
		inmueble.setDatosDeInteres(datosInmo.getDatosInteres());
		inmueble.setFoto1(datosInmo.getFoto1());
		inmueble.setFoto2(datosInmo.getFoto2());
		inmueble.setIdInmueble(gc.asignaCodigoInmueble());
		if(i_log.isInfoEnabled())
			i_log.info("Codigo Inmueble:" + inmueble.getIdInmueble());

		GestorInmuebleBD gestorInmueble= (GestorInmuebleBD)CreadorGestores.crearGestor("inmueble",inmueble);
		
		//Creamos un Bean de Direccion asociada al inmueble ya creado
		InfoDirBean direccion=gestorInmueble.newInfoDirInmuebles("casa");
		//Rellenamos el bean 
		direccion.setCalle(datosInmo.getCalle());
		direccion.setNum(datosInmo.getNum());
		direccion.setPiso(datosInmo.getPiso());
		direccion.setCodPostal(datosInmo.getCodPostal());
		direccion.setPoblacion(datosInmo.getPoblacion());
		direccion.setProvincia(datosInmo.getProvincia());
		direccion.setPais(datosInmo.getPais());
		
		ClienteBean cliente=new ClienteBean();
		GestorClienteBD gestorCliente=(GestorClienteBD)CreadorGestores.crearGestor("cliente",cliente);
		try {
			gestorCliente.consultaLoginPorNombreUsuario(datosInmo.getNombreUsuario());
			if(i_log.isInfoEnabled())
				i_log.info("Foto1:"+datosInmo.getBinFoto1().getFileName()+" Foto2: "+
						datosInmo.getBinFoto2().getFileName());
			if (gestorCliente.getLoginBean().getIdUsuario()!=null)	{
				try {
					//Guardamos la foto1 si la hay
					if (!datosInmo.getFoto1().trim().equalsIgnoreCase(""))
					{
						if(i_log.isInfoEnabled())
							i_log.info("NombreFoto1:"+datosInmo.getBinFoto1().getFileName());
						errors = EscribeFichero(datosInmo.getBinFoto1(),errors,datosInmo.getFoto1());
					}
					if (!datosInmo.getFoto2().trim().equalsIgnoreCase(""))
					{
						if(i_log.isInfoEnabled())
							i_log.info("NombreFoto2:"+datosInmo.getBinFoto2().getFileName());
						errors = EscribeFichero(datosInmo.getBinFoto2(),errors,datosInmo.getFoto2());
					}
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

	private ActionMessages EscribeFichero(FormFile miFile, ActionMessages errors, String nombreFich){
		try {
			OutputStream bos = new FileOutputStream(INMOCTES.pathFotos+nombreFich);
			if(i_log.isInfoEnabled())
				i_log.info("Esribe Fichero - Path de la foto:" + INMOCTES.pathFotos+nombreFich);							// TODO Auto-generated catch block
			InputStream stream = miFile.getInputStream();
			byte[] buffer = new byte[8192];
			int bytesLeidos = 0;
			while((bytesLeidos = stream.read(buffer,0,8192))!= -1){
				bos.write(buffer,0,bytesLeidos);
			}
			bos.close(); //Cerramos el fichero
		} catch (FileNotFoundException e) {
			errors.add("registraPiso", new ActionMessage("errors.bbdd.clave"));
			if(i_log.isInfoEnabled())
				i_log.info("Fallo al guardar la foto1:" + e.toString());							// TODO Auto-generated catch block
		} catch (IOException e) {
			errors.add("registraPiso", new ActionMessage("errors.bbdd.clave"));
			if(i_log.isInfoEnabled())
				i_log.info("Fallo al guardar la foto1:" + e.toString());							// TODO Auto-generated catch block
		}
		return errors;
	}
	
	public ActionMessages introduceVendido(ActionForm datosInmuebleVendido){
		
		GeneradorDeCodigos gc=GeneradorDeCodigos.getGeneradorDeCodigos();
		ActionMessages errors= new ActionMessages();
		
		//Creamos y rellenamos el objeto Bean para el inmueble
		VentasBean inmuebleVend=new VentasBean();
		inmuebleVend.setFechaDesde(((VenderPisoForm)datosInmuebleVendido).getFechIni());
		inmuebleVend.setFechaHasta(((VenderPisoForm)datosInmuebleVendido).getFechFin());
		inmuebleVend.setFechVenta(((VenderPisoForm)datosInmuebleVendido).getFechVenta());
		inmuebleVend.setGanancia(((VenderPisoForm)datosInmuebleVendido).getGanacia());
		inmuebleVend.setIdAgente(((VenderPisoForm)datosInmuebleVendido).getIdAgente());
		inmuebleVend.setIdInmueble(((VenderPisoForm)datosInmuebleVendido).getIdInmueble());
		inmuebleVend.setPrecioFinal(((VenderPisoForm)datosInmuebleVendido).getPrecioFinal());
		inmuebleVend.setPrecioInicial(((VenderPisoForm)datosInmuebleVendido).getPrecioInicial());		
		inmuebleVend.setIdInmueble(gc.asignaCodigoInmueble());
		if(i_log.isInfoEnabled())
			i_log.info("Codigo Inmueble:" + inmuebleVend.getIdInmueble());	
		
		AgenteBean agente=new AgenteBean();
		GestorAgenteBD gestorAgente=(GestorAgenteBD)CreadorGestores.crearGestor("agente",agente);
		try {
			gestorAgente.insertarVenta(inmuebleVend);			
			
		} catch (Exception e1) {			
			errors.add("registraPiso", new ActionMessage("errors.username.noexiste"));
			if(i_log.isInfoEnabled())
				i_log.info("Fallo en la inserción del piso vendido.");
		}
		
		return errors;
	}
}
