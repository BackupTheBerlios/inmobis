<%--El t�tulo de la p�gina se debe pasar como par�metro a la cabecera--%>
<%String tituloPag = "INMOBIS Real Estate - Seguros";%>
<%boolean esIndex=false; %>
<%@include file="cabecera.jsp" %>

<!-- Aqu� es donde va la PARTE PRINCIPAL DE LA P�GINA 
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

<P>INMOBIS ha elaborado esta declaraci�n sobre la privacidad de los datos para corroborar el compromiso con la protecci�n de la privacidad de sus usuarios. EN NING�N SUPUESTO INMOBIS DAR� A CONOCER A NING�N TERCERO INFORMACI�N QUE IDENTIFIQUE A SUS USUARIOS INDIVIDUALMENTE, SIN UNA AUTORIZACI�N EXPRESA DE DICHOS USUARIOS.</P>

<P>INMOBIS trabaja con datos personales de usuarios a la hora del alta para poder acceder al sistema. En el momento del alta, la baja y la modificaci�n de los datos,INMOBIS solicita el nombre del usuario y su direcci�n de correo electr�nico; y puede llegar a pedir informaci�n adicional que en cualquier caso es voluntaria.</P>

<P>Si tiene cualquier duda o comentario sobre la forma en que INMOBIS utiliza los datos de sus usuarios y suscriptores, puede ponerse en contacto con nosotros a trav�s de la direcci�n incluida en la secci�n contacto.</P>

					</center>

                </div>
              </div>
              <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>
</body>
</html>
<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA P?GINA -->

			

<%@ include file="final.htm" %>  