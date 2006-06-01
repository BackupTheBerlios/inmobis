<%--El título de la página se debe pasar como parámetro a la cabecera--%>
<%String tituloPag = "INMOBIS Real Estate - Hipotecas";%>
<%boolean esIndex=false; %>
<%@include file="cabecera.jsp" %>

<!-- Aquí es donde va la PARTE PRINCIPAL DE LA PÁGINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo-->
<%String subtitulo="Informaci&oacute;n";%>
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
								<h2>Hipoteca <B>INMOB<FONT COLOR="GREEN">IS</FONT></B></h2>
							</td>
						</tr>
						<tr>
							<td align="center">
								<IMG SRC="images/casa_hipotecas.jpg">
							</td>
						</tr>
						<tr>
							<td>
								<br><br><br>
								<P>Con Hipoteca <B>INMOB<FONT COLOR="GREEN">IS</FONT></B> podr&aacute;s conseguir la casa de tus sue&ntilde;os. El servicio centralizado de Gesti&oacute;n de Pr&eacute;stamos de <B>INMOB<FONT COLOR="GREEN">IS</FONT></B> cuenta con convenios de colaboraci&oacute;n con las principales entidades bancarias para conseguir ofrecer a sus clientes los mejores productos hipotecarios del mercado</P>
							</td>
						</tr>
						<tr>
							<td>
								<br><br><br>
								<P>Gracias al gran volumen hipotecario generado por la red <B>INMOB<FONT COLOR="GREEN">IS</FONT></B>, conseguimos condiciones preferentes para nuestros clientes. Con HIPOTECA <B>INMOB<FONT COLOR="GREEN">IS</FONT></B>, podr&aacute; mejorar las condiciones de su hipoteca actual, reunificar deudas, comprar su nueva vivienda sin tener que esperar a vender su casa, eligiendo la cuota a pagar... todo ello con un completo asesoramiento financiero y fiscal.</P>
								<br><br><br>
							</td>
						</tr>
						<tr>
							<td align="center">
								<IMG SRC="images/Hipotecacalculos.gif"> 
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