 <%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%--El título de la página se debe pasar como parámetro a la cabecera--%>
<%String tituloPag = "&copy INMOBIS Real Estate - Filtrado de pisos";%>
<%boolean esIndex=false; %>
<%@include file="cabecera.jsp" %>

<!-- Aquí es donde va la PARTE PRINCIPAL DE LA PÁGINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo que tienen todas las paginas-->
<%String subtitulo="P&aacute;gina de Filtrado";%>
<%String tipoMenu="general";//Si no se ha registrado%>
<%
HttpSession sesion=request.getSession();
String tipoU=(String)sesion.getAttribute("tipoUsuario");
%>
<%if (tipoU != null) {%>
<%	tipoMenu = tipoU;%>
<%}%>
<%@ include file="menu_izdo.jsp" %>
              <div id="content"> 
                <div class="feature"> 
                   <table border="0" cellpading="0" cellspacing="0" width="100%">
						 <!-- zona de c�digo-->
<tr>   
        <th><bean:message key=" app.Nombre" /></th>
        <th><bean:message key="app.Apellido1" /></th>
        <th><bean:message key="app.Apellido2" /></th>

        
         <th colspan="2"></th>
      
      </tr>
      <!-- iterate over the results of the query -->
      <logic:iterate id="agente" name="listaAgentes">   
    <tr>
      <td> 
            <bean:write name="agente" property="nombre" />
      </td>
      <td>
            <bean:write name="agente" property="apellido1" />
      </td>
      <td>
            <bean:write name="agente" property="apellido2" />
      </td>

   					<!--	  <td>
					            <a href="EditaAgentePrev.do?datos=<
								<bean:write name="agente"property="idAgenteo" /> 
							    <bean:write name="agente" property="nombre" />
							    <bean:write name="agente" property="apellido1" />
							    <bean:write name="agente" property="apellido2" />
							   />
							  MODIFICAR</a>
						  </td>
						  <td>
                               <a href="BorraAgentePrev.do?datos=<
							    <bean:write name="agente"property="idAgente" /> 
							    <bean:write name="agente" property="nombre" />
							    <bean:write name="agente" property="apellido1" />
							    <bean:write name="agente" property="apellido2" />
							   />
								ELIMINAR</a></div>
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