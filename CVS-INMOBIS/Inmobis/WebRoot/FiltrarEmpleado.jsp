<%--El título de la página se debe pasar como parámetro a la cabecera--%>
<%String tituloPag = "INMOBIS Real Estate - Filtrado de empleados";%>
<%boolean esIndex=false; %>
<%@include file="cabecera.jsp" %>

<!-- Aquí es donde va la PARTE PRINCIPAL DE LA PÁGINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo que tienen todas las paginas-->
<%String subtitulo="P&aacute;gina de Filtrado de empleados";%>
<%String tipoMenu="general";%>
<%@ include file="menu_izdo.jsp" %>

              <div id="content"> 
                <div class="feature">
					<center> 
						<html:errors property="filtrarEmpleado"/>
						<html:form action="filtrarEmpleado.do">
							<table width="100%">
								<tr>
									<td><H2><fmt:message key="filtrarEmpleado.message"/></H2></td>
								</tr>
							</table>							
							<table border="0" width="100%">
								<tr>
									<td>
										<fmt:message key="filtrarEmpleado.nombreEmpleado"/>
									</td>
									<td>
										<html:text 	property="nombreEmpleado" 
													size="40" 
													maxlength="40" />
										<html:errors property="nombreEmpleado" />
									</td>
								</tr>	
								<tr>
									<td>
										<fmt:message key="filtrarEmpleado.apellido1"/>
									</td>
									<td>
										<html:text 	property="apellido1" 
													size="20" 
													maxlength="20" />
										<html:errors property="apellido1" />
									</td>
								</tr>	
								<tr>
									<td>
										<fmt:message key="filtrarEmpleado.apellido2"/>
									</td>
									<td>
										<html:text 	property="apellido2" 
													size="20" 
													maxlength="20" />
										<html:errors property="apellido2" />
									</td>
								</tr>
								<tr>
									<td>
										<fmt:message key="filtrarEmpleado.fechaNacimiento"/>
									</td>
									<td>
										<html:text 	property="fechaNacimiento" 
													size="15" 
													maxlength="15" />
										<html:errors property="fechaNacimiento" />
									</td>
								</tr>
								<tr>
									<td>
										<fmt:message key="filtrarEmpleado.dni"/>
									</td>
									<td>
										<html:text 	property="dniEmpleado" 
													size="15" 
													maxlength="15" />
										<html:errors property="dniEmpleado" />
									</td>
								</tr>	
								
							</table>
							<table width="100%">
								<tr>
									<td align="center">
										<html:submit>
											<fmt:message key="filtrarEmpleado.button.buscar"/>
										</html:submit>
									</td>
								</tr>
							</table>
						</html:form>
					</center>
                </div>
              </div>
              <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>

<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA PAGINA -->

			

<%@ include file="final.htm" %>
