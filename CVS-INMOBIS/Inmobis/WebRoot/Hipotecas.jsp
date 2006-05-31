<%--El título de la página se debe pasar como parámetro a la cabecera--%>
<%String tituloPag = "INMOBIS Real Estate - Menu Gen&eacute;rico";%>
<%boolean esIndex=false; %>
<%@include file="cabecera.jsp" %>

<!-- Aquí es donde va la PARTE PRINCIPAL DE LA PÁGINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo específico del agente-->
<%String subtitulo="Informaci&oacute;n sobre Hipoteca INMOBIS";%>
<%String tipoMenu="general";//En esta página no hay posibilidad de usuarios%>
<%@include file="menu_izdo.jsp" %>
                
              <div id="content"> 
                <div class="feature"> 
                 
				  <center>
				 <IMG SRC="images/casa_hipotecas.jpg"> 
				 <P>Con Hipoteca <B>INMOB<FONT COLOR="GREEN">IS</FONT></B> podrás conseguir la casa de tus sueños. El servicio centralizado de Gestión de Préstamos de <B>INMOB<FONT COLOR="GREEN">IS</FONT></B> cuenta con convenios de colaboración con las principales entidades bancarias para conseguir ofrecer a sus clientes los mejores productos hipotecarios del mercado.</P>

<P>Gracias al gran volumen hipotecario generado por la red <B>INMOB<FONT COLOR="GREEN">IS</FONT></B>, conseguimos condiciones preferentes para nuestros clientes. Con HIPOTECA <B>INMOB<FONT COLOR="GREEN">IS</FONT></B>, podrá mejorar las condiciones de su hipoteca actual, reunificar deudas, comprar su nueva vivienda sin tener que esperar a vender su casa, eligiendo la cuota a pagar... todo ello con un completo asesoramiento financiero y fiscal.</P>
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