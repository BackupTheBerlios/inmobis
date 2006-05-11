<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- JSTL tag libs --%>
<%@ taglib prefix="fmt" uri="/WEB-INF/fmt.tld" %>

<%-- Struts provided Taglibs --%>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html-el.tld" %>
<html>
<html:html locale="true"/>
<head>
    <fmt:setBundle basename="com.inmobis.struts.ApplicationResources" />
	<title>INMOBIS Real Estate - Filtrado de clientes</title>
	<!--<title><fmt:message key="FiltrarCliente.title"/></title>-->
<meta http-equiv="Content-Type" content="text/html;">
<link href="estilo/estilo.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="#ffffff">

<%@ include file="cabecera.htm" %>


<!-- Aqui es donde va la PARTE PRINCIPAL DE LA PAGINA 
CON UN ANCHO DE 767 px -->

            <!--pagecell1-->
            <div id="pageName"> 
                
              <h2>P&aacute;gina de Filtrado de clientes </h2>
              </div>
              <div id="pageNav"> 
                <div id="sectionLinks"> <a href="index.jsp">P&aacute;gina Principal</a><a href="registraClienteCliente.jsp">Registrarse</a><a href="login.jsp">Identificarse</a><a href="login.jsp">Financiaci&oacute;n</a><a href="login.jsp">Hipotecas</a><a href="login.jsp">Seguros</a><a href="ayuda.jsp" target="new">Ayuda</a><a href="mailto:inmobisweb@gmail.com">Contacto</a></div>
              </div>
              <div id="content"> 
                <div class="feature">
					<center> 
						<html:errors property="filtrarCliente"/>
						<html:form action="filtrarCliente.do">
							<table width="100%">
								<tr>
									<td><H2>Rellene los campos por los que desee filtrar</H2></td>
									<!--<td><H2><fmt:message key="filtrarCliente.message"/></H2></td>-->
								</tr>
							</table>							
							<table border="0" width="100%">
								<tr>
									<td>
										Nombre:
										<!--<fmt:message key="filtrarCliente.nombreCliente"/>-->
									</td>
									<td>
										<html:text 	property="nombreCliente" 
													size="40" 
													maxlength="40" />
										<html:errors property="nombreCliente" />
									</td>
								</tr>	
								<tr>
									<td>
										Primer Apellido:
										<!--<fmt:message key="filtrarCliente.apellido1"/>-->
									</td>
									<td>
										<html:text 	property="apellido1" 
													size="20" 
													maxlength="20" />
										<html:errors property="apellido1" />
									</td>
								</tr>	
								<tr>
									<td>
										Segundo Apellido:
										<!--<fmt:message key="filtrarCliente.apellido2"/>-->
									</td>
									<td>
										<html:text 	property="apellido2" 
													size="20" 
													maxlength="20" />
										<html:errors property="apellido2" />
									</td>
								</tr>
								<tr>
									<td>
										Fecha de Nacimiento:
										<!--<fmt:message key="filtrarCliente.fechaNacimiento"/>-->
									</td>
									<td>
										<html:text 	property="fechaNacimiento" 
													size="15" 
													maxlength="15" />
										<html:errors property="fechaNacimiento" />
									</td>
								</tr>
								<tr>
									<td>
										N&uacute;mero de DNI:
										<!--<fmt:message key="filtrarCliente.dni"/>-->
									</td>
									<td>
										<html:text 	property="dniCliente" 
													size="15" 
													maxlength="15" />
										<html:errors property="dniCliente" />
									</td>
								</tr>	
								
							</table>
							<table width="100%">
								<tr>
									<td align="center">
										<html:submit>Buscar</html:submit>
										<!--
										<html:submit>
											<fmt:message key="filtrarCliente.button.buscar"/>
										</html:submit>
										-->
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
