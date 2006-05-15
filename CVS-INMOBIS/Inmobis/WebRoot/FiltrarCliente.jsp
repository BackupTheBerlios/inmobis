<%--El título de la página se debe pasar como parámetro a la cabecera--%>
<%String tituloPag = "INMOBIS Real Estate - Filtrado de clientes";%>
<%boolean esIndex=false; %>
<%@ include file="cabecera.jsp" %>

<!-- Aquí es donde va la PARTE PRINCIPAL DE LA PÁGINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo que tienen todas las paginas-->
<%String subtitulo="P&aacutegina de filtrado";%>
<%boolean esGeneral=true;%>
<%@ include file="menu_izdo_general.jsp" %>
              <div id="content"> 
                <div class="feature">
					<center> 
						<html:errors property="filtrarCliente"/>
						<html:form action="filtrarCliente.do">
							<table width="100%">
								<tr>
									<!--<td><H2>Rellene los campos por los que desee filtrar</H2></td>-->
									<td><H2><fmt:message key="filtrarCliente.message"/></H2></td>
								</tr>
							</table>							
							<table border="0" width="100%">
								<tr>
									<td>
										<fmt:message key="filtrarCliente.nombreCliente"/>
									</td>
									<td>
										<html:text 	property="nombreCliente" 
													size="40" 
													maxlength="40" />
										<html:errors property="nombreCliente" />
									</td>
								</tr>	
								<tr>
									<td>
										<fmt:message key="filtrarCliente.apellido1"/>
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
										<fmt:message key="filtrarCliente.apellido2"/>
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
										<fmt:message key="filtrarCliente.fechaNacimiento"/>
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
										<fmt:message key="filtrarCliente.dni"/>
									</td>
									<td>
										<html:text 	property="dniCliente" 
													size="15" 
													maxlength="15" />
										<html:errors property="dniCliente" />
									</td>
								</tr>								
							</table>
							<table width="100%">
								<tr>
									<td align="center">
										<html:submit>
											<fmt:message key="filtrarCliente.button.buscar"/>
										</html:submit>
									</td>
								</tr>
							</table>
						</html:form>
					</center>
                </div>
              </div>
              <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a>&nbsp;|&nbsp;&copy;2006 INMOBIS Real Estate</div>

<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA PAGINA -->

			

<%@ include file="final.htm" %>
