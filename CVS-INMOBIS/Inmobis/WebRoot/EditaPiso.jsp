<%--El título de la página se debe pasar como parámetro a la cabecera--%>
<%String tituloPag = "INMOBIS Real Estate - Edici&oacute;n de piso";%>
<%boolean esIndex=false; %>
<%@include file="cabecera.jsp" %>

<!-- Aquí es donde va la PARTE PRINCIPAL DE LA PÁGINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo que tienen todas las paginas-->
<%String subtitulo="P&aacute;gina de Edici&oacute;n";%>
<%String tipoMenu="general";%>
<%@ include file="menu_izdo.jsp" %>
	      <div id="content"> 
			<div class="feature">
				<html:errors property="EditaPiso"/>
				<html:form action="EditaPiso.do"  >				
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
							<html:text 	property="numHab" size="15"	maxlength="15" />
							<html:errors property="numHab" />
						</td>
					</tr>
					<tr>
						<td>
							<fmt:message key="editaPiso.tipo"/>	
						</td>
						<td>
							<html:text 	property="tipo" size="15"	maxlength="25" />
							<html:errors property="tipo" />
						</td>
					</tr>
					<tr>
						<td>
							<fmt:message key="editaPiso.zona"/>	
						</td>
						<td>
							<html:text 	property="zona" size="15"	maxlength="25" />
							<html:errors property="zona" />
						</td>
					</tr>
					<tr>
						<td>
							<fmt:message key="editaPiso.metros"/>	
						</td>
						<td>
							<html:text 	property="metros" size="15"	maxlength="15" />
							<html:errors property="metros" />
						</td>
					</tr>
					<tr>
						<td>
							<fmt:message key="editaPiso.regimen"/>	
						</td>
						<td>
							<html:text 	property="regimen" size="15"	maxlength="15" />
							<html:errors property="regimen" />
						</td>
					</tr>
					<tr>
						<td>
							<fmt:message key="editaPiso.precio"/>	
						</td>
						<td>
							<html:text 	property="precio" size="15"	maxlength="15" />
							<html:errors property="precio" />
						</td>
					</tr>
					<tr>
						<td>
							<fmt:message key="editaPiso.datosDeInteres"/>	
						</td>
						<td>
							<html:textarea 	property="datosDeInteres" />
							<html:errors property="datosDeInteres" />
						</td>
					</tr>
					<tr>
						<td>
							<fmt:message key="editaPiso.calle"/>	
						</td>
						<td>
							<html:text 	property="calle" size="15" maxlength="30" />
							<html:errors property="calle" />
						</td>
					</tr>
					<tr>
						<td>
							<fmt:message key="editaPiso.num"/>	
						</td>
						<td>
							<html:text 	property="num" size="8"	maxlength="8" />
							<html:errors property="num" />
						</td>
					</tr>
					<tr>
						<td>
							<fmt:message key="editaPiso.piso"/>	
						</td>
						<td>
							<html:text 	property="piso" size="3" maxlength="3" />
							<html:errors property="piso" />
						</td>
					</tr>
					<tr>
						<td>
							<fmt:message key="editaPiso.codPostal"/>	
						</td>
						<td>
							<html:text 	property="codPostal" size="5" maxlength="5" />
							<html:errors property="codPostal" />
						</td>
					</tr>
					<tr>
						<td>
							<fmt:message key="editaPiso.poblacion"/>	
						</td>
						<td>
							<html:text 	property="poblacion" size="15" maxlength="15" />
							<html:errors property="poblacion" />
						</td>
					</tr>
					<tr>
						<td>
							<fmt:message key="editaPiso.provincia"/>	
						</td>
						<td>
							<html:text 	property="provincia" size="15" maxlength="15" />
							<html:errors property="provincia" />
						</td>
					</tr>
					<tr>
						<td>
							<fmt:message key="editaPiso.pais"/>	
						</td>
						<td>
							<html:text 	property="pais" size="15" maxlength="15" />
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
  

 
  

