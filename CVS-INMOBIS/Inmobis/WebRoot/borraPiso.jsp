<%--Librería específica de esta página: Logic, para usar el iterator--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%--El título de la página se debe pasar como parámetro a la cabecera--%>
<%String tituloPag = "&copy INMOBIS:Eliminar Inmueble";%>
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
				<td><H4>¿ESTA SEGURO DE <font color="red">ELIMINAR</font> EL SIGUIENTE INMUEBLE?</H4></td>
			</tr>
		</table>
					
                  
				  <table width="100%" class="lista">
				  <tr>
						<th>
							<bean:message key="app.zona" />
						</th>
						<th>
							<bean:message key="app.numHab" />
						</th>
						<th>
							<bean:message key="app.metros" />
						</th>
						<th>
							<bean:message key="app.regimen" />
						</th>
						<th>
							<bean:message key="app.tipo" />
						</th>
						<th>
							<bean:message key="app.precio" />
						</th>
						<th>
							<bean:message key="app.opciones" />
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
					<br><br>
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
  

