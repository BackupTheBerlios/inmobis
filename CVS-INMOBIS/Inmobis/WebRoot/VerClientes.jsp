<%--Librería específica de esta página: Logic, para usar el iterator--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%--El título de la página se debe pasar como parámetro a la cabecera--%>
<%String tituloPag = "&copy INMOBIS: Listado Clientes Agente";%>
<%boolean esIndex=false; %>
<%@ include file="cabecera.jsp" %>

<!-- Aquí es donde va la PARTE PRINCIPAL DE LA PÁGINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo que tienen todas las paginas-->
<%String subtitulo="Listado de clientes";%>
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
				<!-- zona de codigo-->
					<table width="100%">
						<tr> 
							<th><fmt:message key="app.nombre" /></th>
							<th><fmt:message key="app.apellido1" /></th>
							<th><fmt:message key="app.apellido2" /></th>
							<!--<th><fmt:message key=" app.IdCliente" /></th>-->
							<th><fmt:message key="app.dniCliente" /></th>
							<th><fmt:message key="app.fechNac" /></th>
							<th>Opciones</th>
						 </tr>
						 <!-- iterate over the results of the query -->
						<logic:iterate id="cliente" name="listaClientes" type="com.inmobis.bbdd.cliente.ClienteBean" >
							<tr>
								<td> 
									<bean:write name="cliente" property="nombreCliente" />
								</td>							  
								<td>
									<bean:write name="cliente" property="apellido1" />
								</td>							  
								<td>
									<bean:write name="cliente" property="apellido2" />
								</td>							
								<!-- MEJOR NO MOSTRAR LOS IDS POR PANTALLA
								<td>
									<html:text name="cliente" property="idCliente" ></html:text>
									<bean:write name="cliente" property="idCliente" />
								</td>
								-->
								<td>
									<bean:write name="cliente" property="dni" />
								</td>
								<td>
									<bean:write name="cliente" property="fechNacimiento" />
								</td> 														
							</tr>
					</logic:iterate>
					</table>
					<br><br>
					<table width="100%">
						<tr>
							<td>
								<a href="filtrarCliente.do" style="color: #3962A6;"><IMG SRC="images/lupa.gif" WIDTH="21" HEIGHT="22" BORDER="0" ALT=""> <fmt:message key="menuAgente.filtrarCliente"/></a>
							</td>
						</tr>
					</table>
				</div>
              </div>
              <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>

<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA P�GINA -->

			

<%@ include file="final.htm" %>  