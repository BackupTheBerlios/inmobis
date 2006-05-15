 <%@ page contentType="text/html;charset=UTF-8" language="java" %>
 <%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
 <%@ taglib prefix="fmt" uri="/WEB-INF/fmt.tld" %>
 <%@ taglib prefix="html" uri="/WEB-INF/struts-html-el.tld" %><html>
<head>
<title>&copy INMOBIS: Listado Clientes Agente</title>
<meta http-equiv="Content-Type" content="text/html;">
<link href="estilo/estilo.css" rel="stylesheet" type="text/css">

</head>
<body bgcolor="#ffffff">

<%@ include file="cabecera.htm" %>

<!-- Aqu� es donde va la PARTE PRINCIPAL DE LA P�GINA 
CON UN ANCHO DE 767 px -->



            <!--pagecell1-->
            <div id="pageName"> 
                
              <h2>P&aacute;gina Principal </h2>
              </div>
              <div id="pageNav"> 
                <div id="sectionLinks"> <a href="index.jsp">P&aacute;gina Principal</a><a href="registraClienteCliente.jsp">Registrarse</a><a href="login.jsp">Identificarse</a><a href="login.jsp">Financiaci�n</a><a href="login.jsp">Hipotecas</a><a href="login.jsp">Seguros</a><a href="ayuda.jsp" target="new">Ayuda</a><a href="mailto:inmobisweb@gmail.com">Contacto</a></div>
              </div>
              <div id="content"> 
                <div class="feature"> 
                   <table border="0" cellpading="0" cellspacing="0" width="100%">
						 <!-- zona de c�digo-->
<table border="0" cellpading="0" cellspacing="0" width="100%">
    <tr>   
        <th><bean:message key=" app.Nombre" /></th>
        <th><bean:message key="app.Apellido1" /></th>
        <th><bean:message key="app.Apellido2" /></th>
        <th><bean:message key=" app.IdCliente" /></th>
        <th><bean:message key=" app.DniCliente" /></th>
        <th><bean:message key=" app.FechNac" /></th> 
         <th colspan="2"></th>
      
      </tr>
      <!-- iterate over the results of the query -->
      <logic:iterate id="cliente" name="listaClientes" type="com.inmobis.bbdd.cliente.ClienteBean" >
    <tr>
      <td> 
            <html:text name="cliente" property="nombreCliente" ></html:text>
            <bean:write name="cliente" property="nombreCliente" />
      </td>
      
      <td>
            <html:text name="cliente" property="apellido1" ></html:text>
            <bean:write name="cliente" property="apellido1" />
      </td>
      
      <td>
            <html:text name="cliente" property="apellido2" ></html:text>
            <bean:write name="cliente" property="apellido2" />
      </td>
    
      <td>
            <html:text name="cliente" property="idCliente" ></html:text>
            <bean:write name="cliente" property="idCliente" />
      </td>
         
      <td>
            <html:text name="cliente" property="dni" ></html:text>
            <bean:write name="cliente" property="dni" />
      </td>
      <td>
            <html:text name="cliente" property="fechNacimiento" ></html:text>
            <bean:write name="cliente" property="fechNacimiento" />
      </td> 
      					 
						  
						  <td>
					            <a href="ModifBajaClientePrev.do?nombreCliente=<bean:write name='cliente' property='nombre' />
					            +&apellido1=+<bean:write name='cliente' property='apellido1' />
					            +&apellido2=+<bean:write name='cliente' property='apellido2' />
					            +&idcliente=+<bean:write name='cliente' property='idcliente' />
					            +&dnicliente=+<bean:write name='cliente' property='dnicliente' />
					            +&fechnac=+<bean:write name='cliente' property='fechnac' />"		
					            >MODIFICAR</a>
						  </td>
						  
						  
						</tr>
				      </logic:iterate>
					</table>
					
					
					
					
					
					
                </div>
              </div>
              <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>

<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA P�GINA -->

			

<%@ include file="final.htm" %>  