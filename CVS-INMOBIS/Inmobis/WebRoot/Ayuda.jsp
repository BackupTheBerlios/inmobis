<%--El t�tulo de la p�gina se debe pasar como par�metro a la cabecera--%>
<%String tituloPag = "INMOBIS Real Estate - Seguros";%>
<%boolean esIndex=false; %>
<%@include file="cabecera.jsp" %>

<!-- Aqu� es donde va la PARTE PRINCIPAL DE LA P�GINA 
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

<P>La estructura de este sitio ha sido organizada para mostrar en primer lugar las �reas de mayor inter�s para los posibles visitantes. La elaboraci�n se ha efectuado procurando conciliar la claridad, la agilidad y el contenido informativo.</P>

<P>Sugerencias:</P>

<P>Para acceder r�pidamente a la informaci�n que desea consultar, visite el Indice del Sitio.</P>

<P>Si desea volver a la p�gina principal de INMOBIS desde cualquier p�gina, haga clic en el enlace Inicio en la parte superior izquierda de la p�gina.</P>

<P>Todos los contenidos de este sitio web son accesibles con Mozilla Firefox y Microsoft Internet Explorer</P>

<P>Si tiene alg�n comentario que hacernos visite la secci�n de contacto.</P>





					</center>

                </div>
              </div>
              <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>
</body>
</html>
<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA P?GINA -->

			

<%@ include file="final.htm" %>  