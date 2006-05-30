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
 		<table width="100%" class="lista">
			<tr>
				<th><bean:message key="app.zona" /></th>
				<th><bean:message key="app.numHab" /></th>
				<th><bean:message key="app.metros" /></th>
				<th><bean:message key="app.regimen" /></th>
				<th><bean:message key="app.tipo" /></th>
				<th><bean:message key="app.precio" /></th>
				<th colspan="2">Opc.</th>
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
				<td width="15">
					<a href="BorraPisoPrev.do?idInmueble=<bean:write name="inmueble" property="idInmueble"/> "><IMG SRC="images/ico_eliminar.gif" WIDTH="14" HEIGHT="16" BORDER="0" ALT="Eliminar elemento"></a>
				</td>
				<td align="right" width="15">
					<a href="EditaPisoPrev.do?idInmueble=<bean:write name="inmueble" property="idInmueble"/>" /><IMG SRC="images/ico_editar.gif" WIDTH="13" HEIGHT="16" BORDER="0" ALT="Editar elemento"></a>
				</td>
			</tr>
			</logic:iterate>
    	</table>
		<table width="100%">
			<tr>
				<td>
					<a href="filtrarPisoAgente.jsp" style="color: #3962A6;"><IMG SRC="images/lupa.gif" WIDTH="21" HEIGHT="22" BORDER="0" ALT=""> <fmt:message key="enlace.filtrarPiso"/></a>	
				</td>
			</tr>
		</table>    	
	</div> 
</div> 
<div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>
                
<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA P?GINA -->
<%@ include file="final.htm" %>  
