<%--Los includes específicos de esta página--%>
<%@ page import="com.inmobis.struts.form.MensajeForm" %>
<%--El título de la página se debe pasar como parámetro a la cabecera--%>
<%String tituloPag = "&copy INMOBIS Real Estate - Ver mensaje";%>
<%boolean esIndex=false; %>
<%@include file="cabecera.jsp" %>

<!-- Aquí es donde va la PARTE PRINCIPAL DE LA PÁGINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo que tienen todas las paginas-->
<%String subtitulo="Vista de mensaje";%>
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
					<!--Es un form para poner los datos en el mismo formato de toda la aplicación-->
					<html:form action="verMensaje.do"  >
					<%MensajeForm form=(MensajeForm)sesion.getAttribute("mensaje");%>
					<table width="100%">
						<tr>  
							<td>   
								<fmt:message key="verMensaje.nombreOrigen"/>
							</td>     
							<td>
								<html:text property="nombreOrigen" size="25" maxlength="25" value="<%=form.getNombreOrigen()%>" readonly="true" />
							</td>
						</tr>
						
						<tr>
						<td>
							<fmt:message key="verMensaje.fecha"/>
						</td> 
						<td>							
							<html:text property="fecha" size="25" maxlength="25" value="<%=form.getFecha()%>" readonly="true" />
						</td>
					 </tr>
												
						<tr>  
							<td>   
								<fmt:message key="verMensaje.asunto"/>
							</td>     
							<td>
								<html:text property="asunto" size="25" maxlength="25" value="<%=form.getAsunto()%>" readonly="true" />
							</td>
						</tr>
						<!--El texto en una fila porque puede ser largo-->
						<tr>  
							<td colspan = "2">   
								<fmt:message key="verMensaje.texto"/>
							</td> 
						</tr>
						<tr>
							<td colspan = "2">
								<TEXTAREA rows="5" cols="80" NAME="texto" readonly="true">
									<%=form.getTexto()%>
								</TEXTAREA>
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