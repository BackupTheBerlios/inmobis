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
<%String tipoMenu="agente";%>
<%@ include file="menu_izdo.jsp" %>
<div id="content"> 
	<div class="feature">     
 		<table width="100%" valign="top">
			<tr>
				<td>
					Zona
				</td>
				<td>
					n&ordm; de hab
				</td>
				<td>
					m&sup2;
				</td>
				<td>
					R&eacute;gimen
				</td>
				<td>
					Tipo
				</td>
				<td>
					Precio
				</td>
				<td>
					&nbsp;
				</td>
			</tr>
			<!-- iterate over the results of the query -->
			<logic:iterate id="inmueble"  name="listaInmuebles" type="com.inmobis.bbdd.inmueble.InmuebleBean" >   
			<tr>
				<td>
					<html:text name="inmueble" property="zona" size="15" maxlength="15" ></html:text>
					<bean:write name="inmueble" property="zona"/>
					</td>
				<td> 
					<html:text name="inmueble" property="numHab" size="1" maxlength="1"></html:text>
					<bean:write name="inmueble" property="numHab" />
				</td>
				<td>
					<html:text name="inmueble" property="metros" size="2" maxlength="4"></html:text>
					<bean:write name="inmueble" property="metros" />
				</td>
				<td>
					<html:text name="inmueble" property="regimen" size="5" maxlength="5"></html:text>
					<bean:write name="inmueble" property="regimen" />
				</td>
				<td>
					<html:text name="inmueble" property="tipo" size="9" maxlength="15"></html:text>
					<bean:write name="inmueble" property="tipo" /> 
				</td>
				<td>
					<html:text name="inmueble" property="precio" size="5" maxlength="4"></html:text>
					<bean:write name="inmueble" property="precio" /> 
				</td>
				<td>		
				<td>
					<a href="borraPisoPrev.do?idinmueble=<bean:write name='inmueble' property='idInmueble'/>
					   +&inmueble=<bean:write name='inmueble' property='zona' />
					   +&numHab=+<bean:write name='inmueble' property='numHab' />
					   +&metros=+<bean:write name='inmueble' property='metros' />
					   +&regimen=+<bean:write name='inmueble' property='regimen' />
					   +&tipo=+<bean:write name='inmueble' property='tipo' />
					   +&precio=+<bean:write name='inmueble' property='precio' />"	
					   >ELIMINAR</a>
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
