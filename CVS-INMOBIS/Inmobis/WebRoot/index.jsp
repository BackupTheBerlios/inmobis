<%--El t�tulo de la p�gina se debe pasar como par�metro a la cabecera--%>
<%String tituloPag = "&copy INMOBIS Real Estate";%>
<%boolean esIndex=true; %>
<%@include file="cabecera.jsp" %>

<!-- Aqu� es donde va la PARTE PRINCIPAL DE LA P�GINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo que tienen todas las paginas-->
<%String subtitulo="P&aacute;gina Principal";%>
<%String tipoMenu="general";%>
<%
HttpSession sesion=request.getSession();
String tipoU=(String)sesion.getAttribute("tipoUsuario");
%>
<%if (tipoU != null) {%>
<%	tipoMenu = tipoU;%>
<%}%>
<%@ include file="menu_izdo.jsp" %>

              <div id="content"> 
                <div class="feature"> 
                  <h3>&iquest;Qu&eacute; es <img src="images/inmobis1.jpg" title="INMOBIS" alt="INMOBIS" width="333"></h3><br><br>
                  <p> Nuestro software consigue mantener m�s contentos y seguros 
                    a los clientes y a los agentes con ello les proporciona una 
                    mayor promoci�n y entrada de clientes. Teniendo en cuenta 
                    la incertidumbre en la que viven los agentes inmobiliarios, 
                    sabiendo lo que han vendido ya, pero no si podr�n vender ma�ana, 
                    el respaldo de un sistema as� les proporciona una mayor seguridad 
                    con la que trabajar m�s a gusto y por ello mejor. </p>
					
					
					<center> <img src="images/mapa.jpg" title="INMOBIS" alt="INMOBIS" width="333"> </center>
					
					
					
                </div>
              </div>
              <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>

<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA P�GINA -->

			

<%@ include file="final.htm" %>  
  

