<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- JSTL tag libs --%>
<%@ taglib prefix="fmt" uri="/WEB-INF/fmt.tld" %>

<%-- Struts provided Taglibs --%>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html-el.tld" %>
<html>
<html:html locale="true"/>
<head>
    <fmt:setBundle basename="com.inmobis.struts.ApplicationResources" />
	<title><fmt:message key="menuAdministrador.title"/></title>
<meta http-equiv="Content-Type" content="text/html;">
<link href="estilo/estilo.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="#ffffff">

<%@ include file="cabecera.htm" %>




            <!--pagecell1-->
            
            <div id="pageName"> 
                <h2>P&aacute;gina Principal Administrador </h2>
            </div>
            <div id="pageNav"> 
			<div id="sectionLinks"> <a href="index.jsp">P&aacute;gina Principal</a><a href="registraClienteCliente.jsp">Registrarse</a><a href="login.jsp">Identificarse</a><a href="login.jsp">Financiaci&oacute;n</a><a href="login.jsp">Hipotecas</a><a href="login.jsp">Seguros</a><a href="ayuda.jsp" target="new">Ayuda</a><a href="mailto:inmobisweb@gmail.com">Contacto</a></div>
			<html:errors property="menuAdministrador"/>
                <div id="sectionLinks2"> 
                
				<h3>&nbsp;<fmt:message key="menuAdministrador.message"/></h3>			
								
				<a class="block_item" href="CerrarSesion.jsp" title="Cerrar la sesion"><font color="red"><b>CERRAR SESION</b></font></a>
				
				
				<!-- he puesto un .do cualquiera para probarlo porque aun no estan las action a las que corresponde-->
                		<html:form action="VerEmpleadosPrev.do" >					
							<html:submit>
								<fmt:message key="menuAdministrador.button.lista"/>
							</html:submit>
				 </html:form>
               
				 <html:form action="registraClienteCliente.do" >					
							<html:submit>
								<fmt:message key="menuAdministrador.button.registra"/>
							</html:submit>
				</html:form>
							
              	</div>
             </div>
              <div id="content"> 
                <div class="feature"> 
                  <h3>&iquest;Qu&eacute; es <img src="images/inmobis1.jpg" title="INMOBIS" alt="INMOBIS" width="333"></h3><br><br>
                  <p> Nuestro software consigue mantener m&aacute;s contentos y seguros 
                    a los clientes y a los agentes con ello les proporciona una 
                    mayor promoci&oacute;n y entrada de clientes. Teniendo en cuenta 
                    la incertidumbre en la que viven los agentes inmobiliarios, 
                    sabiendo lo que han vendido ya, pero no si podr&aacute;n vender ma√±ana, 
                    el respaldo de un sistema as&iacute; les proporciona una mayor seguridad 
                    con la que trabajar m&aacute;s a gusto y por ello mejor. </p>
					
					
					<center> <img src="images/mapa.jpg" title="INMOBIS" alt="INMOBIS" width="333"> </center>
             
					
					
                </div>
              </div>
              <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>
</body>
</html>
<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA P√?GINA -->

			

<%@ include file="final.htm" %>  