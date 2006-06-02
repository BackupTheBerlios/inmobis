<%--Librería específica de esta página: Logic, para usar el iterator--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ page import="com.inmobis.struts.form.MensajeForm" %>
<%--El título de la página se debe pasar como parámetro a la cabecera--%>
<%String tituloPag = "&copy INMOBIS:Eliminar Mensaje";%>
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
<%}%><%@ include file="menu_izdo.jsp" %>  
              <div id="content"> 
                <div class="feature"> 
                <table width="100%">
			<tr>
				<td><H4>¿ESTA SEGURO DE <font color="red">ELIMINAR</font> EL SIGUIENTE MENSAJE?</H4></td>
			</tr>
		</table>
		<br>
		<hr>
		<br>
					<html:form action="verMensaje.do"  >
					<%MensajeForm form=(MensajeForm)sesion.getAttribute("mensaje");%>
					<table width="100%">
						<tr>  
							<td>   
								<fmt:message key="verMensaje.nombreOrigen"/>
							</td>     
							<td>
								<html:text property="nombreOrigen" size="25" maxlength="25" value="<%=form.getNombreOrigen()%>" readonly="true" />
							</td>
						</tr>
						
						<tr>
						<td>
							<fmt:message key="verMensaje.fecha"/>
						</td> 
						<td>							
						<html:text property="fecha" size="15" maxlength="25" value="<%=form.getFecha()%>" readonly="true" />
						</td>
					 </tr>
												
						<tr>  
							<td>   
								<fmt:message key="verMensaje.asunto"/>
							</td>     
							<td>
								<html:text property="asunto" size="25" maxlength="25" value="<%=form.getAsunto()%>" readonly="true" />
							</td>
						</tr>
						<!--El texto en una fila porque puede ser largo-->
						<tr>  
							<td colspan = "2">   
								<fmt:message key="verMensaje.texto"/>
							</td> 
						</tr>
						<tr>
							<td colspan = "2">
								<TEXTAREA rows="5" cols="80" NAME="texto" readonly="true">
									<%=form.getTexto()%>
								</TEXTAREA>
							</td>
						</tr>
					</table>
					</html:form>
					
					<br><br>
                  <hr>
					
					<br>
					<table width="100%">
						<tr>
						    <td width="15">
									<a href="borrarMensaje.do?idMensaje=<bean:write name="mensaje" property="idMensaje"/>&origen=<bean:write name="mensaje" property="origen" />&destino=<bean:write name="mensaje" property="destino" />&fecha=<bean:write name="mensaje" property="fecha" /> "><IMG SRC="images/ico_eliminar.gif" WIDTH="14" HEIGHT="16" BORDER="0" ALT="Eliminar mensaje"> Eliminar mensaje</a>
					        </td>
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
  

