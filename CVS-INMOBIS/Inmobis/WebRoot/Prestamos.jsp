<%--El título de la página se debe pasar como parámetro a la cabecera--%>
<%String tituloPag = "INMOBIS Real Estate - Seguros";%>
<%boolean esIndex=false; %>
<%@include file="cabecera.jsp" %>

<!-- Aquí es donde va la PARTE PRINCIPAL DE LA PÁGINA 
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

<P>El Préstamo Hipotecario le permite disfrutar de financiación a largo plazo con garantía hipotecaria para la compra, construcción y reforma de una vivienda o para cualquier otra destinación. Obtenga financiación por el 80% del valor de la vivienda con un plazo de pago máximo de hasta 30 años. Elija la modalidad de tipo de interés que más le convenga, tipo variable o tipo fijo, y el índice de referencia para el interés de su crédito hipotecario (IRPH Cajas, CECA o Euribor). Con la posibilidad de elegir el sistema de pago que más le convenga:</P>
<P>- Cuota fija. Las revisiones del tipo de interés no hacen variar las cuotas, sino el plazo de la disposición, disminuyéndolo o ampliándolo.</P>
<P>- Cuota variable. Las revisiones del tipo de interés provocan una variación de las cuotas mientras se mantiene el plazo de la operación.>/P>
<P>- Cuota creciente. Las cuotas se incrementan anualmente según una razón geométrica establecida en el momento de la formalización del préstamo. Además, las revisiones del tipo de interés provocan una variación de las cuotas mientras se mantiene el plazo de la operación.</P>

 
 


					</center>

                </div>
              </div>
              <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>
</body>
</html>
<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA P?GINA -->

			

<%@ include file="final.htm" %>  