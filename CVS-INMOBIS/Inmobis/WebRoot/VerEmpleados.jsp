<%--Librería específica de esta página: Logic, para usar el iterator--%>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%--El título de la página se debe pasar como parámetro a la cabecera--%>
<%String tituloPag = "&copy INMOBIS: Listado de empleados";%>
<%boolean esIndex=false; %>
<%@ include file="cabecera.jsp" %>

<!-- Aquí es donde va la PARTE PRINCIPAL DE LA PÁGINA 
CON UN ANCHO DE 767 px -->

<!--El menu izquierdo que tienen todas las paginas-->
<%String subtitulo="Listado de empleados";%>
<%String tipoMenu="gerente";//Se supone que sólo los gerentes ven sus empleados ¿?%>
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
      <logic:iterate id="empleado" name="listaEmpleados">   
    <tr>
      <td> 
            <html:text name="empleado" property="nombre" ></html:text>
            <bean:write name="empleado" property="nombre" />
      </td>
      <td>
            <html:text name="empleado" property="apellido1" ></html:text>
            <bean:write name="empleado" property="apellido1" />
      </td>
      <td>
            <html:text name="empleado" property="apellido2" ></html:text>
            <bean:write name="empleado" property="apellido2" />
      </td>

   					<!--	  <td>
					            <a href="EditaEmpleadoPrev.do?datos=<
								<bean:write name="empleado"property="idEmpleado" /> 
							    <bean:write name="empleado" property="nombre" />
							    <bean:write name="empleado" property="apellido1" />
							    <bean:write name="empleado" property="apellido2" />
							   />
							  MODIFICAR</a>
						  </td>
						  <td>
                               <a href="BorraEmpleadoPrev.do?datos=<
							    <bean:write name="empleado"property="idEmpleado" /> 
							    <bean:write name="empleado" property="nombre" />
							    <bean:write name="empleado" property="apellido1" />
							    <bean:write name="empleado" property="apellido2" />
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