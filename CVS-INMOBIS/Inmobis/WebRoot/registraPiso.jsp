<%--El título de la página se debe pasar como parámetro a la cabecera--%>
<%String tituloPag = "INMOBIS Real Estate - Registro de empleado por el administrador";%>
<%boolean esIndex=false; %>
<%@include file="cabecera.jsp" %>

<!-- Aquí es donde va la PARTE PRINCIPAL DE LA PÁGINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo específico del administrador-->
<%String subtitulo="P&aacute;gina de registro de empleado por el administrador";%>
<%String tipoMenu="administrador";%>
<%@include file="menu_izdo.jsp" %>

	<div id="content"> 
                <div class="feature">
			<html:errors property="registraPiso"/>

			<html:form action="registraPiso.do" focus="calle">
				<table align="center" border = "2">
					<tr align="center">
						<td><H1><fmt:message key="registraPiso.message"/></H1></td>
					</tr>
					<tr align="center">
						<td>
							<table align="center">
								
								<tr>
									<td align="right">
										<fmt:message key="registraPiso.calle"/>
									</td>
									<td align="left">
										<html:text 	property="calle" 
													size="15" 
													maxlength="15" />
										<html:errors property="calle" />
									</td>
								</tr>	
								<tr>
									<td align="right">
										<fmt:message key="registraPiso.num"/>
									</td>
									<td align="left">
										<html:text 	property="num" 
													size="15" 
													maxlength="15" />
										<html:errors property="num" />
									</td>
								</tr>	
								<tr>
									<td align="right">
										<fmt:message key="registraPiso.piso"/>
									</td>
									<td align="left">
										<html:text 	property="piso" 
													size="15" 
													maxlength="15" />
										<html:errors property="piso" />
									</td>
								</tr>	
								<tr>
									<td align="right">
										<fmt:message key="registraPiso.codPostal"/>
									</td>
									<td align="left">
										<html:text 	property="codPostal" 
													size="15" 
													maxlength="15" />
										<html:errors property="codPostal" />
									</td>
								</tr>	
								<tr>
									<td align="right">
										<fmt:message key="registraPiso.poblacion"/>
									</td>
									<td align="left">
										<html:text 	property="poblacion" 
													size="15" 
													maxlength="15" />
										<html:errors property="poblacion" />
									</td>
								</tr>	
								<tr>
									<td align="right">
										<fmt:message key="registraPiso.pais"/>
									</td>
									<td align="left">
										<html:text 	property="pais" 
													size="15" 
													maxlength="15" />
										<html:errors property="pais" />
									</td>
								</tr> 
								
								<tr>
									<td align="right">
										<fmt:message key="registraPiso.regimen"/>
									</td>
									<td>
										<html:select property="regimen" size="1">
											<html:option value="alquiler">Alquiler</html:option>
											<html:option value="venta">Venta</html:option>
										</html:select>
										<html:errors property="regimen" />
									</td>
								</tr> 
								<tr>
									<td>
										<fmt:message key="registraPiso.tipo"/>
									</td>
									<td>
										<%@ include file="tipoInmueble.jsp" %>
									</td>
								</tr>
								<tr>
									<td align="right">
										<fmt:message key="registraPiso.precio"/>
									</td>
									<td align="left">
										<html:text 	property="precio" 
													size="15" 
													maxlength="15" />
										<html:errors property="precio" />
									</td>
								</tr> 
								<tr>
									<td align="right">
										<fmt:message key="registraPiso.metros"/>
									</td>
									<td align="left">
										<html:text 	property="metros" 
													size="15" 
													maxlength="15" />
										<html:errors property="metros" />
									</td>
								</tr> 
								<tr>
									<td align="right">
										<fmt:message key="registraPiso.provincia"/>
									</td>
									<td align="left">
										<%@ include file="provincia.jsp" %>
									</td>
								</tr> 
								<tr>
									<td align="right">
										<fmt:message key="registraPiso.zona"/>
									</td>
									<td align="left">
										<html:text 	property="zona" 
													size="15" 
													maxlength="15" />
										<html:errors property="zona" />
									</td>
								</tr> 
								<tr>
									<td align="right">
										<fmt:message key="registraPiso.numHab"/>
									</td>
									<td>
										<html:select property="numHab" size="1">
											<html:option value="1">Una</html:option>
											<html:option value="2">Dos</html:option>
											<html:option value="3">Tres</html:option>
											<html:option value="4">Cuatro</html:option>
											<html:option value="5">Cinco</html:option>
										</html:select>
										<html:errors property="numHab" />
									</td>
								</tr> 
								<tr>
									<td colspan="2" align="center">
										<html:submit>
											<fmt:message key="registraPiso.button.signon"/>
										</html:submit>
										<html:reset>
											<fmt:message key="registraPiso.button.reset"/>
										</html:reset>
									</td>
								</tr>
								
							</table>
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