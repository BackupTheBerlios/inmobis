<%--Los includes específicos de esta página--%>
<%@ page import="com.inmobis.struts.form.VenderPisoForm" %>
<%--El título de la página se debe pasar como parámetro a la cabecera--%>
<%String tituloPag = "&copy INMOBIS Real Estate - Vender piso";%>
<%boolean esIndex=false; %>
<%@include file="cabecera.jsp" %>

<!-- Aquí es donde va la PARTE PRINCIPAL DE LA PÁGINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo que tienen todas las paginas-->
<%String subtitulo="P&aacute;gina de Venta";%>
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
					<html:errors property="venderPiso"/>
				<html:form action="venderPiso.do"  >	
				<%VenderPisoForm form=(VenderPisoForm)sesion.getAttribute("datosPiso");%>
				<table width="100%">
					<tr>
						<td>
							<H2><fmt:message key="venderPiso.message"/></H2>
						</td>
					</tr>
				</table>
				<table width="100%">
					<tr>
						<td>
							<fmt:message key="venderPiso.fechVenta"/>	
						</td>
						<td>
							<!--Los ids se pasan ocultos-->
							<html:hidden property="idInmueble" value="<%=form.getIdInmueble()%>"/>
							<html:errors property="idInmueble" />
							<html:hidden property="idAgente" value="<%=form.getIdAgente()%>"/>
							<html:errors property="idAgente" />
							<!--El campo que se ve de esta celda-->
							<html:text 	property="fechVenta" size="15" maxlength="30" value="<%=form.getFechVenta()%>" />
							<html:errors property="fechVenta" />
						</td>
					</tr>
					<tr>
						<td>
							<fmt:message key="venderPiso.precioInicial"/>	
						</td>
						<td>
							<html:text 	property="precioInicial" size="15"	maxlength="10" value="<%=form.getPrecioInicial()%>" />
							<html:errors property="precioInicial" />
						</td>
					</tr>
					<tr>
						<td>
							<fmt:message key="venderPiso.precioFinal"/>	
						</td>
						<td>
							<html:text 	property="precioFinal" size="15"	maxlength="20" value="<%=form.getPrecioFinal()%>"/>
							<html:errors property="precioFinal" />
						</td>
					</tr>
					<tr>
						<td>
							<fmt:message key="venderPiso.ganancia"/>	
						</td>
						<td>
							<html:text 	property="ganancia" size="15" maxlength="30" value="<%=form.getGanancia()%>"/>
							<html:errors property="ganancia" />
						</td>
					</tr>
				</table>
				<br>
				<table width="100%">
					<tr>
						<td>
							<html:submit>
								<fmt:message key="venderPiso.button.vender"/>
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
