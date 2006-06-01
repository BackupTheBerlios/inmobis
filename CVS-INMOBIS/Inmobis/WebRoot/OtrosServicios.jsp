<%--El título de la página se debe pasar como parámetro a la cabecera--%>
<%String tituloPag = "INMOBIS Real Estate - Seguros";%>
<%boolean esIndex=false; %>
<%@include file="cabecera.jsp" %>

<!-- Aquí es donde va la PARTE PRINCIPAL DE LA PÁGINA 
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
<P>Las valoraciones precisas y fiables son fundamentales para conseguir el éxito en cada inversión inmobiliaria. Con los servicios que ofrece el Departamento de Valoraciones de INMOBIS, estamos capacitados para realizar valoraciones de alta calidad que ayuden a nuestros clientes a tomar las decisiones inmobiliarias correctas. Ostentamos una posición de liderazgo en el mercado español, unida a extensos recursos y a un profundo conocimiento del mercado.</P>
					<img SRC="images/valoraciones.jpg">

<P>Comprendemos las necesidades de negocio de nuestros clientes. Un gran número de bancos comerciales y de inversión, de sociedades, de fondos de pensiones y de agencias gubernamentales han utilizado nuestros servicios para satisfacer las necesidades de su negocio. INMOBIS sabe que muchos de sus clientes necesitan información rápida y segura para tomar importantes decisiones estratégicas. Por eso, empleamos nuestro conocimiento y experiencia para aplicar procedimientos ágiles y eficaces en la recogida y el análisis de datos. Se trata de un proceso que nos permite añadir valor, y colaborar como una parte integral del equipo de negocio de nuestros clientes.</P>

<P>Nuestra avanzada tecnología, acompañada de recursos para obtener información del mercado, ayudan a nuestros clientes a tomar decisiones más competitivas. Nuestra información procede de fuentes fiables y complejas, reforzadas por la más completa base de datos de propiedades comerciales y residenciales.</P>



					</center>

                </div>
              </div>
              <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>
</body>
</html>
<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA P?GINA -->

			

<%@ include file="final.htm" %>  