<%--Librería específica de esta página: Logic, para usar el iterator--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%--El título de la página se debe pasar como parámetro a la cabecera--%>
<%String tituloPag = "&copy INMOBIS: Listado de mensajes";%>
<%boolean esIndex=false; %>
<%@ include file="cabecera.jsp" %>

<!-- Aquí es donde va la PARTE PRINCIPAL DE LA P�?GINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo que tienen todas las paginas-->
<%String subtitulo="Listado de mensajes";%>
<%String tipoMenu="general";//Si no se ha registrado%>
<%
HttpSession sesion=request.getSession();
String tipoU=(String)sesion.getAttribute("tipoUsuario");
%>
<%if (tipoU != null) {%>
<%	tipoMenu = tipoU;%>
<%}%><%@ include file="menu_izdo.jsp" %>
              <div id="content"> 
                <div class="feature"> 
                <html:errors property="ListaMensaje"/>                
                   <table width="100%" class="lista">
						 <!-- zona de c�digo-->
						<tr>
														
							<th><fmt:message key="verMensaje.nombreOrigen" /></th>
							<th><fmt:message key="verMensaje.asunto" /></th>
							<th><fmt:message key="verMensaje.fecha" /></th>
							<th><fmt:message key="verMensaje.leido" /></th>													
							
							<th colspan="2">Opc.</th>
						</tr>
						<!-- iterate over the results of the query -->
						<logic:iterate id="mensaje" name="listaMensajes" type="com.inmobis.bbdd.mensajes.MensajesBean">   
						<tr>
							  <td> 
									<bean:write name="mensaje" property="nombreOrigen" />
							  </td>
							  <td>
									<bean:write name="mensaje" property="asunto" />
							  </td>
							  <td>
									<bean:write name="mensaje" property="fecha" />
							  </td>
					<!-- 		  <td>
									<bean:write name="mensaje" property="leido" />
							  </td>
						-->	  
				 			  
							  <td width="15">
									<a href="verMensaje.do?idMensaje=<bean:write name="mensaje" property="idMensaje"/>&origen=<bean:write name="mensaje" property="origen" />&destino=<bean:write name="mensaje" property="destino" />&fecha=<bean:write name="mensaje" property="fecha" /> "><IMG SRC="images/lupa.gif" WIDTH="14" HEIGHT="16" BORDER="0" ALT="Ver detalles del mensaje"></a>
							  </td>
							  <td width="15">
									<a href="borrarMensajePrev.do?idMensaje=<bean:write name="mensaje" property="idMensaje"/>&origen=<bean:write name="mensaje" property="origen" />&destino=<bean:write name="mensaje" property="destino" />&fecha=<bean:write name="mensaje" property="fecha" /> "><IMG SRC="images/ico_eliminar.gif" WIDTH="14" HEIGHT="16" BORDER="0" ALT="Eliminar mensaje"></a>
							  </td>
							  						
						</tr>
				      		</logic:iterate>
					</table>
					<br><br>
					<table width="100%">
						<tr>
							<td>
								<a href="crearMensaje.do"><IMG SRC="images/ico_editar.gif" WIDTH="14" HEIGHT="16" BORDER="0" ALT="Crear mensaje">Crear un mensaje nuevo</a>
							</td>
						</tr>
					</table>
					
				</div>
              </div>
              <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>

<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA P�GINA -->

			

<%@ include file="final.htm" %>  