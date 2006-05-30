<%--Los includes espec�ficos de esta p�gina--%>
<%@ page import="com.inmobis.struts.form.EditaEmpleadoForm" %>
<%--El t�tulo de la p�gina se debe pasar como par�metro a la cabecera--%>
<%String tituloPag = "INMOBIS Real Estate - Edici&oacute;n de empleado";%>
<%boolean esIndex=false; %>
<%@ page import="com.inmobis.struts.form.EditaEmpleadoForm" %>
<%@include file="cabecera.jsp" %>
<script>
</script>
<!-- Aqu� es donde va la PARTE PRINCIPAL DE LA P�GINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo que tienen todas las paginas-->
<%String subtitulo="P&aacute;gina de Edici&oacute;n";%>
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
				<html:errors property="editaEmpleado"/>
				<html:form action="editaEmpleado.do"  >	
				<%EditaEmpleadoForm form=(EditaEmpleadoForm)sesion.getAttribute("datosEmpleado");%>
				<table width="100%">
					<tr>
						<td>
							<H2><fmt:message key="editaEmpleado.message"/></H2>
						</td>
					</tr>
				</table>
				<table width="100%">
				<tr>
					<td>   
						<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="editaCliente.password"/>
					</td>
					<td>
						<html:password 	property="password" redisplay="false" maxlength="15" value="<%=form.getPassword()%>" />
						<html:errors property="password" />
					</td>
				</tr>
				 <tr>
					<td>   
						<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="editaCliente.passwordAgain"/>
					</td>  
					<td>
						<html:password 	property="passwordAgain" maxlength="15" redisplay="false" value="<%=form.getPassword()%>"/>
						<html:errors property="passwordAgain" />
					</td>
				 </tr>
					<tr>
						<td>   
							<fmt:message key="editaEmpleado.nombre"/>
						</td>   
						<td>
							<html:hidden property="idUsuario" value="<%=form.getIdUsuario()%>"/>
							<!--El nombre de usuario y lo demas es normal-->
							<html:text 	property="nombre" size="15" maxlength="30" value="<%=form.getNombre()%>"/>
							<html:errors property="nombre" />
						</td>
					</tr>  
					<tr>
						<td>   
							<fmt:message key="editaEmpleado.apellido1"/>
						</td> 
						<td>
							<html:text 	property="apellido1" size="15" maxlength="30" value="<%=form.getApellido1()%>" />
							<html:errors property="apellido1" />
						</td>
					</tr>
					<tr>
						<td>
							<fmt:message key="editaEmpleado.apellido2"/>
						</td>  
						<td>
							<html:text 	property="apellido2" size="15" maxlength="30" value="<%=form.getApellido2()%>"/>
							<html:errors property="apellido2" />
						</td>
					</tr>
					<tr>
						<td>   
							<fmt:message key="editaEmpleado.dni"/>
						</td>   
						<td>
							<html:text 	property="nif" size="10" maxlength="10" value="<%=form.getNif()%>"/>
							<html:errors property="nif" />
						</td>
					</tr>
					<tr>
						<td>
							<fmt:message key="editaCliente.fechaNacimiento"/>
						</td> 
						<td>							
							<%@ include file="fechaEdita.jsp" %>
						</td>
					 </tr>
					 <tr>
					 <tr>
						<td>
							<fmt:message key="editaEmpleado.tipoEmpleado"/>
						</td> 
						<td>
							<html:select property="tipoEmpleado" size="1" value="<%= form.getTipoEmpleado()%>">
								<html:option value="agente">Agente</html:option>
								<html:option value="gerente">Gerente</html:option>
								<html:option value="contable">Contable</html:option>
								<html:option value="administrador" >Administrador</html:option>
							</html:select>
							<html:errors property="tipoEmpleado" />
						</td>
					</tr>
					<!--Esto no va por ahora-->
					<div id="PorcentajeEmpleado" style="visibility:hidden">
					<tr>
						<td>		
							<fmt:message key="editaEmpleado.porcentaje"/>
						</td> 							
						<td>
							<!--ESTO PROBABLEMENTE SEA UN SELECT-->
							<html:text 	property="porcentaje" size="10" maxlength="10" value="<%=form.getPorcentaje()%>"/>
							<html:errors property="porcentaje" />								
						</td>
					</tr>
					</div>					
					 <tr>
						<td>
							<fmt:message key="editaEmpleado.telefono1"/>
						</td> 
						<td>
							<html:text 	property="telefono1" size="9" maxlength="9" value="<%=form.getTelefono1()%>" />
							<html:errors property="telefono1" />
						</td>
					 </tr>
					 <tr>
						<td>
							<fmt:message key="editaEmpleado.telefono2"/>
						</td>
						<td>
							<html:text 	property="telefono2" size="9" maxlength="9" value="<%=form.getTelefono2()%>"/>
							<html:errors property="telefono2" />
						</td>
					 </tr>
					 <tr>
						<td>
							<fmt:message key="editaEmpleado.email"/>
						</td>
						<td>
							<html:text 	property="email" size="25" maxlength="50" value="<%=form.getEmail()%>"/>
							<html:errors property="email" />
						</td>
					 </tr>
					 <tr>
						<td>
							<fmt:message key="editaEmpleado.calle"/>
						</td>  
						<td>
							<html:text 	property="calle" size="15" maxlength="50" value="<%=form.getCalle()%>"/>
							<html:errors property="calle" />
						</td>
					 </tr>
					 <tr>
						<td>
							<fmt:message key="editaEmpleado.num"/>
						</td>  
						<td>
							<html:text 	property="num" size="4" maxlength="15" value="<%=form.getNum()%>"/>
							<html:errors property="num" />
						</td>
					 </tr>
					 <tr>
						<td>
							<fmt:message key="editaEmpleado.piso"/>
						</td>
						<td>
							<html:text 	property="piso" size="2" maxlength="10" value="<%=form.getPiso()%>"/>
							<html:errors property="piso" />
						</td>
					 </tr>
					 <tr>
						<td>
							<fmt:message key="editaEmpleado.codPostal"/>
						</td>  
						<td>
							<html:text 	property="codPostal" size="5" maxlength="5" value="<%=form.getCodPostal()%>"/>
							<html:errors property="codPostal" />
						</td>
					 </tr>
					 <tr>
						<td>		
							<fmt:message key="editaEmpleado.poblacion"/>
						</td>   
						<td>
							<html:text 	property="poblacion" size="25" maxlength="50" value="<%=form.getPoblacion()%>"/>
							<html:errors property="poblacion" />
						</td>
					 </tr>
					 <tr>
						<td>
							<fmt:message key="editaEmpleado.provincia"/>
						</td>
						<td>
							<html:select property="provincia" size="1" value="<%=form.getProvincia()%>">
								<%@ include file="provincia.jsp" %>
							</html:select>
							<html:errors property="provincia" />
						</td>
					 </tr>
					 <tr>
						<td>	
							<fmt:message key="editaEmpleado.pais"/>
						</td>
						<td>
							<html:text 	property="pais" readonly="true" value="Espa�a" />
							<html:errors property="pais" />
						</td>
					 </tr>
					</table>
					<table width="100%">
						<tr>
							<td>	
								<html:submit>
									<fmt:message key="editaEmpleado.button.cambiar"/>
								</html:submit>
							</td>
							<td>
								<html:reset>
									<fmt:message key="editaEmpleado.button.cancelar"/>
								</html:reset>
							</td>
							</tr>
						</table>
					</html:form>
			</div>
		</div>
        <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>

<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA P?GINA -->

			

<%@ include file="final.htm" %>
  

 
  

