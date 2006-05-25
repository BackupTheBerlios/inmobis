<%--Librer�a espec�fica de esta p�gina: Logic, para usar el iterator--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%--El t�tulo de la p�gina se debe pasar como par�metro a la cabecera--%>
<%String tituloPag = "&copy INMOBIS:Eliminar Empleado";%>
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
                  <p> �ESTA SEGURO DE ELIMINAR EL SIGUIENTE EMPLEADO? </p>
				  <table border="0" cellpading="0" cellspacing="0" width="100%">
						<logic:iterate id="borraEmpleadoPrevForm" name="EmpleadoBean">
						<tr>
						  <td>
					            <bean:write name="borraEmpleadoPrevForm" property="nombre" />
						  </td>
						  <td>
					            <bean:write name="borraEmpleadoPrevForm" property="apellido1" />
						  </td>
						  <td>
					            <bean:write name="borraEmpleadoPrevForm" property="apellido2" />
						  </td>						  
						  <td align="center">
							<a href="borraEmpleado.do?idEmpleado=<bean:write name='borraEmpleadoPrevForm' property='idEmpleado'/>"> ELIMINAR </a>
						  </td>
						</tr>
				      </logic:iterate>
					</table>
                </div>
              </div>
              <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>

<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA P�GINA -->

			

<%@ include file="final.htm" %>  