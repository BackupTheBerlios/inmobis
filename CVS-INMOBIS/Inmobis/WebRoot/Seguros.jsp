<%--El t�tulo de la p�gina se debe pasar como par�metro a la cabecera--%>
<%String tituloPag = "INMOBIS Real Estate - Seguros";%>
<%boolean esIndex=false; %>
<%@include file="cabecera.jsp" %>

<!-- Aqu� es donde va la PARTE PRINCIPAL DE LA P�GINA 
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
								<h2>Seguros <B>INMOB<FONT COLOR="GREEN">IS</FONT></B></h2>
							</td>
						</tr>
						<tr>
							<td>
								<br><br><br>
								<P><B>INMOB<FONT COLOR="GREEN">IS</FONT></B> Hogar es un seguro multirriesgo pensado y dise�ado para dar protecci�n frente a una amplia gama de riesgos relativos a la vivienda y a las responsabilidades derivadas de la misma y de las personas que la habitan. Esta p�liza ofrece, a trav�s de sus diferentes modalidades de contrataci�n, un conjunto de garant�as y prestaciones que la hacen adaptarse a las especiales necesidades de cobertura que puede precisar una vivienda, ya sea habitual o secundaria, ya sea piso, casa adosada, chalet o casa de pueblo.</P>
								<br><br>
							</td>
						</tr>
						<tr>
							<td align="center">
								<IMG SRC="images/seguro.jpg" WIDTH="68" HEIGHT="102" BORDER="0" ALT="">
							</td>
						</tr>
						<tr>
							<td>
								<br><br><br>
								<P><u>Riesgos Asegurados</u></P>
							</td>
						</tr>
						<tr>
							<td>
								<br>
								<P>Las garant�as de la p�liza se pueden agrupar en tres tipos de coberturas para facilitar su estudio:</P>
							</td>
						</tr>
						<tr>
							<td>
								<br>
								<P>A. Da�os materiales: Reparaci�n o reposici�n de los bienes objeto del seguro y los gastos relacionados directamente con ellos.</P>
							</td>
						</tr>
						<tr>
							<td>
								<br>
								<P>B. Responsabilidad Civil: Indemnizaci�n a un tercero de los da�os y/o perjuicios causados por nuestro asegurado cuando sea civilmente responsable.</P>
							</td>
						</tr>
						<tr>
							<td>
								<br>
								<P>C. Servicios: Donde englobamos urgencias dom�sticas, asistencia en el hogar, asesoramiento y protecci�n jur�dica. Su utilizaci�n es tan sencilla como realizar una simple llamada telef�nica.</P>
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