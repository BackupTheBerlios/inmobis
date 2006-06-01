<%--El t�tulo de la p�gina se debe pasar como par�metro a la cabecera--%>
<%String tituloPag = "INMOBIS Real Estate - Uso";%>
<%boolean esIndex=false; %>
<%@include file="cabecera.jsp" %>

<!-- Aqu� es donde va la PARTE PRINCIPAL DE LA P�GINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo-->
<%String subtitulo="T&eacute;rminos de uso";%>
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
								<h2>Uso de <B>INMOB<FONT COLOR="GREEN">IS</FONT></B></h2>
							</td>
						</tr>
						<tr>
							<td>
								<br><br><br>
								<P>Esta p�gina establece las "Condiciones Generales" que regulan el uso de INMOBIS (en adelante, el "Sitio Web"). Por favor, lea esta p�gina atentamente. Si no acepta estas Condiciones Generales, no utilice este Sitio Web y ni este servicio. Al utilizar este Sitio Web, usted declara la aceptaci�n de las Condiciones Generales que est�n vigentes en el momento de acceso. El grupo INMOBIS titular del Sitio Web (en adelante, la "Compa��a") puede revisar estas Condiciones Generales en cualquier momento, actualizando esta p�gina. Ud. deber�a visitar esta p�gina cada vez que acceda al Sitio para revisar las Condiciones Generales, puesto que le vinculan. Los t�rminos "Usted" y "Usuario" se emplean aqu� para referirse a todos los individuos y/o entidades que por cualquier raz�n accedan a este sitio de la web.</P>
							</td>
						</tr>
						<tr>
							<td>
								<br><br><br>
								<P>El uso del Material<br>
								La Compa��a le autoriza a visualizar y descargar (bajar) una �nica copia de los contenidos de INMOBIS solamente para su uso personal y no comercial.</P>
							</td>
						</tr>
						<tr>
							<td>
								<br><br><br>
								<P>Los contenidos de este Sitio Web, tales como texto, gr�ficos, im�genes, logos, iconos de bot�n, software y cualquier otro material, todo lo cual designaremos como "el Material", est�n protegidos por la legislaci�n sobre propiedad industrial e intelectual (Derechos de Autor, copyright, marcas registradas) de Espa�a, de los Estados Unidos y de otros pa�ses. Todo el Material es propiedad de la Compa��a, de cualquier otra compa��a del grupo al que pertenece, de sus proveedores de contenido o de sus clientes. La compilaci�n (es decir, la recopilaci�n, la disposici�n y el montaje) de todos los contenidos de este Sitio Web es de propiedad exclusiva de la Compa��a (o de cualquier otra compa��a del grupo al que pertenece) y est� protegida por la legislaci�n sobre propiedad industrial e intelectual de Espa�a, de los Estados Unidos y de otros pa�ses. El uso no autorizado del Material puede suponer la violaci�n de la legislaci�n sobre propiedad intelectual o industrial (derechos de autor, marca registrada, etc.) y de otras leyes aplicables.</P>
							</td>
						</tr>
						<tr>
							<td>
								<br><br><br>
								<P>Usted debe conservar todas las advertencias sobre derechos de autor, marca registrada, marca de servicio y otras relativas a los derechos de propiedad industrial o intelectual contenidas en el Material original en cualquier copia que haga del Material. No podr� vender o modificar el Material o reproducirlo, exhibirlo, representarlo en p�blico, distribuirlo, o hacer otro uso de este Material con fines comerciales o de difusi�n. Est� prohibido el uso del Material en cualquier otro sitio de la web o en otro entorno de ordenadores interconectados para cualquier fin.</P>
							</td>
						</tr>
						<tr>
							<td>
								<br><br><br>
								<P>Usted no copiar� ni adaptar� el c�digo HTML que la Compa��a ha creado para generar sus p�ginas. �ste se halla protegido tambi�n por los derechos de propiedad intelectual (copyright) de la Compa��a o de cualquier otra compa��a del grupo al que pertenece.</P>
							</td>
						</tr>
						<tr>
							<td>
								<br><br><br>
								<P>Uso permitido del Sitio<br>
								Reglas generales: A los usuarios no les est� permitido utilizar el Sitio Web para transmitir, distribuir, almacenar o destruir material (a) violando las leyes o regulaciones vigentes, (b) de forma que infrinjan el derecho de autor, la marca registrada, el secreto comercial o cualquier otro derecho de propiedad intelectual o industrial de terceros o violando la confidencialidad, imagen p�blica o dem�s derechos personales de otras personas, o (c) que sea difamatorio, obsceno, amenazador, injurioso u ofensivo.</P>
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