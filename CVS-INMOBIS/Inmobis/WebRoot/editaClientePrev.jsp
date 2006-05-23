<%--ESTO ES SOLO UNA PRUEBA PARA VER QUE SE PASAN BIEN LOS DATOS.
BORRAR CUANDO LOS VER SEAN DEFINITIVOS.--%>
<%String tituloPag = "INMOBIS Real Estate - Prueba de modificar";%>
<%boolean esIndex=false; %>
<%@include file="cabecera.jsp" %>

<!-- Aquí es donde va la PARTE PRINCIPAL DE LA PÁGINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo específico del administrador-->
<%String subtitulo="P&aacute;gina de registro de empleado por el administrador";%>
<%String tipoMenu="administrador";%>
<html>
<body>
	<div id="content"> 
                <div class="feature">
			<html:errors property="editaClientePrev"/>

			<html:form action="editaClientePrev.do" focus="calle">
				<table align="center" border = "2">
					<tr align="center">
						<td><H1><fmt:message key="editaClientePrev.message"/></H1></td>
					</tr>
					<tr align="center">
						<td>
							<table align="center">
								<tr>
									<td colspan="2" align="center">
										<html:submit>
											<fmt:message key="editaClientePrev.button.signon"/>
										</html:submit>
										<html:reset>
											<fmt:message key="editaClientePrev.button.reset"/>
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
