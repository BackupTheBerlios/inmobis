<%--El t�tulo de la p�gina se debe pasar como par�metro a la cabecera--%>
<%String tituloPag = "&copy INMOBIS Real Estate - Filtrado de pisos";%>
<%boolean esIndex=false; %>
<%@include file="cabecera.jsp" %>

<!-- Aqu� es donde va la PARTE PRINCIPAL DE LA P�GINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo que tienen todas las paginas-->
<%String subtitulo="P&aacute;gina de Filtrado";%>
<%String tipoMenu="general";%>
<%@ include file="menu_izdo.jsp" %>

              <div id="content"> 
                <div class="feature"> 
					<table width="100%">
						<tr>
							<td>
								<IMG SRC="images/enconstruccion.gif" WIDTH="81" HEIGHT="50" BORDER="0" ALT="">
							</td>
							<td>
								<h3><FONT COLOR="RED"> EN CONSTRUCCI&Oacute;N</FONT></h3>
							</td>
						</tr>
					</table>                  
                </div>
              </div>
              <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>

<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA P�GINA -->

			

<%@ include file="final.htm" %>  
