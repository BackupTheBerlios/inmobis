<%--Librer�a espec�fica de esta p�gina: Logic, para usar el iterator--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%--El t�tulo de la p�gina se debe pasar como par�metro a la cabecera--%>
<%String tituloPag = "&copy INMOBIS:Eliminar Inmueble";%>
<%boolean esIndex=true;//Se refiere a la cabecera sencilla que no incluye librer�as %>
<%@include file="cabecera.jsp" %>

<!-- Aqu� es donde va la PARTE PRINCIPAL DE LA P�GINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo que tienen todas las paginas-->
<%String subtitulo="P&aacute;gina Principal";%>
<%String tipoMenu="general";//Si no se ha registrado%>
<%
HttpSession sesion=request.getSession();
String tipoU=(String)sesion.getAttribute("tipoUsuario");
%>
<%if (tipoU != null) {%>
<%	tipoMenu = tipoU;%>
<%}%><%@ include file="menu_izdo.jsp" %>  
              <div id="content"> 
                <div class="feature"> 
                  <p> �ESTA SEGURO DE ELIMINAR EL SIGUIENTE INMUEBLE? </p>
				  <table border="0" cellpading="0" cellspacing="0" width="100%">
				  <tr>
						<th>
							Zona
						</th>
						<th>
							n&ordm; de hab
						</th>
						<th>
							m&sup2;
						</th>
						<th>
							R&eacute;gimen
						</th>
						<th>
							Tipo
						</th>
						<th>
							Precio
						</th>
						<th>
							Opciones
						</th>
					</tr>
					<tr>
						<td>
							<bean:write name="datos" property="zona"/>
						</td>
						<td>
							<bean:write name="datos" property="numHab" />
						</td>
						  <td>
					            <bean:write name="datos" property="metros" />
						  </td>
						  <td>
					            <bean:write name="datos" property="regimen" />
						  </td>
						  <td>
							<bean:write name="datos" property="tipo" /> 
							</td>
						  <td>
					            <bean:write name="datos" property="precio" />
						  </td>						  
						  <td align="center">
							<a href="borraPiso.do?idInmueble=<bean:write name="datos"
						      property="idInmueble" />"> <IMG SRC="images/ico_eliminar.gif" WIDTH="14" HEIGHT="16" BORDER="0" ALT="Eliminar elemento"> </a>
						  </td>
						</tr>
					</table>
				</div>
              </div>
              <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>

<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA P�GINA -->

			

<%@ include file="final.htm" %>  
  

