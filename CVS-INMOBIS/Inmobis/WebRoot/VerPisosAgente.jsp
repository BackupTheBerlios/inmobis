<html>
<head>
<title>&copy INMOBIS: Listado Pisos Agente</title>
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
                   <table border="0" cellpading="0" cellspacing="0" width="100%">
						 <!-- zona de código-->
					<table border="0" cellpading="0" cellspacing="0" width="100%">
						<logic:iterate id="VerPisosAgenteForm" name="ListaInmuebles">
						<tr>
						  <td>
					            <bean:write name="VerPisosAgenteForm" property="metros" />
						  </td>
						  <td>
					            <bean:write name="VerPisosAgenteForm" property="regimen" />
						  </td>
						  <td>
					            <bean:write name="VerPisosAgenteForm" property="precio" />
						  </td>		  
						  <td>
					        <!--    <a href="EditaPisoPrev.do?datos=<
								<bean:write name="verPisosAgenteForm"property="idInmueble"/>
								<bean:write name="verPisosAgenteForm"property="metros"/>
								<bean:write name="verPisosAgenteForm"property="regimen"/>
								<bean:write name="verPisosAgenteForm"property="precio"/>
								/>

								MODIFICAR</a>
						  </td>
						  <td>
                               <a href="BorraPisoPrev.do?codigo=
							   <bean:write name="cliente" property="codigo" />
							   <bean:write name="verPisosAgenteForm"property="metros"/>
							   <bean:write name="verPisosAgenteForm"property="regimen"/>
							   <bean:write name="verPisosAgenteForm"property="precio"/>
							   
							   ELIMINAR</a> -->
	                      </td>     
						  
						</tr>
				      </logic:iterate>
					</table>
					
					
					
					
					
					
              <!--  </div> -->
             <!-- </div> -->
              <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>

<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA PÁGINA -->

			

<%@ include file="final.htm" %>  