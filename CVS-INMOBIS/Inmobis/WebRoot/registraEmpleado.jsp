<%--El título de la página se debe pasar como parámetro a la cabecera--%>
<%String tituloPag = "INMOBIS Real Estate - Registro de empleado por el administrador";%>
<%boolean esIndex=false; %>
<%@include file="cabecera.jsp" %>

<!-- Aquí es donde va la PARTE PRINCIPAL DE LA PÁGINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo específico del administrador-->
<%String subtitulo="P&aacute;gina de registro de empleado por el administrador";%>
<%String tipoMenu="general";//Si no se ha registrado%>
<!-- CON ESTO BASTARÍA--><%-- tipoMenu="administrador";--%>
<%
HttpSession sesion=request.getSession();
String tipoU=(String)sesion.getAttribute("tipoUsuario");
%>
<%if (tipoU != null) {%>
<%	tipoMenu = tipoU;%>
<%}%>
<%@include file="menu_izdo.jsp" %>


<html:form action="registraEmpleado.do"  >

	<div id="content"> 
                <div class="feature">

<fmt:message key="registraEmpleado.message"/>
<hr>
<table align="left">
<tr><td>
<font size="1" color="red"><b>(*)&nbsp;Campos obligatorios</b></font>
</td>
</tr>
</table>

<br><br>

<table>
  <tr>
    <td>   
      <font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.password"/>
    </td>
    <td>
	  <html:password 	property="password" redisplay="false" maxlength="15" />
	  <html:errors property="password" />
	</td>
 </tr>
 <tr>
    <td>   
      <font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.passwordAgain"/>
	</td>  
	<td>
	  <html:password 	property="passwordAgain" maxlength="15" redisplay="false"/>
	  <html:errors property="passwordAgain" />
	</td>
 </tr>
 <tr>
  <td width="45%" align="right">
	<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.nombre"/>
  </td>
  <td width="5%"></td>
  <td width="50%" align="left">		
	<html:text 	property="nombre" 
	      		size="15" 
	      		maxlength="15" />
	<html:errors property="nombre" />
  </td>

 </tr>


 <tr>
  <td width="45%" align="right">
	<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.apellido1"/>
  </td>
  <td width="5%"></td>
  <td width="50%" align="left">
<html:text 	property="apellido1" 
		size="15" 
		maxlength="15" />
<html:errors property="apellido1" />

</td>

 </tr>


 <tr>
  <td width="45%" align="right">
	<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.apellido2"/>
</td>
  <td width="5%"></td>
  <td width="50%" align="left">
<html:text 	property="apellido2" 
		size="15" 
		maxlength="15" />
<html:errors property="apellido2" />

</td>

 </tr>


 <tr>
  <td width="45%" align="right">
	<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.fechaNacimiento"/>
</td>
  <td width="5%"></td>
  <td width="50%" align="left">

<%@ include file="fecha.jsp" %>


</td>

 </tr>


 <tr>
  <td width="45%" align="right">
	<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.nif"/>
</td>
  <td width="5%"></td>
  <td width="50%" align="left">
<html:text 	property="nif" 
		size="15" 
	    	maxlength="15" />
<html:errors property="nif" />

</td>

 </tr>


 <tr>
  <td width="45%" align="right">
	<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.tipoEmpleado"/>
</td>
  <td width="5%"></td>
  <td width="50%" align="left">
<html:text 	property="tipoEmpleado" 
		size="15" 
		maxlength="15" />
<html:errors property="tipoEmpleado" />
</td>

 </tr>


 <tr>
  <td width="45%" align="right">
	<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.porcentaje"/>
</td>
  <td width="5%"></td>
  <td width="50%" align="left">
<html:text 	property="porcentaje" 
		size="15" 
		maxlength="15" />
<html:errors property="porcentaje" />

</td>

 </tr>


 <tr>
  <td width="45%" align="right">
	<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.telefono1"/>
</td>
  <td width="5%"></td>
  <td width="50%" align="left">
<html:text 	property="telefono1" 
		size="15" 
		maxlength="15" />
<html:errors property="telefono1" />

</td>

 </tr>


 <tr>
  <td width="45%" align="right">
	<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.telefono2"/>
</td>
  <td width="5%"></td>
  <td width="50%" align="left">
<html:text 	property="telefono2" 
		size="15" 
		maxlength="15" />
<html:errors property="telefono2" />

</td>

 </tr>


 <tr>
  <td width="45%" align="right">
	<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.email"/>
</td>
  <td width="5%"></td>
  <td width="50%" align="left">
<html:text 	property="email" 
		size="15" 
		maxlength="15" />
<html:errors property="email" />

</td>

 </tr>


 <tr>
  <td width="45%" align="right">
	<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.calle"/>
</td>
  <td width="5%"></td>
  <td width="50%" align="left">
<html:text 	property="calle" 
		size="15" 
		maxlength="15" />
<html:errors property="calle" />

</td>

 </tr>


 <tr>
  <td width="45%" align="right">
	<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.num"/>
</td>
  <td width="5%"></td>
  <td width="50%" align="left">
<html:text 	property="num" 
		size="15" 
		maxlength="15" />
<html:errors property="num" />

</td>

 </tr>


 <tr>
  <td width="45%" align="right">
	<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.piso"/>
</td>
  <td width="5%"></td>
  <td width="50%" align="left">
<html:text 	property="piso" 
		size="15" 
	    	maxlength="15" />
<html:errors property="piso" />
</td>

 </tr>


 <tr>
  <td width="45%" align="right">
	<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.codPostal"/>
</td>
  <td width="5%"></td>
  <td width="50%" align="left">
<html:text 	property="codPostal" 
		size="15" 
		maxlength="15" />
<html:errors property="codPostal" />
</td>

 </tr>


 <tr>
  <td width="45%" align="right">
	<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.poblacion"/>
</td>
  <td width="5%"></td>
  <td width="50%" align="left">
<html:text 	property="poblacion" 
		size="15" 
		maxlength="15" />
<html:errors property="poblacion" />

</td>

 </tr>


 <tr>
  <td width="45%" align="right">
	<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.provincia"/>
</td>
  <td width="5%"></td>
  <td width="50%" align="left">
<html:select property="provincia" size="1">
	<%@ include file="provincia.jsp" %>
</html:select>
<html:errors property="provincia" />
</td>

 </tr>


 <tr>
  <td width="45%" align="right">
	<font size="1" color="red"><b>(*)</b></font>&nbsp;<fmt:message key="registraEmpleado.pais"/>
</td>
  <td width="5%"></td>
  <td width="50%" align="left">
<html:text 	property="pais" 
		size="15" 
		maxlength="15" />
<html:errors property="pais" />
</td>

 </tr>


 <tr>
  <td width="45%" align="right">	
<html:submit>
	<fmt:message key="registraEmpleado.button.signon"/>
</html:submit>
</td>
  <td width="5%"></td>
  <td width="50%" align="left">
<html:reset>
	<fmt:message key="registraEmpleado.button.reset"/>
</html:reset>
</td>

 </tr>
</table>
</html:form>
</div>
              </div>
              <div id="siteInfo"><a href="mailto:inmobisweb@gmail.com">Contacto</a> 
                | &copy;2006 INMOBIS Real Estate</div>
</body>
</html>
<!-- FIN de la parte donde va la PARTE PRINCIPAL DE LA PÁGINA -->

			

<%@ include file="final.htm" %>  