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

<P><A HREF="Financiacion.jsp">Financiaci�n</A>
<P><A HREF="Hipotecas.jsp">Hipotecas</A>
<P><A HREF="Seguros.jsp">Seguros</A>
<P><A HREF="Privacidad.jsp">Privacidad</A>
<P><A HREF="Uso.jsp">T�rminos de uso</A>
<P><A HREF="Prestamos.jsp">Pr�stamos</A>
<P><A HREF="OtrosServicios.jsp">Otros servicios</A>




					</center>

                </div>
              </div>
              <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>
</body>
</html>
<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA P?GINA -->

			

<%@ include file="final.htm" %>  