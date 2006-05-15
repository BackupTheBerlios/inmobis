<%--Librería específica de esta página: Logic, para usar el iterator--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%--El título de la página se debe pasar como parámetro a la cabecera--%>
<%String tituloPag = "&copy INMOBIS:Eliminar Inmueble";%>
<%boolean esIndex=true;//Se refiere a la cabecera sencilla que no incluye librerías %>
<%@include file="cabecera.jsp" %>

<!-- Aquí es donde va la PARTE PRINCIPAL DE LA PÁGINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo que tienen todas las paginas-->
<%String subtitulo="P&aacute;gina Principal";%>
<%String tipoMenu="general";%>
<%@ include file="menu_izdo.jsp" %>  
              <div id="content"> 
                <div class="feature"> 
                  <p> ¿ESTA SEGURO DE ELIMINAR EL SIGUIENTE INMUEBLE? </p>
				  <table border="0" cellpading="0" cellspacing="0" width="100%">
						<logic:iterate id="borraPisoPrevForm" name="InmuebleBean">
						<tr>
						  <td>
					            <bean:write name="borraPisoPrevForm" property="metros" />
						  </td>
						  <td>
					            <bean:write name="borraPisoPrevForm" property="regimen" />
						  </td>
						  <td>
					            <bean:write name="borraPisoPrevForm" property="precio" />
						  </td>						  
						  <td align="center">
							<a href="borraPiso.do?idInmueble=<bean:write name='borraPisoPrevForm'
						      property='idInmueble' />"> ELIMINAR </a>
						  </td>
						</tr>
				      </logic:iterate>
					</table>
				</div>
              </div>
              <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>

<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA PÁGINA -->

			

<%@ include file="final.htm" %>  
  

