<%--Librería específica de esta página: Logic, para usar el iterator--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%--El título de la página se debe pasar como parámetro a la cabecera--%>
<%String tituloPag = "&copy INMOBIS Real Estate - Filtrado de pisos vendidos";%>
<%boolean esIndex=false; %>
<%@include file="cabecera.jsp" %>

<!-- Aquí es donde va la PARTE PRINCIPAL DE LA PÁGINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo que tienen todas las paginas-->
<%String subtitulo="P&aacute;gina de Listado";%>
<%String tipoMenu="general";//Si no se ha registrado%>
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
					<html:errors property="filtrarPisosVendidos"/>
					<html:form action="filtrarPisosVendidos.do">
						<table width="100%">
							<tr>
								<td><H2><fmt:message key="filtrarPisosVendidos.message"/></H2></td>
							</tr>
						</table>							
						<table border="0" width="100%">
						<!--ESTO DE LAS FECHAS HABRÁ QUE CAMBIARLO PORQUE SERÁ CON DÍA MES Y AÑO-->
							<tr>
								<td width="30%">
									<fmt:message key="filtrarPisosVendidos.fechIni"/>
								</td>
								<td>
									<html:text 	property="fechIni" maxlength="30" />
									<html:errors property="fechIni" />
								</td>
							</tr>
							<tr>
								<td width="30%">
									<fmt:message key="filtrarPisosVendidos.fechFin"/>
								</td>
								<td>
									<html:text 	property="fechFin" maxlength="30" />
									<html:errors property="fechFin" />
								</td>
							</tr>	
							<tr>
								<td>
									<fmt:message key="filtrarPisosVendidos.precioInicial"/>
								</td>
								<td>
									<html:text 	property="precioInicial" maxlength="30" />&nbsp;Euros
									<html:errors property="precioInicial" />
								</td>
							</tr>	
							<tr>
								<td>
									<fmt:message key="filtrarPisosVendidos.precioFinal"/>
								</td>
								<td>
									<html:text property="precioFinal" maxlength="30" />&nbsp;Euros
									<html:errors property="precioFinal" />
								</td>
							</tr>
							<tr>
								<td>
									<fmt:message key="filtrarPisosVendidos.ganancia"/>
								</td>
								<td>
									<html:text 	property="ganacia" maxlength="30" />
									<html:errors property="ganacia" />
								</td>
							</tr>							
						</table>
						<br><br>
							<table width="100%">
								<tr>
									<td align="center">
										<html:submit>
											<fmt:message key="filtrarPisosVendidos.button.buscar"/>
										</html:submit>
									</td>
								</tr>
							</table>
					</html:form> 
                </div>
              </div>
              <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>

<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA PÁGINA -->

			

<%@ include file="final.htm" %>  
