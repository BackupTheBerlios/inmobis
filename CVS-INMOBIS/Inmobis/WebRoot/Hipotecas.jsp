<%--El t�tulo de la p�gina se debe pasar como par�metro a la cabecera--%>
<%String tituloPag = "INMOBIS Real Estate - Menu Gen&eacute;rico";%>
<%boolean esIndex=false; %>
<%@include file="cabecera.jsp" %>

<!-- Aqu� es donde va la PARTE PRINCIPAL DE LA P�GINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo espec�fico del agente-->
<%String subtitulo="Informaci&oacute;n sobre Hipoteca INMOBIS";%>
<%String tipoMenu="general";//En esta p�gina no hay posibilidad de usuarios%>
<%@include file="menu_izdo.jsp" %>
                
              <div id="content"> 
                <div class="feature"> 
                 
				  <center>
				 <IMG SRC="images/casa_hipotecas.jpg"> 
				 <P>Con Hipoteca <B>INMOB<FONT COLOR="GREEN">IS</FONT></B> podr�s conseguir la casa de tus sue�os. El servicio centralizado de Gesti�n de Pr�stamos de <B>INMOB<FONT COLOR="GREEN">IS</FONT></B> cuenta con convenios de colaboraci�n con las principales entidades bancarias para conseguir ofrecer a sus clientes los mejores productos hipotecarios del mercado.</P>

<P>Gracias al gran volumen hipotecario generado por la red <B>INMOB<FONT COLOR="GREEN">IS</FONT></B>, conseguimos condiciones preferentes para nuestros clientes. Con HIPOTECA <B>INMOB<FONT COLOR="GREEN">IS</FONT></B>, podr� mejorar las condiciones de su hipoteca actual, reunificar deudas, comprar su nueva vivienda sin tener que esperar a vender su casa, eligiendo la cuota a pagar... todo ello con un completo asesoramiento financiero y fiscal.</P>
				  <IMG SRC="images/Hipotecacalculos.gif"> 
				  </center>
             
                </div>
              </div>
              <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>
</body>
</html>
<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA P?GINA -->

			

<%@ include file="final.htm" %>  