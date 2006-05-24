<%--Librería específica de esta página: Logic, para usar el iterator--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%--El título de la página se debe pasar como parámetro a la cabecera--%>
<%String tituloPag = "&copy INMOBIS: Listado Clientes Sin Agente";%>
<%boolean esIndex=false; %>
<%@ include file="cabecera.jsp" %>

<!-- Aquí es donde va la PARTE PRINCIPAL DE LA PÁGINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo que tienen todas las paginas-->
<%String subtitulo="Listado de clientes";%>
<%String tipoMenu="agente";%>
<%@ include file="menu_izdo_general.jsp" %>
              <div id="content"> 
                <div class="feature"> 
					<table width="100%">
						<tr>   
							<td>
								<bean:message key=" app.Nombre" />
							</td>
							<td>
								<bean:message key="app.Apellido1" />
							</td>
							<td>
								<bean:message key="app.Apellido2" />
							</td>  
							<td>
								&nbsp;
							</td>
						</tr>
						  <!-- iterate over the results of the query -->
						  <logic:iterate id="cliente" name="listaClientes" type="com.inmobis.bbdd.cliente.ClienteBean">   
						<tr>
						  <td> 
								<html:text name="cliente" property="nombre" ></html:text>
								<bean:write name="cliente" property="nombre" />
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
					            <a href="AsignarAgenteAClientes.do?codigo=<
								<bean:write name='cliente' property='idCliente' />
								<bean:write name='cliente' property='nombre' />
								<bean:write name='cliente' property='apeliido1' />
								<bean:write name='cliente' property='apellido2' />">ASIGNAR</a>
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