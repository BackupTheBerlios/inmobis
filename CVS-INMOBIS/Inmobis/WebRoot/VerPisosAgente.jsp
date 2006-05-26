<%--Librería específica de esta página: Logic, para usar el iterator--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%--El título de la página se debe pasar como parámetro a la cabecera--%>
<%String tituloPag = "&copy INMOBIS: Listado de pisos del agente";%>
<%boolean esIndex=false; %>
<%@ include file="cabecera.jsp" %>

<!-- Aquí es donde va la PARTE PRINCIPAL DE LA PÁGINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo que tienen todas las paginas-->
<%String subtitulo="Listado de pisos del agente";%>
<%String tipoMenu="general";//Si no se ha registrado%>
<!-- CON ESTO BASTARÍA--><%-- tipoMenu="agente";--%>
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
 		<table width="100%">
			<tr>
				<th>
					Zona
				</th>
				<th>
					n&ordm; de hab
				</th>
				<th>
					m&sup2;
				</th>
				<th>
					R&eacute;gimen
				</th>
				<th>
					Tipo
				</th>
				<th>
					Precio
				</th>
				<th>
					Opciones
				</th>
			</tr>
			<!-- iterate over the results of the query -->
			<logic:iterate id="inmueble"  name="listaInmuebles" type="com.inmobis.bbdd.inmueble.InmuebleBean" >   
			<tr>
				<td>
					<bean:write name="inmueble" property="zona"/>
				</td>
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
					<bean:write name="inmueble" property="precio" /> 
				</td>		
				<td>
					<table width="100%">
						<tr>
							<td>
								<a href="BorraPisoPrev.do?idInmueble=<bean:write name="inmueble" property="idInmueble"/> "><IMG SRC="images/ico_eliminar.gif" WIDTH="14" HEIGHT="16" BORDER="0" ALT="Eliminar elemento"></a>
							</td>
							<td align="right">
								<a href="EditaPisoPrev.do?idInmueble=<bean:write name="inmueble" property="idInmueble"/>" /><IMG SRC="images/ico_editar.gif" WIDTH="13" HEIGHT="16" BORDER="0" ALT="Editar elemento"></a>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			</logic:iterate>
    	</table>	
	</div> 
</div> 
<div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>
                
<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA P?GINA -->
<%@ include file="final.htm" %>  
