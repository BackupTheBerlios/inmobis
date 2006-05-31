<%--El título de la página se debe pasar como parámetro a la cabecera--%>
<%String tituloPag = "INMOBIS Real Estate - Registro de usuario";%>
<%boolean esIndex=false; %>
<%@include file="cabecera.jsp" %>

<!-- Aquí es donde va la PARTE PRINCIPAL DE LA PÁGINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo que tienen todas las paginas-->
<%String subtitulo="P&aacute;gina de Registro";%>
<%String tipoMenu="general";//Si no se ha registrado%>
<%
HttpSession sesion=request.getSession();
String tipoU=(String)sesion.getAttribute("tipoUsuario");
%>
<%if (tipoU != null) {%>
<%	tipoMenu = tipoU;%>
<%}%><%@ include file="menu_izdo.jsp" %>
		
	<html:errors property="registraClienteCliente"/>	
	<html:form action="registraClienteCliente.do?esAgente=0"  >

	<div id="content"> 
		<div class="feature">
			<table width="100%">
				<tr>
					<td>
						<H2><fmt:message key="registraCliente.message"/></H2>
					</td>
				</tr>
			</table>
			<table width="100%">
				<tr>
					<td align="left">
						<font size="1" color="red"><b>(*)&nbsp;Campos obligatorios</b></font>
					</td>
				</tr>
			</table>
			<br><br>
			<table width="100%">
				<tr>
					<td width="40%">
						<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraCliente.nombreUsuario"/>
					</td>
					<td>		
						<html:text 	property="nombreUsuario" maxlength="25" />
						<html:errors property="nombreUsuario" />
					</td>
				</tr>
				<tr>
					<td>   
						<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraCliente.password"/>
					</td>
					<td>
						<html:password 	property="password" redisplay="false" maxlength="12" />
						<html:errors property="password" />
					</td>
				</tr>
				 <tr>
					<td>   
						<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraCliente.passwordAgain"/>
					</td>  
					<td>
						<html:password 	property="passwordAgain" maxlength="12" redisplay="false"/>
						<html:errors property="passwordAgain" />
					</td>
				 </tr>
				 <tr>
					 <td>   
						<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraCliente.nombre"/>
					 </td> 
					 <td>
						<html:text 	property="nombre" maxlength="25" />
						<html:errors property="nombre" />
					 </td>
				 </tr>
				 <tr> 
					 <td>   
						<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraCliente.apellido1"/>
					 </td> 
					 <td>
						 <html:text property="apellido1" maxlength="25" />
						 <html:errors property="apellido1" />
					  </td>
				 </tr>
				 <tr>
					<td>
						<fmt:message key="registraCliente.apellido2"/>
					</td>
					<td>
						<html:text 	property="apellido2" maxlength="25" />
						<html:errors property="apellido2" />
					</td>
				</tr>
				<tr>
					<td>   
						<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraCliente.dni"/>
					</td>
					<td>
						<html:text 	property="dni" maxlength="8" />
						<html:errors property="dni" />
					</td>
				</tr>
				<tr>
					<td>
						<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraCliente.fechaNacimiento"/>
					</td>
					<td>
						<%@ include file="fecha.jsp" %>                
					</td>
				</tr>
				<tr>
					<td>
						<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraCliente.telefono1"/>
					</td>
					<td>
						<html:text 	property="telefono1" maxlength="9" />
						<html:errors property="telefono1" />
					</td>
				</tr>
				<tr>
					<td>
						<fmt:message key="registraCliente.telefono2"/>
					</td>
					<td>
						<html:text 	property="telefono2" maxlength="9" />
						<html:errors property="telefono2" />
					</td>
				</tr>
				<tr>
					<td>
						<fmt:message key="registraCliente.email"/>
					</td>
					<td>
						<html:text 	property="email" maxlength="30" />
						<html:errors property="email" />
					</td>
				</tr>
				<tr>
					<td>
						<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraCliente.calle"/>
					</td>
					<td>
						<html:text 	property="calle" maxlength="30" />
						<html:errors property="calle" />
					</td>
				</tr>
				<tr>
					<td>
						<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraCliente.num"/>
					</td>
					<td>
						<html:text 	property="num" maxlength="4" />
						<html:errors property="num" />
					</td>
				</tr>
				<tr>
					<td>
						<fmt:message key="registraCliente.piso"/>
					</td>
					<td>
						<html:text 	property="piso" maxlength="10" />
						<html:errors property="piso" />
					</td>

				</tr>
				<tr>
					<td>
						<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraCliente.codPostal"/>
					</td>
					<td>
						<html:text 	property="codPostal" maxlength="5" />
						<html:errors property="codPostal" />
					</td>
				</tr>
				<tr>
					<td>		
						<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraCliente.poblacion"/>
					</td>
					<td>
						<html:text 	property="poblacion" maxlength="25" />
						<html:errors property="poblacion" />
					</td>
				</tr>
				<tr>
					<td>
						<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraCliente.provincia"/>
					</td>
					<td>
						<html:select property="provincia" size="1">
							<%@ include file="provincia.jsp" %>
						</html:select>
						<html:errors property="provincia" />
					</td>
				</tr>
				<tr>
					<td>	
						<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraCliente.pais"/>
					</td>
					<td>
						<html:text 	property="pais" size="15" maxlength="15" readonly="true" value="Espa�a" />
						<html:errors property="pais" />
					</td>
				</tr>
			</table>
			 <table width="100%">
				 <tr>
					 <td align="right">	
						<html:submit>
							<fmt:message key="registraCliente.button.signon"/>
						</html:submit>
					</td>   
					<td>
						<html:reset>
							<fmt:message key="registraCliente.button.reset"/>
						</html:reset>
					</td>
				</tr>
			</table>
</html:form>

		</div>
	</div>
	<div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>

<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA Pï¿½GINA -->

			

<%@ include file="final.htm" %>
  

 
  

