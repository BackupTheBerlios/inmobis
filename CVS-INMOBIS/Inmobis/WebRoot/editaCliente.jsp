<%--Los includes específicos de esta página--%>
<%@ page import="com.inmobis.struts.form.EditaClienteForm" %>
<%--El título de la página se debe pasar como parámetro a la cabecera--%>
<%String tituloPag = "INMOBIS Real Estate - Edici&oacute;n de cliente";%>
<%boolean esIndex=false; %>
<%@include file="cabecera.jsp" %>

<!-- Aquí es donde va la PARTE PRINCIPAL DE LA PÁGINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo que tienen todas las paginas-->
<%String subtitulo="P&aacute;gina de Edici&oacute;n";%>
<%String tipoMenu="general";//Si no se ha registrado%>
<%
HttpSession sesion=request.getSession();
String tipoU=(String)sesion.getAttribute("tipoUsuario");//Para mostrar el menú adecuado
%>
<%if (tipoU != null) {%>
<%	tipoMenu = tipoU;%>
<%}%>
<%@ include file="menu_izdo.jsp" %>
	      <div id="content"> 
			<div class="feature">
				<html:errors property="editaCliente"/>
				<html:form action="editaCliente.do"  >
				<%EditaClienteForm form=(EditaClienteForm)sesion.getAttribute("datosCliente");%>
				<table width="100%">
					<tr>
						<td>
							<H2><fmt:message key="editaCliente.message"/></H2>
						</td>
					</tr>
				</table>
				<table width="100%">
					<tr>
						<td>
							<fmt:message key="editaCliente.nombreUsuario"/>
						</td>
						<td>
							<!--El id se pasa oculto para que no lo vea el usuario-->
							<html:hidden property="idUsuario" />
							<!--El id del agente que registra se pasa oculto para que no lo vea el usuario-->
							<!--DESCOMENTAR SI HACE FALTA PERO YO CREO QUE NO PORQUE EL AGENTE NO SE CAMBIARÁ AL EDITAR
							<html:hidden property="idAgente" value="<%=form.getIdAgente()%>"/>
							-->
							<!--El nombre de usuario y lo demas es normal-->
							<html:text 	property="nombreUsuario" size="15" maxlength="15" value="<%=form.getNombreUsuario()%>" />
							<html:errors property="nombreUsuario" />
						</td>
					</tr>
					<tr>  
						<td>   
							<fmt:message key="editaCliente.password"/>
						</td>     
						<td>
							<html:password 	property="password" size="15" redisplay="false" maxlength="15" />
							<html:errors property="password" />
						</td>
					</tr>
					<tr>
						<td>   
							<fmt:message key="editaCliente.passwordAgain"/>
						</td>
						<td>
							<html:password 	property="passwordAgain" size="15" maxlength="15" redisplay="false"/>
							<html:errors property="passwordAgain" />
						</td>
					</tr>
					<tr>
						<td>   
							<fmt:message key="editaCliente.nombre"/>
						</td>   
						<td>
							<html:text 	property="nombre" size="15" maxlength="15" value="<%=form.getNombre()%>" />
							<html:errors property="nombre" />
						</td>
					</tr>  				
					<tr>
						<td>   
							<fmt:message key="editaCliente.apellido1"/>
						</td> 
						<td>
							<html:text 	property="apellido1" size="15" maxlength="30" value="<%=form.getApellido1()%>" />
							<html:errors property="apellido1" />
						</td>
					</tr>
					<tr>
						<td>
							<fmt:message key="editaCliente.apellido2"/>
						</td>  
						<td>
							<html:text 	property="apellido2" size="15" maxlength="30" value="<%=form.getApellido2()%>"/>
							<html:errors property="apellido2" />
						</td>
					</tr>
					<tr>
						<td>   
							<fmt:message key="editaCliente.dni"/>
						</td>   
						<td>
							<html:text 	property="dni" size="10" maxlength="10" value="<%=form.getDni()%>"/>
							<html:errors property="dni" />
						</td>
					</tr>
					<tr>
						<td>
							<fmt:message key="editaCliente.fechaNacimiento"/>
						</td> 
						<td>							
							<%@ include file="fecha.jsp" %>
						</td>
					 </tr>
					 <tr>
						<td>
							<fmt:message key="editaCliente.telefono1"/>
						</td> 
						<td>
							<html:text 	property="telefono1" size="9" maxlength="9" value="<%=form.getTelefono1()%>" />
							<html:errors property="telefono1" />
						</td>
					 </tr>
					 <tr>
						<td>
							<fmt:message key="editaCliente.telefono2"/>
						</td>
						<td>
							<html:text 	property="telefono2" size="9" maxlength="9" value="<%=form.getTelefono2()%>" />
							<html:errors property="telefono2" />
						</td>
					 </tr>
					 <tr>
						<td>
							<fmt:message key="editaCliente.email"/>
						</td>
						<td>
							<html:text 	property="email" size="25" maxlength="25" value="<%=form.getEmail()%>"/>
							<html:errors property="email" />
						</td>
					 </tr>
					 <tr>
						<td>
							<fmt:message key="editaCliente.calle"/>
						</td>  
						<td>
							<html:text 	property="calle" size="15" maxlength="35" value="<%=form.getCalle()%>"/>
							<html:errors property="calle" />
						</td>
					 </tr>
					 <tr>
						<td>
							<fmt:message key="editaCliente.num"/>
						</td>  
						<td>
							<html:text 	property="num" size="4" maxlength="4" value="<%=form.getNum()%>"/>
							<html:errors property="num" />
						</td>
					 </tr>
					 <tr>
						<td>
							<fmt:message key="editaCliente.piso"/>
						</td>
						<td>
							<html:text 	property="piso" size="2" maxlength="2" value="<%=form.getPiso()%>" />
							<html:errors property="piso" />
						</td>
					 </tr>
					 <tr>
						<td>
							<fmt:message key="editaCliente.codPostal"/>
						</td>  
						<td>
							<html:text 	property="codPostal" size="5" maxlength="5" value="<%=form.getCodPostal()%>"/>
							<html:errors property="codPostal" />
						</td>
					 </tr>
					 <tr>
						<td>		
							<fmt:message key="editaCliente.poblacion"/>
						</td>   
						<td>
							<html:text 	property="poblacion" size="25" maxlength="25" value="<%=form.getPoblacion()%>"/>
							<html:errors property="poblacion" />
						</td>
					 </tr>
					 <tr>
						<td>
							<fmt:message key="editaCliente.provincia"/>
						</td>
						<td>
							<%@ include file="provincia.jsp" %>
						</td>
					 </tr>
					 <tr>
						<td>	
							<fmt:message key="editaCliente.pais"/>
						</td>
						<td>
							<html:text 	property="pais" size="25" maxlength="25" value="<%=form.getPais()%>"/>
							<html:errors property="pais" />
						</td>
					 </tr>
					</table>
					<table width="100%">
						<tr>
							<td>	
								<html:submit>
									<fmt:message key="editaCliente.button.cambiar"/>
								</html:submit>
							</td>
							<td>
								<html:reset>
									<fmt:message key="editaCliente.button.cancelar"/>
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
  

 
  

