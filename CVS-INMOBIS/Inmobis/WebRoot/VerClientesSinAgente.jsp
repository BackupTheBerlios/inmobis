 <%@ page contentType="text/html;charset=UTF-8" language="java" %>
 <%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
 <%@ taglib prefix="fmt" uri="/WEB-INF/fmt.tld" %>
 <%@ taglib prefix="html" uri="/WEB-INF/struts-html-el.tld" %><html>
<head>
<title>&copy INMOBIS: Listado Clientes Sin Agente</title>
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
    <tr>   
        <th><bean:message key=" app.Nombre" /></th>
        <th><bean:message key="app.Apellido1" /></th>
        <th><bean:message key="app.Apellido2" /></th>
      
         <th colspan="2"></th>
      
      </tr>
      <!-- iterate over the results of the query -->
      <logic:iterate id="cliente" name="listaClientes">   
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
      
     		  <!--
						  <td>
					            <a href="AsignarAgenteAClientes.do?codigo=<
								<bean:write name="cliente" property="idCliente" />
								<bean:write name="cliente" property="nombre" />
								<bean:write name="cliente" property="apeliido1" />
								<bean:write name="cliente" property="apellido2" />
							  /> 
							  
							  ASIGNAR</a>
						  </td>
						  -->
						</tr>
				      </logic:iterate>
					</table>
					
					
					
					
					
					
                </div>
              </div>
              <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>

<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA P�GINA -->

			

<%@ include file="final.htm" %>  