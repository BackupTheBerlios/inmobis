<html>
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
						<logic:iterate id="VerClientesAgentePrevForm" name="ClienteBean">
						<tr>
						  <td>
					            <bean:write name="VerClientesAgentePrevForm" property="nombre" />
						  </td>
						  <td>
					            <bean:write name="VerClientesAgentePrevForm" property="apellido1" />
						  </td>
						  <td>
					            <bean:write name="VerClientesAgentePrevForm" property="apellido2" />
						  </td>
						 
						   <td>
					            <bean:write name="VerClientesAgentePrevForm" property="fechNacimiento" />
						  </td>				  
						  <td>
					            <a href="ModifBajaClientePrev.do?idCliente=<bean:write name='VerClientesAgentePrevForm' property='idCliente' />
					            +&apellido1=+<bean:write name='VerClientesAgentePrevForm' property='apellido1' />
					            +&apellido2=+<bean:write name='VerClientesAgentePrevForm' property='apellido2' />"								
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