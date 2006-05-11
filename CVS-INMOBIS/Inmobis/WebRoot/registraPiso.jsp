<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- JSTL tag libs --%>
<%@ taglib prefix="fmt" uri="/WEB-INF/fmt.tld" %>

<%-- Struts provided Taglibs --%>
<%@ taglib prefix="html" uri="/WEB-INF/struts-html-el.tld" %>

<html:html locale="true"/>
<head>
	<fmt:setBundle basename="com.inmobis.struts.ApplicationResources" />
	<title><fmt:message key="registraPiso.title"/></title>
</head>
<html>
<body>
<html:errors property="registraPiso"/>

<html:form action="registraPiso.do" focus="calle">
	<table align="center" border = "2">
  		<tr align="center">
    		<td><H1><fmt:message key="registraPiso.message"/></H1></td>
  		</tr>
  		<tr align="center">
			<td>
  				<table align="center">
	  				
	  				<tr>
	    				<td align="right">
							<fmt:message key="registraPiso.calle"/>
						</td>
	   					<td align="left">
							<html:text 	property="calle" 
	    								size="15" 
	    								maxlength="15" />
							<html:errors property="calle" />
						</td>
	  				</tr>	
	  				<tr>
	    				<td align="right">
							<fmt:message key="registraPiso.num"/>
						</td>
	   					<td align="left">
							<html:text 	property="num" 
	    								size="15" 
	    								maxlength="15" />
							<html:errors property="num" />
						</td>
	  				</tr>	
	  				<tr>
	    				<td align="right">
							<fmt:message key="registraPiso.piso"/>
						</td>
	   					<td align="left">
							<html:text 	property="piso" 
	    								size="15" 
	    								maxlength="15" />
							<html:errors property="piso" />
						</td>
	  				</tr>	
	  				<tr>
	    				<td align="right">
							<fmt:message key="registraPiso.codPostal"/>
						</td>
	   					<td align="left">
							<html:text 	property="codPostal" 
	    								size="15" 
	    								maxlength="15" />
							<html:errors property="codPostal" />
						</td>
	  				</tr>	
	  				<tr>
	    				<td align="right">
							<fmt:message key="registraPiso.poblacion"/>
						</td>
	   					<td align="left">
							<html:text 	property="poblacion" 
	    								size="15" 
	    								maxlength="15" />
							<html:errors property="poblacion" />
						</td>
	  				</tr>	
	  				<tr>
	    				<td align="right">
							<fmt:message key="registraPiso.pais"/>
						</td>
	   					<td align="left">
							<html:text 	property="pais" 
	    								size="15" 
	    								maxlength="15" />
							<html:errors property="pais" />
						</td>
	  				</tr> 
	  				
	  				<tr>
	    				<td align="right">
							<fmt:message key="registraPiso.regimen"/>
						</td>
	   					<td align="left">
							<html:text 	property="regimen" 
	    								size="15" 
	    								maxlength="15" />
							<html:errors property="regimen" />
						</td>
	  				</tr> 
	  				<tr>
	    				<td align="right">
							<fmt:message key="registraPiso.precio"/>
						</td>
	   					<td align="left">
							<html:text 	property="precio" 
	    								size="15" 
	    								maxlength="15" />
							<html:errors property="precio" />
						</td>
	  				</tr> 
	  				<tr>
	    				<td align="right">
							<fmt:message key="registraPiso.metros"/>
						</td>
	   					<td align="left">
							<html:text 	property="metros" 
	    								size="15" 
	    								maxlength="15" />
							<html:errors property="metros" />
						</td>
	  				</tr> 
	  				<tr>
	    				<td align="right">
							<fmt:message key="registraPiso.provincia"/>
						</td>
	   					<td align="left">
							<html:text 	property="provincia" 
	    								size="15" 
	    								maxlength="15" />
							<html:errors property="provincia" />
						</td>
	  				</tr> 
	  				<%-- <tr>
	    				<td align="right">
							<fmt:message key="registraPiso.datosDeInteres"/>
						</td>
	  					<td align="left">
							<html:text 	property="datosDeInteres" 
	    								size="15" 
	    								maxlength="15" />
							<html:errors property="datosDeInteres" />
						</td>
	  				</tr> --%>
	  				<tr>
						<td colspan="2" align="center">
							<html:submit>
								<fmt:message key="registraPiso.button.signon"/>
							</html:submit>
							<html:reset>
								<fmt:message key="registraPiso.button.reset"/>
							</html:reset>
						</td>
	  				</tr>
	  				
  				</table>
			</td>
  		</tr>
	</table>
</html:form>
</body>
</html>