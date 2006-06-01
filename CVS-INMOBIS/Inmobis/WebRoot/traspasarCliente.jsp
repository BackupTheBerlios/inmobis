<%--Librería específica de esta página: Logic, para usar el iterator--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%--El título de la página se debe pasar como parámetro a la cabecera--%>
<%String tituloPag = "&copy INMOBIS: Listado de empleados";%>
<%boolean esIndex=false; %>
<%@ include file="cabecera.jsp" %>

<!-- Aquí es donde va la PARTE PRINCIPAL DE LA P�?GINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo que tienen todas las paginas-->
<%String subtitulo="Listado de empleados";%>
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
                
                <table width="100%">
			<tr>
				<td><H4>�A qu� agente quieres fraspasar el cliente: <font color="blue"><b><%=session.getAttribute("clienteTraspasado")%></b></font>?</H4></td>
			</tr>
		</table>
		
                   <table width="100%" class="lista">
						 <!-- zona de c�digo-->
						<tr>
							<th><fmt:message key="app.nombre" /></th>
							<th><fmt:message key="app.apellido1" /></th>
							<th><fmt:message key="app.apellido2" /></th>
							<th><fmt:message key="app.dni" /></th>
							<th>Opc.</th>
						</tr>
						<!-- iterate over the results of the query -->
						<logic:iterate id="empleado" name="listaEmpleados" type="com.inmobis.bbdd.empleado.EmpleadoBean">   
						<tr>
							  <td> 
									<bean:write name="empleado" property="nombre" />
							  </td>
							  <td>
									<bean:write name="empleado" property="apellido1" />
							  </td>
							  <td>
									<bean:write name="empleado" property="apellido2" />
							  </td>
							  <td>
									<bean:write name="empleado" property="dni" />
							  </td>
							  <td width="15">
									<a href="traspasarCliente.do?idEmpleado=<bean:write name="empleado" property="idEmpleado"/> "><IMG SRC="images/ico_tick.jpg" WIDTH="14" HEIGHT="16" BORDER="0" ALT="Traspasar a este Agente"></a>
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