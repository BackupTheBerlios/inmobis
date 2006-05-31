<%--Librería específica de esta página: Logic, para usar el iterator--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%--El título de la página se debe pasar como parámetro a la cabecera--%>
<%String tituloPag = "&copy INMOBIS:Eliminar Cliente";%>
<%boolean esIndex=true;//Se refiere a la cabecera sencilla que no incluye librerías %>
<%@include file="cabecera.jsp" %>

<!-- Aquí es donde va la PARTE PRINCIPAL DE LA PÁGINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo que tienen todas las paginas-->
<%String subtitulo="P&aacute;gina Principal";%>
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
                <table width="100%">
			<tr>
				<td><H4>¿ESTA SEGURO DE <font color="red">ELIMINAR</font> EL SIGUIENTE CLIENTE?</H4></td>
			</tr>
		</table>                  
				  <table width="100%">
						<logic:iterate id="borraClienteForm" name="ClienteBean">
						<tr>
							<td>
								<bean:write name="cliente" property="nombre" />
							</td>
							<td>
								<bean:write name="cliente" property="apellido1" />
							</td>
							<td>
								<bean:write name="cliente" property="apellido2" />
							</td>						  
							<td align="center">
								<a href="borraCliente.do?idCliente=<bean:write name='borraClienteForm'
								  property='idCliente' />"> ELIMINAR </a>
							</td>
						</tr>
				      </logic:iterate>
					</table>	
					<table width="100%">
						<tr>
							<td>
								<a href=javascript:history.go(-1); style="color: #3962A6;"><IMG SRC="images/volver.gif" WIDTH="20" HEIGHT="20" BORDER="0" ALT=""> Volver</a>
							</td>
						</tr>
					</table>				
                </div>
              </div>
              <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>

<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA PÁGINA -->

			

<%@ include file="final.htm" %>  