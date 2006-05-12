<%@ page contentType="text/html;charset=ISO-8859-1" pageEncoding="ISO-8859-1" language="java" %>

<%-- JSTL tag libs --%>
<%@ taglib prefix="fmt" uri="/WEB-INF/fmt.tld" %>

<%-- Struts provided Taglibs --%>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html-el.tld" %>
<html>
<html:html locale="true"/>
<head>
    <fmt:setBundle basename="com.inmobis.struts.ApplicationResources" />
	<title><fmt:message key="editaEmpleado.title"/></title>
<meta http-equiv="Content-Type" content="text/html;" charset=iso-8859-1>
<link href="estilo/estilo.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="#ffffff">

<%@ include file="cabecera.htm" %>


<!-- Aqu? es donde va la PARTE PRINCIPAL DE LA PAGINA 
CON UN ANCHO DE 767 px -->

            <!--pagecell-->
            <div id="pageName"> 
                
              <h2>P&aacute;gina de Edici&oacute;n </h2>
              </div>
              <div id="pageNav"> 
                <div id="sectionLinks"><a href="index.jsp">P&aacute;gina Principal</a><a href="registraClienteCliente.jsp">Registrarse</a><a href="login.jsp">Identificarse</a><a href="login.jsp">Financiaci&oacute;n</a><a href="login.jsp">Hipotecas</a><a href="login.jsp">Seguros</a><a href="ayuda.jsp" target="new">Ayuda</a><a href="mailto:inmobisweb@gmail.com">Contacto</a></div>
	      </div>
	      <div id="content"> 
			<div class="feature">
				<html:errors property="editaEmpleadoPrev"/>
				<html:form action="editaEmpleadoPrev.do"  >				
				<table width="100%">
					<tr>
						<td>
							<H2><fmt:message key="editaEmpleado.message"/></H2>
						</td>
					</tr>
				</table>
				<table width="100%">
					<tr>
						<td>   
							<fmt:message key="editaEmpleado.nombre"/>
						</td>   
						<td>
							<html:text 	property="nombre" size="15" maxlength="15" />
							<html:errors property="nombre" />
						</td>
					</tr>  
					<tr>
						<td>   
							<fmt:message key="editaEmpleado.nif"/>
						</td>   
						<td>
							<html:text 	property="nif" size="10" maxlength="10" />
							<html:errors property="nif" />
						</td>
					</tr>
					<tr>
						<td>   
							<fmt:message key="editaEmpleado.apellido1"/>
						</td> 
						<td>
							<html:text 	property="apellido1" size="15" maxlength="30" />
							<html:errors property="apellido1" />
						</td>
					</tr>
					<tr>
						<td>
							<fmt:message key="editaEmpleado.apellido2"/>
						</td>  
						<td>
							<html:text 	property="apellido2" size="15" maxlength="30" />
							<html:errors property="apellido2" />
						</td>
					</tr>
					<!--Cambiar esto a con Javascript o incluir fecha.jsp
					<tr>
						<td>
							<fmt:message key="editaEmpleado.fechaNacimiento"/>
						</td> 
						<td>
							
							<html:text 	property="fechaNacimiento" size="10" maxlength="10" />
							<html:errors property="fechaNacimiento" />
						</td>
					 </tr>-->
					 <tr>
						<td>
							<fmt:message key="editaEmpleado.tipoEmpleado"/>
						</td> 
						<td>
							<html:text 	property="tipoEmpleado" size="10" maxlength="10" />
							<html:errors property="tipoEmpleado" />
						</td>
					 </tr>
					 <tr>
						<td>
							<fmt:message key="editaEmpleado.porcentaje"/>
						</td> 
						<td>
							<html:text 	property="porcentaje" size="10" maxlength="10" />
							<html:errors property="porcentaje" />
						</td>
					 </tr>
					 <tr>
						<td>
							<fmt:message key="editaEmpleado.telefono1"/>
						</td> 
						<td>
							<html:text 	property="telefono1" size="9" maxlength="9" />
							<html:errors property="telefono1" />
						</td>
					 </tr>
					 <tr>
						<td>
							<fmt:message key="editaEmpleado.telefono2"/>
						</td>
						<td>
							<html:text 	property="telefono2" size="9" maxlength="9" />
							<html:errors property="telefono2" />
						</td>
					 </tr>
					 <tr>
						<td>
							<fmt:message key="editaEmpleado.email"/>
						</td>
						<td>
							<html:text 	property="email" size="25" maxlength="25" />
							<html:errors property="email" />
						</td>
					 </tr>
					 <tr>
						<td>
							<fmt:message key="editaEmpleado.calle"/>
						</td>  
						<td>
							<html:text 	property="calle" size="15" maxlength="35" />
							<html:errors property="calle" />
						</td>
					 </tr>
					 <tr>
						<td>
							<fmt:message key="editaEmpleado.num"/>
						</td>  
						<td>
							<html:text 	property="num" size="4" maxlength="4" />
							<html:errors property="num" />
						</td>
					 </tr>
					 <tr>
						<td>
							<fmt:message key="editaEmpleado.piso"/>
						</td>
						<td>
							<html:text 	property="piso" size="2" maxlength="2" />
							<html:errors property="piso" />
						</td>
					 </tr>
					 <tr>
						<td>
							<fmt:message key="editaEmpleado.codPostal"/>
						</td>  
						<td>
							<html:text 	property="codPostal" size="5" maxlength="5" />
							<html:errors property="codPostal" />
						</td>
					 </tr>
					 <tr>
						<td>		
							<fmt:message key="editaEmpleado.poblacion"/>
						</td>   
						<td>
							<html:text 	property="poblacion" size="25" maxlength="25" />
							<html:errors property="poblacion" />
						</td>
					 </tr>
					 <tr>
						<td>
							<fmt:message key="editaEmpleado.provincia"/>
						</td>
						<td>
							<html:text 	property="provincia" size="25" 	maxlength="25" />
							<html:errors property="provincia" />
						</td>
					 </tr>
					 <tr>
						<td>	
							<fmt:message key="editaEmpleado.pais"/>
						</td>
						<td>
							<html:text 	property="pais" size="25" maxlength="25" />
							<html:errors property="pais" />
						</td>
					 </tr>
					</table>
					<table width="100%">
						<tr>
							<td>	
								<html:submit>
									<fmt:message key="editaEmpleado.button.cambiar"/>
								</html:submit>
							</td>
							<td>
								<html:reset>
									<fmt:message key="editaEmpleado.button.cancelar"/>
								</html:reset>
							</td>
							</tr>
						</table>
					</html:form>
			</div>
		</div>
        <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>

<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA P?GINA -->

			

<%@ include file="final.htm" %>
  

 
  

