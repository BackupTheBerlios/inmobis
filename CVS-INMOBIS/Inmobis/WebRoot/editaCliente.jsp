<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- JSTL tag libs --%>
<%@ taglib prefix="fmt" uri="/WEB-INF/fmt.tld" %>

<%-- Struts provided Taglibs --%>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html-el.tld" %>
<html>
<html:html locale="true"/>
<head>
    <fmt:setBundle basename="com.inmobis.struts.ApplicationResources" />
	<title><fmt:message key="editaCliente.title"/></title>
<meta http-equiv="Content-Type" content="text/html;">
<link href="estilo/estilo.css" rel="stylesheet" type="text/css">
</head>
<body bgcolor="#ffffff">

<%@ include file="cabecera.htm" %>


<!-- Aqui es donde va la PARTE PRINCIPAL DE LA PAGINA 
CON UN ANCHO DE 767 px -->

<!--****************            REPASAR                 ***************************    -->
            <!--pagecell1-->
            <div id="pageName"> 
                
              <h2>Editor de clientes </h2>
              </div>
              <div id="pageNav"> 
                <div id="sectionLinks"> <a href="index.jsp">P&aacute;gina Principal</a><a href="registraClienteCliente.jsp">Registrarse</a><a href="login.jsp">Identificarse</a><a href="login.jsp">Financiaci&oacute;n</a><a href="login.jsp">Hipotecas</a><a href="login.jsp">Seguros</a><a href="ayuda.jsp" target="new">Ayuda</a><a href="mailto:inmobisweb@gmail.com">Contacto</a></div>
              </div>
              <div id="content"> 
                <div class="feature">
					<center> 
						<html:errors property="editaCliente"/>
						<html:form action="editaCliente.do" focus="userName">
							<table width="100%">
								<tr>
									<td><H2><fmt:message key="editaCliente.message"/></H2></td>
								</tr>
							</table>							
							<table border="0" width="100%">
								<tr>
									<td>
										<fmt:message key="editaCliente.username"/>						
									</td>
									<td>
										<html:text 	property="userName" 
													size="15" 
													maxlength="15" />
										<html:errors property="userName" />
									</td>
								</tr>	
								<tr>
									<td>
										<fmt:message key="editaCliente.password">
										
										</fmt:message>
									</td>
									<td>
										<html:password 	property="password" 
														size="15" 
														maxlength="15" 
														redisplay="false"/>
										<html:errors property="password" />
									</td>
								</tr>	
								<tr>
									<td>
										<fmt:message key="editaCliente.nombreCompleto">
										
										</fmt:message>
									</td>
									<td>
										<html:text 	property="nombreCompleto" 
													size="40" 
													maxlength="40" />
										<html:errors property="nombreCompleto" />
									</td>
								</tr>	
								<tr>
									<td>
										<fmt:message key="editaCliente.domicilio">
										
										</fmt:message>
									</td>
									<td>
										<html:text 	property="domicilio" 
													size="60" 
													maxlength="60" />
										<html:errors property="domicilio" />
									</td>
								</tr>	
								<tr>
									<td>
										<fmt:message key="editaCliente.telefono">
										
										</fmt:message>
									</td>
									<td>
										<html:text 	property="telefono" 
													size="9" 
													maxlength="9" />
										<html:errors property="telefono" />
									</td>
								</tr>
								<tr>
									<td>
										<fmt:message key="editaCliente.email">
										
										</fmt:message>
									</td>
									<td>
										<html:text 	property="email" 
													size="30" 
													maxlength="30" />
										<html:errors property="email" />
									</td>
								</tr>
							</table>
							<table width="100%">
								<tr>
									<td align="center">
										<html:submit>
											<fmt:message key="editaCliente.button.cambiar"/>
										</html:submit>
									</td>
									<td align="center">
										<html:cancel>
											<fmt:message key="editaCliente.button.cancelar"/>
										</html:cancel>
									</td>
								</tr>
							</table>
						</html:form>
					</center>
                </div>
              </div>
              <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>

<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA PAGINA -->

			

<%@ include file="final.htm" %>


<!--******     LO QUE HABÍA    **********************
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- JSTL tag libs --%>
<%@ taglib prefix="fmt" uri="/WEB-INF/fmt.tld" %>

<%-- Struts provided Taglibs --%>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html-el.tld" %>
<html>
<html:html locale="true"/>
<head>
	<fmt:setBundle basename="com.inmobis.struts.ApplicationResources" />
	<title><fmt:message key="editaCliente.title"/></title>
</head>

<body>
<html:errors property="editaCliente"/>

<html:form action="editaCliente.do" focus="userName">
	<table align="center">
  		<tr align="center">
    		<td><H2><fmt:message key="editaCliente.message"/></H2></td>
  		</tr>
  		<tr align="center">
			<td>
  				<table align="center">
	  				<tr>
	    				<td align="right">
							<fmt:message key="editaCliente.username">
							
							</fmt:message>
						</td>
	   					<td align="left">
							<html:text 	property="userName" 
	    								size="15" 
	    								maxlength="15" />
							<html:errors property="userName" />
						</td>
	  				</tr>	
	  				<tr>
	   					<td align="right">
							<fmt:message key="editaCliente.password">
							
							</fmt:message>
						</td>
	   					<td align="left">
							<html:password 	property="password" 
	    									size="15" 
	    									maxlength="15" 
	    									redisplay="false"/>
							<html:errors property="password" />
						</td>
	 				</tr>	
	 				<tr>
	    				<td align="right">
							<fmt:message key="editaCliente.nombreCompleto">
							
							</fmt:message>
						</td>
	   					<td align="left">
							<html:text 	property="nombreCompleto" 
	    								size="40" 
	    								maxlength="40" />
							<html:errors property="nombreCompleto" />
						</td>
	  				</tr>	
	  				<tr>
	    				<td align="right">
							<fmt:message key="editaCliente.domicilio">
							
							</fmt:message>
						</td>
	   					<td align="left">
							<html:text 	property="domicilio" 
	    								size="60" 
	    								maxlength="60" />
							<html:errors property="domicilio" />
						</td>
	  				</tr>	
	  				<tr>
	    				<td align="right">
							<fmt:message key="editaCliente.telefono">
							
							</fmt:message>
						</td>
	   					<td align="left">
							<html:text 	property="telefono" 
	    								size="9" 
	    								maxlength="9" />
							<html:errors property="telefono" />
						</td>
	  				</tr>
	  				<tr>
	    				<td align="right">
							<fmt:message key="editaCliente.email">
							
							</fmt:message>
						</td>
	   					<td align="left">
							<html:text 	property="email" 
	    								size="30" 
	    								maxlength="30" />
							<html:errors property="email" />
						</td>
	  				</tr>		
	 				<tr>
						<td colspan="1" align="left">
							<html:submit>
								<fmt:message key="editaCliente.button.cambiar"/>
							</html:submit>
						</td>
						<td colspan="2" align="center">
							<html:cancel>
								<fmt:message key="editaCliente.button.cancelar"/>
							</html:cancel>
						</td>
	  				</tr>

  				</table>
			</td>
  		</tr>
	</table>
</html:form>
</body>
</html>
