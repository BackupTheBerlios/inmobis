<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- JSTL tag libs --%>
<%@ taglib prefix="fmt" uri="/WEB-INF/fmt.tld" %>

<%-- Struts provided Taglibs --%>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html-el.tld" %>
<html>
<html:html locale="true"/>
<head>
    <fmt:setBundle basename="com.inmobis.struts.ApplicationResources" />
	<title>INMOBIS Real Estate - Filtrado de pisos</title>
	<!--<title><fmt:message key="filtrarPisos.title"/></title>-->
<meta http-equiv="Content-Type" content="text/html;">
<link href="estilo/estilo.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="#ffffff">

<%@ include file="cabecera.htm" %>


<!-- Aqui es donde va la PARTE PRINCIPAL DE LA PAGINA 
CON UN ANCHO DE 767 px -->

            <!--pagecell1-->
            <div id="pageName"> 
                
              <h2>P&aacute;gina de Filtrado de pisos </h2>
              </div>
              <div id="pageNav"> 
                <div id="sectionLinks"> <a href="index.jsp">P&aacute;gina Principal</a><a href="registraPisosPisos.jsp">Registrarse</a><a href="login.jsp">Identificarse</a><a href="login.jsp">Financiaci&oacute;n</a><a href="login.jsp">Hipotecas</a><a href="login.jsp">Seguros</a><a href="ayuda.jsp" target="new">Ayuda</a><a href="mailto:inmobisweb@gmail.com">Contacto</a></div>
              </div>
              <div id="content"> 
                <div class="feature">
					<center> 
						<html:errors property="filtrarPisoAgente"/>
						<html:form action="filtrarPisoAgente.do">
							<table width="100%">
								<tr>
									<td><H2>Rellene los campos por los que desee filtrar</H2></td>
									<!--<td><H2><fmt:message key="filtrarPisos.message"/></H2></td>-->
								</tr>
							</table>							
							<table border="0" width="100%">
								<tr>
									<td>
										Metros:
										<!--<fmt:message key="filtrarPisos.metros"/>-->
									</td>
									<td>
										<html:text 	property="metros" size="40" maxlength="40" />
										<html:errors property="metros" />
									</td>
								</tr>	
								<tr>
									<td>
										Regimen:
										<!--<fmt:message key="filtrarPisos.regimen"/>-->
									</td>
									<td>
										<html:text 	property="regimen" size="20" maxlength="20" />
										<html:errors property="regimen" />
									</td>
								</tr>	
								<tr>
									<td>
										Precio
										<!--<fmt:message key="filtrarPisos.apellido2"/>-->
									</td>
									<td>
										<html:text 	property="precio" size="20" maxlength="20" />
										<html:errors property="precio" />
									</td>
								</tr>
								<tr>
									<td>
										Datos de inter&eacute;s:
										<!--<fmt:message key="filtrarPisos.datosdeinteres"/>-->
									</td>
									<td>
										<html:textarea 	property="datosDeInteres"/>
										<html:errors property="datosDeInteres" />
									</td>
								</tr>
								<tr>
									<td>
										N&uacute;mero de habitaciones:
										<!--<fmt:message key="filtrarPisos.numhab"/>-->
									</td>
									<td>
										<html:text 	property="numHab" size="15" maxlength="15" />
										<html:errors property="numHab" />
									</td>
								</tr>
								<tr>
									<td>
										Tipo:
										<!--<fmt:message key="filtrarPisos.tipo"/>-->
									</td>
									<td>
										<html:text 	property="tipo" size="15" maxlength="15" />
										<html:errors property="tipo" />
									</td>
								</tr>
								<tr>
									<td>
										Zona:
										<!--<fmt:message key="filtrarPisos.zona"/>-->
									</td>
									<td>
										<html:text 	property="zona" size="15" maxlength="15" />
										<html:errors property="zona" />
									</td>
								</tr>
								
							</table>
							<table width="100%">
								<tr>
									<td align="center">
										<html:submit>Buscar</html:submit>
										<!--
										<html:submit>
											<fmt:message key="filtrarPisos.button.buscar"/>
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

