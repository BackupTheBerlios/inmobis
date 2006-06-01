<%--El título de la página se debe pasar como parámetro a la cabecera--%>
<%String tituloPag = "INMOBIS Real Estate - Uso";%>
<%boolean esIndex=false; %>
<%@include file="cabecera.jsp" %>

<!-- Aquí es donde va la PARTE PRINCIPAL DE LA PÁGINA 
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
								<P>Esta página establece las "Condiciones Generales" que regulan el uso de INMOBIS (en adelante, el "Sitio Web"). Por favor, lea esta página atentamente. Si no acepta estas Condiciones Generales, no utilice este Sitio Web y ni este servicio. Al utilizar este Sitio Web, usted declara la aceptación de las Condiciones Generales que estén vigentes en el momento de acceso. El grupo INMOBIS titular del Sitio Web (en adelante, la "Compañía") puede revisar estas Condiciones Generales en cualquier momento, actualizando esta página. Ud. debería visitar esta página cada vez que acceda al Sitio para revisar las Condiciones Generales, puesto que le vinculan. Los términos "Usted" y "Usuario" se emplean aquí para referirse a todos los individuos y/o entidades que por cualquier razón accedan a este sitio de la web.</P>
							</td>
						</tr>
						<tr>
							<td>
								<br><br><br>
								<P>El uso del Material<br>
								La Compañía le autoriza a visualizar y descargar (bajar) una única copia de los contenidos de INMOBIS solamente para su uso personal y no comercial.</P>
							</td>
						</tr>
						<tr>
							<td>
								<br><br><br>
								<P>Los contenidos de este Sitio Web, tales como texto, gráficos, imágenes, logos, iconos de botón, software y cualquier otro material, todo lo cual designaremos como "el Material", están protegidos por la legislación sobre propiedad industrial e intelectual (Derechos de Autor, copyright, marcas registradas) de España, de los Estados Unidos y de otros países. Todo el Material es propiedad de la Compañía, de cualquier otra compañía del grupo al que pertenece, de sus proveedores de contenido o de sus clientes. La compilación (es decir, la recopilación, la disposición y el montaje) de todos los contenidos de este Sitio Web es de propiedad exclusiva de la Compañía (o de cualquier otra compañía del grupo al que pertenece) y está protegida por la legislación sobre propiedad industrial e intelectual de España, de los Estados Unidos y de otros países. El uso no autorizado del Material puede suponer la violación de la legislación sobre propiedad intelectual o industrial (derechos de autor, marca registrada, etc.) y de otras leyes aplicables.</P>
							</td>
						</tr>
						<tr>
							<td>
								<br><br><br>
								<P>Usted debe conservar todas las advertencias sobre derechos de autor, marca registrada, marca de servicio y otras relativas a los derechos de propiedad industrial o intelectual contenidas en el Material original en cualquier copia que haga del Material. No podrá vender o modificar el Material o reproducirlo, exhibirlo, representarlo en público, distribuirlo, o hacer otro uso de este Material con fines comerciales o de difusión. Está prohibido el uso del Material en cualquier otro sitio de la web o en otro entorno de ordenadores interconectados para cualquier fin.</P>
							</td>
						</tr>
						<tr>
							<td>
								<br><br><br>
								<P>Usted no copiará ni adaptará el código HTML que la Compañía ha creado para generar sus páginas. Éste se halla protegido también por los derechos de propiedad intelectual (copyright) de la Compañía o de cualquier otra compañía del grupo al que pertenece.</P>
							</td>
						</tr>
						<tr>
							<td>
								<br><br><br>
								<P>Uso permitido del Sitio<br>
								Reglas generales: A los usuarios no les está permitido utilizar el Sitio Web para transmitir, distribuir, almacenar o destruir material (a) violando las leyes o regulaciones vigentes, (b) de forma que infrinjan el derecho de autor, la marca registrada, el secreto comercial o cualquier otro derecho de propiedad intelectual o industrial de terceros o violando la confidencialidad, imagen pública o demás derechos personales de otras personas, o (c) que sea difamatorio, obsceno, amenazador, injurioso u ofensivo.</P>
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