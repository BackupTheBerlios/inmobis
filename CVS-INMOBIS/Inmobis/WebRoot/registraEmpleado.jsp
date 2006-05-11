<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- JSTL tag libs --%>
<%@ taglib prefix="fmt" uri="/WEB-INF/fmt.tld" %>

<%-- Struts provided Taglibs --%>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html-el.tld" %>
<html>
<html:html locale="true"/>
<head>
    <fmt:setBundle basename="com.inmobis.struts.ApplicationResources" />
	<title><fmt:message key="registraEmpleado.title"/></title>
<meta http-equiv="Content-Type" content="text/html;">
<link href="estilo/estilo.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="#ffffff">

<%@ include file="cabecera.htm" %>





<!-- Aqu� es donde va la PARTE PRINCIPAL DE LA P�GINA 
CON UN ANCHO DE 767 px -->

          <div id="pageName"> 
                <h2>P&aacute;gina Principal Administrador </h2>
            </div>
            <div id="pageNav"> 
			<div id="sectionLinks"> <a href="index.jsp">P&aacute;gina Principal</a><a href="registraClienteCliente.jsp">Registrarse</a><a href="login.jsp">Identificarse</a><a href="login.jsp">Financiaci&oacute;n</a><a href="login.jsp">Hipotecas</a><a href="login.jsp">Seguros</a><a href="ayuda.jsp" target="new">Ayuda</a><a href="mailto:inmobisweb@gmail.com">Contacto</a></div>
			<html:errors property="registraEmpleado"/>
                <div id="sectionLinks"> 
                
				<h3>&nbsp;<fmt:message key="menuAdministrador.message"/></h3>			
				<a href="VerEmpleados.jsp"><fmt:message key="menuAdministrador.button.lista"/></a>
				<a href="registraEmpleado.jsp"><fmt:message key="menuAdministrador.button.registra"/></a>
				
				<a class="block_item" href="CerrarSesion.jsp" title="Cerrar la sesion"><font color="red"><b>CERRAR SESION</b></font></a>
				
				
		</div>
             </div>

<html:form action="registraEmpleado.do"  >

	<div id="content"> 
                <div class="feature">

<fmt:message key="registraEmpleado.message"/>
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
	<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.nombre"/>
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
	<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.apellido1"/>
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
	<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.apellido2"/>
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
	<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.fechaNacimiento"/>
</td>
  <td width="5%"></td>
  <td width="50%" align="left">

<%@ include file="fecha.jsp" %>


</td>

 </tr>


 <tr>
  <td width="45%" align="right">
	<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.nif"/>
</td>
  <td width="5%"></td>
  <td width="50%" align="left">
<html:text 	property="nif" 
		size="15" 
	    	maxlength="15" />
<html:errors property="nif" />

</td>

 </tr>


 <tr>
  <td width="45%" align="right">
	<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.tipoEmpleado"/>
</td>
  <td width="5%"></td>
  <td width="50%" align="left">
<html:text 	property="tipoEmpleado" 
		size="15" 
		maxlength="15" />
<html:errors property="tipoEmpleado" />
</td>

 </tr>


 <tr>
  <td width="45%" align="right">
	<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.porcentaje"/>
</td>
  <td width="5%"></td>
  <td width="50%" align="left">
<html:text 	property="porcentaje" 
		size="15" 
		maxlength="15" />
<html:errors property="porcentaje" />

</td>

 </tr>


 <tr>
  <td width="45%" align="right">
	<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.telefono1"/>
</td>
  <td width="5%"></td>
  <td width="50%" align="left">
<html:text 	property="telefono1" 
		size="15" 
		maxlength="15" />
<html:errors property="telefono1" />

</td>

 </tr>


 <tr>
  <td width="45%" align="right">
	<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.telefono2"/>
</td>
  <td width="5%"></td>
  <td width="50%" align="left">
<html:text 	property="telefono2" 
		size="15" 
		maxlength="15" />
<html:errors property="telefono2" />

</td>

 </tr>


 <tr>
  <td width="45%" align="right">
	<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.email"/>
</td>
  <td width="5%"></td>
  <td width="50%" align="left">
<html:text 	property="email" 
		size="15" 
		maxlength="15" />
<html:errors property="email" />

</td>

 </tr>


 <tr>
  <td width="45%" align="right">
	<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.calle"/>
</td>
  <td width="5%"></td>
  <td width="50%" align="left">
<html:text 	property="calle" 
		size="15" 
		maxlength="15" />
<html:errors property="calle" />

</td>

 </tr>


 <tr>
  <td width="45%" align="right">
	<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.num"/>
</td>
  <td width="5%"></td>
  <td width="50%" align="left">
<html:text 	property="num" 
		size="15" 
		maxlength="15" />
<html:errors property="num" />

</td>

 </tr>


 <tr>
  <td width="45%" align="right">
	<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.piso"/>
</td>
  <td width="5%"></td>
  <td width="50%" align="left">
<html:text 	property="piso" 
		size="15" 
	    	maxlength="15" />
<html:errors property="piso" />
</td>

 </tr>


 <tr>
  <td width="45%" align="right">
	<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.codPostal"/>
</td>
  <td width="5%"></td>
  <td width="50%" align="left">
<html:text 	property="codPostal" 
		size="15" 
		maxlength="15" />
<html:errors property="codPostal" />
</td>

 </tr>


 <tr>
  <td width="45%" align="right">
	<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.poblacion"/>
</td>
  <td width="5%"></td>
  <td width="50%" align="left">
<html:text 	property="poblacion" 
		size="15" 
		maxlength="15" />
<html:errors property="poblacion" />

</td>

 </tr>


 <tr>
  <td width="45%" align="right">
	<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.provincia"/>
</td>
  <td width="5%"></td>
  <td width="50%" align="left">
<html:text 	property="provincia" 
		size="15" 
		maxlength="15" />
<html:errors property="provincia" />
</td>

 </tr>


 <tr>
  <td width="45%" align="right">
	<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.pais"/>
</td>
  <td width="5%"></td>
  <td width="50%" align="left">
<html:text 	property="pais" 
		size="15" 
		maxlength="15" />
<html:errors property="pais" />
</td>

 </tr>


 <tr>
  <td width="45%" align="right">	
<html:submit>
	<fmt:message key="registraEmpleado.button.signon"/>
</html:submit>
</td>
  <td width="5%"></td>
  <td width="50%" align="left">
<html:reset>
	<fmt:message key="registraEmpleado.button.reset"/>
</html:reset>
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
<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA P�GINA -->

			

<%@ include file="final.htm" %>  