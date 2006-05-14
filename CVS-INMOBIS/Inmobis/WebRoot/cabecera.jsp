<html>
<%--Parte de la cabecera para el index--%>
<%if(esIndex){%>	
	<head>
<%--Parte de la cabecera para el resto de las paginas--%>
<%}else{%>
	<%@ page contentType="text/html;charset=ISO-8859-1" pageEncoding="ISO-8859-1" language="java" %>
	<%-- JSTL tag libs --%>
	<%@ taglib prefix="fmt" uri="/WEB-INF/fmt.tld" %>
	<%-- Struts provided Taglibs --%>
	<%@ taglib prefix="html" uri="/WEB-INF/struts-html-el.tld" %>

	<html:html locale="true"/>
	<head>
    <fmt:setBundle basename="com.inmobis.struts.ApplicationResources" />
<%}%>
<%--Parte comun--%>
<title><%=tituloPag%></title>
<meta http-equiv="Content-Type" content="text/html;">
<link href="estilo/estilo.css" rel="stylesheet" type="text/css">

</head>
<body bgcolor="#ffffff">
<center>

<table class="general">
<tr><td>

<table class="cabecera" align="center" cellpadding="0" cellspacing="0">
 <tr> 
  <td class="cabecera-superior" colspan="3"><img class="cabecera-superior" name="n1" src="images/1.jpg" alt="INMOBIS" title="INMOBIS"><img class="cabecera-superior2" name="n2" src="images/2.jpg" alt="INMOBIS" title="INMOBIS">
  </td>
 </tr>
 <tr> 
  <td class="cabecera-logo" colspan="3"><img class="cabecera-logo" name="logo" src="images/logo.jpg" alt="INMOBIS" title="INMOBIS"><img class="cabecera-logo2" name="n3" src="images/3.jpg" alt="INMOBIS" title="INMOBIS">
  </td>
 </tr>
 <tr> 
  <td class="navbar" colspan="3">

   <table class="navbar" cellspacing="0" cellpadding="0">
    <tr> 
     <td class="navbar-espacio">&nbsp;</td>
	 <td class="navbar-boton1"><a href="index.jsp" class="tnav" alt="Página Principal" title="Ir a la Página de Inicio">Inicio</a></td>
     <td class="navbar-boton2"><a href="financiacion.html" class="tnav" alt="Financiación" title="Financiación">Financiaci&oacute;n</a></td>
     <td class="navbar-boton3"><a href="hipotecas.html" class="tnav" alt="Hipotecas" title="Hipotecas">Hipotecas</a></td>
     <td class="navbar-boton4"><a href="seguros.html" class="tnav" alt="Seguros" title="Seguros">Seguros</a></td>
     <td class="navbar-boton5"><a href="ayuda.html" class="tnav" alt="Ayuda" title="Ayuda">Ayuda</a></td>
	 <td class="navbar-boton6"><a href="mailto:inmobisweb@gmail.com" class="tnav" alt="Contactar" title="Contactar con nosotros">Contactar</a></td>
     <td class="navbar-espacio">&nbsp;</td>
    </tr>
   </table>

  </td>
 </tr>

 <tr> 
  <td>
  
   <table align="center" width="100%"background="images/bg.jpg">
        <tr> 
          <td>  

