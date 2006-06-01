<%--Librería específica de esta página: Logic, para usar el iterator--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%--El título de la página se debe pasar como parámetro a la cabecera--%>
<%String tituloPag = "&copy INMOBIS:Eliminar Empleado";%>
<%boolean esIndex=true;//Se refiere a la cabecera sencilla que no incluye librerías %>
<%@include file="cabecera.jsp" %>


<!-- Aquí es donde va la PARTE PRINCIPAL DE LA PÁGINA 
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
                <table width="100%">
			<tr>
				<td><H4>¿ESTA SEGURO DE <font color="red">ELIMINAR</font> EL SIGUIENTE EMPLEADO?</H4></td>
			</tr>
		</table>
                  
				  <table border="0" cellpading="0" cellspacing="0" width="100%">
				  <tr>
						<th>
							<bean:message key="app.nombre" />
						</th>
						<th>
							<bean:message key="app.apellido1" />
						</th>
						<th>
							<bean:message key="app.apellido2" />
						</th>
						<th>
							Opc.
						</th>
					</tr>
					<tr>
						  <td>
					            <bean:write name="empleado" property="nombre" />
						  </td>
						  <td>
					            <bean:write name="empleado" property="apellido1" />
						  </td>
						  <td>
					            <bean:write name="empleado" property="apellido2" />
						  </td>						  
						  <td width="15">
							<a href="borraEmpleado.do?idEmpleado=<bean:write name="empleado" property="idEmpleado"/>"> <IMG SRC="images/ico_eliminar.gif" WIDTH="14" HEIGHT="16" BORDER="0" ALT="Eliminar elemento"> </a>
						  </td>
						</tr>
					</table>
					<table width="100%">
						<tr>
							<td>
								<a href=javascript:history.go(-1); style="color: #3962A6;"><IMG SRC="images/volver.gif" WIDTH="20" HEIGHT="20" BORDER="0" ALT=""> Volver</a>
							</td>
						</tr>
					</table>
				</div>
              </div>
              <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>

<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA PÁGINA -->

			

<%@ include file="final.htm" %>  