<%--Librería específica de esta página: Logic, para usar el iterator--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%--El título de la página se debe pasar como parámetro a la cabecera--%>
<%String tituloPag = "&copy INMOBIS Real Estate - Ver Pisos Vendidos";%>
<%boolean esIndex=false; %>
<%@include file="cabecera.jsp" %>

<!-- Aquí es donde va la PARTE PRINCIPAL DE LA PÁGINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo que tienen todas las paginas-->
<%String subtitulo="P&aacute;gina de Listado";%>
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
					<table width="100%" class="lista">
						<tr>   
					       <th><bean:message key="verPisosVendidos.fechVenta" /></th>
						   <th><bean:message key="verPisosVendidos.precioInicial" /></th>
					       <th><bean:message key="verPisosVendidos.precioFinal" /></th>
					       <th><bean:message key="verPisosVendidos.ganancia" /></th>
   						</tr>
						<!--HABRÁ QUE PONER EL TIPO-->
						<logic:iterate id="inmuebleVend" name="listaInmuebles"> 
					    <tr>
							<td>
								<bean:write name="inmuebleVend" property="fechVenta" />
							</td>
							<td>
								<bean:write name="inmuebleVend" property="precioInicial" />
							</td>
							<td>
								<bean:write name="inmuebleVend" property="precioFinal" />
							</td>
							<td>
								<bean:write name="inmuebleVend" property="ganancia" />
							</td>
						</tr>
				      </logic:iterate>
					</table>									
					<br><br>
					<table width="100%">
						<tr>
							<td>
								<a href="FiltrarPisosVendidos.jsp" style="color: #3962A6;"><IMG SRC="images/lupa.gif" WIDTH="21" HEIGHT="22" BORDER="0" ALT=""> <fmt:message key="enlace.filtrarPisoVendido"/></a>
							</td>
						</tr>
					</table>
                </div>
              </div>
              <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>

<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA PÁGINA -->

			

<%@ include file="final.htm" %>  
