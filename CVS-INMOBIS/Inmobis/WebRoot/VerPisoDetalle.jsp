<%--Los includes específicos de esta página--%>
<%@ page import="com.inmobis.struts.form.VerPisoDetalleForm" %>
<%--El título de la página se debe pasar como parámetro a la cabecera--%>
<%String tituloPag = "INMOBIS Real Estate - Edici&oacute;n de piso";%>
<%boolean esIndex=false; %>
<%@include file="cabecera.jsp" %>

<!-- Aquí es donde va la PARTE PRINCIPAL DE LA PÁGINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo que tienen todas las paginas-->
<%String subtitulo="P&aacute;gina de Ver Detalles";%>
<%String tipoMenu="general";//Si no se ha registrado%>
<%
HttpSession sesion=request.getSession();
String tipoU=(String)sesion.getAttribute("tipoUsuario");
%>
<%if (tipoU != null) {%>
<%	tipoMenu = tipoU;%>
<%}%>
<%@ include file="menu_izdo.jsp" %>
	      <div id="content"> 
			<div class="feature">
				<%VerPisoDetalleForm form=(VerPisoDetalleForm)sesion.getAttribute("datosPiso");%>
				<table width="100%">
					<tr>
						<td>
							<H2><fmt:message key="detallesPiso.message"/></H2>
						</td>
					</tr>
				</table>
				<table width="100%">
					<tr>
						<td>
							<table width="100%">
								<tr>
									<td>
										<IMG src="pisos/<%=form.getFoto1()%>" border="0">
									</td>
								</tr>
								<tr>
									<td>
										<IMG src="pisos/<%=form.getFoto2()%>" border="0">
										
									</td>
								</tr>
							</table>
						</td>
						<td>
							<table width="100%">
								<tr>
									<td>
										<fmt:message key="detallesPiso.numHab"/>
									</td>
									<td>
										<%=form.getNumHab()%>
									</td>
								</tr>
								<tr>
									<td>
										<fmt:message key="detallesPiso.tipo"/>	
									</td>
									<td>
										<%=form.getTipo()%>
									</td>
								</tr>
								<tr>
									<td>
										<fmt:message key="detallesPiso.zona"/>	
									</td>
									<td>
										<%=form.getZona()%>
									</td>
								</tr>
								<tr>
									<td>
										<fmt:message key="detallesPiso.metros"/>	
									</td>
									<td>
										<%=form.getMetros()%>
									</td>
								</tr>
								<tr>
									<td>
										<fmt:message key="detallesPiso.regimen"/>	
									</td>
									<td>
										<%=form.getRegimen()%>
									</td>
								</tr>
								<tr>
									<td>
										<fmt:message key="detallesPiso.precio"/>	
									</td>
									<td>
										<%=form.getPrecio()%>
									</td>
								</tr>
								<tr>
									<td>
										<fmt:message key="detallesPiso.datosDeInteres"/>	
									</td>
									<td>
										<%=form.getDatosDeInteres()%>
									</td>
								</tr>
								<tr>
									<td>
										<fmt:message key="detallesPiso.calle"/>	
									</td>
									<td>
										<%=form.getCalle()%>
									</td>
								</tr>
								<tr>
									<td>
										<fmt:message key="detallesPiso.num"/>	
									</td>
									<td>
										<%=form.getNum()%>
									</td>
								</tr>
								<tr>
									<td>
										<fmt:message key="detallesPiso.piso"/>	
									</td>
									<td>
									
										<%=form.getPiso()%>
									</td>
								</tr>
								<tr>
									<td>
										<fmt:message key="detallesPiso.codPostal"/>	
									</td>
									<td>
										<%=form.getCodPostal()%>
									</td>
								</tr>
								<tr>
									<td>
										<fmt:message key="detallesPiso.poblacion"/>	
									</td>
									<td>
										<%=form.getPoblacion()%>
									</td>
								</tr>
								<tr>
									<td>
										<fmt:message key="detallesPiso.provincia"/>	
									</td>
									<td>
										<%=form.getProvincia()%>
									</td>
								</tr>
								<tr>
									<td>
										<fmt:message key="detallesPiso.pais"/>	
									</td>
									<td>
										"España"
									</td>
								</tr>					
							</table>
						</td>
					</tr>
				</table>
			</div>
		</div>
        <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>

<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA Pï¿½GINA -->

		

<%@ include file="final.htm" %>
  

 
  

