<html>
<head>
<title>&copy INMOBIS: Eliminar Empleado</title>
<meta http-equiv="Content-Type" content="text/html;">
<link href="estilo/estilo.css" rel="stylesheet" type="text/css">

</head>
<body bgcolor="#ffffff">

<%@ include file="cabecera.htm" %>

<!-- Aquí es donde va la PARTE PRINCIPAL DE LA PÁGINA 
CON UN ANCHO DE 767 px -->



            <!--pagecell1-->
            <div id="pageName"> 
                
              <h2>P&aacute;gina Principal </h2>
              </div>
              <div id="pageNav"> 
                <div id="sectionLinks"> <a href="index.jsp">P&aacute;gina Principal</a><a href="registraClienteCliente.jsp">Registrarse</a><a href="login.jsp">Identificarse</a><a href="login.jsp">Financiación</a><a href="login.jsp">Hipotecas</a><a href="login.jsp">Seguros</a><a href="ayuda.jsp" target="new">Ayuda</a><a href="mailto:inmobisweb@gmail.com">Contacto</a></div>
              </div>
              <div id="content"> 
                <div class="feature"> 
                  <p> ¿ESTA SEGURO DE ELIMINAR EL SIGUIENTE EMPLEADO? </p>
				  <table border="0" cellpading="0" cellspacing="0" width="100%">
						<logic:iterate id="borraEmpleadoPrevForm" name="EmpleadoBean">
						<tr>
						  <td>
					            <bean:write name="borraEmpleadoPrevForm" property="nombre" />
						  </td>
						  <td>
					            <bean:write name="borraEmpleadoPrevForm" property="apellido1" />
						  </td>
						  <td>
					            <bean:write name="borraEmpleadoPrevForm" property="apellido2" />
						  </td>						  
						  <td>
					          <CENTER></CENTER>  <a href="borraEmpleado.do?idEmpleado=<bean:write name="borraEmpleadoPrevForm"
						      property="idEmpleado" /> ELIMINAR </a></CENTER>
						  </td>
						</tr>
				      </logic:iterate>
					</table>
					
					
					
					
					
					
                </div>
              </div>
              <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>

<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA PÁGINA -->

			

<%@ include file="final.htm" %>  