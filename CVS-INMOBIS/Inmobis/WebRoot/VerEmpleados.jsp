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
						 <!-- zona de c�digo-->
						<tr>
							<th>
								Nombre
							</th>
							<th>
								Apellido 1
							</th>
							<th>
								Apellido 2
							</th>
							<th>
								Opciones
							</th>
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
									<table width="100%">
									<tr>
										<td>
											<a href="borraEmpleadoPrev.do?idEmpleado=<bean:write name="empleado" property="idEmpleado"/> "><IMG SRC="images/ico_eliminar.gif" WIDTH="14" HEIGHT="16" BORDER="0" ALT="Eliminar elemento"></a>
										</td>
										<td align="right">
											<a href="editaEmpleadoPrev.do?idEmpleado=<bean:write name="empleado" property="idEmpleado"/>" /><IMG SRC="images/ico_editar.gif" WIDTH="13" HEIGHT="16" BORDER="0" ALT="Editar elemento"></a>
										</td>
									</tr>
									</table>
								</td>								
						</tr>
				      </logic:iterate>
					</table>
					<a href="filtrarEmpleado.do">
			           <fmt:message key="menuAdministrador.filtrarEmpleado"/>
		            </a>
                </div>
              </div>
              <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>

<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA P�GINA -->

			

<%@ include file="final.htm" %>  