<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- JSTL tag libs --%>
<%@ taglib prefix="fmt" uri="/WEB-INF/fmt.tld" %>

<%-- Struts provided Taglibs --%>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html-el.tld" %>
<html>
<html:html locale="true"/>
<head>
    <fmt:setBundle basename="com.inmobis.struts.ApplicationResources" />
	<title><fmt:message key="registraCliente.title"/></title>
<meta http-equiv="Content-Type" content="text/html;">
<link href="estilo/estilo.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="#ffffff">

<%@ include file="cabecera.htm" %>


<!-- Aqu� es donde va la PARTE PRINCIPAL DE LA P�GINA 
CON UN ANCHO DE 767 px -->

            <!--pagecell1-->
            <div id="pageName"> 
                
              <h2>P&aacute;gina de Registro </h2>
              </div>
              <div id="pageNav"> 
                <div id="sectionLinks"><a href="index.jsp">P&aacute;gina Principal</a><a href="registraClienteCliente.jsp">Registrarse</a><a href="login.jsp">Identificarse</a><a href="login.jsp">Financiaci&oacute;n</a><a href="login.jsp">Hipotecas</a><a href="login.jsp">Seguros</a><a href="ayuda.jsp" target="new">Ayuda</a><a href="mailto:inmobisweb@gmail.com">Contacto</a></div>
		<html:errors property="registraClienteCliente"/>
	      </div>
		
	
	<html:form action="registraClienteCliente.do?esAgente=0"  >

	      <div id="content"> 
                <div class="feature">
		<fmt:message key="registraCliente.message"/>
<hr>
<table align="left">
<tr><td>
<font size="1" color="red"><b>(*)&nbsp;Campos obligatorios</b></font>
</td>
</tr>
</table>

<br><br>

<table>
 <tr>
  <td width="45%" align="right">
	<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraCliente.nombreUsuario"/>
  </td>
  <td width="5%"></td>
  <td width="50%" align="left">		
	<html:text 	property="nombreUsuario" 
			size="15" 
			maxlength="15" />
	<html:errors property="nombreUsuario" />
  </td>

 </tr>
 <tr>
  
  <td width="45%" align="right">   
		<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraCliente.password"/>
  </td>   
  <td width="5%"></td>   
  <td width="50%" align="left">
		<html:password 	property="password" 
				size="15" 
				redisplay="false"
				maxlength="15" />
		<html:errors property="password" />
  </td>

 </tr>
 <tr>

  <td width="45%" align="right">   
		<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraCliente.passwordAgain"/>
  </td>
  <td width="5%"></td>   
  <td width="50%" align="left">
		<html:password 	property="passwordAgain" 
				size="15" 
				maxlength="15" 
				redisplay="false"/>
		<html:errors property="passwordAgain" />
  </td>

 </tr>
 <tr>


  <td width="45%" align="right">   
		<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraCliente.nombre"/>
  </td>
  <td width="5%"></td>   
  <td width="50%" align="left">
		<html:text 	property="nombre" 
				size="15" 
				maxlength="15" />
		<html:errors property="nombre" />
  </td>
 
 </tr>  
 <tr>

  <td width="45%" align="right">   
		<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraCliente.apellido1"/>
  </td>
  <td width="5%"></td>   
  <td width="50%" align="left">
		<html:text 	property="apellido1" 
				size="15" 
				maxlength="15" />
		<html:errors property="apellido1" />
  </td>

 </tr>
 <tr>

  <td width="45%" align="right">
		<fmt:message key="registraCliente.apellido2"/>
  </td>
  <td width="5%"></td>   
  <td width="50%" align="left">
		<html:text 	property="apellido2" 
				size="15" 
				maxlength="15" />
		<html:errors property="apellido2" />
  </td>

 </tr>
 <tr>

  <td width="45%" align="right">
		<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraCliente.fechaNacimiento"/>
  </td>
  <td width="5%"></td>   
  <td width="50%" align="left">

<%@ include file="fecha.jsp" %>

                
 </td>

 </tr>
 <tr>

  <td width="45%" align="right">
		<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraCliente.telefono1"/>
 </td>
  <td width="5%"></td>   
  <td width="50%" align="left">
		<html:text 	property="telefono1" 
				size="9" 
				maxlength="9" />
		<html:errors property="telefono1" />
 </td>

 </tr>
 <tr>

  <td width="45%" align="right">
		<fmt:message key="registraCliente.telefono2"/>
 </td>
  <td width="5%"></td>   
  <td width="50%" align="left">
		<html:text 	property="telefono2" 
				size="9" 
				maxlength="9" />
		<html:errors property="telefono2" />
 </td>

 </tr>
 <tr>

  <td width="45%" align="right">
		<fmt:message key="registraCliente.email"/>
 </td>
  <td width="5%"></td>   
  <td width="50%" align="left">
		<html:text 	property="email" 
				size="25" 
				maxlength="25" />
		<html:errors property="email" />
 </td>

 </tr>
 <tr>

  <td width="45%" align="right">
		<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraCliente.calle"/>
 </td>
  <td width="5%"></td>   
  <td width="50%" align="left">
		<html:text 	property="calle" 
				size="15" 
				maxlength="35" />
		<html:errors property="calle" />
 </td>

 </tr>
 <tr>

  <td width="45%" align="right">
		<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraCliente.num"/>
 </td>
  <td width="5%"></td>   
  <td width="50%" align="left">
		<html:text 	property="num" 
				size="4" 
				maxlength="4" />
		<html:errors property="num" />
 </td>

 </tr>
 <tr>

  <td width="45%" align="right">
		<fmt:message key="registraCliente.piso"/>
 </td>
  <td width="5%"></td>   
  <td width="50%" align="left">
		<html:text 	property="piso" 
				size="2" 
				maxlength="2" />
		<html:errors property="piso" />
 </td>

 </tr>
 <tr>

  <td width="45%" align="right">
		<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraCliente.codPostal"/>
 </td>
  <td width="5%"></td>   
  <td width="50%" align="left">
		<html:text 	property="codPostal" 
				size="5" 
	    			maxlength="5" />
		<html:errors property="codPostal" />
 </td>

 </tr>
 <tr>

  <td width="45%" align="right">		
		<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraCliente.poblacion"/>
 </td>
  <td width="5%"></td>   
  <td width="50%" align="left">
		<html:text 	property="poblacion" 
				size="25" 
				maxlength="25" />
		<html:errors property="poblacion" />
 </td>

 </tr>
 <tr>

  <td width="45%" align="right">
		<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraCliente.provincia"/>
 </td>
  <td width="5%"></td>   
  <td width="50%" align="left">
		<html:text 	property="provincia" 
				size="25" 
				maxlength="25" />
		<html:errors property="provincia" />
 </td>

 </tr>
 <tr>

  <td width="45%" align="right">	
		<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraCliente.pais"/>
 </td>
  <td width="5%"></td>   
  <td width="50%" align="left">
		<html:text 	property="pais" 
				size="25" 
				maxlength="25" />
		<html:errors property="pais" />
 </td>

 </tr>
 <tr>

  <td width="45%" align="right">	
	<html:submit>
	<fmt:message key="registraCliente.button.signon"/>
	</html:submit>
 </td>
  <td width="5%"></td>   
  <td width="50%" align="left">
	<html:reset>
	<fmt:message key="registraCliente.button.reset"/>
	</html:reset>
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
  

 
  

