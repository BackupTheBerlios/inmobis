<%--El t�tulo de la p�gina se debe pasar como par�metro a la cabecera--%>
<%String tituloPag = "INMOBIS Real Estate - Seguros";%>
<%boolean esIndex=false; %>
<%@include file="cabecera.jsp" %>

<!-- Aqu� es donde va la PARTE PRINCIPAL DE LA P�GINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo-->
<%String subtitulo="Informaci&oacute;n sobre prestamos";%>
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

<P>El Pr�stamo Hipotecario le permite disfrutar de financiaci�n a largo plazo con garant�a hipotecaria para la compra, construcci�n y reforma de una vivienda o para cualquier otra destinaci�n. Obtenga financiaci�n por el 80% del valor de la vivienda con un plazo de pago m�ximo de hasta 30 a�os. Elija la modalidad de tipo de inter�s que m�s le convenga, tipo variable o tipo fijo, y el �ndice de referencia para el inter�s de su cr�dito hipotecario (IRPH Cajas, CECA o Euribor). Con la posibilidad de elegir el sistema de pago que m�s le convenga:</P>
<P>- Cuota fija. Las revisiones del tipo de inter�s no hacen variar las cuotas, sino el plazo de la disposici�n, disminuy�ndolo o ampli�ndolo.</P>
<P>- Cuota variable. Las revisiones del tipo de inter�s provocan una variaci�n de las cuotas mientras se mantiene el plazo de la operaci�n.>/P>
<P>- Cuota creciente. Las cuotas se incrementan anualmente seg�n una raz�n geom�trica establecida en el momento de la formalizaci�n del pr�stamo. Adem�s, las revisiones del tipo de inter�s provocan una variaci�n de las cuotas mientras se mantiene el plazo de la operaci�n.</P>

 
 


					</center>

                </div>
              </div>
              <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>
</body>
</html>
<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA P?GINA -->

			

<%@ include file="final.htm" %>  