 <%@ page contentType="text/html;charset=UTF-8" language="java" %>
  <%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
 <%@ taglib prefix="fmt" uri="/WEB-INF/fmt.tld" %>
 <%@ taglib prefix="html" uri="/WEB-INF/struts-html-el.tld" %><html>
<head>
<title>&copy INMOBIS: Listado Pisos</title>
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
					       <th><bean:message key="app.numHab" /></th>
						   <th><bean:message key="app.metros" /></th>
					       <th><bean:message key=" app.regimen" /></th>
					       <th><bean:message key="app.tipo" /></th>
						   <th><bean:message key="app.zona" /></th>
						   <th><bean:message key=" app.precio" /></th>
						   <th><bean:message key="app.datosdeinteres" /></th>  
        
						   <th colspan="2"></th>
      
						</tr>
						<logic:iterate id="inmueble" name="listaInmuebles">   
					    <tr>
							<td>
								<bean:write name="inmueble" property="numHab" />
							</td>
							<td>
								<bean:write name="inmueble" property="metros" />
							</td>
							<td>
								<bean:write name="inmueble" property="regimen" />
							</td>
							<td>
								<bean:write name="inmueble" property="tipo" />
							</td>
							<td>
								<bean:write name="inmueble" property="zona" />
							</td>
							<td>
								<bean:write name="inmueble" property="precio" />
							</td>
							<td>
						</tr>
				      </logic:iterate>
					</table>

                </div>
              </div>
              <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>

<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA P�GINA -->

			

<%@ include file="final.htm" %>  