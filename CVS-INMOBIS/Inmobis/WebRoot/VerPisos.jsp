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
<%String tipoMenu="general";%>
<%@ include file="menu_izdo.jsp" %>
              <div id="content"> 
                <div class="feature"> 
                   
					<table width="100%">
						<tr>   
					       <td><bean:message key="app.numHab" /></td>
						   <td><bean:message key="app.metros" /></td>
					       <td><bean:message key=" app.regimen" /></td>
					       <td><bean:message key="app.tipo" /></td>
						   <td><bean:message key="app.zona" /></td>
						   <td><bean:message key=" app.precio" /></td>
						   <td><bean:message key="app.datosdeinteres" /></td>  
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

                </div>
              </div>
              <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>

<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA P�GINA -->

			

<%@ include file="final.htm" %>  