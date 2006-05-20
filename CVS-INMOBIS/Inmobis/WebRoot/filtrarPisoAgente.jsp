<%--El título de la página se debe pasar como parámetro a la cabecera--%>
<%String tituloPag = "INMOBIS Real Estate - Filtrado de pisos";%>
<%boolean esIndex=false; %>
<%@include file="cabecera.jsp" %>

<!-- Aquí es donde va la PARTE PRINCIPAL DE LA PÁGINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo que tienen todas las paginas-->
<%String subtitulo="P&aacute;gina de Filtrado de pisos";%>
<%String tipoMenu="general";%>
<%@ include file="menu_izdo.jsp" %>
              <div id="content"> 
                <div class="feature">
					<center> 
						<html:errors property="filtrarPisoAgente"/>
						<html:form action="filtrarPisoAgente.do">
							<table width="100%">
								<tr>
									<td><H2><fmt:message key="filtrarPisos.message"/></H2></td>
								</tr>
							</table>							
							<table border="0" width="100%">
								<tr>
									<td width="30%">
										<fmt:message key="filtrarPisos.metros"/>
									</td>
									<td>
										<html:text 	property="metros" size="10" maxlength="10" />
										<html:errors property="metros" />
									</td>
								</tr>	
								<tr>
									<td>
										<fmt:message key="filtrarPisos.regimen"/>
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
										<fmt:message key="filtrarPisos.precio"/>
									</td>
									<td>
										<html:text 	property="precio" size="10" maxlength="10" />
										<html:errors property="precio" />
									</td>
								</tr>
								<!-- ESTO NO TIENE SENTIDO EN UN FILTRAR
								<tr>
									<td>
										<fmt:message key="filtrarPisos.datosdeinteres"/>
									</td>
									<td>
										<html:textarea 	property="datosDeInteres"/>
										<html:errors property="datosDeInteres" />
									</td>
								</tr>
								-->
								<tr>
									<td>
										<fmt:message key="filtrarPisos.numhab"/>
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
								<!--ESTO DEBERÍA SER OTRO SELECT??????????    *********************************-->
								<tr>
									<td>
										<fmt:message key="filtrarPisos.tipo"/>
									</td>
									<td>
										<html:text 	property="tipo" size="15" maxlength="15" />
										<html:errors property="tipo" />
									</td>
								</tr>
								<tr>
									<td>
										<fmt:message key="filtrarPisos.zona"/>
									</td>
									<td>
										<html:text 	property="zona" size="15" maxlength="15" />
										<html:errors property="zona" />
									</td>
								</tr>
								
							</table>
							<br><br>
							<table width="100%">
								<tr>
									<td align="center">
										<html:image value="submit" src="images/buscarBtnGAB.GIF"/>
									</td>
								</tr>
							</table>
						</html:form>
					</center>
                </div>
              </div>
              <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>

<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA PAGINA -->

			

<%@ include file="final.htm" %>

