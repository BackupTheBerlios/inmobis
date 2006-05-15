<%--El t�tulo de la p�gina se debe pasar como par�metro a la cabecera--%>
<%String tituloPag = "INMOBIS Real Estate - Edici&oacute;n de cliente";%>
<%boolean esIndex=false; %>
<%@include file="cabecera.jsp" %>

<!-- Aqu� es donde va la PARTE PRINCIPAL DE LA P�GINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo que tienen todas las paginas-->
<%String subtitulo="P&aacute;gina de Edici&oacute;n";%>
<%String tipoMenu="general";%>
<%@ include file="menu_izdo.jsp" %>
	      <div id="content"> 
			<div class="feature">
				<html:errors property="editaCliente"/>
				<html:form action="editaCliente.do"  >				
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
							<html:text 	property="nombreUsuario" size="15"	maxlength="15" />
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
							<html:text 	property="nombre" size="15" maxlength="15" />
							<html:errors property="nombre" />
						</td>
					</tr>  
					
					<tr>
						<td>   
							<fmt:message key="editaCliente.dni"/>
						</td>   
						<td>
							<html:text 	property="dni" size="10" maxlength="10" />
							<html:errors property="dni" />
						</td>
					</tr>
					
					<tr>
						<td>   
							<fmt:message key="editaCliente.apellido1"/>
						</td> 
						<td>
							<html:text 	property="apellido1" size="15" maxlength="30" />
							<html:errors property="apellido1" />
						</td>
					</tr>
					<tr>
						<td>
							<fmt:message key="editaCliente.apellido2"/>
						</td>  
						<td>
							<html:text 	property="apellido2" size="15" maxlength="30" />
							<html:errors property="apellido2" />
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
							<html:text 	property="telefono1" size="9" maxlength="9" />
							<html:errors property="telefono1" />
						</td>
					 </tr>
					 <tr>
						<td>
							<fmt:message key="editaCliente.telefono2"/>
						</td>
						<td>
							<html:text 	property="telefono2" size="9" maxlength="9" />
							<html:errors property="telefono2" />
						</td>
					 </tr>
					 <tr>
						<td>
							<fmt:message key="editaCliente.email"/>
						</td>
						<td>
							<html:text 	property="email" size="25" maxlength="25" />
							<html:errors property="email" />
						</td>
					 </tr>
					 <tr>
						<td>
							<fmt:message key="editaCliente.calle"/>
						</td>  
						<td>
							<html:text 	property="calle" size="15" maxlength="35" />
							<html:errors property="calle" />
						</td>
					 </tr>
					 <tr>
						<td>
							<fmt:message key="editaCliente.num"/>
						</td>  
						<td>
							<html:text 	property="num" size="4" maxlength="4" />
							<html:errors property="num" />
						</td>
					 </tr>
					 <tr>
						<td>
							<fmt:message key="editaCliente.piso"/>
						</td>
						<td>
							<html:text 	property="piso" size="2" maxlength="2" />
							<html:errors property="piso" />
						</td>
					 </tr>
					 <tr>
						<td>
							<fmt:message key="editaCliente.codPostal"/>
						</td>  
						<td>
							<html:text 	property="codPostal" size="5" maxlength="5" />
							<html:errors property="codPostal" />
						</td>
					 </tr>
					 <tr>
						<td>		
							<fmt:message key="editaCliente.poblacion"/>
						</td>   
						<td>
							<html:text 	property="poblacion" size="25" maxlength="25" />
							<html:errors property="poblacion" />
						</td>
					 </tr>
					 <tr>
						<td>
							<fmt:message key="editaCliente.provincia"/>
						</td>
						<td>
							<html:text 	property="provincia" size="25" 	maxlength="25" />
							<html:errors property="provincia" />
						</td>
					 </tr>
					 <tr>
						<td>	
							<fmt:message key="editaCliente.pais"/>
						</td>
						<td>
							<html:text 	property="pais" size="25" maxlength="25" />
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
  

 
  

