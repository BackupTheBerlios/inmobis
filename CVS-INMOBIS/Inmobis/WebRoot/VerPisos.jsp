<%--Librería específica de esta página: Logic, para usar el iterator--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%--El título de la página se debe pasar como parámetro a la cabecera--%>
<%String tituloPag = "&copy INMOBIS: Listado de pisos";%>
<%boolean esIndex=false; %>
<%@ include file="cabecera.jsp" %>

<!-- Aquí es donde va la PARTE PRINCIPAL DE LA PÁGINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo que tienen todas las paginas-->
<%String subtitulo="Listado de pisos";%>
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
					       <th><bean:message key="app.numHab" /></th>
						   <th><bean:message key="app.metros" /></th>
					       <th><bean:message key="app.regimen" /></th>
					       <th><bean:message key="app.tipo" /></th>
						   <th><bean:message key="app.zona" /></th>
						   <th><bean:message key="app.precio" /></th>
						   <!--<th><bean:message key="app.datosdeinteres" /></th>-->  
   						</tr>
						<logic:iterate id="inmueble" name="listaInmuebles">   
					    <tr>
							<td>
								<bean:write name="inmueble" property="numHab" />
							</td>
							<td>
								<bean:write name="inmueble" property="metros" />
							</td>
							<td>
								<bean:write name="inmueble" property="regimen" />
							</td>
							<td>
								<bean:write name="inmueble" property="tipo" />
							</td>
							<td>
								<bean:write name="inmueble" property="zona" />
							</td>
							<td>
								<bean:write name="inmueble" property="precio" />
							</td>
						</tr>
				      </logic:iterate>
					</table>
					<a href="filtrarPiso.do">
			           <fmt:message key="menuGenerico.filtrarPiso"/>
		            	</a>

                </div>
              </div>
              <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>

<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA P�GINA -->

			

<%@ include file="final.htm" %>  