<%--Los includes específicos de esta página--%>
<%@ page import="com.inmobis.struts.form.EditaPisoForm" %>
<%--El título de la página se debe pasar como parámetro a la cabecera--%>
<%String tituloPag = "INMOBIS Real Estate - Edici&oacute;n de piso";%>
<%boolean esIndex=false; %>
<%@include file="cabecera.jsp" %>

<!-- Aquí es donde va la PARTE PRINCIPAL DE LA PÁGINA 
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
<%}%>
<%@ include file="menu_izdo.jsp" %>
	      <div id="content"> 
			<div class="feature">
				<html:errors property="EditaPiso"/>
				<html:form action="EditaPiso.do"  >	
				<%EditaPisoForm form=(EditaPisoForm)sesion.getAttribute("datosPiso");%>
				<table width="100%">
					<tr>
						<td>
							<H2><fmt:message key="editaPiso.message"/></H2>
						</td>
					</tr>
				</table>
				<table width="100%">
					<tr>
						<td>
							<fmt:message key="editaPiso.numHab"/>
						</td>
						<td>
							<!--El id se pasa oculto para que no lo vea el usuario-->
							<html:hidden property="idInmueble" />
							<!--El numero de habitaciones y lo demas es normal-->
							<html:select property="numHab" size="1" value="<%=form.getNumHab()%>">				
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
						<td>
							<fmt:message key="editaPiso.tipo"/>	
						</td>
						<td>
							<html:select property="tipo" size="1" value="<%=form.getTipo()%>">
								<%@ include file="tipoInmueble.jsp" %>
							</html:select>
							<html:errors property="tipo" />
						</td>
					</tr>
					<tr>
						<td>
							<fmt:message key="editaPiso.zona"/>	
						</td>
						<td>
							<html:text 	property="zona" size="15" maxlength="25" value="<%=form.getZona()%>" />
							<html:errors property="zona" />
						</td>
					</tr>
					<tr>
						<td>
							<fmt:message key="editaPiso.metros"/>	
						</td>
						<td>
							<html:text 	property="metros" size="15"	maxlength="15" value="<%=form.getMetros()%>" />
							<html:errors property="metros" />
						</td>
					</tr>
					<tr>
						<td>
							<fmt:message key="editaPiso.regimen"/>	
						</td>
						<td>
							<html:select property="regimen" size="1" value="<%=form.getRegimen()%>">
								<html:option value="Alquiler"/>
								<html:option value="Venta"/>
							</html:select>
							<html:errors property="regimen" />
						</td>
					</tr>
					<tr>
						<td>
							<fmt:message key="editaPiso.precio"/>	
						</td>
						<td>
							<html:text 	property="precio" size="15"	maxlength="15" value="<%=form.getPrecio()%>"/>
							<html:errors property="precio" />
						</td>
					</tr>
					<tr>
						<td>
							<fmt:message key="editaPiso.datosDeInteres"/>	
						</td>
						<td>
							<html:textarea 	property="datosDeInteres" value="<%=form.getDatosDeInteres()%>" />
							<html:errors property="datosDeInteres" />
						</td>
					</tr>
					<tr>
						<td>
							<fmt:message key="editaPiso.calle"/>	
						</td>
						<td>
							<html:text 	property="calle" size="15" maxlength="30" value="<%=form.getCalle()%>"/>
							<html:errors property="calle" />
						</td>
					</tr>
					<tr>
						<td>
							<fmt:message key="editaPiso.num"/>	
						</td>
						<td>
							<html:text 	property="num" size="8"	maxlength="8" value="<%=form.getNum()%>" />
							<html:errors property="num" />
						</td>
					</tr>
					<tr>
						<td>
							<fmt:message key="editaPiso.piso"/>	
						</td>
						<td>
							<html:text 	property="piso" size="3" maxlength="3" value="<%=form.getPiso()%>" />
							<html:errors property="piso" />
						</td>
					</tr>
					<tr>
						<td>
							<fmt:message key="editaPiso.codPostal"/>	
						</td>
						<td>
							<html:text 	property="codPostal" size="5" maxlength="5" value="<%=form.getCodPostal()%>"/>
							<html:errors property="codPostal" />
						</td>
					</tr>
					<tr>
						<td>
							<fmt:message key="editaPiso.poblacion"/>	
						</td>
						<td>
							<html:text 	property="poblacion" size="15" maxlength="15" value="<%=form.getPoblacion()%>"/>
							<html:errors property="poblacion" />
						</td>
					</tr>
					<tr>
						<td>
							<fmt:message key="editaPiso.provincia"/>	
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
							<fmt:message key="editaPiso.pais"/>	
						</td>
						<td>
							<html:text 	property="pais" size="15" maxlength="15" readonly="true" value="España"/>
							<html:errors property="pais" />
						</td>
					</tr>
				</table>
				<br>
				<table width="100%">
					<tr>
						<td>
							<html:submit>
								<fmt:message key="editaPiso.button.cambiar"/>
							</html:submit>
						</td>
						<td>
							<html:cancel>
								<fmt:message key="editaPiso.button.cancelar"/>
							</html:cancel>
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
  

 
  

