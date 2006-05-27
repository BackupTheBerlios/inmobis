<%--ESTO ES SOLO UNA PRUEBA PARA VER QUE SE PASAN BIEN LOS DATOS.
BORRAR CUANDO LOS VER SEAN DEFINITIVOS.--%>
<%String tituloPag = "INMOBIS Real Estate - Prueba de modificar";%>
<%boolean esIndex=false; %>
<%@include file="cabecera.jsp" %>

<!-- Aquí es donde va la PARTE PRINCIPAL DE LA PÁGINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo específico del administrador-->
<%String subtitulo="P&aacute;gina de registro de empleado por el administrador";%>
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
			<html:errors property="editaClientePrev"/>

			<html:form action="editaClientePrev.do" focus="calle">
				<table align="center" >
					<tr align="center">
						<td><H1>P&aacute;gina de prueba</H1></td>
					</tr>
					<tr align="center">
						<td>
							<table align="center">
								<tr>
									<td colspan="2" align="center">
										<html:submit>
											Enviar
										</html:submit>
										<html:reset>
											Cancelar
										</html:reset>
									</td>
								</tr>
								
							</table>
						</td>
					</tr>
				</table>
			</html:form>

			</div>
         </div>
         <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>
</body>
</html>
<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA PÁGINA -->

			

<%@ include file="final.htm" %>  
