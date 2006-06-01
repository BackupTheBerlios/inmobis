<%--El t�tulo de la p�gina se debe pasar como par�metro a la cabecera--%>
<%String tituloPag = "INMOBIS Real Estate - Seguros";%>
<%boolean esIndex=false; %>
<%@include file="cabecera.jsp" %>

<!-- Aqu� es donde va la PARTE PRINCIPAL DE LA P�GINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo-->
<%String subtitulo="Otros Servicios";%>
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
					<center>
<P>Las valoraciones precisas y fiables son fundamentales para conseguir el �xito en cada inversi�n inmobiliaria. Con los servicios que ofrece el Departamento de Valoraciones de INMOBIS, estamos capacitados para realizar valoraciones de alta calidad que ayuden a nuestros clientes a tomar las decisiones inmobiliarias correctas. Ostentamos una posici�n de liderazgo en el mercado espa�ol, unida a extensos recursos y a un profundo conocimiento del mercado.</P>
					<img SRC="images/valoraciones.jpg">

<P>Comprendemos las necesidades de negocio de nuestros clientes. Un gran n�mero de bancos comerciales y de inversi�n, de sociedades, de fondos de pensiones y de agencias gubernamentales han utilizado nuestros servicios para satisfacer las necesidades de su negocio. INMOBIS sabe que muchos de sus clientes necesitan informaci�n r�pida y segura para tomar importantes decisiones estrat�gicas. Por eso, empleamos nuestro conocimiento y experiencia para aplicar procedimientos �giles y eficaces en la recogida y el an�lisis de datos. Se trata de un proceso que nos permite a�adir valor, y colaborar como una parte integral del equipo de negocio de nuestros clientes.</P>

<P>Nuestra avanzada tecnolog�a, acompa�ada de recursos para obtener informaci�n del mercado, ayudan a nuestros clientes a tomar decisiones m�s competitivas. Nuestra informaci�n procede de fuentes fiables y complejas, reforzadas por la m�s completa base de datos de propiedades comerciales y residenciales.</P>



					</center>

                </div>
              </div>
              <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>
</body>
</html>
<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA P?GINA -->

			

<%@ include file="final.htm" %>  