<%--El título de la página se debe pasar como parámetro a la cabecera--%>
<%String tituloPag = "INMOBIS Real Estate - Mapa";%>
<%boolean esIndex=false; %>
<%@include file="cabecera.jsp" %>

<!-- Aquí es donde va la PARTE PRINCIPAL DE LA PÁGINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo-->
<%String subtitulo="Mapa del sitio web";%>
<%String tipoMenu="general";//Si no se ha registrado%>
<%
HttpSession sesion=request.getSession();
String tipoU=(String)sesion.getAttribute("tipoUsuario");
%>
<%if (tipoU != null) {%>
<%	tipoMenu = tipoU;%>
<%}%>
<%@include file="menu_izdo.jsp" %>
                
              <div id="content"> 
                <div class="feature">
					<table width="100%">
						<tr>
							<td>
								<table width="100%">
									<tr>
										<td>
											<A HREF="Financiacion.jsp" class="mapa"><IMG SRC="images/BlurMetalDg4.gif" WIDTH="11" HEIGHT="11" BORDER="0" ALT="">&nbsp;Financiación</A>
											<br><br>
										</td>
									</tr>
									<tr>
										<td>
											<A HREF="Hipotecas.jsp" class="mapa"><IMG SRC="images/BlurMetalDg4.gif" WIDTH="11" HEIGHT="11" BORDER="0" ALT="">&nbsp;Hipotecas</A>
											<br><br>
										</td>
									</tr>
									<tr>
										<td>
											<A HREF="Seguros.jsp" class="mapa"><IMG SRC="images/BlurMetalDg4.gif" WIDTH="11" HEIGHT="11" BORDER="0" ALT="">&nbsp;Seguros</A>
											<br><br>
										</td>
									</tr>
									<tr>
										<td>
											<A HREF="Privacidad.jsp" class="mapa"><IMG SRC="images/BlurMetalDg4.gif" WIDTH="11" HEIGHT="11" BORDER="0" ALT="">&nbsp;Privacidad</A>
											<br><br>
										</td>
									</tr>
									<tr>
										<td>
											<A HREF="Uso.jsp" class="mapa"><IMG SRC="images/BlurMetalDg4.gif" WIDTH="11" HEIGHT="11" BORDER="0" ALT="">&nbsp;Términos de uso</A>
											<br><br>
										</td>
									</tr>
									<tr>
										<td>
											<A HREF="Prestamos.jsp" class="mapa"><IMG SRC="images/BlurMetalDg4.gif" WIDTH="11" HEIGHT="11" BORDER="0" ALT="">&nbsp;Préstamos</A>
											<br><br>
										</td>
									</tr>
									<tr>
										<td>
											<A HREF="OtrosServicios.jsp" class="mapa"><IMG SRC="images/BlurMetalDg4.gif" WIDTH="11" HEIGHT="11" BORDER="0" ALT="">&nbsp;Otros servicios</A>
										</td>
									</tr>
								</table>
							</td>
							<td>
								<IMG SRC="images/mapaTesoro.jpg" WIDTH="84" HEIGHT="87" BORDER="0" ALT="">
							</td>
						</tr>
					</table>
                </div>
              </div>
              <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>
</body>
</html>
<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA P?GINA -->

			

<%@ include file="final.htm" %>  