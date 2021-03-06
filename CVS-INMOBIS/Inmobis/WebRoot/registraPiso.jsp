<%--El t�tulo de la p�gina se debe pasar como par�metro a la cabecera--%>
<%String tituloPag = "INMOBIS Real Estate - Registro de empleado por el administrador";%>
<%boolean esIndex=false; %>
<%@include file="cabecera.jsp" %>

<!-- Aqu� es donde va la PARTE PRINCIPAL DE LA P�GINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo espec�fico del administrador-->
<%String subtitulo="P&aacute;gina de registro de piso";%>
<%String tipoMenu="general";//Si no se ha registrado%>
<!-- CON ESTO BASTAR�A--><%-- tipoMenu="administrador";--%>
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
				<html:form action="registraPiso.do" focus="calle" enctype="multipart/form-data">
				<center>
					<table width="100%">
						<tr>
							<td><H2><fmt:message key="registraPiso.message"/></H2></td>
						</tr>
						<tr>
							<td><font size="1" color="red"><b>(*)&nbsp;Campos obligatorios</b></font></td>
						</tr>
					</table>
					<br><br>
					<table width="100%">													
						<tr>
							<td width="30%">
								<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraPiso.calle"/>
							</td>
							<td>
								<html:text 	property="calle" 
											size="15" 
											maxlength="30" />
								<html:errors property="calle" />
							</td>
						</tr>	
						<tr>
							<td>
								<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraPiso.num"/>
							</td>
							<td>
								<html:text 	property="num" 
											size="15" 
											maxlength="4" />
								<html:errors property="num" />
							</td>
						</tr>	
						<tr>
							<td>
								<fmt:message key="registraPiso.piso"/>
							</td>
							<td>
								<html:text 	property="piso" 
											size="15" 
											maxlength="10" />
								<html:errors property="piso" />
							</td>
						</tr>	
						<tr>
							<td>
								<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraPiso.codPostal"/>
							</td>
							<td>
								<html:text 	property="codPostal" 
											size="15" 
											maxlength="5" />
								<html:errors property="codPostal" />
							</td>
						</tr>	
						<tr>
							<td>
								<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraPiso.poblacion"/>
							</td>
							<td>
								<html:text 	property="poblacion" 
											size="15" 
											maxlength="30" />
								<html:errors property="poblacion" />
							</td>
						</tr>	
						<tr>
							<td>
								<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraPiso.provincia"/>
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
								<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraPiso.pais"/>
							</td>
							<td>
								<html:text 	property="pais" readonly="true" value="Espa�a"/>
								<html:errors property="pais" />
							</td>
						</tr>						
						<tr>
							<td>
								<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraPiso.regimen"/>
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
								<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraPiso.tipo"/>
							</td>
							<td>
								<html:select property="tipo" size="1">
									<%@ include file="tipoInmueble.jsp" %>
								</html:select>
								<html:errors property="tipo" />
							</td>
						</tr>
						<tr>
							<td>
								<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraPiso.precio"/>
							</td>
							<td>
								<html:text 	property="precio" 
											size="15" 
											maxlength="15" />
								<html:errors property="precio" />
							</td>
						</tr> 
						<tr>
							<td>
								<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraPiso.metros"/>
							</td>
							<td>
								<html:text 	property="metros" 
											size="15" 
											maxlength="10" />
								<html:errors property="metros" />
							</td>
						</tr> 
						<tr>
							<td>
								<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraPiso.zona"/>
							</td>
							<td>
								<html:text 	property="zona" 
											size="15" 
											maxlength="30" />
								<html:errors property="zona" />
							</td>
						</tr> 
						<tr>
							<td>
								<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraPiso.numHab"/>
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
						<TR>
							<TD>
								Foto1: <BR />
								<html:file property="binFoto1" />
							</TD>
							<TD>
								Foto2: <BR />
							 	<html:file property="binFoto2" /> 
							</TD>
						</TR>
						<tr>
							<td colspan="2">
								<br><fmt:message key="registraPiso.clienteTexto"/><br><br>
							</td>
						</tr>
						<tr>
							<td>
								<fmt:message key="registraPiso.cliente"/>
							</td>
							<td>
								<html:text 	property="nombreUsuario" 
											size="15" 
											maxlength="25" />
								<html:errors property="nombreUsuario" />
							</td>
						</tr> 
					</table>
					<br><br>
					<table width="100%">
						<tr>
							<td align="center">
								<html:submit>
									<fmt:message key="registraPiso.button.signon"/>
								</html:submit>
								<html:reset>
									<fmt:message key="registraPiso.button.reset"/>
								</html:reset>
							</td>
						</tr>									
					</table>
				</html:form>
			</center>
			</div>
         </div>
         <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>
</body>
</html>
<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA P�GINA -->

			

<%@ include file="final.htm" %>  