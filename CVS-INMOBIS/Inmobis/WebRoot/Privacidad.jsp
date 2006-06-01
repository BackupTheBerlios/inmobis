<%--El título de la página se debe pasar como parámetro a la cabecera--%>
<%String tituloPag = "INMOBIS Real Estate - Seguros";%>
<%boolean esIndex=false; %>
<%@include file="cabecera.jsp" %>

<!-- Aquí es donde va la PARTE PRINCIPAL DE LA PÁGINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo-->
<%String subtitulo="Informaci&oacute;n sobre privacidad";%>
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

<P>INMOBIS ha elaborado esta declaración sobre la privacidad de los datos para corroborar el compromiso con la protección de la privacidad de sus usuarios. EN NINGÚN SUPUESTO INMOBIS DARÁ A CONOCER A NINGÚN TERCERO INFORMACIÓN QUE IDENTIFIQUE A SUS USUARIOS INDIVIDUALMENTE, SIN UNA AUTORIZACIÓN EXPRESA DE DICHOS USUARIOS.</P>

<P>INMOBIS trabaja con datos personales de usuarios a la hora del alta para poder acceder al sistema. En el momento del alta, la baja y la modificación de los datos,INMOBIS solicita el nombre del usuario y su dirección de correo electrónico; y puede llegar a pedir información adicional que en cualquier caso es voluntaria.</P>

<P>Si tiene cualquier duda o comentario sobre la forma en que INMOBIS utiliza los datos de sus usuarios y suscriptores, puede ponerse en contacto con nosotros a través de la dirección incluida en la sección contacto.</P>

					</center>

                </div>
              </div>
              <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>
</body>
</html>
<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA P?GINA -->

			

<%@ include file="final.htm" %>  