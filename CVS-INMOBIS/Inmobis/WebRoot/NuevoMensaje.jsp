<!--HAY QUE HACER UN IMPORT PARA COGER LA FECHA DE HOY-->
<%--El título de la página se debe pasar como parámetro a la cabecera--%>
<%String tituloPag = "&copy INMOBIS Real Estate - Nuevo mensaje";%>
<%boolean esIndex=false; %>
<%@include file="cabecera.jsp" %>

<!-- Aquí es donde va la PARTE PRINCIPAL DE LA PÁGINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo que tienen todas las paginas-->
<%String subtitulo="Crear nuevo mensaje";%>
<%String tipoMenu="general";//Si no se ha registrado%>
<%
HttpSession sesion=request.getSession();
String tipoU=(String)sesion.getAttribute("tipoUsuario");
String nombreO = (String)sesion.getAttribute("userName");
%>
<%if (tipoU != null) {%>
<%	tipoMenu = tipoU;%>
<%}%><%@ include file="menu_izdo.jsp" %>
              <div id="content"> 
                <div class="feature"> 
					<html:errors property="enviarMensaje"/>
					<html:form action="enviarMensaje.do" >
					<table width="100%">
						<tr>
							<td>
								<H2><fmt:message key="nuevoMensaje.message"/></H2>
							</td>
						</tr>
					</table> 
					<table width="100%">
						<tr>  
							<td>   
								<fmt:message key="nuevoMensaje.nombreOrigen"/>
							</td>     
							<td>
								<html:text 	property="nombreOrigen" maxlength="50" readonly="true" value="<%=nombreO%>"/>
								<html:errors property="nombreOrigen"/>
							</td>
						</tr>
						<tr>  
							<td>   
								<fmt:message key="nuevoMensaje.nombreDestino"/>
							</td>     
							<td>
								<html:text 	property="nombreDestino" maxlength="50" />
								<html:errors property="nombreDestino"/>
							</td>
						</tr>
						<tr>  
							<td>   
								<fmt:message key="nuevoMensaje.fecha"/>
							</td>     
							<td>
								<html:text 	property="fecha" maxlength="50" />
								<!--HAY QUE PONER LA FECHA DEL DÍA DE HOY CON Date x= newDate(), HAY QUE SABER EL FORMATO DE LOS DATOS (es AAAAMMDD??)-->
								<html:errors property="fecha"/>
							</td>
						</tr>
						<tr>  
							<td>   
								<fmt:message key="nuevoMensaje.asunto"/>
							</td>     
							<td>
								<html:text 	property="asunto" maxlength="50" />
								<html:errors property="asunto"/>
							</td>
						</tr>
						<!--El texto en una fila porque puede ser largo-->
						<tr>  
							<td colspan = "2">   
								<fmt:message key="nuevoMensaje.texto"/>
							</td> 
						</tr>
						<tr>
							<td colspan = "2">
								<html:textarea 	property="texto" rows="5" cols="80" />
								<html:errors property="texto"/>
							</td>
						</tr>
					</table>
					<table width="100%">
						<tr>
							<td>	
								<html:submit>
									<fmt:message key="nuevoMensaje.button.signon"/>
								</html:submit>
							</td>
							<td>
								<html:reset>
									<fmt:message key="nuevoMensaje.button.reset"/>
								</html:reset>
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