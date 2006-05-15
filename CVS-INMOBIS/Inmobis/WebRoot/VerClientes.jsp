<%--Librería específica de esta página: Logic, para usar el iterator--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%--El título de la página se debe pasar como parámetro a la cabecera--%>
<%String tituloPag = "&copy INMOBIS: Listado Clientes Agente";%>
<%boolean esIndex=false; %>
<%@ include file="cabecera.jsp" %>

<!-- Aquí es donde va la PARTE PRINCIPAL DE LA PÁGINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo que tienen todas las paginas-->
<%String subtitulo="Listado de clientes";%>
<%boolean esGenerico=true;%>
<%@ include file="menu_izdo_general.jsp" %>
              <div id="content"> 
                <div class="feature">
				<!-- zona de codigo-->
					<table width="100%">
						<tr> 
							<td><fmt:message key=" app.Nombre" /></td>
							<td><fmt:message key="app.Apellido1" /></td>
							<td><fmt:message key="app.Apellido2" /></td>
							<td><fmt:message key=" app.IdCliente" /></td>
							<td><fmt:message key=" app.DniCliente" /></td>
							<td><fmt:message key=" app.FechNac" /></td>
						 </tr>
						</table>
						<table width="100%">
						 <!-- iterate over the results of the query -->
						<logic:iterate id="cliente" name="listaClientes" type="com.inmobis.bbdd.cliente.ClienteBean" >
							<tr>
								<td> 
									<html:text name="cliente" size="15" property="nombreCliente" ></html:text>
									<bean:write name="cliente" property="nombreCliente" />
								</td>							  
								<td>
									<html:text name="cliente" property="apellido1" ></html:text>
									<bean:write name="cliente" property="apellido1" />
								</td>							  
								<td>
									<html:text name="cliente" property="apellido2" ></html:text>
									<bean:write name="cliente" property="apellido2" />
								</td>							
								<td>
									<html:text name="cliente" property="idCliente" ></html:text>
									<bean:write name="cliente" property="idCliente" />
								</td>								 
								<td>
									<html:text name="cliente" property="dni" ></html:text>
									<bean:write name="cliente" property="dni" />
								</td>
								<td>
									<html:text name="cliente" property="fechNacimiento" ></html:text>
									<bean:write name="cliente" property="fechNacimiento" />
								</td> 
								<td>
									<a href="ModifBajaClientePrev.do?nombreCliente=<bean:write name='cliente' property='nombre' />+&apellido1=+<bean:write name='cliente' property='apellido1' />+&apellido2=+<bean:write name='cliente' property='apellido2' />+&idcliente=+<bean:write name='cliente' property='idcliente' />+&dnicliente=+<bean:write name='cliente' property='dnicliente' />+&fechnac=+<bean:write name='cliente' property='fechnac' />">MODIFICAR</a>
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