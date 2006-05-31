<%--El título de la página se debe pasar como parámetro a la cabecera--%>
<%String tituloPag = "INMOBIS Real Estate - Registro de empleado por el administrador";%>
<%boolean esIndex=false; %>
<%@include file="cabecera.jsp" %>

<!-- Aquí es donde va la PARTE PRINCIPAL DE LA PÁGINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo específico del administrador-->
<%String subtitulo="P&aacute;gina de registro de empleado por el administrador";%>
<%String tipoMenu="general";//Si no se ha registrado%>
<!-- CON ESTO BASTARÍA--><%-- tipoMenu="administrador";--%>
<%
HttpSession sesion=request.getSession();
String tipoU=(String)sesion.getAttribute("tipoUsuario");
%>
<%if (tipoU != null) {%>
<%	tipoMenu = tipoU;%>
<%}%>
<%@include file="menu_izdo.jsp" %>

	<div id="content"> 
                <div class="feature">
			<html:errors property="registraPiso"/>
			<html:form action="registraEmpleado.do"  >
			<center>
			<table width="100%">
				<tr>
					<td><H2><fmt:message key="registraEmpleado.message"/></H2></td>
				</tr>
				<tr>
					<td><font size="1" color="red"><b>(*)&nbsp;Campos obligatorios</b></font></td>
				</tr>
			</table>
			
			<br><br>
			<table width="100%">													
				<tr>
					<td>
					      <font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.password"/>
    					</td>
    					<td>
	  					<html:password 	property="password" redisplay="false" maxlength="12" />
	  					<html:errors property="password" />
					</td>
 				</tr>
 				<tr>
    					<td>   
      						<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.passwordAgain"/>
					</td>  
					<td>
	  					<html:password 	property="passwordAgain" maxlength="12" redisplay="false"/>
	  					<html:errors property="passwordAgain" />
					</td>
 				</tr>
 				<tr>
  					<td>
						<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.nombre"/>
  					</td>
  					<td>		
						<html:text 	property="nombre" size="15" maxlength="25" />
						<html:errors property="nombre" />
  					</td>
				 </tr>
				 <tr>
  					<td>
						<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.apellido1"/>
  					</td>
  					<td>
						<html:text 	property="apellido1" size="15" maxlength="25" />
						<html:errors property="apellido1" />
					</td>
				</tr>
				<tr>
  					<td>
						<fmt:message key="registraEmpleado.apellido2"/>
					</td>
  					<td>
						<html:text 	property="apellido2" size="15" maxlength="25" />
						<html:errors property="apellido2" />
					</td>
				</tr>
				<tr>
  					<td>
						<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.fechaNacimiento"/>
					</td>
  					<td>
						<%@ include file="fecha.jsp" %>		
					</td>

				</tr>	
				<tr>
  					<td>
						<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.nif"/>
					</td>
  					<td>
						<html:text 	property="nif" size="15" maxlength="8" />
						<html:errors property="nif" />
	
					</td>
				</tr>
				<tr>
  					<td>
						<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.tipoEmpleado"/>
					</td>
  					<td>
						<html:select property="tipoEmpleado" size="1">
						<html:option value="agente">Agente</html:option>
						<html:option value="gerente">Gerente</html:option>
						<html:option value="contable">Contable</html:option>
						<html:option value="administrador" >Administrador</html:option>
						</html:select>
						<html:errors property="tipoEmpleado" />
					</td>
  				</tr>
				<tr>
  					<td>	
						<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.porcentaje"/>
					</td>
  					<td>						
						<html:select property="porcentaje" size="1">
							<html:option value="5">5 %</html:option>
							<html:option value="10">10 %</html:option>
							<html:option value="15">15 %</html:option>
							<html:option value="20" >20 %</html:option>
							<html:option value="25" >25 %</html:option>
						</html:select>
						<html:errors property="porcentaje" />
					</td>
				</tr>
				<tr>
  					<td>
						<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.telefono1"/>
					</td>
  					<td>
						<html:text 	property="telefono1" size="15" maxlength="9" />
						<html:errors property="telefono1" />
					</td>
				</tr>
				<tr>
  					<td>
						<fmt:message key="registraEmpleado.telefono2"/>
					</td>
  					<td width="50%" align="left">
						<html:text 	property="telefono2" size="15" maxlength="9" />
						<html:errors property="telefono2" />
					</td>
				</tr>
				<tr>
  					<td>
						<fmt:message key="registraEmpleado.email"/>
					</td>
  					<td>
						<html:text 	property="email" size="15" maxlength="30" />
						<html:errors property="email" />
					</td>
				</tr>
				<tr>
  					<td>
						<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.calle"/>
					</td>
  					<td>
						<html:text 	property="calle" size="15" maxlength="30" />
						<html:errors property="calle" />
					</td>
				</tr>
				<tr>
  					<td>
						<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.num"/>
					</td>
  					<td>
						<html:text 	property="num" size="15" maxlength="4" />
						<html:errors property="num" />
					</td>
				</tr>
				<tr>
  					<td>
						<fmt:message key="registraEmpleado.piso"/>
					</td>
  					<td>
						<html:text 	property="piso" size="15" maxlength="10" />
						<html:errors property="piso" />
					</td>
				</tr>
				<tr>
  					<td>
						<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.codPostal"/>
					</td>
  					<td>
						<html:text 	property="codPostal" size="15" maxlength="5" />
						<html:errors property="codPostal" />
					</td>
				</tr>
				<tr>
  					<td>
						<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.poblacion"/>
					</td>
  					<td>
						<html:text 	property="poblacion" size="15" maxlength="25" />
						<html:errors property="poblacion" />
					</td>
				</tr>
				<tr>
  					<td>
						<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.provincia"/>
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
						<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.pais"/>
					</td>
  					<td>
						<html:text 	property="pais" size="15" maxlength="15" readonly="true" value="España" />
						<html:errors property="pais" />
					</td>
				</tr>
				<tr>
  					<td>	
						<html:submit>
						<fmt:message key="registraEmpleado.button.signon"/>
						</html:submit>
					</td>
  					<td>
						<html:reset>
						<fmt:message key="registraEmpleado.button.reset"/>
						</html:reset>
					</td>
				</tr>
			</table>
		</html:form>
</div>
              </div>
              <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>
</body>
</html>
<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA PÁGINA -->

			

<%@ include file="final.htm" %>  