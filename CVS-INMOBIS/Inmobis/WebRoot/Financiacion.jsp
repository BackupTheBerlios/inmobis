<%--El t�tulo de la p�gina se debe pasar como par�metro a la cabecera--%>
<%String tituloPag = "INMOBIS Real Estate - Menu Gen&eacute;rico";%>
<%boolean esIndex=false; %>
<%@include file="cabecera.jsp" %>

<!-- Aqu� es donde va la PARTE PRINCIPAL DE LA P�GINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo espec�fico del agente-->
<%String subtitulo="Informaci&oacute;n sobre Financiaci�n con INMOBIS";%>
<%String tipoMenu="general";//En esta p�gina no hay posibilidad de usuarios%>
<%@include file="menu_izdo.jsp" %>
                
              <div id="content"> 
                <div class="feature"> 
                 
				  <center>
				 <IMG SRC="images/logoLaCaixa.gif"> 
				 <P><B>INMOB<FONT COLOR="GREEN">IS</FONT></B> Real Estate mantiene un acuerdo preferencial con La Caixa para la financiaci�n por parte de sus clientes de las adquisiciones inmobiliarias que estos realicen. La financiaci�n incluye una rebaja significativa en el tipo de inter�s situ�ndose este al 1,5% TAE en hipotecas a m�s de 20 a�os.</P>

<P>La experiencia adquirida por nuestra compa��a a lo largo de los �ltimos a�os, nos ha hecho abrir un nuevo tipo de servicio orientado especialmente a los j�venes con pocos ingresos que buscan acceder a su primera vivienda. Para ellos tenemos el plan 30 metros, para dar cabida a sus aspiraciones de independencia paternal.</P>
<P>Caja de Ahorros y Pensiones de Barcelona, "la Caixa". Inscrita en el Registro Administrativo Especial del Banco de Espa�a con el n�mero 2100 y en el Registro Especial de Cajas de Ahorro de la Generalitat de Catalunya con el n�mero 1. Entidad sujeta a la supervisi�n del Banco de Espa�a y del Departament d'Economia i Finances de la Generalitat de Catalunya e inscrita en el Registro Mercantil de Barcelona, tomo 20397, folio 1, hoja B-5614, n�mero 3003.</P>

				  </center>
             
                </div>
              </div>
              <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>
</body>
</html>
<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA P?GINA -->

			

<%@ include file="final.htm" %>  