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
					<FORM METHOD=POST ACTION="">
					<%MensajeForm form=(MensajeForm)sesion.getAttribute("datosMensaje");%>
					<table width="100%">
						<tr>  
							<td>   
								<fmt:message key="verMensaje.nombreOrigen"/>
							</td>     
							<td>
								<input type="text" name="nombreOrigen" value="<%=form.getNombreOrigen()%>" readonly >
							</td>
						</tr>
						<tr>  
							<td>   
								<fmt:message key="verMensaje.nombreDestino"/>
							</td>     
							<td>
								<input type="text" name="nombrerDestino" value="<%=form.getNombreDestino()%>" readonly>
							</td>
						</tr>
						<tr>  
							<td>   
								<fmt:message key="verMensaje.fecha"/>
							</td>     
							<td>
								<!--HABRÁ QUE PONER BIEN EL FORMATO-->
								<input type="text" name="fecha" value="<%=form.getFecha()%>" readonly >
							</td>
						</tr>
						<tr>  
							<td>   
								<fmt:message key="verMensaje.leido"/>
							</td>     
							<td>
								<input type="text" name="leido" value="<%=form.getLeido()%>" readonly>
							</td>
						</tr>
						<tr>  
							<td>   
								<fmt:message key="verMensaje.asunto"/>
							</td>     
							<td>
								<input type="text" name="asunto" value="<%=form.getAsunto()%>" readonly>
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
								<TEXTAREA rows="5" cols="80" NAME="texto" >
									<%=form.getTexto()%>
								</TEXTAREA>
							</td>
						</tr>
					</table>
					</FORM>                  
                </div>
              </div>
              <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>

<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA PÁGINA -->

			

<%@ include file="final.htm" %>  