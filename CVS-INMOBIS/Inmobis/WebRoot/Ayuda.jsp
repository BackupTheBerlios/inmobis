<%--El título de la página se debe pasar como parámetro a la cabecera--%>
<%String tituloPag = "INMOBIS Real Estate - Seguros";%>
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
					<center>
<P>A nuestros visitantes:</P>

<P>La estructura de este sitio ha sido organizada para mostrar en primer lugar las áreas de mayor interés para los posibles visitantes. La elaboración se ha efectuado procurando conciliar la claridad, la agilidad y el contenido informativo.</P>

<P>Sugerencias:</P>

<P>Para acceder rápidamente a la información que desea consultar, visite el Indice del Sitio.</P>

<P>Si desea volver a la página principal de INMOBIS desde cualquier página, haga clic en el enlace Inicio en la parte superior izquierda de la página.</P>

<P>Todos los contenidos de este sitio web son accesibles con Mozilla Firefox y Microsoft Internet Explorer</P>

<P>Si tiene algún comentario que hacernos visite la sección de contacto.</P>





					</center>

                </div>
              </div>
              <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>
</body>
</html>
<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA P?GINA -->

			

<%@ include file="final.htm" %>  