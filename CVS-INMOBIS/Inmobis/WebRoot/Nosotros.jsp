<%--El t�tulo de la p�gina se debe pasar como par�metro a la cabecera--%>
<%String tituloPag = "INMOBIS Real Estate - Seguros";%>
<%boolean esIndex=false; %>
<%@include file="cabecera.jsp" %>

<!-- Aqu� es donde va la PARTE PRINCIPAL DE LA P�GINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo-->
<%String subtitulo="Informaci&oacute;n sobre el grupo INMOBIS";%>
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
								<h2>Grupo <B>INMOB<FONT COLOR="GREEN">IS</FONT></B></h2>
							</td>
						</tr>
						<tr>
							<td align="center">
								<img SRC="images/nosotros.jpg">
							</td>
						</tr>
						<tr>
							<td>
								<br><br><br>
								<p>Con motivo de la realizaci�n de la asignatura de Ingenier�a del Software, quince personas se juntaron para dar forma al grupo INMOBIS. Este grupo de desarrolladores, especializado en plataformas web, dispone de experiencia de desarrollo en la plataforma J2EE. Tras ocho meses de intenso trabajo este grupo ha dado forma a la aplicaci�n INMOBIS, lider en el mercado de sistemas de gesti�n inmobiliario.</p>
								</td>
						</tr>
						<tr>
							<td>
								<br><br><br>
								<p>Estamos a su disposici�n para la realizaci�n de cualquier tipo de proyecto, para lo cual le ofreceremos un presupuesto sin compromiso por su parte, para que constate nuestra calidad y bajos costes frente a los de terceras empresas. Si quiere que desarrollemos su proyecto a medida p�ngase en contacto con nosotros a trav�s de la direcci�n detallada en la secci�n contacto de esta misma web.</p>
							<br><br><br>
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