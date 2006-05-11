<%@ include file="cabecera.htm" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- JSTL tag libs --%>
<%@ taglib prefix="fmt" uri="/WEB-INF/fmt.tld"%>

<%-- Struts provided Taglibs --%>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html-el.tld"%>


<html:html locale="true" />
<head>
	<fmt:setBundle basename="com.inmobis.struts.ApplicationResources" />
	<title><fmt:message key="editaPiso.title"/></title>
	<meta http-equiv="Content-Type" content="text/html;">
	<link href="estilo/estilo.css" rel="stylesheet" type="text/css">
</head>

<body>    


              <div id="pageName">
              	<h2>P&aacute;gina de Edición de Pisos</h2>
              </div>
              <div id="pageNav"> 
                <div id="sectionLinks"> <a href="index.jsp">P&aacute;gina Principal</a><a href="registraClienteCliente.jsp">Registrarse</a><a href="login.jsp">Identificarse</a><a href="login.jsp">Financiaci&oacute;n</a><a href="login.jsp">Hipotecas</a><a href="login.jsp">Seguros</a><a href="ayuda.jsp" target="new">Ayuda</a><a href="mailto:inmobisweb@gmail.com">Contacto</a></div>
              </div>
              <div id="content"> 
                <div class="feature">
					<center> 
						<html:errors property="EditaPiso"/>
						<html:form action="EditaPiso">
							<table width="100%">
								<tr>
									<td><H2><fmt:message key="editaPiso.message"/></H2></td>
									<!--<td><H2><fmt:message key="filtrarCliente.message"/></H2></td>-->
								</tr>
							</table>							
							<table border="0" width="100%">
								<tr>
									<td>
										<fmt:message key="editaPiso.idInmueble"/>
					
									</td>
									<td>
										<html:text 	property="idInmueble" 
													size="40" 
													maxlength="40" />
										<html:errors property="idInmueble" />
									</td>
								</tr>	
								<tr>
									<td>
										<fmt:message key="editaPiso.numHab"/>
					
									</td>
									<td>
										<html:text 	property="numHab" 
													size="40" 
													maxlength="40" />
										<html:errors property="numHab" />
									</td>
								</tr>
								<tr>
									<td>
										<fmt:message key="editaPiso.tipo"/>
					
									</td>
									<td>
										<html:text 	property="tipo" 
													size="40" 
													maxlength="40" />
										<html:errors property="tipo" />
									</td>
								</tr>	
								<tr>
									<td>
										<fmt:message key="editaPiso.zona"/>
					
									</td>
									<td>
										<html:text 	property="zona" 
													size="40" 
													maxlength="40" />
										<html:errors property="zona" />
									</td>
								</tr>		
								<tr>
									<td>
										<fmt:message key="editaPiso.metros"/>
									</td>
									<td>
										<html:text 	property="metros" 
													size="20" 
													maxlength="20" />
										<html:errors property="metros" />
									</td>
								</tr>	
								<tr>
									<td>
										<fmt:message key="editaPiso.datosDeInteres"/>
									</td>
									<td>
										<html:text 	property="datosDeInteres" 
													size="20" 
													maxlength="20" />
										<html:errors property="datosDeInteres" />
									</td>
								</tr>
								<tr>
									<td>
										<fmt:message key="editaPiso.precio"/>
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
										<fmt:message key="editaPiso.regimen"/>
									</td>
									<td>
										<html:text 	property="regimen" 
													size="15" 
													maxlength="15" />
										<html:errors property="regimen" />
									</td>
								</tr>	
								
							</table>
							<table width="100%">
								<tr>
									<td align="center">
										<html:submit>
											<fmt:message key="editaPiso.button.cambiar"/>
										</html:submit>
										<html:reset>
											<fmt:message key="editaPiso.button.cancelar"/>
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


			
<%@ include file="final.htm" %>
